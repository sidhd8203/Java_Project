package hms.hotel.ui;
import java.util.Scanner;
import hms.hotel.action.Action;
import hms.hotel.action.AdminAction;
import hms.hotel.action.ReserveAction;
import hms.hotel.action.ReserveCancleAction;
import hms.hotel.action.ReserveChangeAction;
import hms.hotel.controller.FrontController;
public class MainProcessor {
	public static void main_menu() {
		System.out.println("----- < Main Menu > ------");
		System.out.println("1. �����ϱ�");
		System.out.println("2. ���ຯ��");
		System.out.println("3. �������");
		System.out.println("4. �۾�����");
		System.out.println("5. �����ڸ޴�");
		System.out.println("--------------------------");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		System.out.println("< Hotel Reservation System >");
		System.out.println(" WELCOME TO JSL_HOTEL ");
		
		boolean isStop = false;
		
		FrontController fc = new FrontController();
		int menu = 0;
		do {
			
			System.out.println();
			main_menu();
			System.out.print("menu =");
			try {
		
			menu = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				e.printStackTrace();
			}
			Action action = null;
			
			switch(menu) {
				case 1: // �����ϱ�
					action = new ReserveAction();
					break;
				case 2: // ���ຯ��
					action = new ReserveChangeAction();
					break;
				case 3: // �������
					action = new ReserveCancleAction();
					break; // �۾�����
				case 4 : isStop = true;
					break;
				case 5 : // ������ �޴�
					action = new AdminAction();
					break;
				default:
					System.out.println("�޴��� ������ �ùٸ��� �ʽ��ϴ�.");
			}
			if(action != null) {
				fc.processRequest(action, sc);
			}
		}while(!isStop);
		System.out.println("ȣ�� ���� ���α׷��� �����մϴ�.");
	}

}
