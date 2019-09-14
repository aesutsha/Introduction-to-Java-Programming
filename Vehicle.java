package project;

public class Vehicle {
	private String name;
	private String plat_no;
	private int make;
	private String type;
	private int cc;
	private double price;
	
	public Vehicle()
	{
		
	}
	public Vehicle (String name, String plat_no, int make, String type, int cc, double price)
	{
		this.setPlat_no(plat_no);
		this.setMake(make);
		this.setType(type);
		this.setCc(cc);
		this.setPrice(price);
		this.setName(name);
	}
	public String getPlat_no() {
		return plat_no;
	}
	public void setPlat_no(String plat_no) {
		this.plat_no = plat_no;
	}
	public int getMake() {
		return make;
	}
	public void setMake(int make) {
		this.make = make;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int string) {
		this.cc = string;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
