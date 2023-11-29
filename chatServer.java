package jhansi;
import java.net.*;
import java.io.*;
public class chatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket s = null;
		DataInputStream is = null, is1 = null;
		PrintStream os = null;
		Socket c = null;
		String line;
		try {
			s=new ServerSocket(2000);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		try {
			c=s.accept();
			is = new DataInputStream(c.getInputStream());
			is1 = new DataInputStream(System.in);
			os = new PrintStream(c.getOutputStream());
			
			do {
				line = is.readLine();
				System.out.println("Client : "+line);
				System.out.print("Server : ");
				line = is1.readLine();
				os.println(line);
			}while(line.equalsIgnoreCase("quit") == false);
			
			os.close();is.close();is1.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

}
