package telecom_module;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.text.DefaultCaret;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiTelecomControlPanel {

	private JFrame frmTelecomControlPanel;
	private static GuiTelecomControlPanel window=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new GuiTelecomControlPanel();
					window.frmTelecomControlPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public GuiTelecomControlPanel() {
		initialize();
	}

	private JTextArea txtrTelecomControlPanel=null;

	private ActionListener taskPerformer= null;
	static private String message= " ";
	static private String text= " ";
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelecomControlPanel = new JFrame();
		frmTelecomControlPanel.setTitle("Telecom control panel");
		frmTelecomControlPanel.setBounds(580, 710, 470, 200);
		frmTelecomControlPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtrTelecomControlPanel = new JTextArea();
		txtrTelecomControlPanel.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtrTelecomControlPanel);	
		
		txtrTelecomControlPanel.append(message);
		txtrTelecomControlPanel.setFont(new Font("Monospaced", Font.PLAIN, 13));
		DefaultCaret caret = (DefaultCaret)txtrTelecomControlPanel.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		frmTelecomControlPanel.getContentPane().add(scrollPane, BorderLayout.CENTER);
		taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				System.out.println(message);
				frmTelecomControlPanel.setVisible(false);
				main(null);
			
				txtrTelecomControlPanel.append(message);
				txtrTelecomControlPanel.append("\n");
				
			}
		};
	}


	public void write(String mess) {
		message = mess;
	//	text.concat("\n");
		text = text + message + "\n";
		message = text;
		taskPerformer.actionPerformed(null);
	}
}

