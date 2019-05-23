package hms.hotel.action;

import java.util.ArrayList;
import java.util.Scanner;

import hms.hotel.dto.Hotel;
import hms.hotel.svc.AdminService;
import hms.hotel.util.ConsoleUtils;

public class AdminAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		boolean check = cu.getAdmin(sc);
		
		
		AdminService admin = new AdminService();
		ArrayList<Hotel> list = null;
		
		if(check) {
			int menu  = 0;
			do {
				menu = cu.admin_menu(sc);	
				if(menu == 1) {
					list = admin.show();
					cu.AllAccount(list);
				}
				if(menu != 1 && menu != 2)
				System.out.println("�ٽ� �Է����ּ���.");
				System.out.println();
				
			}while(menu != 2);
		}
		else {
			System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���.");
		}
		
		
		
		
	}

}
