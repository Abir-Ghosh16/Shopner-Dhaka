package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class SearchBill extends JFrame implements ActionListener {

    private Font fontstyle,fontstyle1;
    private JButton bank, billinfo, back;
    private JButton card;
    private JButton mobileBanking;
    private JTextField billField;
    private JComboBox<String> provider;
    private JPanel panel;
    private boolean matched;
    private String[] row;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
	private JFrame f;
	private String getProvider,storedBillNumber,getBillNumber,status,name,imagepath,filepath,email;
	private float bill;
	

    SearchBill(String email,String imagepath,String filepath) {
		this.email=email;
		this.imagepath=imagepath;
		this.filepath=filepath;
        f = new JFrame("SearchBill");
        

        fontstyle = new Font("Chesna Grotesk", Font.BOLD, 18);
		fontstyle1 = new Font("Chesna Grotesk", Font.PLAIN, 18);

        JLabel providerLabel = new JLabel("Service Provider:");
        providerLabel.setBounds(217, 142, 200, 30);
        providerLabel.setFont(fontstyle);
        providerLabel.setForeground(Color.black);

        String[] country1 = {"DESCO", "NESCO", "DPDC", "BPDB", "Westzone", "Palli Bidyut"};
        provider = new JComboBox<>(country1);
        provider.setBounds(217, 177, 280, 40);

        JLabel billLabel = new JLabel("Bill Number:");
        billLabel.setBounds(217, 230, 140, 35);
        billLabel.setFont(fontstyle);

        billField = new JTextField();
        billField.setBounds(217, 265, 280, 40);
		billField.setFont(fontstyle1);
		//billField.setOpaque(false);
        billField.setToolTipText("Enter your Bill Number");
		
		ImageIcon billIcon = new ImageIcon(".\\All_Image\\Customer Bill Information.png");
        Image Image20 = billIcon.getImage().getScaledInstance(400, 50, java.awt.Image.SCALE_SMOOTH);
        billIcon = new ImageIcon(Image20);

        billinfo = new JButton(billIcon);
        billinfo.setBounds(160, 340, 400, 50);
        billinfo.setBorderPainted(false);
        billinfo.addActionListener(this);

        JLabel label1 = new JLabel("Pay bill with");
        label1.setBounds(310, 400, 200, 30);
        label1.setFont(fontstyle1);
        label1.setForeground(Color.black);
		
		
		ImageIcon cardIcon = new ImageIcon(".\\All_Image\\Card.png");
        Image Image14 = cardIcon.getImage().getScaledInstance(150, 40, java.awt.Image.SCALE_SMOOTH);
        cardIcon = new ImageIcon(Image14);
        card = new JButton(cardIcon);
        card.setBounds(110, 450, 150, 40);
		card.setBorderPainted(false);
		card.setContentAreaFilled(false);
        card.addActionListener(this);
		
		ImageIcon mobileBankingIcon = new ImageIcon(".\\All_Image\\Mobile Banking.png");
        Image Image15 = mobileBankingIcon.getImage().getScaledInstance(190, 40, java.awt.Image.SCALE_SMOOTH);
        mobileBankingIcon = new ImageIcon(Image15);

        mobileBanking = new JButton(mobileBankingIcon);
        mobileBanking.setBounds(265, 450, 190, 40);
		mobileBanking.setBorderPainted(false);
		mobileBanking.setContentAreaFilled(false);
        mobileBanking.addActionListener(this);

        

        ImageIcon bankIcon = new ImageIcon(".\\All_Image\\Bank.png");
        Image Image13 = bankIcon.getImage().getScaledInstance(150, 40, java.awt.Image.SCALE_SMOOTH);
        bankIcon = new ImageIcon(Image13);
        bank = new JButton(bankIcon);
        bank.setBounds(460, 450, 150, 40);
		bank.setBorderPainted(false);
		bank.setContentAreaFilled(false);
        bank.addActionListener(this);
		
		
		back = new JButton("Back");
        back.setBounds(35, 40, 80, 30);
        back.setBorderPainted(false);
		back.setBackground(new java.awt.Color(3, 62, 142));
        back.setForeground(Color.white);
        //ImageIcon icon = new ImageIcon("All_Image\\L3.png");
		back.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(720, 170, 310, 300);
		panel.setLayout(null);
        panel.setOpaque(false);
        

        label2 = new JLabel();
		label2.setBounds(40, 20, 250, 30);
        label2.setFont(fontstyle);
        label2.setForeground(Color.black);
		
        label3 = new JLabel();
		label3.setBounds(40, 70, 250, 30);
        label3.setFont(fontstyle);
        label3.setForeground(Color.black);
		
        label4 = new JLabel();
		label4.setBounds(40, 120, 250, 30);
        label4.setFont(fontstyle);
        label4.setForeground(Color.black);
		
        label5 = new JLabel();
		label5.setBounds(40, 170, 250, 30);
        label5.setFont(fontstyle);
        label5.setForeground(Color.black);
		
        label6 = new JLabel();
		label6.setBounds(40, 220, 250, 30);
        label6.setFont(fontstyle);
        label6.setForeground(Color.black);

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L6.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(imagepath);
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(providerLabel);
        f.add(provider);
        f.add(billLabel);
        f.add(billField);
        f.add(billinfo);
        f.add(label1);
        f.add(mobileBanking);
       // f.add(card);
       // f.add(bank);
		f.add(back);
		
		panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
		f.add(panel);
        f.setIconImage(image);
        f.add(background);

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1120, 630);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == billinfo) {
            getProvider = (String) provider.getSelectedItem();
            getBillNumber = billField.getText();
            String file = filepath;
            if (getProvider.equals("") || getBillNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            } else {
                try {
                    FileReader fr = new FileReader(file);
                    matched = false;
                    String providerStore = "";
                    String storedBillNumber = "";
                    BufferedReader br = new BufferedReader(fr);
                    String line;

                    while ((line = br.readLine()) != null) {
                        row = line.split("        ");
                        if (row[0].equals(getProvider) && row[2].equals(getBillNumber)) {
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                if (matched) {
                     name = row[1];
                    String stringbill = row[3];
					 bill = Float.parseFloat(stringbill);
                    status = row[4];

                    label2.setText("Full Name: " + name);
                    label3.setText("Bill Number: " + getBillNumber);
                    label4.setText("Service Provider: " + getProvider);
                    label5.setText("Bill: " + bill +" tk");
                    label6.setText("Status: " + status);

                    
                } else {
                    JOptionPane.showMessageDialog(null, "Bill not found");
                }
            }
        }
		else if (e.getSource() == mobileBanking) {
			if(status == null)
			{
				JOptionPane.showMessageDialog(null, "Please at first search your bill");
			}
			else if(status.equals("Paid"))
			{
				JOptionPane.showMessageDialog(null, "You already paid your bill");
			}
			else{
			f.setVisible(false);
		    Mobilebanking1 f6 = new Mobilebanking1(getProvider,bill,getBillNumber,name,email,filepath,imagepath);}
		}
		else if(e.getSource() == back)
		{
			    f.setVisible(false);
                MainMenu f3 = new MainMenu(email);
		}
    }

   
}


