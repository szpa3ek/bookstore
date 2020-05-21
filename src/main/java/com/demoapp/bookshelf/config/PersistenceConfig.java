package com.demoapp.bookshelf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
public class PersistenceConfig {
    @Autowired
    private Environment env;

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("punit"); // this is reference to resources/META-INF/persistence.xml
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties());
        return localContainerEntityManagerFactoryBean;
    }

    private JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("jdbc.driverClassName")));
        driverManagerDataSource.setUrl(env.getProperty("jdbc.url)")); // mind timezone and character encoding might be required in newer  version of the connector
        driverManagerDataSource.setUsername(env.getProperty("jdbc.user"));
        driverManagerDataSource.setPassword(env.getProperty("jdbc.pass")); // pass as environment variable
        return driverManagerDataSource;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect"); // make sure MySQL engine is InnoDB – should be the default these days
        properties.setProperty("hibernate.hbm2ddl.auto", "create"); // mind this will create tables every time you start the application, it’s good for development, not really good for production
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }
}
