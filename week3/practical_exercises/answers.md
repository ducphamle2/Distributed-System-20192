Question 1: 
	package.json appears. This file is responsible for containing metadata of the project from the project name, version to license. It also handles project depedencies (packages, modules outside of the project)

Question 2: The message is Hello World

Question 3: Nothing changed. The reason is because there is no client connected to our server socket yet, and the socket io has only been implemented in the server side only.

Question 4: An html file has been rendered, with an input for changing username and and input for sending messages. It is a chat room for distributed systems class

Question 5: I see the same message being sent to both tab browsers. This is because the server sends message to clients who are listening to the event 'new_message'. All browsers listen to this event so every tab can receive the message.
