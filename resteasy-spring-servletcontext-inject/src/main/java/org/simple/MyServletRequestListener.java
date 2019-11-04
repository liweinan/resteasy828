package org.simple;

import org.jboss.resteasy.core.ResteasyContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.Map;

public class MyServletRequestListener implements ServletRequestListener {
   @Override
   public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
      System.out.println("::MyServletRequestListener.requestDestroyed()");
   }

   @Override
   public void requestInitialized(ServletRequestEvent servletRequestEvent) {
      System.out.println("::MyServletRequestListener.requestInitialized()");
      System.out.println(">>>DUMP OF CONTEXT_DATA_MAP<<<");
      ServletContext servletContext = servletRequestEvent.getServletContext();
      Map<Class<?>, Object> map = ResteasyContext.getContextDataMap();
      map.put(ServletContext.class, servletContext);
      System.out.println(map);
      System.out.println(">>>END OF CONTEXT_DATA_MAP<<<");
   }
}
