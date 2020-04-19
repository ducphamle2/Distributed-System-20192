Question 1: 
	'./mvnwclean package -Dmaven.test.skip=true ' helps cleaning the maven project and build the services to jar files (the services are built in Java maven)
	'docker build --tag=microservice-kubernetes-demo-apache apache' builds a docker image using an image blueprint from the Docker hub, which is microservice-kubernetes-demo-apache. 'apache' is our directory containing the Dockerfile needed to build the docker image
	'docker tag microservice-kubernetes-demo-apache your_docker_account/microservice-kubernetes-demo-apache:latest' helps labeling or tagging our newly built image with our account. By doing this, we are creating a reference to our image so that we can deploy it later.
	'docker push your_docker_account/microservice-kubernetes-demo-apache' is used to deploy our newly built image onto the Docker hub
	Other trivial commands i do not make an attempt to explain, since they are just cloning a git repository or signing in a docker account.

Question 2:
	My repository contains my newly published image which is the microservice-kubernetes-demo-apache image with a tag 'latest'

Question 3:
	The status of these created pods were first ContainerCreating, but after a few minutes it turned into Running status.

Question 4:
	Glassfish is an application server mostly served for Java EE application. Glassfish can host a basic web server that handles HTTP requests as well as handle servlets and JSP for java web development (similarly to Apache Tomcat).

Question 5:
	Two JNDI are used because the first one is used to name the topic connection factory instance so that the clients and servers and connect to (topic connection factory is used to create connections to the associated messaging provider of JMS topic destinations, for publish and subscribe messaging). The second one is used to name the topic instance for the client and server to lookup and access to.

Question 6:
	Based on the event-based system diagram, our subscriber (MyReceiver) and publisher (MySender) in the program are two components. There is a topic called "myTopic", which is the "Event Bus" in the diagram. The publisher uses "myTopicConnectionFactory" as a connection to connect to the topic. 
After that, the publisher publishes a message to the "myTopic" topic. 
On the other hand, the subscriber also makes a connection to the topic pool through "myTopicConnectionFactory" and lookups the topic "myTopic". The subscriber also needs to have a listener (MyListener) as an Event Delivery whenever a message is sent to the topic. 
In conclusion, a common topic is created, publisher sends a message to the topic, the subscriber subscribes to the topic, listens and retrieve the message using the Listener component. This is a Publish/Subscribe system, and both components do not know each other (Processes are loosely coupled) => Event-based

Question 7:
	JMS and DDS both have the publish-and-subscribe model for event-based architecture, and they are both a middleware. 
	For JMS, both subscribers and publishers must share the same topic, and publishers will send messages into that topic. In order for the subscribers to retrieve such messages, they should remain continuously active to collect the message. When it comes to long-term subscription, the messages that have not been collected will be redistributed when those subscribers become active again. By this way, JMS creates a loosely coupled model where subscribers and publishers may not know each other, they only need to know the topic they that they like.
	For DDS, it focuses more on simplifying the network programming by using the publish-subscribe pattern for sending and receiving data. Instead of using a common topic like JMS, DDS uses topic as a reference for publishers to send messages to the subscribers. Indeed, messages are delivered by DDS to subscribers interested in a topic created by a publisher. By doing this way, the communication betwwen subscribers and publishers are also decoupled without having to rely on a specific topic holding messages in between. Here, DDS is the middle man, transferring data between the two; hence, DDS simplifies distributed applications and encourages modular and it can optimize the network data transferring with high throughput and low latency. 
