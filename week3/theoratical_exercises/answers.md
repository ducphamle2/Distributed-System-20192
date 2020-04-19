Question 1: 
	A process is a program in execution while a thread is just a piece of program code that is executed independently
	A process is created when user launches a program, while threads stay inside a process and there can be multiple threads within a process
	Two processes have different context, while two threads in the same process share the same context and data used by two threads can be exchanged (shared variables). Data used by threads must be managed by developers not OS.
	An independent address space with memory segment is allocated for a process, while a thread is is put in a stack
	Switch processes is costly because we need to apply switching context from process 1 to process 2, while create new threads within a process does not need to do so. However, too many threads can cause stack overflow.

Question 2:
	Yes, because in a big system with many clients requesting at the same time, if we do not limit the number of threads within a server process, it can lead to stackoverflow situation with too much memory consumption and will affect the entire server to work properly.

Question 3:
	Lightweight process solves both problems of the user mode and kernel mode by using both of them with a slight modification.
	User mode: use multiple threads within a process. This leads to blocking system call (I/O call), which will block the entire process. Lightweight process solves this by using multiple LWPs with multiple threads mapping to them. By doing this, if a thread calls I/O, the corresponding lightweight process will be entirely blocked. However, other threads mapping with other lightweight processes will still be working as normal, and the parent process will not be affected => solve the problem of blocking the entire process
	Kernel mode: This mode is similar to multi-processes, which is really costly in terms of context switching and creating, destroying threads. Lightweight process solves this by using multiple lightweight processes which share the same context as the parent process. Hence, creating multiple LWPs will not be costly anymore

	Having only a single LWP per process is not a good idea because it will turn the system into a user level mode only with multiple threads, and whenever there is a system call, the entire process will be blocked since there are no other LWPs to handle other tasks.

Question 4: Advantages: 
	The response time for querying and requesting is faster as there are more threads working at the same time to handle the tasks
	Multithreaded server can show the amount of time a process runs which is quite responsive.
	Threads are independent, therefore they do not affect other threads when running.

Question 5: 
	Thread per request:
		Advantages: Good bandwidth and latency because there is no queue. Each request is executed immediately and independently.
		Disavantages: May give stackoverflow when the server receives too many requests at the same time (threads are stored in stacks)

	Thread per object / connection:
		Advantages: The number of threads are stables and there are not too many tasks to handle
		Disavantages: load balancing problem, as some connections / objects may have too many requests, while others are too free.

Question 6: 
	Nodejs follow the Finite state machine.
	It is highly scalable because it does not have a queue of requests waiting for execution like thread per object / connection models. Instead, it delegates the requests to seperate components and focus on new requests (asynchronous, do not need to wait for responses). After finisihing, the delegated component will return the result (event driven model)
	It does not need to care about threads and handling data between threads like multithreaded servers. Hence, it does not face the problems faced by thread per request or per object / connection models.
	Because of the asynchronous characteristic, Nodejs can process different requests in parallel with a non-blocking system calls

Question 7:
	The reasons for multithreaded client in distributed systems are:
		Creating a seperate UI for each thread for better user experience and system performance
		Processing tasks in different threads concurrently to call api to different servers and receive responses from multiple servers when needed. Even though the server is multithreaded, bottleneck can happen at the client side, where the responses need to be executed sequentially not concurrently. Client needs to wait for the response of one server before requesting data from another server.
	Example: web browser

Question 8:
	Because hardware changes really fast, while software is stable and cannot adapt to hardware, we need virtualization so softwares can run on their own virtual machines regardless of the different hardwares or machines.

Question 9:

Question 10:
	Daemon server: store endpoints of servers (the servers will register their endpoints or DNS to the daemon). The client will request to this service, asking to get the specific servers
	Superserver: Create sub servers for requested services. Each time a client makes a request, the superserver will create a sub server for this request to server the client. 