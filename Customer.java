package project;

import java.time.LocalDate;

public class Customer {
	
	private String name;
	private int age;
	private String license_no;
	private String issued_in;
	private String e_mail;
	private String tel_no;
	private LocalDate exDate;
	
	public Customer()
	{
		
	}
	
	public Customer(String name, int age, String license_no, String issued_in, String e_mail, String tel_no, LocalDate exDate
	    	)
	{
		this.setName(name);
		this.setAge(age);
		this.setLicense_no(license_no);
		this.setE_mail(e_mail);
		this.setTel_no(tel_no);
		this.setExDate(exDate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLicense_no() {
		return license_no;
	}

	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}

	public String getIssued_in() {
		return issued_in;
	}

	public void setIssued_in(String issued_in) {
		this.issued_in = issued_in;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public LocalDate getExDate() {
		return exDate;
	}

	public void setExDate(LocalDate exDate) {
		this.exDate = exDate;
	}
	
	

}
