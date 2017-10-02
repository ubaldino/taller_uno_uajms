package org.ubaldino.taller.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Ubaldino Zurita
 */

@Configuration
@EnableWebMvc
@ComponentScan("org.ubaldino.taller.app")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final int maxUploadSizeInMb = 25 * 1024 * 1024; // 5 MB

    @Bean
    public InternalResourceViewResolver resolver() {
       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setViewClass(JstlView.class);
       resolver.setPrefix("/WEB-INF/views/");
       resolver.setSuffix(".jsp");
       return resolver;
    }

    @Bean
    public MessageSource messageSource() {
       ResourceBundleMessageSource source = new ResourceBundleMessageSource();
       source.setBasename("messages");
       return source;
    }

    @Override
    public Validator getValidator() {
       LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
       validator.setValidationMessageSource(messageSource());
       return validator;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                .addResourceLocations("/")
                .setCachePeriod(0);
    }
   
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        cmr.setMaxUploadSize(maxUploadSizeInMb * 2);
        cmr.setMaxUploadSizePerFile(maxUploadSizeInMb); //bytes
        return cmr;

    }
}
