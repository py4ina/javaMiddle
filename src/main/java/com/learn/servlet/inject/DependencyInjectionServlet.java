package com.learn.servlet.inject;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

public class DependencyInjectionServlet extends HttpServlet {
    private static final String APP_CTX_PATH = "contextConfigLocation";

    @Override
    public final void init () throws ServletException {
        String appCtxPath = this.getServletContext().getInitParameter(APP_CTX_PATH);
        System.out.println("load " + APP_CTX_PATH + " -> " + appCtxPath);

        if (appCtxPath == null){
            System.err.println("I need init param " + APP_CTX_PATH);
            throw new ServletException(APP_CTX_PATH + " init param == null");
        }

        try {
            ApplicationContext appCtx = new ClassPathXmlApplicationContext(appCtxPath);
            List<Field> allFields = FieldReflector.collectUpTo(this.getClass(), DependencyInjectionServlet.class);
            List<Field> injectFields = FieldReflector.filterInject(allFields);

            for (Field field : injectFields) {
                field.setAccessible(true);
                Inject annotation = field.getAnnotation(Inject.class);
                System.out.println("@Inject: " + field);

                String beanName = annotation.value();
                System.out.println(beanName);

                Object bean = appCtx.getBean(beanName);
                System.out.println(bean);
                if (bean == null) {
                    throw new ServletException("beanName => " + beanName);
                }
                field.set(this, bean);
            }
        } catch (Exception e) {
            throw new ServletException("Can't inject from " + APP_CTX_PATH, e);
        }
    }
}

class Test {
    @Value("#{systemProperties[user.timezone]}")
    private String string;

    Test(){
        System.out.println(string);
    }

    public static void main(String[] args) {
        Test test = new Test();
        Properties properties = System.getProperties();

        for (Object key : properties.keySet()) {
            System.out.println(key + " -> " + System.getProperty((String) key));
        }
    }
}