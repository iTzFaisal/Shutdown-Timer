//Faisal Alkheraiji
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class ShutdownGUI {

	private JFrame frmShutdownTimer;
	private JTextField tfTime;
	private JButton btnSetTimer;
	private JButton btnResetTimer;
	private JLabel lblByFaisalAlkheraiji;
	private JRadioButtonMenuItem radioButtonsGroup;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMinutes;
	private JRadioButton rdbtnHours;
	private JRadioButton rdbtnSeconds;
	private Image icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ShutdownGUI window = new ShutdownGUI();
					window.frmShutdownTimer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShutdownGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShutdownTimer = new JFrame();
		frmShutdownTimer.setResizable(false);
		frmShutdownTimer.setTitle("Shutdown Timer");
		frmShutdownTimer.setBounds(100, 100, 336, 165);
		frmShutdownTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShutdownTimer.getContentPane().setLayout(null);
		try{
			icon = ImageIO.read(new File("img/shutdown.png"));
		}catch(IOException e){
			
		}
		frmShutdownTimer.setIconImage(icon);
		
		JLabel lblEnterTime = new JLabel("Enter Time:");
		lblEnterTime.setBounds(12, 13, 79, 16);
		frmShutdownTimer.getContentPane().add(lblEnterTime);
		
		tfTime = new JTextField();
		tfTime.setBounds(89, 10, 180, 22);
		frmShutdownTimer.getContentPane().add(tfTime);
		tfTime.setColumns(10);
		
		btnSetTimer = new JButton("Set Timer");
		btnSetTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(rdbtnSeconds.isSelected()){
						Shutdown.setTimer(Integer.parseInt(tfTime.getText()), 0);
					}
					else if(rdbtnMinutes.isSelected()){
						Shutdown.setTimer(Integer.parseInt(tfTime.getText()), 1);
					}
					else if(rdbtnHours.isSelected()){
						Shutdown.setTimer(Integer.parseInt(tfTime.getText()), 2);
					}
					else{
						JOptionPane.showMessageDialog(null, "Please choose a unit");
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
			}
		});
		btnSetTimer.setBounds(12, 69, 108, 25);
		frmShutdownTimer.getContentPane().add(btnSetTimer);
		
		btnResetTimer = new JButton("Reset Timer");
		btnResetTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shutdown.resetTimer();
			}
		});
		btnResetTimer.setBounds(161, 69, 108, 25);
		frmShutdownTimer.getContentPane().add(btnResetTimer);
		
		lblByFaisalAlkheraiji = new JLabel("By: Faisal Alkheraiji");
		lblByFaisalAlkheraiji.setForeground(Color.LIGHT_GRAY);
		lblByFaisalAlkheraiji.setBounds(12, 105, 264, 16);
		frmShutdownTimer.getContentPane().add(lblByFaisalAlkheraiji);
		
		
		rdbtnSeconds = new JRadioButton("Seconds");
		rdbtnSeconds.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				rdbtnMinutes.setSelected(false);
				rdbtnHours.setSelected(false);
			}
		});
		rdbtnSeconds.setBounds(12, 35, 100, 25);
		frmShutdownTimer.getContentPane().add(rdbtnSeconds);
		
		rdbtnMinutes = new JRadioButton("Minutes");
		rdbtnMinutes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rdbtnHours.setSelected(false);
				rdbtnSeconds.setSelected(false);
			}
		});
		rdbtnMinutes.setBounds(116, 35, 100, 25);
		frmShutdownTimer.getContentPane().add(rdbtnMinutes);

		
		rdbtnHours = new JRadioButton("Hours");
		rdbtnHours.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rdbtnMinutes.setSelected(false);
				rdbtnSeconds.setSelected(false);
			}
		});
		rdbtnHours.setBounds(220, 35, 100, 25);
		frmShutdownTimer.getContentPane().add(rdbtnHours);		
	}
}
