package hms.hotel.action;

import java.util.Scanner;

import hms.hotel.dto.Hotel;
import hms.hotel.svc.RemoveService;
import hms.hotel.util.ConsoleUtils;




public class ReserveCancleAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtils cu = new ConsoleUtils();
		Hotel h = cu.getName("ªË¡¶", sc);
		
		RemoveService remove = new RemoveService();
		boolean check = remove.delete(h);
		
		if(check)
			cu.deleteSuccess(h);
		else
			cu.deleteFail(h);

	}

}
