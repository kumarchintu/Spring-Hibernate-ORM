package info.inetsolv.SpringORMwithHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
	public static void main(String[] args) {
//		ApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext container = new AnnotationConfigApplicationContext("info.inetsolv");
		EmployeeDAO employeeDAO = container.getBean(EmployeeDAO.class);
		employeeDAO.saveEmployee(new Employee(10,"Abhi",25000d));
		((AbstractApplicationContext)container).close();
	}
}