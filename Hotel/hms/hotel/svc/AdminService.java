package hms.hotel.svc;

import java.util.ArrayList;

import hms.hotel.dao.HotelDAO;
import hms.hotel.dto.Hotel;



public class AdminService {
	public ArrayList<Hotel> show() {
		// TODO Auto-generated method stub
		HotelDAO dao = new HotelDAO();
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		list = dao.selectHotelList();
		return list;
	}
}
