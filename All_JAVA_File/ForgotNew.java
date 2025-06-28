package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ForgotNew extends JFrame implements ActionListener {

    private Font fontstyle;
	private Font fontstyle2;
    private JButton next,back;
    private JPasswordField passwordField;
	private JPasswordField repasswordField;
	private ImageIcon img;
	private JLabel background;
	private FileWriter fw;
	private Exception ae;
	FileReader fr;
	private String to;
	private String file;
	private String email;
	
    private JFrame f;

    ForgotNew (String to) {
        f = new JFrame("New Password");
		
        this.to=to;
		//file = to.substring(0, to.length() - 4);

		
        fontstyle = new Font("Arial", Font.BOLD, 18);
		fontstyle2 = new Font("cambria", Font.PLAIN, 15);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 225, 100, 30);
		passwordLabel.setFont(fontstyle);
		passwordLabel.setForeground(Color.white);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 270, 325, 30);
        passwordField.setToolTipText("Enter a strong password");
		passwordField.setOpaque(false);
        passwordField.setForeground(Color.white);
		
		JLabel repasswordLabel = new JLabel("Confirm Password:");
        repasswordLabel.setBounds(100, 315, 180, 30);
		repasswordLabel.setFont(fontstyle);
		repasswordLabel.setForeground(Color.white);

        repasswordField = new JPasswordField();
        repasswordField.setBounds(100, 360, 325, 30);
        repasswordField.setToolTipText("Retype password");
		repasswordField.setOpaque(false);
        repasswordField.setForeground(Color.white);
		
		back = new JButton("Back to log in");
        back.setBounds(150, 400, 230, 30);
        back.setBorderPainted(false);
        back.setForeground(Color.BLACK);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setFont(fontstyle2);
       // ImageIcon icon = new ImageIcon("back1.png");
       // back.setIcon(icon);
        back.addActionListener(this);

        next = new JButton("Next");
        next.setBounds(162, 430, 200, 36);
        next.setBorderPainted(false);
		ImageIcon icon1 = new ImageIcon(".\\All_Image\\fnew.png");
        next.setIcon(icon1);
		next.addActionListener(this);
		
        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\ForgotNew.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0,0,1106,595);

		f.add(passwordLabel);
		f.add(passwordField);
        f.add(repasswordLabel);
        f.add(repasswordField);
        f.add(next);
		f.add(back);
        f.setIconImage(image);
        f.add(background);
		 
        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
public void actionPerformed(ActionEvent e) {
        String email = to;
        file = email.substring(0, email.length() - 4);
        String passwordf = new String(passwordField.getPassword());
        String repasswordf = new String(repasswordField.getPassword());
        String firstname = "";
        String lastname = "";
        String uname = "";
        String pnumber = "";
        String emailn = "";
		String dob= "";
        if (e.getSource() == next) {
            if (passwordf.equals("") || repasswordf.equals("")) {
                JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            } else {
                if (passwordf.equals(repasswordf)) {
                    try {
                        fr = new FileReader("./All_Text_File/"+file);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] row = line.split(": ");
                            if (row[0].equals("First name")) {
                                firstname = row[1];
                            } else if (row[0].equals("last name")) {
                                lastname = row[1];
                            } else if (row[0].equals("Username")) {
                                uname = row[1];
                            } else if (row[0].equals("Phone number")) {
                                pnumber = row[1];
                            } else if (row[0].equals("Email")) {
                                emailn = row[1];
                            }
							else if (row[0].equals("Date of birth")) {
                                dob = row[1];
                            }
							
                        }
                        fr.close();
                        File nf = new File("./All_Text_File/"+file);
                        if (nf.delete()) {
                            fw = new FileWriter("All_Text_File/"+file);
                            fw.write("First name: " + firstname);
                            fw.write(System.getProperty("line.separator"));
                            fw.write("last name: " + lastname);
                            fw.write(System.getProperty("line.separator"));
                            fw.write("Username: " + uname);
                            fw.write(System.getProperty("line.separator"));
                            fw.write("Phone number: " + pnumber);
                            fw.write(System.getProperty("line.separator"));
                            fw.write("Email: " + emailn);
                            fw.write(System.getProperty("line.separator"));
                            fw.write("Date of birth: "+dob);
                            fw.write(System.getProperty("line.separator"));
                            fw.write("Password: " + passwordf);
                            fw.write(System.getProperty("line.separator"));
                            fw.write("__________________");
                            fw.write(System.getProperty("line.separator"));
                            fw.close();
                            JOptionPane.showMessageDialog(null, "Password changed successfully.");
                            f.dispose();
							f.setVisible(false);
                            Login f3 = new Login();
							//f3.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "An error occurred while updating the data.");
					}}                                 			 						 
                                      
			            catch (IOException ex) {
					   ex.printStackTrace();
                       JOptionPane.showMessageDialog(this, "An error occurred while updating the data.");

						}
					}
					else
                    {
                            JOptionPane.showMessageDialog(null,"The Confirmation Password Does Not Match");          
			        }
            }
}
else if (e.getSource() == back)
			{
			    f.setVisible(false);
                Login f3 = new Login();
			}

}}