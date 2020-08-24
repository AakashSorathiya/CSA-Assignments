import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Client {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.0.0.1", 8050);
		
		OutputStream to = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(to);
		
		File fileName = new File("C:\\Users\\SONY\\Downloads\\barc.txt");
        FileInputStream fis = new FileInputStream(fileName);
        byte[] b = new byte[(int) fileName.length()];

        fis.read(b, 0, b.length);
        dos.write(b);
        
        dos.close();
        to.close();

        fis.close();
		
		s.close();
		

	}

}
