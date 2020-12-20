package fun.chanvo;


import fun.chanvo.page.HomePage;
import fun.chanvo.page.LoadPage;
import fun.chanvo.util.SpringUtil;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Chanvo
 * @create: 2020-12-09 10:53
 * @description: 主程序启动类
 **/

@MapperScan(basePackages = "fun.chanvo.mapper")
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        LoadPage loadPage = new LoadPage();
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            UIManager.put("RootPane.setupButtonVisible", false);
        } catch (Exception e) {
            return;
        }
        ConfigurableApplicationContext context = new SpringApplicationBuilder(MainApplication.class).headless(false).run(args);
        SpringUtil.setContext(context);
        EventQueue.invokeLater(() -> {
            new HomePage().setVisible(true);
            loadPage.dispose();
        });
    }

}
