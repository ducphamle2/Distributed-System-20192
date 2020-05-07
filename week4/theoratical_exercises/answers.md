## Question 1: 

We do not use only a single header that controls everything because:

**+**: Not all network communication uses all the layers

**+**: Using seperate headers can help reduce the coupling between layers. One layer does not need to know the headers of other layers to be able to communicate

**+**: Using seperate headers means we can add or remove layers without affecting other layers

## Question 2:

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

## Question 6:

**+**: It has scalability problems because when the network goes bigger, the client and server are further apart from each other, it would take more time for the server to response back to the client. While waiting for the server, the client is in idle mode, and it will be a waste of time. If the system is like this, it will not be able to scale bigger.

**+ Solution**: Use asynchronous instead of synchronous. This helps the caller to continue its tasks while waiting for the response of the callee

## Question 7:

**+**: Yes we can, the client can implement a callback or an interrupt so that when the server returns a response, the client will interrupt its current task and handle the response. By doing this way, the client will not have to be in idle mode while the server is executing its RPC call.
