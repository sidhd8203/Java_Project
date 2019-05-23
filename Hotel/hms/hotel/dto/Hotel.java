package hms.hotel.dto;

public class Hotel {
	private String name;
	private String phone;
	private int pass;
	
	
	public Hotel() {}
	public Hotel(String name, String phone, int pass) {
		this.name = name;
		this.phone = phone;
		this.pass = pass;
	}
	public int getPass() {
		return pass;
	}
	
	public void setPass(int pass) {
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", phone=" + phone + "]";
	}
	public void reserveSuccess(Hotel h) {
		System.out.println(h.getName() + " 님 예약이 완료되었습니다.");
		
	}
	public void reserveFail(Hotel h) {
		System.out.println(h.getName() + " 정보입력을 확인해주세요.");
		
	}
	
}
