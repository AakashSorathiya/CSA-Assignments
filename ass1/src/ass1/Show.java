package ass1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Show {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollpane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Show window = new Show(null,null);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Show(String[][] data,String[] head) {
		initialize(data,head);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[][] data,String[] head) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String data1[][] = {{"no data found"}};
		String head1[] = {"error"};
		if(data==null)
		{
			System.out.println("no data found");
			data = data1;
			head = head1;
		}
		table = new JTable(data,head);
		scrollpane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		//table.add(scrollpane);
		scrollpane.setVisible(true);
		table.setBounds(50, 50, 300, 100);
		scrollpane.setBounds(50, 50, 300, 100);
		frame.getContentPane().add(scrollpane);
		//table.setVisible(true);
	}
}
