package com.Customs.CIA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_employee")
public class Employee {
	
	@Id
	@Column(name = "employeeID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int EmployeeID;
	
	@Column(name = "nama")
	private String Nama;
	
	@Column(name = "job")
	private String Pekerjaan;
	
	@Column(name = "unit")
	private String Unit;
	
	@Column(name = "gaji")
	private int Gaji;

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getNama() {
		return Nama;
	}

	public void setNama(String nama) {
		Nama = nama;
	}

	public String getPekerjaan() {
		return Pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		Pekerjaan = pekerjaan;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public int getGaji() {
		return Gaji;
	}

	public void setGaji(int gaji) {
		Gaji = gaji;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(!(obj instanceof Employee)){
			return false;
		}
		Employee employee = (Employee) obj;
		if(Nama != null ? !Nama.equals(employee.Nama) : employee.Nama != null){
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public int hashCode(){
		return Nama != null ? Nama.hashCode() : 0;
	}
	
	public String toString(){
		return "Employee [id= " +EmployeeID+ ", name=" +Nama+ ", job=" +Pekerjaan
				+ ", unit=" +Unit+ ", gaji=" +Gaji+ "]";
	}
}
