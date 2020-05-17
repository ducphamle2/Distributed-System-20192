## Question 1: 

We do not use only a single header that controls everything because:

**+**: Not all network communication uses all the layers

**+**: Using seperate headers can help reduce the coupling between layers. One layer does not need to know the headers of other layers to be able to communicate

**+**: Using seperate headers means we can add or remove layers without affecting other layers

## Question 2:

**+ Two values of the socket**: They are ip address and port

## Question 3:

### a) TCP

**+ Connection-oriented**: For TCP, a channel is needed for the sender and receiver to communicate with each other

**+ Reliable**: Reliable here means the data is ensured to be sent. If a packet fails to be sent, it will be resent until there is an acknowledgement from the receiver that the packet has been received.

**+ Synchronous**: The client can only do other tasks after receving a response from the server

### b) UDP

**+ connection-less oriented**: For UDP, the sender and the receiver do not need to have a channel to communicate with each other

**+ Unreliable**: UDP cannot confirm if a packet is sent successfully or not.

**+ Synchronous**: Similar to TCP

## Question 4:

**+ Heterogenous system**: Because the caller and the callee are two different machines, they have different memory space and different information representation. Eg: caller uses big-indian type while callee uses little-indian

**+ Has faults**: There will be faults happening when using RPC, so a fault torelance mechanism must be provided. Eg: machine 1 breaks down when machine 2 is sending a response => there's no way to know this and resend when machine 1 becomes available again.

## Question 5:

**+ Pass by reference**: In this case, the same pointer is passed for two parameters, so after the procedure, the value of that same pointer is incremented two times, hence final result is 2

**+ Copy/restore**: In this case, it uses pass by value, so two copies of i are passed and are incremented to 1. After that, the writeback will be sequential, and the second writeback will overwrite the first one => final result is 1.

## Question 6:

**+**: It has scalability problems because when the network goes bigger, the client and server are further apart from each other, it would take more time for the server to response back to the client. While waiting for the server, the client is in idle mode, and it will be a waste of time. If the system is like this, it will not be able to scale bigger.

**+ Solution**: Use asynchronous instead of synchronous. This helps the caller to continue its tasks while waiting for the response of the callee

## Question 7:

**+**: Yes we can, the client can implement a callback or an interrupt so that when the server returns a response, the client will interrupt its current task and handle the response. By doing this way, the client will not have to be in idle mode while the server is executing its RPC call.

## Question 8:

**+**: Because the ip address and port of client does not need to be fixed. When connecting to the server, the client already binds its ip address and a random port so the server can send a response to. Meanwhile, the server needs to assign a specific ip address and port so other clients know where to connect to.

## Question 9:

**+ Incomplete connection queue**: When the server receives a Syn from a client, it creates a new entry for that Syn and puts it into a incomplete queue. This queue is responsible for storing connection entries waiting to be accepted

**+ Completed connection queue**: After finishing the handshake or ACK from the client, the incomplete connection entry is moved to a complete queue where the 'accept' function dequeues and returns the completed connection to the client. Because there are many entries so this queue is used to store completed entries waiting to be dequeued by the accept function.

**+ Backlog parameter**: Backlog parameter is the threshold for the sum of both queues. In short, the total number of entries in both queues should not exceed this parameter

## Question 10:
**+**: Provide extensive support where it offers intermediate-term storage capacity for the sent messages

**+**: Latency torelance

## Question 11: 

**+ Bit rate**: The number of bits sent in an interval should be consistent

**+ Delay**: In streaming, timing or interval between two consecutive server data is very important => delay is very sensitive. The delay and round-trip delay must be considered and handled carefully to obtain QoS

**+ Jitter**: The total time difference between two consecutive data unit of the sender and receiver side. Eg: Time between two consecutive packets in sender is 1ms, 5ms in receiver then jitter is 4ms

## Question 12:

**+**: Buffer at the receiver can store the successfully sent packets while waiting for the rest to come to reduce the playback gap between packets. This will increase the time the client receives the first packet, but the jiiter will be reduced.

## Question 13:

**+**: It distributes the lost dataframes throughout the stream to reduce the gap or delay time between packets assuming each packet has a fixed number of dataframes.
