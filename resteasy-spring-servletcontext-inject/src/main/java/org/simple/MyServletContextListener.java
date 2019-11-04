package org.simple;

import org.jboss.resteasy.core.ResteasyContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

public class MyServletContextListener implements ServletContextListener {
   @Override
   public void contextInitialized(ServletContextEvent servletContextEvent) {
      System.out.println("***MyServletContextListener.contextInitialized()");
      System.out.println(">>>DUMP OF CONTEXT_DATA_MAP<<<");
      ServletContext servletContext = servletContextEvent.getServletContext();
      Map<Class<?>, Object> map = ResteasyContext.getContextDataMap();
      map.put(ServletContext.class, servletContext);
      System.out.println(map);
      System.out.println(">>>END OF CONTEXT_DATA_MAP<<<");
   }

   @Override
   public void contextDestroyed(ServletContextEvent servletContextEvent) {
      System.out.println("***MyServletContextListener.contextDestroyed()");
   }
}
