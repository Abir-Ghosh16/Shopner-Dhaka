package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Font;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Aboutus extends JFrame implements ActionListener {
    private Font fontstyle,fontstyle2;
    private JButton b1;
    private JButton nextButton;
    private JButton backButton;
	private String email;
    private JFrame f;
    private JLabel label;

    Aboutus(String email) {
        f = new JFrame("About us");
		this.email = email;

        fontstyle = new Font("Garet", Font.BOLD, 30);
		fontstyle2 = new Font("Arial", Font.PLAIN, 16);

        label = new JLabel();
        label.setBounds(485, 100, 150, 150);

        JLabel aboutusLabel = new JLabel("About us");
        aboutusLabel.setBounds(30, 365, 320, 30);
		aboutusLabel.setForeground(Color.white);
        aboutusLabel.setFont(fontstyle);
		
		JLabel discribeLabel = new JLabel();
        discribeLabel.setBounds(30, 400, 1030, 120);
		discribeLabel.setForeground(Color.white);
        discribeLabel.setFont(fontstyle2);
		discribeLabel.setText("<html><body style='width: 810px'>" +
        "Shopner Dhaka is a citizen engagement management platform for citizens of Dhaka. Shopner Dhaka is a citizen engagement management platform through which citizens of Dhaka can easily avail services provided by the corporation in the areas covered by Dhaka City Corporation. Citizens of Dhaka City Corporation can download this app on their Android mobile devices. Through this application, citizens will be able to submit issues like road, mosquito, street light, garbage, waterlogging, public toilet, drainage and illegal structure directly to the concerned officials, employees and councilors of city corporation." +
        "</body></html>");

        

        b1 = new JButton();
        ImageIcon icon1 = new ImageIcon(".\\All_Image\\LogIn.png");
        b1.setIcon(icon1);
        b1.addActionListener(this);
        b1.setVisible(false);

        

        nextButton = new JButton("Submit");
        nextButton.setFont(fontstyle);
        nextButton.setBounds(900, 520, 100, 30);
        nextButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setFont(fontstyle2);
        backButton.setBounds(30, 530, 100, 30);
        ImageIcon icon2 = new ImageIcon(".\\All_Image\\ba.png");
        Image img1 = icon2.getImage();
        Image scaledImage1 = img1.getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        backButton.setIcon(new ImageIcon(scaledImage1));

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();


        JLabel background;
        ImageIcon img2 = new ImageIcon(".\\All_Image\\Aboutus.png");
        background = new JLabel("", img2, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(aboutusLabel);
		f.add(discribeLabel);
        f.add(label);
		f.add(backButton);
       // f.add(nextButton);
        f.setIconImage(image);
        f.add(background);
        backButton.addActionListener(this);
		nextButton.addActionListener(this);
        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == nextButton) {
       // f.setVisible(false);
       // new Road3();
    } else if (e.getSource() == backButton) {
        f.setVisible(false);
        new MainMenu(email);
    } 
	
	}}

