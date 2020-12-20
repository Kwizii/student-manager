package fun.chanvo.page;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author: Chanvo
 * @create: 2020-12-13 17:33
 * @description:
 **/

public class LoadPage extends JWindow {

    public LoadPage() {
        Container container = getContentPane();
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        setLocationRelativeTo(null);
        URL url = getClass().getResource("../../../images/logo.png");
        if (url != null) {
            ImageIcon imageIcon = new ImageIcon(url);
            container.add(new JLabel(imageIcon), BorderLayout.CENTER);
        }
        Dimension screen = getToolkit().getScreenSize();
        // 得到屏幕尺寸
        pack();
        // 窗口适应组件尺寸
        setLocation((screen.width - getSize().width) / 2,
                (screen.height - getSize().height) / 2);
        // 设置窗口位置
        AWTUtilities.setWindowOpaque(this, false);
        toFront();
        setVisible(true);
    }
}
