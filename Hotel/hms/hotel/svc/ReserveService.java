package hms.hotel.svc;

import hms.hotel.dao.HotelDAO;
import hms.hotel.dto.Hotel;

public class ReserveService {
	
	public boolean add(Hotel h) {
		HotelDAO dao = new HotelDAO();
		int result = dao.insertHotel(h);
		
		if(result > 0)
			return true;
		return false;
	}
}
