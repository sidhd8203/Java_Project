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
		System.out.println("1. 예약하기");
		System.out.println("2. 예약변경");
		System.out.println("3. 예약취소");
		System.out.println("4. 작업종료");
		System.out.println("5. 관리자메뉴");
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
				case 1: // 예약하기
					action = new ReserveAction();
					break;
				case 2: // 예약변경
					action = new ReserveChangeAction();
					break;
				case 3: // 예약취소
					action = new ReserveCancleAction();
					break; // 작업종료
				case 4 : isStop = true;
					break;
				case 5 : // 관리자 메뉴
					action = new AdminAction();
					break;
				default:
					System.out.println("메뉴의 선택이 올바르지 않습니다.");
			}
			if(action != null) {
				fc.processRequest(action, sc);
			}
		}while(!isStop);
		System.out.println("호텔 예약 프로그램을 종료합니다.");
	}

}
