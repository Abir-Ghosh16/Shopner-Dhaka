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

public class Mosquito extends JFrame implements ActionListener{

    private Font fontstyle;
	private Font fontstyle2;
    private JButton next;
    private JButton back;
    private JTextField areaField;
	private String email;
	private JComboBox<String> thana;
    private JComboBox<String> issue;
    private JFrame f;

    Mosquito(String email){
        f = new JFrame("Mosquito");
		this.email = email;

        fontstyle = new Font("Arial", Font.BOLD, 25);
		fontstyle2 = new Font("cambria", Font.BOLD, 15);

        final JLabel label = new JLabel();
        label.setBounds(850, 380, 200, 50);

        JLabel thanaLabel = new JLabel("Thana:");
        thanaLabel.setBounds(100, 180, 100, 30);
        thanaLabel.setFont(fontstyle);
		thanaLabel.setForeground(Color.black);
		
		
		String country1[]={"Adabor","Badda","Bangshal","Biman Bandar","Banani","cantonment","Lalbag","Mirpur","Motijheel","Nawabganj","New market","Pallabi","Paltan","Ramna","Nawab ganj","Kafrul","Jatrabari","bhashantek","vatara","Gendaria","Dhanmondi","Khilkhet","Khilgaon","Dakhshinkhan","Dohar","Kadamtali","Kotwali","Mughdapara","Ramna","Paltan"};        
        thana = new JComboBox<>(country1);   
        thana.setBounds(100, 212,250,30); 
	  //  thana.setOpaque(false);
	  thana.setFont(fontstyle2);


        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setBounds(100, 260, 80, 30);
        areaLabel.setFont(fontstyle);
		areaLabel.setForeground(Color.black);

        areaField = new JTextField();
        areaField.setBounds(100, 292, 300, 30);
        areaField.setToolTipText("Enter your area");
		areaField.setFont(fontstyle2);

        JLabel issueLabel = new JLabel("Types of Issue:");
        issueLabel.setBounds(100, 340, 200, 30);
        issueLabel.setFont(fontstyle);

        String country2[]={"Marshes","Pond","slum"};        
        issue = new JComboBox<>(country2);    
        issue.setBounds(100, 372,250,30); 
	   // issue.setOpaque(false);
	   issue.setFont(fontstyle2);
        

        next = new JButton("Next");
        next.setBounds(915, 510, 80, 30);
        next.setBorderPainted(false);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.GRAY);
		next.addActionListener(this);
        

        back = new JButton("Back");
        back.setBounds(105, 510, 80, 30);
        back.setBorderPainted(false);
		back.setBackground(Color.BLACK);
        back.setForeground(Color.GRAY);
		back.addActionListener(this);
        

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\Mosquito.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(thanaLabel);
        f.add(thana);
		f.add(areaLabel);
		f.add(areaField);
		f.add(issueLabel);
		f.add(issue);
        f.add(label);
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
    if (e.getSource() == next) {
		String getthana= (String) thana.getSelectedItem();
		String getarea=areaField.getText();
		String getissue=(String) issue.getSelectedItem();
		if( getthana.equals("") || getarea.equals("") || getissue.equals(""))
            {
                JOptionPane.showMessageDialog(null,"One Or More Fields Are Empty");
            }
			else{      
                f.setVisible(false);
               Mosquito1 f4= new Mosquito1(email,getthana,getarea,getissue);
			   //f4.setVisible(true);
			    }
    }


	else if (e.getSource() == back) {
        f.setVisible(false);
        new MainMenu(email);
    } 
}
   
    
}