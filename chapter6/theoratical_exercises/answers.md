## Question 1: 

**1st example**: If there is one resource and that is used on a distributed system with many hosts and multiple processes, each host has its own local clock, we cannot use semaphore to resolve the problem of resource sharing between processes => need a synchronization mechanism.

**2nd example**: In an event driven system where the order of the events is important, we need to make sure that an message m1 is executed before an message m2 if m is sent before m1. m2 can reach the destination earlier due to the network layer but we cannot control that => need a synchronization mechanism

# NOTE: 2nd example needs fix

## Question 2:

**Network time**: 

  **+**: Based on an exact time of the time server, and others need to synchronize their clocks with the time server. 
  
  **+**: For example, let B be the time server, and A is a server that wants to synchronize its clock to the time server. A sends a a message to B at T1, arrive at T2. B sends back a response message at T3, arrive at T4. Use T1, T2, T3, T4 to calculate the time skew, and A uses this time skew to adjust its local clock to match with the time server.

**Berkeley algorithm**: 

  **+**: Does not care about the exact time but care for synchronizing the local time system

  **+**: Use a time daemon that asks machines in the system for their local machine time. After receiving the responses, the time daemon tells the machines how to adjust their local time.

## Question 3:

**+**: Machines do not change their local time system, instead they store offset values which are the time differences with other machines within the system (based on the average time difference when receiving n messages)

**+**: When two machines A and B communicate with each other, they use their offset values (need confirmation here) to adjust their message sending time.

## Question 4: A bit short may need to check if this is correct ?

**+**: Physical synchronization is based on the actual time of the local clocks among machines within the system

**+**: Logical synchronization is based on the relative ordering of event messages sent among machines within the system

## Question 5: Không hiểu ????

## Question 6: 

## Question 7: 

### a) 
**First condition: ts(m)[i] = VC<sub>j</sub>[i] + 1** where **ts(m)[i]** is the timestamp of message m of the sending process number i; **VC<sub>j</sub>[i]** is the vector clock of the receiving process number j corresponding to process i

**Second condition: ts(m)[k] <= VC<sub>j</sub>[k]** for all k != i

### b) 
