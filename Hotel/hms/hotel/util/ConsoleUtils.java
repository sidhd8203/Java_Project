package hms.hotel.util;

import java.util.ArrayList;
import java.util.Scanner;

import hms.hotel.dto.Hotel;

public class ConsoleUtils {

	public Hotel reserve(Scanner sc) {
		System.out.println("-----< 예약하기 > -----");
		System.out.print("고객이름=");
		String name = sc.nextLine();
		if(name.length() == ' ') {
			while(name.length() == ' ') {
				System.out.println("고객이름=");
				name = sc.nextLine();
			}
		}
		System.out.print("핸드폰 번호 (xxx-xxxx-xxxx) =");
		String phone = sc.nextLine();
		if(phone.length() != 13) {
			while(phone.length() != 13) {
				System.out.print("핸드폰 번호 (xxx-xxxx-xxxx) =");
				phone = sc.nextLine();
			}
		}
		System.out.print("비밀번호 입력(20자 내) =");
		int pass = Integer.parseInt(sc.nextLine());					
		return new Hotel(name, phone, pass); 
	}
	
	public Hotel getName(String name, Scanner sc) {
		System.out.println(name + "할 정보를 입력하세요.");
		System.out.print("name = ");
		String name1 = sc.nextLine();
		System.out.print("phone = ");
		String phone = sc.nextLine();
		System.out.print("pass =");
		int pass = Integer.parseInt(sc.nextLine());
		return new Hotel(name1, phone, pass);

	}
	public boolean getAdmin(Scanner sc) {
		boolean admin_check = false;
		System.out.println("--------<관리자 모드>-------");
		System.out.print("Id = ");
		String name = sc.nextLine();
		System.out.print("Pass = ");
		int pass = Integer.parseInt(sc.nextLine());
		
		if(name.equals("최성진") && pass==1234) {
			admin_check = true;
		}
		return admin_check;
	}

	public int admin_menu(Scanner sc) {
		System.out.println("== 관리자 메뉴 ==");
		System.out.println("1. 전체손님조회");
		System.out.println("2. 메인메뉴 ");
		System.out.print("menu = ");
		return Integer.parseInt(sc.nextLine());
	}

	public void AllAccount(ArrayList<Hotel> list) {
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));		
	}
	
	public void addSuccess(Hotel dto) {
		System.out.println(dto.getName() + "님 회원정보 등록이 성공하였습니다.");
	}

	public void addFail(Hotel dto) {
		System.out.println(dto.getName() + "님 회원정보 등록이 실패하였습니다.");
	}

	public void showFail() {
		System.out.println("고객정보가 존재하지 않습니다.");
	}

	public void showAllHotel(ArrayList<Hotel> list) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i);
		}
	}
	public Hotel getUpdateMember(Scanner sc, Hotel oldHotel) {
		System.out.print("이름 : " + oldHotel.getName() + " ==> ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : " + oldHotel.getPass() + " ==> ");
		int pass = Integer.parseInt(sc.nextLine());
		return new Hotel(name,oldHotel.getPhone(),pass);
	}
	
	public void modifySuccess(Hotel oldHotel) {
		System.out.println(oldHotel.getName() + "회원님 정보수정이 성공하였습니다.");
	}
	
	public void modifyFail(Hotel oldHotel) {
		System.out.println(oldHotel.getName() + "회원님 정보수정이 실패하였습니다.");
	}
	
	public void deleteSuccess(Hotel h) {
		System.out.println(h + "예약취소 되었습니다.");
	}
	
	public void deleteFail(Hotel h) {
		System.out.println("고객정보를 확인해주세요.");
	}

}


