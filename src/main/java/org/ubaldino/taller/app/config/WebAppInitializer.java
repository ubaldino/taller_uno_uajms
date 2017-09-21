package org.ubaldino.taller.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Ubaldino Zurita
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfiguration.class };
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    /**
     * {@inheritDoc}
     *
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters()
     */
    /*
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[] { encodingFilter };
    }
    */
    /**
     * {@inheritDoc}
     *
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
     */
    
}
