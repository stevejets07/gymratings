package com.gymRatings.gym_ratings.common.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration// always any configuration/permission to manage external sources including database connection
@EnableTransactionManagement//gives class permission to due sql in database
public class DataSourceConfig {

    @Autowired//declares a bean inside of another bean
    private Environment environment;//talks to the applicain.propertys file in order to get database order details

    @Bean//any object retured from this method will be converted into a spring bean
    public DataSource getMysqlDataSource() throws Exception//trigged if error while conncected to the database
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();//creating empty datasource (holds connection details)

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));//getting data from environment > application.properties
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));

        return dataSource;//returns data source
    }

    @Bean//any object retured from this method will be converted into a spring bean
    @Qualifier("gymRatingsDataSourceTemplate")//names the bean
    public JdbcTemplate gymRatingsDataSource() throws Exception
    {
        //does the sql stuff updates,select etc
        // constructor takes datasoruce as argument new JdbcTemplate(getMysqlDataSource());
        // getMysqlDataSource() method provides bean data source
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getMysqlDataSource());
        return jdbcTemplate;
//        return  new JdbcTemplate(getMysqlDataSource());
    }
}
