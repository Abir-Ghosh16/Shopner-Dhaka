package All_JAVA_File;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {

    private int duration;

    public SplashScreen(int duration)
	{
		this.duration = duration;
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);

        int width = 560;
        int height = 325;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        ImageIcon icon = new ImageIcon(".\\All_Image\\S.png");
        JLabel label = new JLabel(icon);
        content.add(label, BorderLayout.CENTER);

        setVisible(true);
        try { Thread.sleep(duration); } catch (Exception e) {};

        
        setVisible(false);
        Login f3 = new Login();
	   // f3.setVisible(true);
    }
}