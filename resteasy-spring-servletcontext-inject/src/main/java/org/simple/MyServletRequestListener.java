package org.simple;

import org.jboss.resteasy.core.ResteasyContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.Map;

public class MyServletRequestListener implements ServletRequestListener {
   @Override
   public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
      System.out.println("HAHAHAHAHAHA");
   }

   @Override
   public void requestInitialized(ServletRequestEvent servletRequestEvent) {
      System.out.println("POPOPOPOPOPOPOP");
      ServletContext servletContext = servletRequestEvent.getServletContext();
      Map<Class<?>, Object> map = ResteasyContext.getContextDataMap();
      map.put(ServletContext.class, servletContext);
   }
}
