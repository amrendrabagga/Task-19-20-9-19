package com.wp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.wp.custom.validator.CheckSalary;



@Entity
@NamedQueries({@NamedQuery(name="GET_ALL_EMP",query="from Emp")})
public class Emp {
	
	@Id
	@Min(value=101,message="cannot enter value less than 101")
	@Max(value=301,message="cannot enter value more than 301")
	private int eno;
	
	@Pattern(regexp = "^[a-zA-Z0-9_\\.]+(\\s[a-zA-Z0-9_]+)*$",message="special characters are not allowed")
	@NotNull(message="cannot enter empty ename")
	private String ename;
	
	@CheckSalary //custom validation- salary must lie between(10k to 1cr)
	private int salary;
	
	@Pattern(regexp = "^[a-zA-Z_]+[0-9]*( [a-zA-Z_]+)*$",message="special characters are not allowed")
	@Size(min=2,max=15,message="cannot enter designation less than 2 char and more than 15")
	@NotNull(message="cannot enter empty designation")
	private String designation;
	
	@Pattern(regexp = "^[a-zA-Z_]+[0-9]*( [a-zA-Z_]+)*$",message="avoid special characters except '_'")
	@Size(min=2,max=15,message="cannot enter designation less than 2 char and more than 15")
	@NotNull(message="cannot enter empty department")
	private String dept;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Emp [eno=" + eno + ", ename=" + ename + ", salary=" + salary + ", designation=" + designation
				+ ", dept=" + dept + "]";
	}
}
