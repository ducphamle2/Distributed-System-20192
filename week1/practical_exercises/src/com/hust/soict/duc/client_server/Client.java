package com.hust.soict.duc.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
// Note: We need to use consistent type of reader and writer between server and client
public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9898);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			System.out.println(in.readLine());
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String temp = scanner.nextLine(); // this is not efficient but who cares
				if (temp.isEmpty() || temp.equals("\n")) // if user types empty then out of the loop
					break;
				out.println(temp); // send data to server
				//read data sent from server. Remember to use variable defined before not new one
	            String line;
	            while ((line = in.readLine()) != null) {
	                System.out.println(line);
	            }
			}
			socket.close();
			scanner.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
