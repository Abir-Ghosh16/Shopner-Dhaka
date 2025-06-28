package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class EmployeeTable extends JFrame implements ActionListener {

    private JButton submit, back, remove;
    private Font fontstyle;
    private JTable jt;
	private String email;
    private DefaultTableModel tblModel;
    private String filePath;
	private String name;
	private JFrame f;
    FileWriter fw;
    BufferedWriter bw;
    File file;
    String converted_path;
    JPanel panel;

    EmployeeTable(String email,String filePath,String name) {

        this.email = email;
        this.filePath = filePath;
		this.name=name;

        fontstyle = new Font("cambria", Font.BOLD, 30);
		
		f=new JFrame("Employee table");

        panel = new JPanel();
        panel.setBounds(340, 80, 440, 250);
        panel.setLayout(new FlowLayout());

        submit = new JButton("Show Image");
        submit.setBounds(360, 530, 190, 40);
        submit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(50, 530, 80, 30);
        back.addActionListener(this);

        remove = new JButton("Remove Problem");
        remove.setBounds(570, 530, 190, 40);
        remove.addActionListener(this);

        JLabel firstnameLabel = new JLabel(name);
        firstnameLabel.setFont(fontstyle);
        firstnameLabel.setForeground(Color.BLACK);
		firstnameLabel.setBounds(50, 15, 1000, 40);
        firstnameLabel.setHorizontalAlignment(JLabel.CENTER);
        
        

        String[] column = {"Email", "Thana", "Area", "Types of issue", "Problem Discription", "Date and Time", "Image path"};
        tblModel = new DefaultTableModel(column, 0);
        jt = new JTable(tblModel);
		jt.removeColumn(jt.getColumnModel().getColumn(6));
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(50, 350, 1000, 150);

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
            Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\EmployeeTable.png");
        Image image = imageIcon.getImage();

        JLabel background = new JLabel(imageIcon);
        background.setBounds(0, 0, 1106, 595);

        f.add(firstnameLabel);
        f.add(submit);
        f.add(sp);
        f.add(back);
        f.add(remove);
        f.add(panel);
        f.add(background);

        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                if (getExtendedState() == JFrame.NORMAL) {
                    try {
                        displayImage();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove) {
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {
                tblModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");

                try {
                    FileWriter fw1 = new FileWriter(filePath);
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
                    Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No row selected");
            }
        } else if (e.getSource() == submit) {
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {
             
                converted_path = ""; 

                try {
                    
					       int column6 = 6;
						   int row = jt.getSelectedRow();
                           String imagepath = tblModel.getValueAt(row, column6).toString();
                          // System.out.println(imagepath);
                            converted_path = imagepath.replace('\\', '/');
                           // System.out.println(converted_path);
                 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try {
                    displayImage();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No row selected");
            }
        } else if (e.getSource() == back) {
            f.setVisible(false);
            EmployeeMenu a = new EmployeeMenu(email);
        }
    }

    private void displayImage() throws IOException {
        if (converted_path != null && !converted_path.isEmpty()) {
            BufferedImage myPicture = ImageIO.read(new File(converted_path));
			ImageIcon resizedImage = resizeImage(myPicture, panel.getWidth(), panel.getHeight());
			JLabel picLabel = new JLabel(resizedImage);
            
            panel.removeAll();
            panel.add(picLabel);
            panel.revalidate();
            panel.repaint();
        } else {
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
        }
    }
private ImageIcon resizeImage(BufferedImage image, int width, int height) {
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
  
	
}}
