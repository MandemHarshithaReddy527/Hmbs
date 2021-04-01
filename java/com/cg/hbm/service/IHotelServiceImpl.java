
package com.cg.hbm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.dao.IHotelRepository;

@Service
public class IHotelServiceImpl implements IHotelService{
	@Autowired
	IHotelRepository iDao;
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel
	 */
	@Override
	public Hotel addHotel(Hotel hotel) {
		return iDao.save(hotel);
	}
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel
	 */
	

	@Override
	public Hotel updateHotel(Hotel hotel) {
		return iDao.saveAndFlush(hotel);
	}
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel
	 */

	@Override
	public Hotel removeHotel(Hotel hotel) {
		iDao.deleteById(hotel.getHotel_id());
		return hotel;
	}
	/**
	 * @author Harshitha
	 * @return List<Hotel>
	 * 
	 */
	

	@Override
	public List<Hotel> showAllHotels() {
		return iDao.findAll();
	}
	/**
	 * @author Harshitha
	 * @return Hotel
	 * @param hotel_id
	 */

	@Override
	public Hotel showHotel(int hotel_id) {
		return iDao.findById(hotel_id).get();
	}

}
