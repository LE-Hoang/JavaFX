/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author LEHoang
 */
public class FXMLDocumentController implements Initializable {
    
   
    
    @FXML
    private Button Snap;
    @FXML
    private Button Live;
    @FXML
    private Button Stop;
    @FXML
    private ImageView display;
    @FXML
    private Label Time;
    public Socket connection;
    public ServerSocket server;
    /*private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
   
    @FXML
    private TextField bash;
   
    
    @FXML
    private void handleButtonSnap(ActionEvent event){
        
       File imagefile =  new File("C:\\Users\\LEHoang\\Desktop\\test.jpg");
       String imageUrl = imagefile.toURI().toString(); 
       display.setImage(new Image(imageUrl));
    }
    @FXML
    private void handleButtonLive(ActionEvent event) throws IOException  {
          String MessIn = new String();
          ModelClass.communication(connection,MessIn);
          bash.setText(MessIn);
          System.out.println(MessIn);
         
          
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            // TODO
            // Open the connection on Port 555
             server = new ServerSocket(555);
            
             connection =server.accept();
            // Setup DataOut
            System.out.println("Client has connected !");
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
}
