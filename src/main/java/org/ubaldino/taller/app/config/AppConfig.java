package org.ubaldino.taller.app.config;


import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
  * @author Ubaldino Zurita
*/
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value={
    @ComponentScan("org.ubaldino.taller.app")
})

public class AppConfig {

    @Autowired
    private Environment env;
 
    
    @Bean(name="dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("postgresql.driver"));
        dataSource.setUrl(env.getProperty("postgresql.url"));
        dataSource.setUsername(env.getProperty("postgresql.user"));
        dataSource.setPassword(env.getProperty("postgresql.password"));
        if(!Base.hasConnection()) Base.open();
        return dataSource;
    }
     
     
}
