package project;

import java.time.LocalDate;

public class Rental {
	private String plate_no;
	private LocalDate pickupDate;
	private LocalDate dropoffDate;
	private int total_days;
	private double total_price;
	private Customer customer;
	
	public Rental()
	{
		
	}
	
	public String getPlate_no() {
		return plate_no;
	}
	public void setPlate_no(String plate_no) {
		this.plate_no = plate_no;
	}
	public LocalDate getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}
	public LocalDate getDropoffDate() {
		return dropoffDate;
	}
	public void setDropoffDate(LocalDate dropoffDate) {
		this.dropoffDate = dropoffDate;
	}
	public int getTotal_days() {
		return total_days;
	}
	public void setTotal_days(int total_days) {
		this.total_days = total_days;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
