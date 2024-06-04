package LibrarySystem;

import java.awt.EventQueue;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class BorrowerList extends JFrame{
	private static final long serialVersionUID = 1L;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs1;
	static ResultSet rs2;
    static String query1;
    static String query2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerList window = new BorrowerList();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BorrowerList() {
		
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setBounds(550, 200, 468, 245);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Borrower List");

        String[][] studentData = new String[10][4];
        String[][] teacherData = new String[3][3];

        try {
            query1 = "SELECT username, student_id, year_level, section FROM users WHERE role = 'Student'";
            rs1 = stmt.executeQuery(query1);

            int i = 0;
            while (rs1.next()) {
                studentData[i][0] = rs1.getString("username");
                studentData[i][1] = rs1.getString("student_id");
                studentData[i][2] = rs1.getString("year_level");
                studentData[i][3] = rs1.getString("section");
                i++;
            }

            query2 = "SELECT username, employee_id, department FROM users WHERE role = 'Teacher'";
            rs2 = stmt.executeQuery(query2);

            int j = 0;
            while (rs2.next()) {
                teacherData[j][0] = rs2.getString("username");
                teacherData[j][1] = rs2.getString("employee_id");
                teacherData[j][2] = rs2.getString("department");
                j++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable studentTable = new JTable(studentData, new String[]{"NAME", "STUDENT_ID", "YEAR_LEVEL", "SECTION"});
        JTable teacherTable = new JTable(teacherData, new String[]{"NAME", "EMPLOYEE_ID", "DEPARTMENT"});

        JPanel studentPanel = new JPanel();
        studentPanel.add(new JScrollPane(studentTable));
        JPanel teacherPanel = new JPanel();
        teacherPanel.add(new JScrollPane(teacherTable));

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Student", studentPanel);
        tabs.add("Teacher", teacherPanel);
        studentTable.setBackground(new Color(252, 251, 237));
        teacherTable.setBackground(new Color(252, 251, 237));
        tabs.setBackground(new Color(120, 202, 250));

        getContentPane().add(new JScrollPane(tabs));
        
        pack();
        setVisible(true);
    }
}
