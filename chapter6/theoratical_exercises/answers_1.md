# Pham Le Duc
# Student ID: 20161128
# Class: ICT.01-K61

## Question 1: 

**1st example**: If there is one shared resource that cannot support multiple processes on a distributed system with many hosts and multiple processes, each host has its own local clock, we cannot use semaphore to resolve the problem of which process can be allowed to use the resource first => need a synchronization mechanism.

**2nd example**: In the example of enforcing causal communication, assume that all three processes agree on an order of events that if a message m is sent before m*, then it should be executed first. However, in the example, m* is sent from P1 to P2 after m is sent from P0 to P2, but m* reaches P2 first based on the vector clock => break the event order => need a synchronization mechanism.

## Question 2:

**Network time**: 

  **+**: Based on an exact time of the time server, and others need to synchronize their clocks with the time server. 
  
  **+**: For example, let B be the time server, and A is a server that wants to synchronize its clock to the time server. A sends a a message to B at T1, arrive at T2. B sends back a response message at T3, arrive at T4. Then the time skew is (T2 - T1 + T3 - T4) / 2, and A uses this time skew to adjust its local clock to match with the time server.

  **+**: NTP servers are those around the world that have access to atomic clocks, NTP clients which are normal computers will try to synchronize the clocks through NTP servers

**Berkeley algorithm**: 

  **+**: Does not care about the exact time but care for synchronizing the local time system

  **+**: Use a time daemon that asks machines in the system for their local machine time. After receiving the responses from the machines, the time daemon tells the machines including itself to adjust their local time to match with each other.

  **+**: Time daemon is a master node which is elected using the election algorithm within a set of nodes in the network, other nodes are called slaves.

## Question 3:

**+**: Machines do not change their local time system, instead they store offset values which are the time differences with other machines within the system (based on the average time difference when receiving n messages)

**+**: When two machines A and B communicate with each other, they use their offset values (need confirmation here) to adjust their message sending time.

## Question 4:

**+**: Physical synchronization is based on the actual time of the local clocks among machines within the system

**+**: Logical synchronization is based on the relative ordering of events sent among machines within the system

## Question 5:

Assume that we have a process Pi and a counter Ci, the steps to update Ci for Pi:

**1st step**: Ci += 1 

**2nd step**: When the message of Pi is sent to another process called Pj, Pi's timestamp ts(m) = Ci

**3rd step**: When Pj receives the message, it updates its local counter Cj = max(Cj, ts(m)). Finally, it increases its local counter Cj += 1 then continue sending the message onto the application.

## Question 6: 

**a)**:

It is not absolutely correct, it is only correct when time from P to S equals time from S to P. This is because RTT/2 means the request time from P to S and the response time from S to P are equal. However, in reality this is not the case, and there will be deviation between the two request and response time, so the formula is not absolutely correct. 

**b)**:

Because min is the minimum time value it takes for a one-way message transmission => **min = T<sub>P</sub> - T<Sub>Q</sub>**

**T<sub>P</sub> - T<Sub>Q</sub> = RTT / 2 +- deviation**

**+-deviation = T<sub>P</sub> - T<Sub>Q</sub> = RTT / 2 = min - RTT / 2**

## Question 7: 

### a) 
**First condition: ts(m)[i] = VC<sub>j</sub>[i] + 1** where **ts(m)[i]** is the timestamp of message m of the sending process number i; **VC<sub>j</sub>[i]** is the knowledge of process j of the number of events occuring of process i

**Second condition: ts(m)[k] <= VC<sub>j</sub>[k]** for all k != i

### b) 

**+**: At X1, before sending message m1 to P0 and P2: 

**VC<sub>1</sub>[1] += 1 = 1** 

=> VC1 = (0, 1, 0)

VC0 = (0, 0, 0)

VC2 = (0, 0, 0)

**+**: At X2, after m1 arrives, P0 adjusts its local clock to match. Since ts[m1][1] = 1, so new VC0 is:

VC0 = (0, 1, 0)

VC1 = (0, 1, 0)

VC2 = (0, 0, 0)

**+**: At X3, before sending message m2 to P1 and P2:

**VC<sub>0</sub>[0] += 1 = 0 + 1 = 1**

=> VC0 = (1, 1, 0)

VC1 = (0, 1, 0)

VC2 = (0, 0, 0) because m2 when arrives with ts(m2) does not satisfy the two conditions => m2 is currently kept in the middleware

**+**: At X4, m1 arrives at P2, and ts(m1) satisfies the two conditions => update vector clock of P2

VC0 = (1, 1, 0)

VC1 = (0, 1, 0)

VC2 = (0, 1, 0)

### c)

m2 is kept in the middleware as explained in question b)