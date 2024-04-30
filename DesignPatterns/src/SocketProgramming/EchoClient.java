package SocketProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Connect to the server running on localhost:12345

            // Open input and output streams for the socket
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Send messages to the server and receive echoes back
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String userMessage;
            while ((userMessage = userInput.readLine()) != null) {
                output.println(userMessage); // Send the message to the server
                System.out.println("Server response: " + input.readLine()); // Receive and print the server's response
            }

            // Close the streams and the socket
            input.close();
            output.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
