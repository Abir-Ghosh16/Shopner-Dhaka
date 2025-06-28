package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;



public class Mobilebanking2 extends JFrame implements ActionListener {
    private Font fontstyle;
    private Font fontstyle1, fontstyle2;
    private JButton next;
    private JButton back;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private String getProvider, path, service,getBillNumber,name,email,filepath,imagepath;
    private float bill;
    private String[] row;
	private String[] row1;
    private float balance;
	boolean matched;
	
	JFrame f;

    Mobilebanking2(String getProvider, float bill, String path, String service,String getBillNumber,String name,String email,String filepath,String imagepath) {
        this.getProvider = getProvider;
        this.bill = bill;
        this.path = path;
        this.service = service;
		this.getBillNumber=getBillNumber;
		this.name=name;
		this.email=email;
		this.filepath=filepath;
		this.imagepath=imagepath;
		
		f = new JFrame("payment");

        fontstyle = new Font("Chesna Grotesk", Font.BOLD, 15);
        fontstyle1 = new Font("Chesna Grotesk", Font.BOLD, 20);
        fontstyle2 = new Font("Chesna Grotesk", Font.PLAIN, 20);

        JLabel toLabel = new JLabel(getProvider);
        toLabel.setBounds(100, 173, 200, 30);
        toLabel.setFont(fontstyle2);
        toLabel.setForeground(Color.BLACK);

        JLabel amountLabel = new JLabel(Float.toString(bill));
        amountLabel.setBounds(950, 173, 100, 30);
        amountLabel.setFont(fontstyle2);
        amountLabel.setForeground(Color.BLACK);

        JLabel phoneLabel = new JLabel("Your bkash Account number");
        phoneLabel.setBounds(450, 255, 300, 30);
        phoneLabel.setFont(fontstyle);
        phoneLabel.setForeground(Color.WHITE);

        phoneField = new JTextField();
        phoneField.setBounds(360, 300, 400, 50);
        phoneField.setFont(fontstyle1);
        phoneField.setHorizontalAlignment(JTextField.CENTER);
        phoneField.setToolTipText("Enter your Account number");

        JLabel passwordLabel = new JLabel("Your Pin Number");
        passwordLabel.setBounds(495, 365, 400, 30);
        passwordLabel.setFont(fontstyle);
        passwordLabel.setForeground(Color.WHITE);

        passwordField = new JPasswordField();
        passwordField.setBounds(360, 410, 400, 50);
        passwordField.setFont(fontstyle1);
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setToolTipText("Enter Your Pin Number");
		
		ImageIcon confirmIcon = new ImageIcon(".\\All_Image\\Confirm.png");
        Image Image15 = confirmIcon.getImage().getScaledInstance(561, 70, java.awt.Image.SCALE_SMOOTH);
        confirmIcon = new ImageIcon(Image15);

        next = new JButton(confirmIcon);
        next.setBounds(561, 523, 561, 70);
        next.setBorderPainted(false);
        next.setBackground(Color.GRAY);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);


        ImageIcon cancelIcon = new ImageIcon(".\\All_Image\\Cancel.png");
        Image Image151 = cancelIcon.getImage().getScaledInstance(559, 70, java.awt.Image.SCALE_SMOOTH);
        cancelIcon = new ImageIcon(Image151); 
		
        back = new JButton(cancelIcon);
        back.setBounds(0, 523, 559, 70);
        back.setBorderPainted(false);
        
        back.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\Bk.png");
        Image image = imageIcon.getImage();

        JLabel background = new JLabel();
        ImageIcon img = new ImageIcon(path);
        background.setIcon(img);
        background.setBounds(0, 0, 1106, 595);

        f.add(phoneLabel);
        f.add(phoneField);
        f.add(passwordLabel);
        f.add(passwordField);
        f.add(next);
        f.add(back);
        f.add(amountLabel);
        f.add(toLabel);
        f.setIconImage(image);
        f.add(background);

        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == next) {
        String getaccount = phoneField.getText();
        String getpin = passwordField.getText();

        if (getaccount.equals("") || getpin.equals("")) {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
        } else {
            try {
                String file = "./All_Text_File/Balance.txt";
                File oldFile = new File(file);
                File newFile = new File("./All_Text_File/Balance_temp.txt");

                BufferedReader br = new BufferedReader(new FileReader(oldFile));
                FileWriter fw = new FileWriter(newFile);

                String line;
                while ((line = br.readLine()) != null) {
                    row = line.split("        ");
                    if (row[0].equals(service) && row[2].equals(getaccount) && row[3].equals(getpin)) {
                        matched = true;
                        String stringBalance = row[4];
                        balance = Float.parseFloat(stringBalance);

                        if (balance >= bill) {
                            float newBalance = balance - bill;
                            row[4] = String.valueOf(newBalance);
                            line = String.join("        ", row);
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient balance");
                        }
                    }
                    fw.write(line + System.lineSeparator());
                }

                br.close();
                fw.close();

                oldFile.delete();
                newFile.renameTo(oldFile);

                if (matched && balance >= bill) {
                    String file1 = filepath;
                    File oldFile1 = new File(file1);
                    File newFile1 = new File("./All_Text_File/electricbill_temp.txt");

                    BufferedReader br1 = new BufferedReader(new FileReader(oldFile1));
                    FileWriter fw1 = new FileWriter(newFile1);

                    String line1;
                    while ((line1 = br1.readLine()) != null) {
                        row1 = line1.split("        ");
                        if (row1[2].equals(getBillNumber)) {
                            row1[4] = "Paid";  
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            String date = dtf.format(now);
                            row1[5] = date;
							row1[6] = email;

                            line1 = String.join("        ", row1);
                        }
                        fw1.write(line1 + System.lineSeparator());
                    }
                    br1.close();
                    fw1.close();

                    oldFile1.delete();
                    newFile1.renameTo(oldFile1);

                    int sel = JOptionPane.showConfirmDialog(f, "Would you like to download a PDF of your bill?", "Download PDF", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (sel == JOptionPane.YES_OPTION) {
                        try {
                            PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);
    PDPageContentStream contentStream = new PDPageContentStream(document, page);
    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
    contentStream.beginText(); 
    contentStream.newLineAtOffset(50, 650);

    String[] lines = {
    "                               Payment Informatiom",
	" ",
	" ",
	" ",
    "                      Customer Name   :  " + name,
	" ",
    "                      Service Provider  :  " + getProvider,
	" ",
    "                      Bill No                   :  " + getBillNumber,
	" ",
    "                      Amount                 :  " + bill,
	" ",
    "                      Status                    :  Paid",
	" ",
	" ",
    "                                   Thank you"
    };

    float lineHeight = 15;
    for (String line2 : lines) {
    contentStream.showText(line2);
    contentStream.newLineAtOffset(0, -lineHeight);
    }

    contentStream.endText();
    contentStream.close();

    //document.save("All_Text_File\\bill.pdf");
	String pdfPath = "./All_Text_File/" + getBillNumber + ".pdf";
	document.save(pdfPath);
    document.close();

    f.setVisible(false);
    MainMenu f6 = new MainMenu(email);
    } catch (IOException ae) {
      ae.printStackTrace();
    }
                    }
					else if(sel==JOptionPane.NO_OPTION)
	                {
		  
	                }
                }

            else{
                    JOptionPane.showMessageDialog(null, "Wrong Account number or PIN number");
                } 
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    } else if (e.getSource() == back) {
        f.setVisible(false);
       // Mobilebanking1 f6 = new Mobilebanking1(getProvider, bill, getBillNumber, name,email,filepath,imagepath);
	      SearchBill f6= new SearchBill(email,imagepath,filepath);
    }
}



    
    }

    

