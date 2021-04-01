
package com.cg.hbm.service;


import java.util.List;



import com.cg.hbm.entites.Hotel;
/*************************************************************************************************
 *@author          	Harshitha
 *Description      	It is a IHotelService Interface and provides methods for the Implementation class.  
 *Version          	1.0
 *Created Date    	31-MAR-2021
 *************************************************************************************************/

public interface IHotelService {
	public Hotel addHotel(Hotel hotel);
	public Hotel updateHotel(Hotel hotel);
	public Hotel removeHotel(Hotel hotel);
	public List<Hotel> showAllHotels();
	public Hotel showHotel(int hotel_id);
}

	
	
	


