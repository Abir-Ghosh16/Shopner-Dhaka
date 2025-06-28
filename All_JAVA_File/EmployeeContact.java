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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class EmployeeContact extends JFrame implements ActionListener {

    private JFrame f;
    private JButton submit, back, remove;
    private Font fontstyle;
    private JTable jt;
	private String email;
    private DefaultTableModel tblModel;
	FileWriter fw;
	BufferedWriter bw;
	
	String filePath = ".\\All_Text_File\\Contactus.txt";

    EmployeeContact(String email) {

        f = new JFrame("EmployeeContact");
		this.email = email;

        fontstyle = new Font("cambria", Font.BOLD, 30);
		
		
		JLabel firstnameLabel = new JLabel("Contact With Us");
        firstnameLabel.setFont(fontstyle);
        firstnameLabel.setForeground(Color.BLACK);
		firstnameLabel.setBounds(50, 15, 1000, 40);
        firstnameLabel.setHorizontalAlignment(JLabel.CENTER);


        back = new JButton("Back");
        back.setBounds(50, 530, 80, 30);
        back.addActionListener(this);

        remove = new JButton("Remove");
        remove.setBounds(465, 530, 190, 40);
        remove.addActionListener(this);


        String[] column = {"Email", "Full Name", "Given Email for Contact","Massage", "Date and Time"};
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
            Logger.getLogger(EmployeeContact.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon = new ImageIcon("ng");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\EmployeeTable.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(firstnameLabel);
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
         if (e.getSource() == remove) {
        int selectedRow = jt.getSelectedRow();
        if (selectedRow != -1) {
            tblModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");

            try {
                FileWriter fw1 = new FileWriter(".\\All_Text_File\\Contactus.txt");
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
                Logger.getLogger(EmployeeContact.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row selected");
        }
    } else if (e.getSource() == back) {
            f.setVisible(false);
            EmployeeMenu a = new EmployeeMenu(email);
        }
    }
}
