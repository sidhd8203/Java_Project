package hms.hotel.util;

import java.util.ArrayList;
import java.util.Scanner;

import hms.hotel.dto.Hotel;

public class ConsoleUtils {

	public Hotel reserve(Scanner sc) {
		System.out.println("-----< �����ϱ� > -----");
		System.out.print("���̸�=");
		String name = sc.nextLine();
		if(name.length() == ' ') {
			while(name.length() == ' ') {
				System.out.println("���̸�=");
				name = sc.nextLine();
			}
		}
		System.out.print("�ڵ��� ��ȣ (xxx-xxxx-xxxx) =");
		String phone = sc.nextLine();
		if(phone.length() != 13) {
			while(phone.length() != 13) {
				System.out.print("�ڵ��� ��ȣ (xxx-xxxx-xxxx) =");
				phone = sc.nextLine();
			}
		}
		System.out.print("��й�ȣ �Է�(20�� ��) =");
		int pass = Integer.parseInt(sc.nextLine());					
		return new Hotel(name, phone, pass); 
	}
	
	public Hotel getName(String name, Scanner sc) {
		System.out.println(name + "�� ������ �Է��ϼ���.");
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
		System.out.println("--------<������ ���>-------");
		System.out.print("Id = ");
		String name = sc.nextLine();
		System.out.print("Pass = ");
		int pass = Integer.parseInt(sc.nextLine());
		
		if(name.equals("�ּ���") && pass==1234) {
			admin_check = true;
		}
		return admin_check;
	}

	public int admin_menu(Scanner sc) {
		System.out.println("== ������ �޴� ==");
		System.out.println("1. ��ü�մ���ȸ");
		System.out.println("2. ���θ޴� ");
		System.out.print("menu = ");
		return Integer.parseInt(sc.nextLine());
	}

	public void AllAccount(ArrayList<Hotel> list) {
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));		
	}
	
	public void addSuccess(Hotel dto) {
		System.out.println(dto.getName() + "�� ȸ������ ����� �����Ͽ����ϴ�.");
	}

	public void addFail(Hotel dto) {
		System.out.println(dto.getName() + "�� ȸ������ ����� �����Ͽ����ϴ�.");
	}

	public void showFail() {
		System.out.println("�������� �������� �ʽ��ϴ�.");
	}

	public void showAllHotel(ArrayList<Hotel> list) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i);
		}
	}
	public Hotel getUpdateMember(Scanner sc, Hotel oldHotel) {
		System.out.print("�̸� : " + oldHotel.getName() + " ==> ");
		String name = sc.nextLine();
		System.out.print("��й�ȣ : " + oldHotel.getPass() + " ==> ");
		int pass = Integer.parseInt(sc.nextLine());
		return new Hotel(name,oldHotel.getPhone(),pass);
	}
	
	public void modifySuccess(Hotel oldHotel) {
		System.out.println(oldHotel.getName() + "ȸ���� ���������� �����Ͽ����ϴ�.");
	}
	
	public void modifyFail(Hotel oldHotel) {
		System.out.println(oldHotel.getName() + "ȸ���� ���������� �����Ͽ����ϴ�.");
	}
	
	public void deleteSuccess(Hotel h) {
		System.out.println(h + "������� �Ǿ����ϴ�.");
	}
	
	public void deleteFail(Hotel h) {
		System.out.println("�������� Ȯ�����ּ���.");
	}

}


