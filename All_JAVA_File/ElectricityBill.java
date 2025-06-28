package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class ElectricityBill extends JFrame implements ActionListener {

    private JFrame f;
    private JButton submit, back, remove;
    private Font fontstyle,fontstyle1;
    private JTextField BillNumberField;
    private JTextField AmountField,nameField;
    private JComboBox<String> provider;
    private JTable jt;
    private DefaultTableModel tblModel;
	FileWriter fw;
	BufferedWriter bw;
	String email1;
	
	String filePath = ".\\All_Text_File\\electricbill.txt";

    ElectricityBill(String email1) {
		
		this.email1 = email1;

        f = new JFrame("ElectricityBill");

        fontstyle = new Font("cambria", Font.PLAIN, 16);
		fontstyle1 = new Font("cambria", Font.BOLD, 30);
		
		 JLabel Label = new JLabel("Electricity Bill");
        Label.setFont(fontstyle1);
        Label.setForeground(Color.BLACK);
		Label.setBounds(50, 15, 1000, 40);
        Label.setHorizontalAlignment(JLabel.CENTER);

        submit = new JButton("Add bill");
        submit.setBounds(360, 530, 190, 40);
        submit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(50, 530, 80, 30);
        back.addActionListener(this);

        remove = new JButton("Remove bill");
        remove.setBounds(570, 530, 190, 40);
        remove.addActionListener(this);

        JLabel providerlable = new JLabel("Service Provider:");
        providerlable.setBounds(50, 100, 120, 30);
        providerlable.setFont(fontstyle);
		providerlable.setForeground(Color.black);

        String[] country1 = {"DESCO", "NESCO", "DPDC", "BPDB", "Westzone", "Palli Bidyut"};
        provider = new JComboBox<>(country1);
        provider.setBounds(50, 132, 200, 30);
		
		JLabel name = new JLabel("Name:");
        name.setBounds(277, 100, 150, 30);
        name.setFont(fontstyle);
		name.setForeground(Color.black);

        nameField = new JTextField();
        nameField.setBounds(277, 132, 200, 30);
        nameField.setFont(fontstyle);
        nameField.setToolTipText("Enter Name");
		

        JLabel BillNumber = new JLabel("Bill Number:");
        BillNumber.setBounds(498, 100, 150, 30);
        BillNumber.setFont(fontstyle);
		BillNumber.setForeground(Color.black);

        BillNumberField = new JTextField();
        BillNumberField.setBounds(498, 132, 200, 30);
        BillNumberField.setFont(fontstyle);
        BillNumberField.setToolTipText("Enter Bill Number");

        JLabel AmountLabel = new JLabel("Amount:");
        AmountLabel.setBounds(719, 100, 150, 30);
        AmountLabel.setFont(fontstyle);
		AmountLabel.setForeground(Color.black);

        AmountField = new JTextField();
        AmountField.setBounds(719, 132, 200, 30);
        AmountField.setFont(fontstyle);
        AmountField.setToolTipText("Enter Amount");
		
		
		

        String[] column = {"Service Provider","Name", "Bill Number", "Amount", "Status", "Date and Time of paid","Email"};
        tblModel = new DefaultTableModel(column, 0);
        jt = new JTable(tblModel);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(50, 200, 1000, 300);
		
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("        ");
                tblModel.addRow(dataRow);
            }

        } catch (Exception ex) {
            Logger.getLogger(ElectricityBill.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon = new ImageIcon("ng");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\EmployeeTable.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(Label);
		f.add(name);
		f.add(nameField);
        f.add(providerlable);
        f.add(BillNumber);
        f.add(BillNumberField);
        f.add(AmountLabel);
        f.add(AmountField);
        f.add(provider);
        f.add(submit);
        f.add(sp);
        f.add(back);
        f.add(remove);
        f.setIconImage(image);
        f.add(background);

        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String getprovider = (String) this.provider.getSelectedItem();
            String getbillnumber = BillNumberField.getText();
			String getname = nameField.getText();
            String getamount = AmountField.getText();
            String PaidorDue = "Unpaid";
            String date = "-";
			String email="-";
            
			

            if (getprovider.equals("") || getbillnumber.equals("") || getamount.equals("")|| getname.equals("")) {
                JOptionPane.showMessageDialog(null, "One or more fields are empty");
            } else {
				String[] data = {getprovider,getname, getbillnumber, getamount, PaidorDue, date,email};
                tblModel.addRow(data);
				
                try {
                    FileWriter fw = new FileWriter(".\\All_Text_File\\electricbill.txt");
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (int i = 0; i < tblModel.getRowCount(); i++) {
                        for (int j = 0; j < tblModel.getColumnCount(); j++) {
                            bw.write(tblModel.getValueAt(i, j) + "        ");
                        }
                        bw.write("\n");
                    }

                    bw.close();
                    fw.close();
                    BillNumberField.setText("");
					nameField.setText("");
                    AmountField.setText("");
                    provider.setSelectedItem("");
                } catch (IOException ex) {
                    Logger.getLogger(ElectricityBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == remove) {
        int selectedRow = jt.getSelectedRow();
        if (selectedRow != -1) {
            tblModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");

            try {
                FileWriter fw1 = new FileWriter(".\\All_Text_File\\electricbill.txt");
                BufferedWriter bw1 = new BufferedWriter(fw1);
                for (int i = 0; i < tblModel.getRowCount(); i++) {
                    for (int j = 0; j < tblModel.getColumnCount(); j++) {
                        bw1.write(tblModel.getValueAt(i, j) + "        ");
                    }
                    bw1.write("\n");
                }
                bw1.close();
                fw1.close();
            } catch (IOException ex) {
                Logger.getLogger(ElectricityBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row selected");
        }
    } else if (e.getSource() == back) {
            f.setVisible(false);
            EmployeeMenu a = new EmployeeMenu(email1);
        }
    }
}





























/*import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;


public class Addemployee extends JFrame implements ActionListener {

    private JFrame f;
    private JButton submit, back,remove;
    private Font fontstyle;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> day;
    private JComboBox<String> month;
    private JComboBox<String> year;
    private JComboBox<String> gender;
    JTable jt;
    DefaultTableModel tblModel;

    Addemployee() {

        f = new JFrame("Add employee");

        fontstyle = new Font("cambria", Font.PLAIN, 16);

        submit = new JButton("Add employee");
        submit.setBounds(485, 530, 190, 40);
        submit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(50, 530, 80, 30);
        back.addActionListener(this);
		
		remove = new JButton("Remove Employee");
        remove.setBounds(200, 530, 80, 30);
        remove.addActionListener(this);

        JLabel firstnameLabel = new JLabel("Name:");
        firstnameLabel.setBounds(20, 100, 120, 30);
        firstnameLabel.setFont(fontstyle);

        firstnameField = new JTextField();
        firstnameField.setBounds(20, 132, 200, 30);
        firstnameField.setOpaque(false);
        firstnameField.setFont(fontstyle);
        firstnameField.setToolTipText("Enter name");

        JLabel email = new JLabel("Email:");
        email.setBounds(247, 100, 150, 30);
        email.setFont(fontstyle);

        emailField = new JTextField();
        emailField.setBounds(247, 132, 200, 30);
        emailField.setOpaque(false);
        emailField.setFont(fontstyle);
        emailField.setToolTipText("Enter email");

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(468, 100, 150, 30);
        passwordLabel.setFont(fontstyle);

        passwordField = new JPasswordField();
        passwordField.setBounds(468, 132, 200, 30);
        passwordField.setOpaque(false);
        passwordField.setFont(fontstyle);
        passwordField.setToolTipText("Enter a strong password");

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(800, 100, 120, 30);
        dob.setFont(fontstyle);

        String country[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        day = new JComboBox<>(country);
        day.setBounds(800, 132, 90, 25);
        day.setOpaque(false);

        String country1[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        month = new JComboBox<>(country1);
        month.setBounds(900, 132, 90, 25);
        month.setOpaque(false);

        String country2[] = {"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};
        year = new JComboBox<>(country2);
        year.setBounds(1000, 132, 90, 25);
        year.setOpaque(false);

        JLabel genderlable = new JLabel("Gender:");
        genderlable.setBounds(685, 100, 120, 30);
        genderlable.setFont(fontstyle);

        String country3[] = {"Male", "Female"};
        gender = new JComboBox<>(country3);
        gender.setBounds(685, 132, 90, 25);
        gender.setOpaque(false);

        String column[] = {"First Name", "Email", "Password", "Gender", "Date of birth", "Date and time"};
        DefaultTableModel model = new DefaultTableModel(column, 0);
        jt = new JTable(model);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(50, 200, 1000, 300);
		
		String filePath = "All_Text_File\\employee.txt";
        File file = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
           
            Object[] tableLines = br.lines().toArray();
            
            
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("        ");
                model.addRow(dataRow);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(Addemployee.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		
		
		
		
		
		
		
		
		
		

        ImageIcon imageIcon = new ImageIcon("ng");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon("A.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(firstnameLabel);
        f.add(firstnameField);
        f.add(gender);
        f.add(genderlable);
        f.add(email);
        f.add(emailField);
        f.add(passwordLabel);
        f.add(passwordField);
        f.add(dob);
        f.add(day);
        f.add(month);
        f.add(year);
        f.add(submit);
        f.add(sp);
        f.add(back);
		f.add(remove);
        f.setIconImage(image);
        f.add(background);

        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = firstnameField.getText();
            String emailid = emailField.getText();
            String password = passwordField.getText();
            String genders = (String) gender.getSelectedItem();
            String birthdate = (String) day.getSelectedItem() + "-" + (String) month.getSelectedItem() + "-" + (String) year.getSelectedItem();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            String[] data = {name, emailid, password, genders, birthdate, date};
            DefaultTableModel tblModel = (DefaultTableModel) jt.getModel();

            tblModel.addRow(data);

            if (name.equals("") || emailid.equals("") || password.equals("") || genders.equals("") || birthdate.equals("")) {
                JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            } else {
                try {
                    FileWriter fw = new FileWriter("All_Text_File\\employee.txt");
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (int i = 0; i < tblModel.getRowCount(); i++) {
                        for (int j = 0; j < tblModel.getColumnCount(); j++) {
                            bw.write(tblModel.getValueAt(i, j) + "        ");
                        }
                        bw.write("\n");
                    }
                    bw.close();
                    fw.close();
					firstnameField.setText("");		
			        emailField.setText("");
			        passwordField.setText("");
			        gender.setSelectedItem("");
                    day.setSelectedItem("");
                    month.setSelectedItem("");
                    year.setSelectedItem("");
                    //JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                } catch (IOException ex) {
                    Logger.getLogger(Addemployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
		else if (e.getSource() == remove) {
           // int selectedRow = jt.getSelectedRow();
            if (jt.getSelectedRowCount ()== 1) {
                tblModel.removeRow(jt.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            }
        } 
		else if (e.getSource() == back) {
            f.setVisible(false);
                Admin f3 = new Admin();
        }
    }
remove.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        if (tbl.getSelectedRowCount() != 0) {
            int selectedRow = tbl.getSelectedRow();
            tblModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
        } else {
            JOptionPane.showMessageDialog(null, "No row selected");
        }
    }
});


    
}*/

































