package info.inetsolv.SpringORMwithHibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DBUtil {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setUsername("spring");
		dataSource.setPassword("spring");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setAnnotatedClasses(Employee.class);
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return sessionFactoryBean;
	}
	
	public Properties getHibernateProperties(){
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate(){
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory);
		return hibernateTemplate;
	}	
	
	@Bean
	public HibernateTransactionManager transactionManager(){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}