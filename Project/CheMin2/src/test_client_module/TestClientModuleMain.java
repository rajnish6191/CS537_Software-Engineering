package test_client_module;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.awt.event.ActionEvent;

import json.Constants;

public class TestClientModuleMain {

	private JFrame frmTestClient;
	protected int flag = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		//int flag = 0;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestClientModuleMain window = new TestClientModuleMain();
					window.frmTestClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestClientModuleMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frmTestClient = new JFrame();
		frmTestClient.setTitle("Test client");
		frmTestClient.setBounds(100, 100, 500, 346);
		frmTestClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("rawtypes")
		JComboBox settings_selection = new JComboBox();
		settings_selection.setModel(new DefaultComboBoxModel<Object>(new String[] {"Run full process", "Manual selection"}));
		JPanel commands_selection = new JPanel();
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("sample_receive");
		JCheckBox chckbxNewCheckBox = new JCheckBox("xray_set_position");
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("cell_next");
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("cell_clean_current");
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("inlet_open");
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("inlet_close");
		JCheckBox chckbxFillsamplecell = new JCheckBox("fill_sample_cell");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox_1.setEnabled(false);
		chckbxNewCheckBox_2.setEnabled(false);
		chckbxNewCheckBox_3.setEnabled(false);
		chckbxNewCheckBox_4.setEnabled(false);
		chckbxNewCheckBox_5.setEnabled(false);
		chckbxFillsamplecell.setEnabled(false);
		
		GroupLayout gl_commands_selection = new GroupLayout(commands_selection);
		gl_commands_selection.setHorizontalGroup(
			gl_commands_selection.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_commands_selection.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_commands_selection.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxNewCheckBox)
						.addComponent(chckbxNewCheckBox_2)
						.addComponent(chckbxNewCheckBox_3)
						.addComponent(chckbxNewCheckBox_4)
						.addComponent(chckbxNewCheckBox_1)
						.addComponent(chckbxFillsamplecell)
						.addComponent(chckbxNewCheckBox_5))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_commands_selection.setVerticalGroup(
			gl_commands_selection.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_commands_selection.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxNewCheckBox)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_1)
					.addGap(1)
					.addComponent(chckbxNewCheckBox_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxFillsamplecell)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_5)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		commands_selection.setLayout(gl_commands_selection);
		
		JPanel panel_1 = new JPanel();
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("power_off");
		chckbxNewCheckBox_11.setEnabled(false);
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("send_results");
		chckbxNewCheckBox_10.setEnabled(false);
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("cdd_create_1d_2t_plot");
		chckbxNewCheckBox_9.setEnabled(false);
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("cdd_create_diffraction_image");
		chckbxNewCheckBox_8.setEnabled(false);
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("analysis_start");
		chckbxNewCheckBox_7.setEnabled(false);
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("xray_turn_on");
		chckbxNewCheckBox_6.setEnabled(false);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxNewCheckBox_6)
						.addComponent(chckbxNewCheckBox_7)
						.addComponent(chckbxNewCheckBox_8)
						.addComponent(chckbxNewCheckBox_9)
						.addComponent(chckbxNewCheckBox_10)
						.addComponent(chckbxNewCheckBox_11))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxNewCheckBox_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxNewCheckBox_7)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_8)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_9)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_10)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox_11)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		
		JPanel panel = new JPanel();
		JButton send_button = new JButton("Send commands to chemin");
		panel.add(send_button);
		send_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//when send button is pressed, create txt command files and send command file path to chemin
				///// .txt command file creation
				String command_file_name = "command_file.txt";
				PrintWriter writer = null;
				try {
					writer = new PrintWriter(Constants.ROOT_PATH+command_file_name, "UTF-8");
				} catch (FileNotFoundException e) {
		
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
				
					e.printStackTrace();
				}
				if(settings_selection.getSelectedItem()=="Run full process")
				{
					//fill .txt file
					writer.println("launch_Chemin_Process");
					writer.close();
				} else if(settings_selection.getSelectedItem()=="Manual selection")
				{
					//fill .txt file
					if(chckbxNewCheckBox.isSelected())
					{
						writer.println("xray_set_position");
					}
					if(chckbxNewCheckBox_1.isSelected())
					{
						writer.println("sample_receive");
					}
					if(chckbxNewCheckBox_2.isSelected())
					{
						writer.println("cell_next");
					}
					if(chckbxNewCheckBox_3.isSelected())
					{
						writer.println("cell_clean_current");
					}
					if(chckbxNewCheckBox_4.isSelected())
					{
						writer.println("inlet_open");
					}
					if(chckbxFillsamplecell.isSelected())
					{
						writer.println("sample_fill");
					}
					if(chckbxNewCheckBox_5.isSelected())
					{
						writer.println("inlet_close");
					}
					if(chckbxNewCheckBox_6.isSelected())
					{
						writer.println("xray_turn_on");
					}
					if(chckbxNewCheckBox_7.isSelected())
					{
						writer.println("analysis_start");
					}
					if(chckbxNewCheckBox_8.isSelected())
					{
						writer.println("cdd_create_diffraction_image");
					}
					if(chckbxNewCheckBox_9.isSelected())
					{
						writer.println("cdd_create_1d_2t_plot");
					}
					if(chckbxNewCheckBox_10.isSelected())
					{
						writer.println("send_results");
					}
					if(chckbxNewCheckBox_11.isSelected())
					{
						writer.print("");
						writer.close();
						try {
							writer = new PrintWriter(Constants.ROOT_PATH+command_file_name, "UTF-8");
						} catch (FileNotFoundException | UnsupportedEncodingException e) {
							
							e.printStackTrace();
						}
						writer.println("power_off");
						flag = 1;
					}
					writer.close();
				}
				Socket socket = null;
				if(flag == 0) {
					try {

						socket = new Socket("localhost",9010);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					ObjectOutputStream outstr = null;
					try {
						outstr = new ObjectOutputStream(socket.getOutputStream());
					} catch (IOException e) {
					
						e.printStackTrace();
					}
					try {

						outstr.writeObject(Constants.ROOT_PATH+command_file_name);
					} catch (IOException e) {
						
						e.printStackTrace();
					}

				} else {

					try {


						flag = 0;
						socket = new Socket("localhost",9008);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					ObjectOutputStream outstr = null;
					try {
						outstr = new ObjectOutputStream(socket.getOutputStream());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					try {

						outstr.writeObject("power_off");
					} catch (IOException e) {
						
						e.printStackTrace();
					}

				}




			}});
		JButton reset_button = new JButton("Reset");
		panel.add(reset_button);
		GroupLayout groupLayout = new GroupLayout(frmTestClient.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(settings_selection, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(commands_selection, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(69)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(settings_selection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addComponent(commands_selection, GroupLayout.PREFERRED_SIZE, 206, Short.MAX_VALUE))
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frmTestClient.getContentPane().setLayout(groupLayout);


		reset_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				Socket socket = null;
				try {



					socket = new Socket("localhost",9008);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				ObjectOutputStream outstr = null;
				try {
					outstr = new ObjectOutputStream(socket.getOutputStream());
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				try {

					outstr.writeObject("reset");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}


			}
		});
		settings_selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(settings_selection.getSelectedItem()=="Run full process")
				{
					chckbxNewCheckBox.setEnabled(false);
					chckbxNewCheckBox_1.setEnabled(false);
					chckbxNewCheckBox_2.setEnabled(false);
					chckbxNewCheckBox_3.setEnabled(false);
					chckbxNewCheckBox_4.setEnabled(false);
					chckbxNewCheckBox_5.setEnabled(false);
					chckbxNewCheckBox_6.setEnabled(false);
					chckbxNewCheckBox_7.setEnabled(false);
					chckbxNewCheckBox_8.setEnabled(false);
					chckbxNewCheckBox_9.setEnabled(false);
					chckbxNewCheckBox_10.setEnabled(false);
					chckbxFillsamplecell.setEnabled(false);
					
					chckbxNewCheckBox_11.setEnabled(false);
					//fill .txt file
				} else if(settings_selection.getSelectedItem()=="Manual selection")
				{
					chckbxNewCheckBox.setEnabled(true);
					chckbxNewCheckBox_1.setEnabled(true);
					chckbxNewCheckBox_2.setEnabled(true);
					chckbxNewCheckBox_3.setEnabled(true);
					chckbxNewCheckBox_4.setEnabled(true);
					chckbxNewCheckBox_5.setEnabled(true);
					chckbxNewCheckBox_6.setEnabled(true);
					chckbxNewCheckBox_7.setEnabled(true);
					chckbxNewCheckBox_8.setEnabled(true);
					chckbxNewCheckBox_9.setEnabled(true);
					chckbxNewCheckBox_10.setEnabled(true);
					chckbxNewCheckBox_11.setEnabled(true);
					chckbxFillsamplecell.setEnabled(true);
					//fill .txt file
				}
			}
		});

	}
}

