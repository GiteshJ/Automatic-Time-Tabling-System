package phoenix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Labfilter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	DisplayManager dm= new DisplayManager();
    public Labfilter() {
    	setTitle("AUTOMATIC TIME TABLING SYSTEM");
    	initialise_component();
    }
    public Labfilter(DisplayManager d) {
    	dm=d;
    	initialise_component();
    }
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Labfilter frame = new Labfilter();
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
	public void initialise_component() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JComboBox select_lab = new JComboBox();
		select_lab.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "C1", "C2", "C3", "C4", "C5", "C6"}));
		select_lab.setMaximumRowCount(9);
		select_lab.setFont(new Font("Times New Roman", Font.BOLD, 18));
		select_lab.setForeground(new Color(0, 204, 255));
		select_lab.setBounds(212, 111, 134, 26);
		contentPane.add(select_lab);
		
		JLabel lab = new JLabel("SELECT LAB");
		lab.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lab.setForeground(new Color(0, 204, 255));
		lab.setBounds(10, 111, 134, 26);
		contentPane.add(lab);
		
		JLabel year = new JLabel("SELECT YEAR");
		year.setForeground(new Color(0, 204, 255));
		year.setFont(new Font("Times New Roman", Font.BOLD, 18));
		year.setBounds(10, 63, 134, 26);
		contentPane.add(year);
		
		JComboBox select_year = new JComboBox();
		select_year.setModel(new DefaultComboBoxModel(new String[] {"1st year", "2nd year", "3rd year", "4th year"}));
		select_year.setForeground(new Color(0, 204, 255));
		select_year.setFont(new Font("Times New Roman", Font.BOLD, 18));
		select_year.setBounds(212, 65, 134, 26);
		contentPane.add(select_year);
		
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
		cancel.setBounds(231, 185, 115, 30);
		contentPane.add(cancel);
	}
	private void homeActionPerformed(ActionEvent e) {
    	
    	dm.load(dm);
        this.setVisible(false);
    }
    private void submitActionPerformed(ActionEvent e) {
    	
    	View v=new View();
    	v.setVisible(true);
        this.setVisible(false);
    }
    private void cancelActionPerformed(ActionEvent e) {
    	
    	dm.setFilterScreen(dm);
        this.setVisible(false);
    }
}
