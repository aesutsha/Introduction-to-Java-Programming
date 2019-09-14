package project;

public class Motorcycle extends Vehicle{
	private int min_experience;
	private int min_age;
	
	public Motorcycle()
	{
		
	}
	
	public Motorcycle(String name,String plat_no, int make, String type, int cc, double price, int min_experience, int min_age)
	{
		super(name, plat_no, make, type, cc, price);
		this.setMin_experience(min_experience);
		this.setMin_age(min_age);
	}

	public int getMin_experience() {
		return min_experience;
	}

	public void setMin_experience(int min_experience) {
		this.min_experience = min_experience;
	}

	public int getMin_age() {
		return min_age;
	}

	public void setMin_age(int min_age) {
		this.min_age = min_age;
	}

}
