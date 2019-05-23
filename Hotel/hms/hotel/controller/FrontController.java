package hms.hotel.controller;

import java.util.Scanner;

import hms.hotel.action.Action;

public class FrontController {
		
	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
