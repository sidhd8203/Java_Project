package hms.hotel.svc;

import hms.hotel.dao.HotelDAO;
import hms.hotel.dto.Hotel;

public class ReserveChangeService {
	public Hotel getHotel(Hotel h) {
		HotelDAO dao = new HotelDAO();
		Hotel oldHotel = null;
		oldHotel = dao.selectOldHotel(h);

		return oldHotel;
	}
	
	public boolean update(Hotel updateHotel) {
		HotelDAO dao = new HotelDAO();
		int result = dao.updateHotel(updateHotel);

		if(result > 0)
			return true;		
		return false;
}
}