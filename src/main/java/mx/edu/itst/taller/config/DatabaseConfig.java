package mx.edu.itst.taller.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
	
	@Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.connectionTestQuery}")
    private String connectionTestQuery;
    
    @Value("${spring.datasource.maximumPoolSize}")
    private String maximumPoolSize;


    @Bean(name = "dsProvisioning")
	@Primary      //this is needed 	
    public DataSource primaryDataSource() {
        Properties dsProps = new Properties();
        dsProps.setProperty("url", dataSourceUrl);
        dsProps.setProperty("user", user);
        dsProps.setProperty("password", password);

        Properties configProps = new Properties();
        configProps.setProperty("connectionTestQuery", connectionTestQuery);
        configProps.setProperty("driverClassName", driverClassName);
        configProps.setProperty("jdbcUrl", dataSourceUrl);
        configProps.setProperty("maximumPoolSize", maximumPoolSize);

        HikariConfig hc = new HikariConfig(configProps);
        hc.setDataSourceProperties(dsProps);        
        return new HikariDataSource(hc);
    }

	
	
	@Bean(name = "jdbcProvisioning")
    @Autowired
    public JdbcTemplate provJdbcTemplate(@Qualifier("dsProvisioning") DataSource dsProvisioning) {
        return new JdbcTemplate(dsProvisioning);
    }
}
