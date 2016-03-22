/**
 **
 * @author Miao He mhe23@myseneca.ca
 * @version 1.0
 */
package CreditCard;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args){

	    System.out.println("CreditCardServer started.");

	    try{
	    	@SuppressWarnings("resource") 
			ServerSocket s = new ServerSocket(7145); //My Student # last four digits
	        Socket clientSocket = s.accept();
	        System.out.println("Connected to: " + clientSocket.getInetAddress()
	          + " at port: " + clientSocket.getLocalPort());

	      //Connect input and output streams to the socket
	      ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
	      ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());
	      CreditCard one;
	      try{
	          
	          while(true){ //While there is data from the client
	            //Read the object from the client
	        	  one = (CreditCard) inFromClient.readObject();
	            System.out.println("Recieved CreditCard Object from client");

	            //Assign CreditCardNumber for the CreditCard with the CreditCard's hashCode
	            //one.setCreditCardNumber(one.isValid());
	            boolean check = CardValidation.isValid(one.getCreditCardNumber());
	           // one.setCreditCardNumber(one.hashCode());
	            //Send the edited CreditCard Object back to the client then flush the output stream
	            one.setFlag(check);
	            outToClient.writeObject(one);
	            outToClient.flush();
	            System.out.println("Send CreditCard Object back to client");
	          }

	        } //End try
	        catch (ClassNotFoundException cnf){
	          //cnf.printStackTrace();
	        	 System.out.println(cnf);
	        }
	        catch (EOFException eof){
	          System.out.println("The client has terminated the session");
	        }
	        catch (IOException ioe){
	        	System.out.println(ioe);
	        }

	        //Close the connection to the client
	        outToClient.close();
	        inFromClient.close();
	        clientSocket.close();

	      } //End try
	      catch (IOException ioe){
	    	  System.out.println(ioe);
	      }
	    }
	  }

