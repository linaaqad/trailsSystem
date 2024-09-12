package boundary;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.JDatePicker;

import com.toedter.calendar.JDateChooser;

import control.addTrailLogic;
import control.addTrailLogic;
import control.ex;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import entity.DifficultyLevel;
import entity.NatureGuide;
import entity.Site;

import javax.swing.JTextArea;
import javax.swing.JButton;
import entity.TrailType;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;



@SuppressWarnings("serial")
public class addnewtrail extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JTextField textFieldDescription;
	private JTextField textField;
	@SuppressWarnings("unused")
	private JTextField textField_1;
	private JComboBox comboBoxTrailType = new JComboBox();
	private JComboBox comboBox = new JComboBox();
	private static ArrayList<entity.NatureGuide> NGuiedsInSite;
	private static ArrayList<Long> sitenums;

	JLabel addedmess = new JLabel("Trail added sucessfuly!!");
	private JComboBox textFieldSiteNum;
	private JList<entity.NatureGuide> NGuidelist = new JList<NatureGuide>();
	private JDateChooser trailDatePicker = new JDateChooser();
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                addnewtrail frame = new addnewtrail();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	    example();
	    example1();
}
	
public static void example() {
	sitenums = ex.getInstance().getSiteNumbers();
} 

public static void example1() {
	NGuiedsInSite = ex.getInstance().getNatureGuide();
}
	 
	public addnewtrail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 530);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("let's add a new trail!");
		lblTitle.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		lblTitle.setBounds(312, 2, 276, 29);
		contentPane.add(lblTitle);
		
		JLabel lblEnterDetails = new JLabel("please enter the trail details:");
		lblEnterDetails.setFont(new Font("Bradley Hand ITC", Font.BOLD, 23));
		lblEnterDetails.setBounds(10, 27, 418, 44);
		contentPane.add(lblEnterDetails);
		
		JLabel lblDescription = new JLabel("description:");
		lblDescription.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		lblDescription.setBounds(78, 110, 108, 20);
		contentPane.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBounds(232, 103, 206, 36);
		contentPane.add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		JLabel lblDefLevel = new JLabel("difficultyLevel:");
		lblDefLevel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		lblDefLevel.setBounds(78, 161, 144, 29);
		contentPane.add(lblDefLevel);
		
		
		comboBox.setModel(new DefaultComboBoxModel(DifficultyLevel.values()));
		comboBox.setSelectedIndex(1);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(232, 165, 206, 22);
		contentPane.add(comboBox);
		
		JLabel lblLengh = new JLabel("length:");
		lblLengh.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		lblLengh.setBounds(78, 211, 80, 29);
		contentPane.add(lblLengh);
		
		textField = new JTextField();
		textField.setBounds(232, 216, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTrailType = new JLabel("TrailType:");
		lblTrailType.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		lblTrailType.setBounds(78, 251, 93, 29);
		contentPane.add(lblTrailType);
		
		
		comboBoxTrailType.setModel(new DefaultComboBoxModel(TrailType.values()));
		comboBoxTrailType.setSelectedIndex(1);
		comboBoxTrailType.setMaximumRowCount(5);
		comboBoxTrailType.setBounds(232, 255, 206, 22);
		contentPane.add(comboBoxTrailType);
		
		JLabel lblSiteNum = new JLabel("Sitenumber:");
		lblSiteNum.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		lblSiteNum.setBounds(78, 309, 125, 14);
		contentPane.add(lblSiteNum);
		
		JLabel lblTrailGuides = new JLabel("choose Trail Guides:");
		lblTrailGuides.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblTrailGuides.setBounds(584, 71, 177, 21);
		contentPane.add(lblTrailGuides);
		
		JLabel lblTrailDate = new JLabel("TrailDate:");
		lblTrailDate.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
		lblTrailDate.setBounds(78, 355, 125, 14);
		contentPane.add(lblTrailDate);
		
		
		
        trailDatePicker.setBounds(232, 349, 206, 20);;
        contentPane.add(trailDatePicker);
		
		JButton btnAddTrail = new JButton("Add trail");
		btnAddTrail.setForeground(UIManager.getColor("Button.disabledForeground"));
		btnAddTrail.setBackground(UIManager.getColor("Button.darkShadow"));
		btnAddTrail.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		btnAddTrail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddTrail.setBounds(91, 409, 114, 29);
		contentPane.add(btnAddTrail);
		
		
		NGuidelist.setBounds(526, 103, 304, 359);
		contentPane.add(NGuidelist);
		NGuiedsInSite = ex.getInstance().getNatureGuide();
		NGuidelist.setListData(NGuiedsInSite.toArray(new NatureGuide[0]));
		
		textFieldSiteNum = new JComboBox();
		//textFieldSiteNum.setModel(new DefaultComboBoxModel(new String[] {"1 ", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		  for (Long siteNum : sitenums) {
		        textFieldSiteNum.addItem(String.valueOf(siteNum));
		    }

		textFieldSiteNum.setBounds(232, 306, 206, 22);
		contentPane.add(textFieldSiteNum);
		
		JButton btnaddanother = new JButton("add another trail");
		btnaddanother.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		btnaddanother.setBounds(312, 410, 177, 26);
		contentPane.add(btnaddanother);
		//trailnum++;
		
		btnAddTrail.addActionListener(this);
		btnaddanother.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ev) {
		String arg = ev.getActionCommand();
		if(arg.equals("Add trail"))
		{
		// add the trail details(to the tblTrail)
			String entereddiscription= textFieldDescription.getText();
			DifficultyLevel entereddifficultyLevel = (DifficultyLevel) comboBox.getSelectedItem();
			String difficultyLevelAsString = entereddifficultyLevel.toString();
			String enteredlength= textField.getText();
			float floatValue=0;
			try {
			    floatValue = Float.parseFloat(enteredlength);
			    // Use floatValue where needed
			TrailType enteredTrailType = (TrailType) comboBoxTrailType.getSelectedItem();
			String enteredTrailType1 = enteredTrailType.toString();
			int enteredsite = Integer.parseInt(((String) textFieldSiteNum.getSelectedItem()).trim());
			addTrailLogic.getInstance();
			int trailnum = addTrailLogic.addtrail(difficultyLevelAsString,entereddiscription,floatValue,enteredTrailType1,enteredsite);
			 //System.out.println(trailnum);
		
			 // now add the trailDate and the guides to the contact table (tblNatureGuideAccompanyTrail) 
			 //, we want in this table : trailnum , natureGuideId , traildate
			Date entereddate = new Date(trailDatePicker.getDate().getTime());
			List<entity.NatureGuide> selectedGuides = NGuidelist.getSelectedValuesList();
			
            // call the function addguidedate selected guides times every time with the next selected guide,
            for (entity.NatureGuide guide : selectedGuides) {
            	addTrailLogic.addguidedate(trailnum,guide.getGuideserialNumber(),entereddate);
                System.out.println("Selected guide: " + guide.getGuideserialNumber());
            }
            // added successfully message
			contentPane.add(addedmess);
			addedmess.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
			addedmess.setBounds(373, 465, 189, 14);
			} 
			catch (NumberFormatException e) {
			    JOptionPane.showMessageDialog(null, "Please enter a valid float value.", "Error", JOptionPane.ERROR_MESSAGE);
			}
        }
		if(arg.equals("add another trail"))
		{
			addedmess.setVisible(false);
			//reset the previous enterd data 
			textFieldDescription.setText("");
			textField.setText("");
			
	        // Reset combo boxes to their initial state
	        comboBox.setSelectedIndex(1);
	        comboBoxTrailType.setSelectedIndex(1);
	        textFieldSiteNum.setSelectedIndex(0);
	        trailDatePicker.setDate(null);
	        // Clear selected guides in NGuidelist
	        NGuidelist.clearSelection();		
		}
    }
}