package hms.hotel.svc;

import hms.hotel.dao.HotelDAO;
import hms.hotel.dto.Hotel;

public class RemoveService {
	public boolean delete(Hotel h) {
		HotelDAO dao = new HotelDAO();
		int result = 0;
		result = dao.deleteHotel(h);
		
		if(result > 0)
			return true;
		
		return false;
	}
}
