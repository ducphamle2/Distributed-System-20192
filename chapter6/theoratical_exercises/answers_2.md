## Question 1: 

It is used to resolve the problem where there is a common and share resource that cannot support multiple processes at the same time. In order to use this resource, these processes need to use mutual exclusion algorithm to access the resource one by one

## Question 2:

**+**: Scalability problem, where the coordinator can be overloaded when the number of processes increases

**+**: Fault torelance problem. If the coordinator is broken then the the processes cannot access the resource anymore

**+**: The requested process does not know whether the coordinator is broken or it is currently in the queue waiting to access the resource

## Question 3:

**+**: If one process is broken then others will have no access to the resource because they always miss one "OK" vote from the broken process

**+**: Service scalability problem because of the broadcasting algorithm. One process needs to send its messages to all other processes, when more and more processes join, the entire system or network will crash. Other processes will also cannot run or run very slowly. For example, P1 is currently using the resource, but it constantly needs to process and response to messages from other processes

## Question 4:

The nodes can add another protocol to notify each other about the current position of the token ring, which is the gossip protocol. One node periodically sends a signal or a notification to a set of random nodes to give its knowledge about the location of the token. Other nodes also do the same. The previous leader node that created the token will be the node that aggregates the result. If all the nodes send a "EMPTY" message, for example, the previous leader node will hold an election to choose a new leader, and the new leader will generate a new token to use for the system.

## Question 5:

3 sends messages to 4, 5, 6, 7 => total 4 messages

5, 6 rep to 3 => total 6 messages

5 to 6, 7 => total 8 messages

6 rep to 5 => total 9 messages

6 to 7 => total 10 messages

In conclusion: total 10 messages to elect a coordinator

## Question 6:

**a)**: 

Assume that the broadcasting messages still count as the total message to vote for the coordinator, and initially the coordinator is N, and it is currently broken. 

In the best case scenario, Pi is the process P(N-1) where N is the broken coordinator => the total message is N - 1 because of broadcasting

In the worst case scenario, Pi has to send messages from N-1 to itself, the total messages needed is (N - 1 - i) * 2 + N - 1 where N - 1 - i is the logical distance from P(N-1) to Pi, it multiplies with 2 because there are request and response messages, and finally it needs to send N - 1 messages to broadcast to other nodes.

**b)**: 

In both cases, the broken node needs to broadcast to N - 1 messages to N - 1 nodes to rebuild the status table.

First case, when the broken node has a higher ID than the current coordinator ID, the broken node will hold a new election to change the current coordinator ID, and it costs in total