package project;

public class Car extends Vehicle{
		private String transmission;
		private String aircon;
		private int no_of_passenger;
		private int no_of_laugage;
		
		
		public Car()
		{}
		
		public Car(String name, String plat_no, int make, String type, int cc, double price, String transmission, String aircon, int no_of_passenger, int no_of_laugage)
		{
			super(name, plat_no, make, type, cc, price);
			this.setTransmission(transmission);
			this.setAircon(aircon);
			this.setNo_of_passenger(no_of_passenger);
			this.setNo_of_laugage(no_of_laugage);		
		}

		public String getTransmission() {
			return transmission;
		}

		public void setTransmission(String transmission) {
			this.transmission = transmission;
		}

		public String isAircon() {
			return aircon;
		}

		public void setAircon(String aircon) {
			this.aircon = aircon;
		}

		public int getNo_of_passenger() {
			return no_of_passenger;
		}

		public void setNo_of_passenger(int no_of_passenger) {
			this.no_of_passenger = no_of_passenger;
		}

		

		
		public int getNo_of_laugage() {
			return no_of_laugage;
		}

		public void setNo_of_laugage(int no_of_laugage) {
			this.no_of_laugage = no_of_laugage;
		}

		
	}

