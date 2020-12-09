package fun.chanvo.util;

import org.springframework.context.ApplicationContext;

/**
 * @author: Chanvo
 * @create: 2020-12-09 13:40
 * @description:
 **/

public class SpringUtil {

    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        SpringUtil.context = context;
    }
}
