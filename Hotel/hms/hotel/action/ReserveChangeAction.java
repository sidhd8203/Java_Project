package hms.hotel.action;

import java.util.Scanner;

import hms.hotel.dto.Hotel;
import hms.hotel.svc.ReserveChangeService;
import hms.hotel.util.ConsoleUtils;




public class ReserveChangeAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtils cu = new ConsoleUtils();
		Hotel h = cu.getName("수정", sc);
		
		ReserveChangeService modify = new ReserveChangeService();
		Hotel oldHotel = modify.getHotel(h);
		
		if(oldHotel == null) {
			System.out.println("해당 사람은 존재하지 않습니다.");
			return;
		}
		
		Hotel updatehotel = cu.getUpdateMember(sc, oldHotel);
		boolean check = false;
		check = modify.update(updatehotel);
		
		if(check)
			cu.modifySuccess(oldHotel);
		else
			cu.modifyFail(oldHotel);
	}

}
