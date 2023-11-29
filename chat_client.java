package jhansi;
import java.io.*;
import java.net.*;

public class chat_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket c = null;
		String line;
		DataInputStream is=null, is1=null;
		PrintStream os = null;
		try {
			c = new Socket("127.0.0.1",2000);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		try {
			is1 = new DataInputStream(c.getInputStream());
			is = new DataInputStream(System.in);
			os = new PrintStream(c.getOutputStream());
			do{
				System.out.println("Client : ");
				line = is.readLine();
				os.println(line);
				System.out.println("Server : "+is1.readLine());
				
			}while(line.equalsIgnoreCase("quit") == false);
			os.close();is.close();is1.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

}
