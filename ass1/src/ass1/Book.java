package ass1;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Book {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book window = new Book();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(183, 78, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMyBookStore = new JLabel("My Book Store");
		lblMyBookStore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMyBookStore.setBounds(120, 10, 202, 37);
		frame.getContentPane().add(lblMyBookStore);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId.setBounds(78, 77, 71, 16);
		frame.getContentPane().add(lblBookId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 107, 96, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(183, 136, 96, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(183, 165, 96, 19);
		frame.getContentPane().add(textField_3);
		
		JLabel lblBookId_1 = new JLabel("Book Name");
		lblBookId_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId_1.setBounds(78, 103, 84, 16);
		frame.getContentPane().add(lblBookId_1);
		
		JLabel lblBookId_2 = new JLabel("Author");
		lblBookId_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId_2.setBounds(78, 136, 71, 16);
		frame.getContentPane().add(lblBookId_2);
		
		JLabel lblBookId_3 = new JLabel("Publication");
		lblBookId_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId_3.setBounds(78, 165, 78, 16);
		frame.getContentPane().add(lblBookId_3);
		
		JLabel lblBookId_4 = new JLabel("Price");
		lblBookId_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId_4.setBounds(78, 196, 71, 16);
		frame.getContentPane().add(lblBookId_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(183, 194, 96, 19);
		frame.getContentPane().add(textField_4);
		
		JButton btnQuery = new JButton("Query");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query window = new Query();
				//window.frame.setVisible(true);
			}
		});
		btnQuery.setBounds(316, 77, 85, 21);
		frame.getContentPane().add(btnQuery);
		
		JButton btnQuery_1 = new JButton("Submit");
		btnQuery_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{	
					File f = new File("F:\\msujava\\JAVA_WORK\\ass1\\Book.dat");
				
					if(f.exists())
					{
						BufferedReader br=new BufferedReader(new FileReader("F:\\msujava\\JAVA_WORK\\ass1\\Book.dat"));
						while(br.readLine()!=null);
						br.close();
					}
					BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\msujava\\JAVA_WORK\\ass1\\Book.dat",true));
					
					bw.write(textField.getText()); bw.newLine();
					bw.write(textField_1.getText()); bw.newLine();
					bw.write(textField_2.getText()); bw.newLine();
					bw.write(textField_3.getText()); bw.newLine();
					bw.write(textField_4.getText()); bw.newLine();
					bw.close();
				}
				catch(Exception ef)
				{
					System.out.print("ERROR : "+ef.getMessage());
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnQuery_1.setBounds(316, 122, 85, 21);
		frame.getContentPane().add(btnQuery_1);
		
		JButton btnQuery_2 = new JButton("Show");
		btnQuery_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int count=0,i=0;
				String head[]={"BID","BNA","AUT","PUB","EDI"};
			
				try
				{
					BufferedReader br=new BufferedReader(new FileReader("F:\\msujava\\JAVA_WORK\\ass1\\Book.dat"));
					
					while(br.readLine()!=null)
					{
						count++;
					}
					br.close();
					count = count/5;
					if(count!=0)
					{
						br=new BufferedReader(new FileReader("F:\\msujava\\JAVA_WORK\\ass1\\Book.dat"));
					
						String data[][]=new String[count][5];
					
						while(count!=0)
						{
							data[i][0]=br.readLine();
							data[i][1]=br.readLine();
							data[i][2]=br.readLine();
							data[i][3]=br.readLine();
							data[i][4]=br.readLine();
							i++; count--;
						}
						br.close();
						Show window = new Show(data,head);
						
					}
				}
				catch(Exception ef)
				{
					System.out.println(ef.getMessage());
				}
			}
		});
		btnQuery_2.setBounds(316, 164, 85, 21);
		frame.getContentPane().add(btnQuery_2);
	}
}
