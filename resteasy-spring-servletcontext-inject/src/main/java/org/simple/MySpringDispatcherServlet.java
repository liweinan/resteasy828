package org.simple;

import org.jboss.resteasy.core.ResteasyContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MySpringDispatcherServlet extends DispatcherServlet {

   @Override
   protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
      try {
         System.out.println("::: MySpringDispatcherServlet.doDispatch() -> servletContext: " + this.getServletContext());
         ServletContext servletContext = this.getServletContext();
         Map<Class<?>, Object> map = ResteasyContext.getContextDataMap();
         map.put(ServletContext.class, servletContext);
         super.doDispatch(request, response);
      } finally {
         System.out.print("::: END OF MySpringDispatcherServlet.doDispatch()");
         ResteasyContext.popContextData(ServletContext.class);
      }
   }
}
