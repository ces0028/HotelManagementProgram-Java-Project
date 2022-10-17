package hotelManagementProgram;

import java.util.Objects;

public class CustomerInfo implements Comparable<CustomerInfo> {
	public static final int NUMBER_OF_QUARTER = 4;

	private String name;
	private String customerNumber;
	private String birth;
	private boolean gender;
	private String telNumber;
	private int firstQuarter;
	private int secondQuarter;
	private int thirdQuarter;
	private int fourthQuarter;
	private String specialRequest;
	private int total;
	private double avg;
	private String grade;

	public CustomerInfo(String name, String customerNumber, String birth, boolean gender, String telNumber,	int firstQuarter, int secondQuarter, int thirdQuarter, int fourthQuarter, String specialRequest) {
		this.name = name;
		this.customerNumber = customerNumber;
		this.birth = birth;
		this.gender = gender;
		this.telNumber = telNumber;
		this.firstQuarter = firstQuarter;
		this.secondQuarter = secondQuarter;
		this.thirdQuarter = thirdQuarter;
		this.fourthQuarter = fourthQuarter;
		this.specialRequest = specialRequest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getBirth() {
		return birth;
	}

	public void setAge(String birth) {
		this.birth = birth;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public int getFirstQuarter() {
		return firstQuarter;
	}

	public void setFirstQuarter(int firstQuarter) {
		this.firstQuarter = firstQuarter;
	}

	public int getSecondQuarter() {
		return secondQuarter;
	}

	public void setSecondQuarter(int secondQuarter) {
		this.secondQuarter = secondQuarter;
	}

	public int getThirdQuarter() {
		return thirdQuarter;
	}

	public void setThirdQuarter(int thirdQuarter) {
		this.thirdQuarter = thirdQuarter;
	}

	public int getFourthQuarter() {
		return fourthQuarter;
	}

	public void setFourthQuarter(int fourthQuarter) {
		this.fourthQuarter = fourthQuarter;
	}

	public int getTotal() {
		return total;
	}

	public double getAvg() {
		return avg;
	}

	public String getGrade() {
		return grade;
	}

	public void calculateTotal() {
		this.total = this.firstQuarter + this.secondQuarter + this.thirdQuarter + this.fourthQuarter;
	}

	public void calculateAvg() {
		this.avg = (double) this.total / NUMBER_OF_QUARTER;
	}

	public void calculateGrade() {
		if (this.avg > 100) {
			grade = "VIP";
		} else if (this.avg > 70) {
			grade = "플래티넘";
		} else if (this.avg > 40) {
			grade = "골드";
		} else if (this.avg > 20) {
			grade = "실버";
		} else {
			grade = "일반";
		}
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CustomerInfo)) {
			return false;
		}
		CustomerInfo customerInfo = (CustomerInfo) obj;
		if (this.name.equals(customerInfo.name)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public int compareTo(CustomerInfo o) {
		CustomerInfo customerInfo = null;
		if (o instanceof CustomerInfo) {
			customerInfo = (CustomerInfo) o;
		} else {
			return 0;
		}
		return this.name.compareToIgnoreCase(customerInfo.name);
	}

	@Override
	public String toString() {
		char charGender = this.gender == false ? '남' : '여';
		return name + "\t" + customerNumber + "\t   " + birth + "\t" + charGender + "\t" + telNumber + "\t" + grade
				+ "\t  " + specialRequest;
	}
}