package org.ubaldino.taller.app.config;


import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.spring.view.JadeViewResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;





/**
 * @author Ubaldino Zurita
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.ubaldino.taller.app.*")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    //private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final int maxUploadSizeInMb = 25 * 1024 * 1024; // 5 MB
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        
        configurer.enable();
    }
    
    @Bean
    public MessageSource messageSource() {
       ResourceBundleMessageSource source = new ResourceBundleMessageSource();
       source.setBasename("messages");
       return source;
    }
    
    /*
    @Override
    public Validator getValidator() {
       LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
       validator.setValidationMessageSource(messageSource());
       return validator;
    }
    */

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
     
    
    @Bean
    public SpringTemplateLoader templateLoader() {
        SpringTemplateLoader templateLoader 
          = new SpringTemplateLoader();
        templateLoader.setBasePath("/WEB-INF/views/");
        templateLoader.setSuffix(".jade");
        return templateLoader;
    }
  
    @Bean
    public JadeConfiguration jadeConfiguration() {
        JadeConfiguration configuration 
          = new JadeConfiguration();
        configuration.setCaching(false);
        configuration.setTemplateLoader(templateLoader());
        return configuration;
    }
    
    @Bean
    public JadeViewResolver viewResolver() {
        JadeViewResolver viewResolver = new JadeViewResolver();
        viewResolver.setConfiguration(jadeConfiguration());
        return viewResolver;
    }     
}
