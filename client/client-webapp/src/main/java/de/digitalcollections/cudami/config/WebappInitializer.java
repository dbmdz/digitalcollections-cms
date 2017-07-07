package de.digitalcollections.cudami.config;

import de.digitalcollections.commons.servlet.filter.LogSessionIdFilter;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
//import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Replaces web.xml.
 */
@Order(2)
public class WebappInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebappInitializer.class);

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[]{SpringConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return null;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/*"};
  }

  @Override
  protected Filter[] getServletFilters() {
    // FIXME remove this, when backend is replaced by rest client
    // jpa session
//    OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
//    openEntityManagerInViewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");

    // session id for logging, see log4j.xml
    final LogSessionIdFilter logSessionIdFilter = new LogSessionIdFilter();

    return new Filter[]{logSessionIdFilter};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);

    ServletRegistration.Dynamic servletRegistration = (ServletRegistration.Dynamic) servletContext.
            getServletRegistration(DEFAULT_SERVLET_NAME);
    servletRegistration.
            setMultipartConfig(new MultipartConfigElement("/tmp", 1024 * 1024 * 5, 1024 * 1024 * 5 * 5, 1024 * 1024));

    // servletContext.addListener(new HttpSessionListenerImpl()); // session and servlet context config see now ServletContextListenerImpl
    System.setProperty("filter", "false");
  }
}