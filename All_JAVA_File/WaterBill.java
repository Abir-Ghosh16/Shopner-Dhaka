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

public class WaterBill extends JFrame implements ActionListener {

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
	
	String filePath = ".\\All_Text_File\\waterbill.txt";

    WaterBill(String email1) {
		
		this.email1 = email1;

        f = new JFrame("WaterBill");

        fontstyle = new Font("cambria", Font.PLAIN, 16);
		fontstyle1 = new Font("cambria", Font.BOLD, 30);
		
		 JLabel Label = new JLabel("Water Bill");
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

        String[] country1 = {"WASA"};
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
            Logger.getLogger(WaterBill.class.getName()).log(Level.SEVERE, null, ex);
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
                    FileWriter fw = new FileWriter(".\\All_Text_File\\waterbill.txt");
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
                    Logger.getLogger(WaterBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == remove) {
        int selectedRow = jt.getSelectedRow();
        if (selectedRow != -1) {
            tblModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");

            try {
                FileWriter fw1 = new FileWriter(".\\All_Text_File\\waterbill.txt");
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
                Logger.getLogger(WaterBill.class.getName()).log(Level.SEVERE, null, ex);
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


