Question 1: Divide the the request into sub-requests that retrieve small chunk of resources which can be used immediately instead of a large data request. Another solution is to use multiple sessions or threadings where each thread / session requests a piece of resource. After that, accumulation is executed (a fine example here is Spark, where data is divided and put into different workers to improve performance).

Question 2: Three-tiered client server architecture is a type of client-server architecture that divides the system into three distinct, independent and transparent layers: boundary (User Interface) for interacting with users, control (Server) for processing business logic and entity (Database) for data storage. Each layer serves a specific purpose, and data is processed in sequence. The request is sent through the boundary layer that interacts with the user, then forwarded to control and to entity layer. After retrieving data, it is sent back to control, boundary and displayed to the user.

Question 3: 
	Vertical distribution: Layers (one different machine per layer) are distributed in multitiered architectures throughout many machines.
	Horizontal distribution: Distribution of one layer throughout different machine.

Question 4: Because overlay network is built on top of the physical network. A source node will retrieve data from its closest nodes based on the overlay network, not the physical one. As a result, the closest node may be the farthest node in real life => high latency and delay.

Question 5: P1 will need to wait P(n-1) processes before finishing itself. So if n is large, the request-response performance is very bad. Moreover, if one process has a problem, it will break down the entire system, as it is a chain of request-reply.

Question 6: The policy is reasonable, but not the best. In the diagram, it is true that for node (0.2, 0.3), the best route to reach (0.9, 0.6) is to go through (0.6, 0.7) because the total of euclidean distance is the smallest. However, the policy would make it go to the (0.7, 0.2) instead since their distance is shorter.

Question 7: Benefits: Simpler to deploy and understand. The services are reusable across business and they are faster defect isolation. Finally, it can minimize the risk of change since all services are independent, transparent, run their own processes and can be deployed independently.

Question 8: This exercise is drawn in the e-commerce image located in the same directory as this fiel.
