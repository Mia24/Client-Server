/**
 **
 * @author Miao He mhe23@myseneca.ca
 * @version 1.0
 */
package CreditCard;
import java.io.*;
import java.net.*;


public class Client {
	

	public static void main(String[] args){

		    Socket clientSocket;
		    try{
		    	 clientSocket = new Socket(InetAddress.getByName("localhost"), 7145);
		         System.out.println("Connected to " + clientSocket.getInetAddress().getHostName());
		         ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		         ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		         
		         System.out.println("I/O streams connected to the socket");
		         CreditCard one = new CreditCard();
		         one=new CreditCard(33333333L, false);
		         System.out.println("this is first one creditcard object before the server invocation:");
		         System.out.println(one.toString());
		         //CreditCard[0] = new CreditCard(4008001234567891L, false);
		        // CreditCard[1] = new CreditCard(4228661234567891L, true);
		         //CreditCard[2] = new CreditCard(4348561234567891L, false);
		        
		         try{

		             //Send an object to the server
		             outToServer.writeObject(one);
		             outToServer.flush();
		             System.out.println("Sent a CreditCard Object for processing");

		             //Recieve object from server
		             one = (CreditCard) inFromServer.readObject();
		             System.out.println("Recieved a CreditCard Object from the server");
		         } //End try
		         catch (ClassNotFoundException cnf){
		              	 System.out.println(cnf);
		         }
		         catch (EOFException eof){
		        	 System.out.println(eof);
		         }
		         catch (IOException ioe){
		        	 System.out.println(ioe);
		         }
		         outToServer.close();
		         inFromServer.close();
		         clientSocket.close();
		         System.out.println("this is first one creditcard object after the server invocation:");
		         System.out.println(one.toString());
		         
		       
		    }
		       catch (IOException ioe){
		    	   System.out.println(ioe);
		       } 
		       

		       System.out.println("End of the client");
		    }
	}

