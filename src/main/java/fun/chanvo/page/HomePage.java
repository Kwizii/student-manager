package fun.chanvo.page;

import cn.hutool.core.io.resource.ClassPathResource;
import com.sun.awt.AWTUtilities;

import javax.swing.*;

/**
 * @author: Chanvo
 * @create: 2020-12-09 11:55
 * @description: 主页
 **/

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("学生学籍管理系统");
        setIconImage(getToolkit().getImage(new ClassPathResource("images/usermanager.png").getAbsolutePath()));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        setLocationRelativeTo(null);
        StudentManagerPanel panel = new StudentManagerPanel();
        setContentPane(panel);
        panel.setLayout(null);
        AWTUtilities.setWindowOpacity(this,0.5f);
    }

}
