package phoenix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Instructorfilter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructorfilter frame = new Instructorfilter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	DisplayManager dm = new DisplayManager();
	private JTextField ins_name;
	public Instructorfilter() {
		setTitle("AUTOMATIC TIME TABLING SYSTEM");
		
		initialise_component();
		
	}
	public Instructorfilter(DisplayManager d) {
		dm=d;
		initialise_component();
		
	}
	public void initialise_component() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		 setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton HOME = new JButton("HOME");
		HOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeActionPerformed( e);
			}
		});
		HOME.setForeground(new Color(0, 204, 255));
		HOME.setFont(new Font("Times New Roman", Font.BOLD, 18));
		HOME.setBounds(10, 11, 121, 30);
		contentPane.add(HOME);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitActionPerformed( e);
			}
		});
		submit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		submit.setForeground(new Color(0, 204, 255));
		submit.setBounds(10, 185, 121, 30);
		contentPane.add(submit);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed( e);
			}
		});
		cancel.setForeground(new Color(0, 204, 255));
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cancel.setBounds(309, 185, 115, 30);
		contentPane.add(cancel);
		
		JLabel instructor = new JLabel("ENTER INSTRUCTOR NAME");
		instructor.setFont(new Font("Times New Roman", Font.BOLD, 18));
		instructor.setForeground(new Color(0, 204, 255));
		instructor.setBounds(10, 84, 303, 30);
		contentPane.add(instructor);
		
		ins_name = new JTextField();
		ins_name.setFont(new Font("Tahoma", Font.BOLD, 18));
		ins_name.setForeground(new Color(0, 204, 255));
		ins_name.setBounds(291, 88, 121, 26);
		contentPane.add(ins_name);
		ins_name.setColumns(10);
	}
	private void homeActionPerformed(ActionEvent e) {
    	
    	dm.load(dm);
        this.setVisible(false);
    }
    private void submitActionPerformed(ActionEvent e) {
    	
    	
        this.setVisible(false);
    }
    private void cancelActionPerformed(ActionEvent e) {
    	
    	dm.setFilterScreen(dm);
        this.setVisible(false);
    }
}
