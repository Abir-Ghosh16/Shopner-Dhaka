package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Font;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Drainage1 extends JFrame implements ActionListener {
    private Font fontstyle, fontstyle2;
    private JButton b1;
    private JButton nextButton;
    private JButton backButton;
    private JButton camButton;
    private JTextArea problemArea;
    private JFrame f;
    private JLabel label;
    private String email;
    private String getthana;
    private String getarea;
    private String getissue;
	private String imagePath;


    Drainage1(String email, String getthana, String getarea) {
        f = new JFrame("Drainage1");
        this.email = email;
        this.getthana = getthana;
        this.getarea = getarea;
      

        fontstyle = new Font("Arial", Font.BOLD, 18);
        fontstyle2 = new Font("Arial", Font.BOLD, 15);

        label = new JLabel();
        label.setBounds(485, 100, 150, 150);

        JLabel problemLabel = new JLabel("Please describe your problem:");
        problemLabel.setBounds(100, 210, 320, 30);
        problemLabel.setForeground(Color.black);
        problemLabel.setFont(fontstyle);

        problemArea = new JTextArea();
        problemArea.setLineWrap(true);
        problemArea.setBounds(100, 250, 900, 250);
        problemArea.setToolTipText("Enter your problem description");
        problemArea.setFont(fontstyle2);

        b1 = new JButton();
        ImageIcon icon1 = new ImageIcon(".\\All_Image\\LogIn.png");
        b1.setIcon(icon1);
        b1.addActionListener(this);
        b1.setVisible(false);

        ImageIcon camIcon = new ImageIcon(".\\All_Image\\cam.png");
        Image camImage = camIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        camIcon = new ImageIcon(camImage);

        camButton = new JButton(camIcon);
        camButton.setBounds(503, 100, 100, 100);
        camButton.setBorder(BorderFactory.createEmptyBorder());
        camButton.setContentAreaFilled(false);
        camButton.addActionListener(this);
        camButton.setOpaque(false);

        nextButton = new JButton("Submit");
        nextButton.setBounds(920, 520, 80, 30);
		nextButton.setBorderPainted(false);
		nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.GRAY);
        nextButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(100, 520, 80, 30);
		backButton.setBorderPainted(false);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.GRAY);

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();


        JLabel background;
        ImageIcon img2 = new ImageIcon(".\\All_Image\\Drainage1.png");
        background = new JLabel("", img2, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(problemLabel);
        f.add(label);
        f.add(camButton);
        f.add(backButton);
        f.add(problemArea);
        f.add(nextButton);
        f.setIconImage(image);
        f.add(background);
        backButton.addActionListener(this);
        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) { 
	

	 if (e.getSource() == camButton) {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
        file.addChoosableFileFilter(filter);
        int result = file.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
             imagePath = selectedFile.getAbsolutePath();
            ImageIcon resizedImage = resizeImage(imagePath, camButton.getWidth(), camButton.getHeight());
            camButton.setIcon(resizedImage);
        }
    }
      else if (e.getSource() == nextButton) {
		  
		  int sel = JOptionPane.showConfirmDialog(f,"Are you sure the given information is correct?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(sel== JOptionPane.YES_OPTION)
		  {
			String getproblemArea = problemArea.getText();
			
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            if (getproblemArea.equals("")) {
                JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            } else {
                try {
                    FileWriter fw = new FileWriter(".\\All_Text_File\\DrainageProblem.txt", true);

                    fw.write(email + "        " + getthana + "        " + getarea + "        " + getproblemArea+"        "+date+"        "+imagePath);
                    fw.write(System.getProperty("line.separator"));
                    fw.close();
                    f.setVisible(false);
                    new MainMenu(email);
                } catch (IOException ex) {
                    Logger.getLogger(Drainage1.class.getName()).log(Level.SEVERE, null, ex);
                }
	  }}
	  else if(sel==JOptionPane.NO_OPTION)
	  {
		  
	  }
        } else if (e.getSource() == backButton) {
            f.setVisible(false);
            new Drainage(email);
        } 
    }

        private ImageIcon resizeImage(String imgPath, int width, int height) {
        ImageIcon originalImage = new ImageIcon(imgPath);
        Image img = originalImage.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedImage = new ImageIcon(newImg);
        return resizedImage;
    }

}