package jhansi;
import java.net.*;
import java.io.*;
public class fileServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket s =null;
		Socket c = null;
		try{
			s = new ServerSocket(5000);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		try{
			c = s.accept();
			
			File file = new File("C://Users//nanda//Desktop//jhansi//5th sem//cn//file.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			OutputStream os = c.getOutputStream();
			
			byte[] contents;
			long fileLength = file.length();
			long current =0;
			long start = System.nanoTime();
			while(current != fileLength) {
				int size = 100;
				if(fileLength - current >= size)
					current += size;
				else {
					size = (int)(fileLength - current);
					current = fileLength;
				}
				contents = new byte[size];
				bis.read(contents, 0, size);
				os.write(contents);
				System.out.println("sending file ... "+(current*100)/fileLength+"% complete!");
			}
			long end = System.nanoTime();
			
			os.flush();
			bis.close();
			c.close();
			s.close();
			System.out.println("successfully send");
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
