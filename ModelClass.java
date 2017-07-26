/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package sample;
import java.io.*;
import java.net.*;

/**
 *
 * @author LEHoang
 */
public class ModelClass {
    
   /* public static void connect () throws IOException{
        // Open the connection on Port 555
        // Open the connection on Port 555
        ServerSocket server = new ServerSocket(555);
        
        Socket connection =server.accept();
        // Setup DataOut
        System.out.println("Client has connected !");
       
        
        
    }*/
    public static void communication(Socket connection, String MessIn) throws IOException{
        
        OutputStream os  = connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        String MessOut = "Hello Client, this is the JVServer!";
         // Send Messsage
        bw.write(MessOut);
        bw.flush();
       
        // get DataIn
       InputStream is = connection.getInputStream();
       InputStreamReader isr = new InputStreamReader(is);
       BufferedReader br = new BufferedReader(isr);
       MessIn = br.readLine();
       System.out.println("Mess from Client C++ is: " +MessIn);
    }
    
}
