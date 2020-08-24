import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(8050);
		Socket s = ss.accept();
		InputStream from = s.getInputStream();
		DataInputStream dis = new DataInputStream(from);

		
		File fileName = new File("E:\\TCP\\server.txt");
        byte[] b = dis.readAllBytes();
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(b, 0, b.length);
        fos.flush();
        fos.close();
		
		ss.close();
	}
}