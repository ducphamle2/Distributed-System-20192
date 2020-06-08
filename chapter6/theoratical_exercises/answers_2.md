## Question 1: 

It is used to resolve the problem where there is a common and share resource that cannot support multiple processes at the same time. In order to use this resource, these processes need to use mutual exclusion algorithm to access the resource one by one

## Question 2:

**+**: Scalability problem, where the coordinator can be overloaded when the number of processes increases

**+**: Fault torelance problem. If the coordinator is broken then the the processes cannot access the resource anymore

**+**: The requested process does not know whether the coordinator is broken or it is currently in the queue waiting to access the resource

## Question 3:

**+**: If one process is broken then others will have no access to the resource because they always miss one "OK" vote from the broken process

**+**: Service scalability problem because of the broadcasting algorithm. One process needs to send its messages to all other processes, when more and more processes join, the entire system or network will crash. Other processes will also cannot run or run very slowly. For example, P1 is currently using the resource, but it constantly needs to process and response to messages from other processes

**+**: 