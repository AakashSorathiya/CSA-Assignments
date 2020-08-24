package ass1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Query {

	JFrame frame;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query window = new Query();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Query() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(143, 75, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblQueryOn = new JLabel("Query On :");
		lblQueryOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQueryOn.setBounds(41, 36, 80, 13);
		frame.getContentPane().add(lblQueryOn);
		
		JLabel lblQuery = new JLabel("Query");
		lblQuery.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuery.setBounds(41, 76, 80, 13);
		frame.getContentPane().add(lblQuery);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Book ID", "Book Name", "Author", "Publication"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(141, 34, 109, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
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
							//System.out.println(data[i][0] + textField.getText());
							data[i][1]=br.readLine();
							data[i][2]=br.readLine();
							data[i][3]=br.readLine();
							data[i][4]=br.readLine();
							int j = comboBox.getSelectedIndex();
							//System.out.println(data[i][j]+textField.getText());
							if(data[i][j].equals(textField.getText()))
							{
								i++;
							}
							count--;
						}
						
						//System.out.println(data[i][0] + textField.getText());
						if(i!=0) {
						if(data[i][comboBox.getSelectedIndex()]!=textField.getText())
						{
							String news[] = {"","","","",""};
							data[i]=news;
						}
						}
						else
						{
							data = null;
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
		btnNewButton.setBounds(120, 156, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
