package LibrarySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BorrowerList_NODB extends JFrame {
	private static final long serialVersionUID = 1L;
	//JLabel lblUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerList_NODB window = new BorrowerList_NODB();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BorrowerList_NODB() {
		setTitle("Borrower List");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		new JFrame();
		
		
		setBounds(620, 200, 468, 245);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] columns = new String[] {
				"NAME", "STUDENT_ID", "YEAR_LEVEL", "SECTION"
		};
		
		Object[][] data = new Object[][] {
			{"Russel", "A12345071", "1st", "I-CCSAD"},
			{"Rona", "A12345123", "1st", "I-CCSAD"},
			{"Althea", "K12345345", "1st", "I-CCSAD"},
			{"Sarah", "A12345125", "1st", "I-CCSAD"},
			{"Mea", "K12345071", "1st", "I-CCSAD"},
			{"Skye", "K12345987", "1st", "I-CCSAD"},
			{"Grace", "A12345771", "1st", "I-CCSAD"},
			{"Taher", "K12345482", "1st", "I-AINS"},
			{"Hazel", "A12345009", "1st", "I-BCSAD"},
			{"Mark", "A12345023", "1st", "I-CCSAD"},
		};
		
		String[] columns2 = new String[] {
				"NAME", "EMPLOYEE_ID", "DEPARTMENT"
		};
		
		Object[][] data2 = new Object[][] {
			{"Joms", "123456789", "CCIS"},
			{"Alex", "246810121", "CCIS"},
			{"Jennifer", "987654321", "CCIS"},
			
		};
		
		JTable table = new JTable(data, columns);
		JTable table2 = new JTable(data2, columns2);
		
		JPanel p1 = new JPanel();
		p1.add(table);
		JPanel p2 = new JPanel();
		p2.add(table2);
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(100, 100, 468, 245);
		tabs.add("Student", p1);
		tabs.add("Teacher", p2);
		
		getContentPane().add(new JScrollPane(tabs));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}

}
