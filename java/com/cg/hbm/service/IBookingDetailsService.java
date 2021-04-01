
package com.cg.hbm.service;


import java.util.List;



import com.cg.hbm.entites.BookingDetails;
/***************************************************************************************************************
 *@author          	Harshitha
 *Description      	It is a IBookingDetailsService Interface and provides methods for the Implementation class.  
 *Version          	1.0
 *Created Date    	31-MAR-2021
 **************************************************************************************************************/

public interface IBookingDetailsService {
	public BookingDetails addBookingDetails(BookingDetails bookingDetails);
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails);
	public BookingDetails removeBookingDetails(BookingDetails bookingDetails);
	public List<BookingDetails> showAllBookingDetails();
	public BookingDetails showBookingDetails(int bookingDetails_id);
}

