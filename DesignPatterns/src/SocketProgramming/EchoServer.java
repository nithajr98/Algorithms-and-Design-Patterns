package SocketProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Create a server socket bound to port 12345
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Wait for a client connection
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Open input and output streams for the client socket
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);


                // Echo messages back to the client
                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Received from client: " + message);
                    output.println("Server echoes: " + message); // Send back the echoed message
                }

                // Close the streams and the socket for this client
                input.close();
                output.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
