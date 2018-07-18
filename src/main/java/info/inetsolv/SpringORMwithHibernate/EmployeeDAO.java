package info.inetsolv.SpringORMwithHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public Integer saveEmployee(Employee employee) {
		return (Integer) hibernateTemplate.save(employee);
	}
}