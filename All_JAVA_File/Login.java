package All_JAVA_File;

import java.util.regex.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Login extends JFrame implements ActionListener {

    private Font fontstyle;
    private JButton login;
    private JButton Signup;
    private JButton forgotPass;
    private JTextField emailField;
    private JPasswordField passwordField;
    private String file;
    private JFrame f;
    private boolean matched;

    Login() {
        f = new JFrame("Login Screen");

        fontstyle = new Font("Chesna Grotesk", Font.BOLD, 18);

        final JLabel label = new JLabel();
        label.setBounds(850, 380, 200, 50);

        JLabel emailLabel = new JLabel("Email address:");
        emailLabel.setBounds(750, 200, 140, 30);
        emailLabel.setFont(fontstyle);

        emailField = new JTextField();
        emailField.setBounds(750, 250, 230, 30);
        emailField.setToolTipText("Enter your name");

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(750, 300, 120, 30);
        passwordLabel.setFont(fontstyle);

        passwordField = new JPasswordField();
        passwordField.setBounds(750, 350, 230, 30);
        passwordField.setToolTipText("Enter a strong password");

        login = new JButton("Login");
        login.setBounds(750, 400, 80, 30);
        login.setBorderPainted(false);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.GRAY);
        ImageIcon icon1 = new ImageIcon(".\\All_Image\\Log In1.png");
        login.setIcon(icon1);
        login.addActionListener(this);

        final JLabel label1 = new JLabel("or");
        label1.setBounds(850, 390, 50, 30);
        label1.setFont(fontstyle);

        Signup = new JButton("Sign Up");
        Signup.setBounds(900, 400, 80, 30);
        Signup.setBorderPainted(false);
        Signup.setForeground(Color.BLUE);
        ImageIcon icon = new ImageIcon(".\\All_Image\\Signup.png");
        Signup.setIcon(icon);
        Signup.addActionListener(this);

        forgotPass = new JButton("Forgot password?");
        forgotPass.setBounds(770, 450, 200, 30);
        forgotPass.setBorderPainted(false);
        forgotPass.setForeground(Color.BLUE);
        forgotPass.setOpaque(false);
        forgotPass.setContentAreaFilled(false);
        forgotPass.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L6.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\login.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(passwordField);
        f.add(emailLabel);
        f.add(label);
        f.add(label1);
        f.add(passwordLabel);
        f.add(login);
        f.add(Signup);
        f.add(forgotPass);
        f.add(emailField);
        f.setIconImage(image);
        f.add(background);

        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            // Code executed when the login button is clicked

            String email = emailField.getText();
            //file = email.substring(0, email.length() - 4);
            String password = new String(passwordField.getPassword());
			
			
			String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if (email.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            }
			else if (email.equals("Admin") && password.equals("Admin")) {
                    f.setVisible(false);
                    Admin f2 = new Admin();
                    // f2.setVisible(true);
                }
            else if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid Email Format");
                }

			else {
             
					file = email.substring(0, email.length() - 4);
                    File filee = new File("./All_Text_File/"+file);
                    if (filee.exists() && !filee.isDirectory()) {
                        try {
                            FileReader fr = new FileReader("./All_Text_File/"+file);
                            matched = false;
                            String emailstore = "";
                            String storedPassword = "";
                            BufferedReader br = new BufferedReader(fr);
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] row = line.split(": ");
                                if (row[0].equals("Email")) {
                                    emailstore = row[1];
                                } else if (row[0].equals("Password")) {
                                    storedPassword = row[1];
                                }
                                if (!emailstore.equals("") && !storedPassword.equals("")) {
                                    if (emailstore.equals(email) && storedPassword.equals(password)) {
                                        matched = true;
                                        break;
                                    }
                                }
                            }
                            fr.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        if (matched) {
                            JOptionPane.showMessageDialog(null, "Login Successful");
                            f.setVisible(false);
                            //Menu f7 = new Menu(email);
							MainMenu f7 = new MainMenu(email);
                            // f2.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Username and Password Do Not Match");
                        }
                    } else {
                        try {
                            FileReader fr1 = new FileReader(".\\All_Text_File\\employee.txt");
                            BufferedReader br1 = new BufferedReader(fr1);
                            String line;
                            boolean found = false;
                            while ((line = br1.readLine()) != null) {
                                String[] row1 = line.split("        ");
                                if (email.equals(row1[1]) && password.equals(row1[2])) {
                                    f.setVisible(false);
									EmployeeMenu f9= new EmployeeMenu(email);
                                    //JOptionPane.showMessageDialog(null, "Match");
                                    found = true;
                                    break;
                                }
                            }
                            fr1.close();

                            if (!found) {
                                JOptionPane.showMessageDialog(null, "Username and Password Do Not Match");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
               
            }
        } else if (e.getSource() == Signup) {
            // Code executed when the signup button is clicked

            f.setVisible(false);
            SignUpEmail f3 = new SignUpEmail();
            // f3.setVisible(true);
        } else if (e.getSource() == forgotPass) {
            // Code executed when the forgot password button is clicked

            f.setVisible(false);
            ForgotEmail f1 = new ForgotEmail();
        }
    }

    
}

      

		
    
