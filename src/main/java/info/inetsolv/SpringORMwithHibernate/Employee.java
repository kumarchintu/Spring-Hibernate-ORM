package info.inetsolv.SpringORMwithHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private Integer eno;
	private String ename;
	private double salary;
	
	
	public Employee(Integer eno, String ename, double salary) {
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
	}
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}