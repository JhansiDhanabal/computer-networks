package jhansi;
import java.io.*;
import java.net.*;
public class fileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket c = null;
		try {
			c = new Socket("127.0.0.1",5000);
			byte [] contents = new byte[100];
			FileOutputStream fos = new FileOutputStream("C://Users//nanda//Desktop//jhansi//5th sem//cn//file1.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			InputStream is = c.getInputStream();
			
			int bytesRead = 0;
			while((bytesRead=is.read(contents)) != -1)
				bos.write(contents, 0, bytesRead);
			
			bos.flush();
			c.close();
			System.out.println("file saved successfully");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

}
