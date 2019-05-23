package hms.hotel.action;

import java.util.Scanner;

import hms.hotel.dto.Hotel;
import hms.hotel.svc.ReserveService;
import hms.hotel.util.ConsoleUtils;

public class ReserveAction implements Action {
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtils cu = new ConsoleUtils();
		Hotel h = cu.reserve(sc);
		
		ReserveService reserveService = new ReserveService();
		boolean check = reserveService.add(h);
		
		if(check)
			h.reserveSuccess(h);
		else
			h.reserveFail(h);
	}
}
