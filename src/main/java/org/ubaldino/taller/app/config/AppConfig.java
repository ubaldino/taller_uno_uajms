package org.ubaldino.taller.app.config;


import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
  * @author Ubaldino Zurita
*/
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value={ 
    @ComponentScan("org.ubaldino.taller.app.dao"),
    @ComponentScan("org.ubaldino.taller.app.model"),
    @ComponentScan("org.ubaldino.taller.app.service")
})
public class AppConfig {

    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "org.ubaldino.taller.app.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
 
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("postgresql.driver"));
        dataSource.setUrl(env.getProperty("postgresql.url"));
        dataSource.setUsername(env.getProperty("postgresql.user"));
        dataSource.setPassword(env.getProperty("postgresql.password"));
        return dataSource;
    }
 
    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE,env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE,env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT,env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT,env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS,env.getProperty("hibernate.c3p0.max_statements"));
        return props;
    }
 
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
    
    
    /*
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();
        // Setting JDBC properties
        props.put(DRIVER, env.getProperty("postgresql.driver"));
        props.put(URL, env.getProperty("postgresql.url"));
        props.put(USER, env.getProperty("postgresql.user"));
        props.put(PASS, env.getProperty("postgresql.password"));

        // Setting Hibernate properties
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, 
              env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, 
              env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT,
              env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, 
              env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, 
            env.getProperty("hibernate.c3p0.max_statements"));

        props.put("hibernate.connection.CharSet", "utf-8");
        props.put("hibernate.connection.useUnicode", true);
        props.put("hibernate.connection.characterEncoding", "utf-8");

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);
        factoryBean.setAnnotatedClasses(Role.class);
        factoryBean.setAnnotatedClasses(UserRol.class);
        
        return factoryBean;
    }
    

    @Bean
    public HibernateTransactionManager getTransactionManager() {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager();
       transactionManager.setSessionFactory(getSessionFactory().getObject());
       return transactionManager;
    }
    */
}
