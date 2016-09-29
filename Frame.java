package scjp;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Frame extends JFrame implements ActionListener{
	private JFrame frame = new JFrame();
	private JPanel panel1 = new JPanel();
	
	private JLabel nameLbl = new JLabel("NAME: ");
	private JLabel idLbl = new JLabel("I'D: ");
	private JRadioButton malerb = new JRadioButton("MALE");
	private JRadioButton femalerb = new JRadioButton("FEMALE");
	private ButtonGroup bg = new ButtonGroup();
	private JLabel ageLbl = new JLabel("AGE(years): ");
	
	private JTextField nameTxt = new JTextField(10);
	private JTextField idTxt = new JTextField(10);
	private JTextField ageTxt = new JTextField(10);
	
	private JPanel panel2 = new JPanel();
	
	private JLabel cityLbl = new JLabel("CITY: ");
	private JLabel stateLbl = new JLabel("STATE: ");
	private JLabel zipLbl = new JLabel("ZIP: ");
	
	private JTextField cityTxt = new JTextField(10);
	private JTextField stateTxt = new JTextField(10);
	private JTextField zipTxt = new JTextField(10);
	
	private JPanel panel3 = new JPanel();
	
	private JLabel professionLbl = new JLabel("PROFESSION: ");
	private JComboBox<String> professionTxt = new JComboBox<String>();
	
	
	
	private JPanel panel4 = new JPanel();
	
	private JButton save = new JButton("SAVE");
	private JButton cancel = new JButton("CANCEL");
	private JButton reset = new JButton("RESET");
	
	
	Frame(){
		setTitle("REGISTRATION FORM");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 2));
		
		panel1.setLayout(new GridLayout(4, 2));
		panel1.add(nameLbl);
		
		panel1.add(nameTxt);
		nameTxt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if (!(Character.isAlphabetic(ch) || ch == ' '|| ch == '\b')){
					nameTxt.setText("");
					JOptionPane.showMessageDialog(null, "Only [A-Z,a-z,space character]!");
				}
			}
		});
		panel1.add(idLbl);
		panel1.add(idTxt);
		bg.add(malerb);
		bg.add(femalerb);
		panel1.add(ageLbl);
		panel1.add(ageTxt);
		panel1.add(malerb);
		panel1.add(femalerb);
		
		panel2.setLayout(new GridLayout(3, 2));
		panel2.add(cityLbl);
		panel2.add(cityTxt);
		panel2.add(stateLbl);
		panel2.add(stateTxt);
		panel2.add(zipLbl);
		panel2.add(zipTxt);
		
		panel3.setLayout(new FlowLayout());
		panel3.add(professionLbl);
		professionTxt.addItem("STUDENT");
		professionTxt.addItem("EMPLOYEE");
		panel3.add(professionTxt);
		
       
		
		
		
		panel4.setLayout(new FlowLayout());
		panel4.add(save);
		panel4.add(cancel);
		panel4.add(reset);
		save.addActionListener(this);
		cancel.addActionListener(this);
		reset.addActionListener(this);
		
		
		
		add(panel1);
		add(panel2);
		add(panel3);
		    	
    	 professionTxt.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                	               
	                if(((String)professionTxt.getSelectedItem()).equals("STUDENT")){
	                    JPanel pan = new JPanel();
	     		        JLabel gpaLbl = new JLabel("GPA: ");
	             		JTextField gpaTxt = new JTextField(10);
	             		pan.add(gpaLbl);
	                 	pan.add(gpaTxt);
	                 	pan.setLayout(new FlowLayout());
	                	pan.setVisible(true);
	                	add(pan);
	    		      
	                }
	                else if(((String)professionTxt.getSelectedItem()).equals("EMPLOYEE")){
	                	JPanel pan1 = new JPanel();
	                    JLabel salaryLbl = new JLabel("SALARY: ");
	            		JTextField salaryTxt = new JTextField(10);
	            		pan1.add(salaryLbl);
	                	pan1.add(salaryTxt);
	            	    pan1.setLayout(new FlowLayout());
	            		pan1.setVisible(true);
	                	add(pan1);
	                
	      		  }

	            }
	        });
	
		
		add(panel4);
			
	
	}
	
	public static void main(String[] args) {
		Frame f=new Frame();
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("SAVE")){
		if (((( ((((nameTxt.getText().trim().length() == 0 )|| (idTxt.getText().trim().length() == 0) )|| (ageTxt.getText().trim().length() == 0))|| 
				(bg.isSelected(null))
				|| (cityTxt.getText().trim().length() == 0 ))|| (stateTxt.getText().trim().length() == 0) )|| 
				(zipTxt.getText().trim().length() == 0 )))){
			
			JOptionPane.showMessageDialog(null, "Fill all fields....");
			
							}
	
		else {
			
			
			try {
				
				
		        int int1 = Integer.parseInt(idTxt.getText());
		        idTxt.requestFocusInWindow();
		        if(int1<1){
		        	JOptionPane.showMessageDialog(this, "I'd have at least 1 number!",
				               "Inane error", JOptionPane.ERROR_MESSAGE);
		        	idTxt.setText("");
		        	idTxt.requestFocusInWindow();
	                return;
	                }
		        } catch (Exception z) { 
		            JOptionPane.showMessageDialog(this, "I'D is Incorrect Data Type! Numbers Only!",
		               "Inane error", JOptionPane.ERROR_MESSAGE);
		            idTxt.setText("");
		            idTxt.requestFocusInWindow();
		            return;
		   }
			
			try {
		        int int2 = Integer.parseInt(ageTxt.getText());
		        ageTxt.requestFocusInWindow();
		        if(int2>100||int2<1){
		        	JOptionPane.showMessageDialog(this, "Age is greater than 100!",
				               "Inane error", JOptionPane.ERROR_MESSAGE);
		        ageTxt.setText("");
	            ageTxt.requestFocusInWindow();
	            return;}
		        
		        } catch (Exception z) { 
		            JOptionPane.showMessageDialog(this, "Age is Incorrect Data Type! Numbers Only!",
		               "Inane error", JOptionPane.ERROR_MESSAGE);
		            ageTxt.setText("");
		            ageTxt.requestFocusInWindow();
		            return;
		   }
			
			try {
		        int int2 = Integer.parseInt(zipTxt.getText());
		        zipTxt.requestFocusInWindow();
		        if((String.valueOf(int2)).length()<4){
		        	JOptionPane.showMessageDialog(this, "Zip requires min 4 numbers!",
				               "Inane error", JOptionPane.ERROR_MESSAGE);
		        	 zipTxt.setText("");
			            zipTxt.requestFocusInWindow();
			            return;
		        	
		        }
		        } catch (Exception z) { 
		            JOptionPane.showMessageDialog(this, "Zip is Incorrect Data Type! Numbers Only!",
		               "Inane error", JOptionPane.ERROR_MESSAGE);
		            zipTxt.setText("");
		            zipTxt.requestFocusInWindow();
		            return;
		   }
			String name = nameTxt.getText();
			String id = idTxt.getText();
			String gender= null;
			if((malerb.isSelected())){
			gender = malerb.getText().toString();}
			else if((femalerb.isSelected())){
			gender = femalerb.getText().toString();}
			String age = ageTxt.getText();
			
			String city = cityTxt.getText();
			String state = stateTxt.getText();
			String zip = zipTxt.getText();
			String profession=(String)professionTxt.getSelectedItem();
			
			try {
				 FileWriter fileOutStrm = new FileWriter("EmployeeDetails.txt");
				 BufferedWriter bufWriter = new BufferedWriter(fileOutStrm);
				 PrintWriter outWriter = new PrintWriter(bufWriter,true);

				 outWriter.println(nameLbl.getText()+"= "+name);
				 outWriter.println(idLbl.getText()+"= "+id);
				 outWriter.println("GENDER: = "+ gender);
				 outWriter.println(ageLbl.getText()+"= "+age);
				 outWriter.println(cityLbl.getText()+"= "+city);
				 outWriter.println(stateLbl.getText()+"= "+state);
				 outWriter.println(zipLbl.getText()+"= "+zip);
				 outWriter.println(professionLbl.getText()+"= "+profession);
				 outWriter.close();
				 
			 } catch (Exception ex) {
			 	System.out.println("Exception: " + ex);
			 }

			JOptionPane.showMessageDialog(null, "SAVED SUCCESSFULLY....");
		}
		}
			else if(e.getActionCommand().equals("CANCEL")){
				
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to close this window?");

					       if(result == JOptionPane.YES_OPTION){
					               System.exit(0);
					       }else{
					               //Do nothing
					       }
			}
			else if(e.getActionCommand().equals("RESET")){
				
				nameTxt.setText("");
				idTxt.setText("");
				ageTxt.setText("");
				cityTxt.setText("");
				stateTxt.setText("");
				zipTxt.setText("");
				
				JOptionPane.showMessageDialog(null, "RESET SUCCESSFULLY....");
			}
		}
	
	
	
	}




