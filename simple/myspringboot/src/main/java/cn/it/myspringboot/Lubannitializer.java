package cn.it.myspringboot;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class Lubannitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        ServletRegistration.Dynamic registration = ctx.addServlet("xx", new SpringServlet());
        registration.addMapping("/");
//        System.out.println("aaaa");
    }
}
