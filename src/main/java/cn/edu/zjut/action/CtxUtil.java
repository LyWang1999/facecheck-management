package cn.edu.zjut.action;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring容器上下文工具类，用于获取当前的Spring容器
 * 实现了接口ApplicationContextAware且该类被Spring管理
 * 则会自动调用setApplicationContext方法获取Spring容器对象
 */
@Component
public class CtxUtil implements ApplicationContextAware {

    public static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    /**
     * 根据类型获得bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);
    }

    /**
     * 根据名称名称获得bean
     */
    public static Object getBean(String name) {
        return ctx.getBean(name);
    }

}