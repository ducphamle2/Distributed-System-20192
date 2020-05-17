## Question 1: 

In the part:

  ```AMQP.BasicProperties replyProps = new AMQP.BasicProperties.Builder().correlationId(delivery.getProperties().getCorrelationId()).build();```

## Question 2:

**+ Send message to server through queue**:

  ```channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));```

**+ Create a queue waiting for reply**:

  ```String replyQueueName = channel.queueDeclare().getQueue();AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().correlationId(corrId).replyTo(replyQueueName).build();```

## Question 3:

By testing with two clients running at the same time, three queues are obtained:

	amq.gen-xALlts1dQig0r4Sg5XjVrE	0 0

	amq.gen--rpWf8cDaxVwl05o3Xh41T	0 0

	rpc_queue			1 1

Explaination:

**+ Message ready**: The number of messages ready to be sent to the clients

**+ messages unacknowledged**: The number of messages that have been sent to clients but have not been acknowledged

**+ First queue**: reply queue of the first client

**+ Second queue**: reply queue of the second client

**+ Third queue**: reply queue of the server. 1 1 are the number of message ready and message unack. Here the server response to the client 1 first => it is unack message. Meanwhile, response for client 2 is in ready state (ready to be sent) => message ready. In general, if there are n clients, n-1 clients will need to wait when the server sends the response message to 1 client

## Question 4:

**+**: IP address of the two machines are: 192.168.1.110 and 192.168.1.115

**+**: How to ping: 

  ```ping <ip address>```

Example:

	ping 192.168.1.110
	PING 192.168.1.110 (192.168.1.110) 56(84) bytes of data.
	64 bytes from 192.168.1.110: icmp_seq=1 ttl=64 time=0.049 ms
	64 bytes from 192.168.1.110: icmp_seq=2 ttl=64 time=0.051 ms
	64 bytes from 192.168.1.110: icmp_seq=3 ttl=64 time=0.043 ms
	64 bytes from 192.168.1.110: icmp_seq=4 ttl=64 time=0.058 ms
	64 bytes from 192.168.1.110: icmp_seq=5 ttl=64 time=0.039 ms
	64 bytes from 192.168.1.110: icmp_seq=6 ttl=64 time=0.041 ms
	64 bytes from 192.168.1.110: icmp_seq=7 ttl=64 time=0.042 ms
	64 bytes from 192.168.1.110: icmp_seq=8 ttl=64 time=0.044 ms
	64 bytes from 192.168.1.110: icmp_seq=9 ttl=64 time=0.040 ms
	64 bytes from 192.168.1.110: icmp_seq=10 ttl=64 time=0.036 ms
	--- 192.168.1.110 ping statistics ---
	10 packets transmitted, 10 received, 0% packet loss, time 9193ms
	rtt min/avg/max/mdev = 0.036/0.044/0.058/0.008 ms

## Question 5:

**+**: Yes, i can watch the video in the client machine

**+**: The quality is good

## Question 6:

**+**: The result of the ping test now:

	ping 192.168.1.110
	PING 192.168.1.110 (192.168.1.110) 56(84) bytes of data.
	64 bytes from 192.168.1.110: icmp_seq=1 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=2 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=3 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=4 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=5 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=6 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=7 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=8 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=9 ttl=64 time=100 ms
	64 bytes from 192.168.1.110: icmp_seq=10 ttl=64 time=100 ms
	--- 192.168.1.110 ping statistics ---
	10 packets transmitted, 10 received, 0% packet loss, time 12ms
	rtt min/avg/max/mdev = 100.503/100.213/100.380/0.018 ms

**+**: Yes i can see the increase of 100 milliseconds

## Question 7:

The video quality at the client is still the same despite of the 100ms delay from the server

However, the overall stream of the client is slightly delayed

## Question 8:

The video quality is still the same, as the delay time is too small to cause any major impacts

## Question 9:

The video quality in terms of buffering is slightly decreased because of the packet loss. The buffer time increases even more when increasing the chance of packet loss because the video must wait for that packet to be re-sent before continuing.

## Question 10:

The impact of loss rate with variation is not much, it is mostly equal to the fixed loss rate

## Question 11:

The impact of packet duplication is not significant on the streaming service. When increasing, the buffer time increases similarly to the packet loss case

## Question 12:

The impact of packet corruption is not significant on the streaming service because the delay is small
