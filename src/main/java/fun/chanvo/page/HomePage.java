package fun.chanvo.page;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.net.URL;

/**
 * @author: Chanvo
 * @create: 2020-12-09 11:55
 * @description: 主页
 **/

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("学生学籍管理系统");
        URL url = getClass().getResource("../../../images/usermanager.png");
        if (url != null) {
            setIconImage(getToolkit().getImage(url));
        }
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        setLocationRelativeTo(null);
        StudentManagerPanel panel = new StudentManagerPanel();
        setContentPane(panel);
        panel.setLayout(null);
        AWTUtilities.setWindowOpaque(this, false);
    }

}
