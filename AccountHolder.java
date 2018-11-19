public class AccountHolder {
	private int ssn;
	private String name;
	private String dob;
	private String address;
	public AccountHolder(int ssn, String name, String dob, String address) {
		this.ssn = ssn;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}
	public int getSSN () {
		return ssn;
	}
	public String getname () {
		return name;
	}
	public String getDob () {
		return dob;
	}
	public String getAddress () {
		return address;
	}
}
