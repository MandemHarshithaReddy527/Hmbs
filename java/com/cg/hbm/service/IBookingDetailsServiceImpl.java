package com.cg.hbm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entites.BookingDetails;

import com.cg.hbm.dao.IBookingDetailsRepository;

@Service
public class IBookingDetailsServiceImpl implements IBookingDetailsService{
	@Autowired
	IBookingDetailsRepository bDao;
	/**
	 * @author Harshitha
	 * @param bookingdetails
	 * @return BookingDetails
	 */

	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
		return bDao.save(bookingDetails);
	}
	/**
	 * @author Harshitha
	 * @param bookingdetails
	 * @return BookingDetails
	 */

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {
		return bDao.saveAndFlush(bookingDetails);
	}
	/**
	 * @author Harshitha
	 * @param bookingdetails
	 * @return BookingDetails
	 */

	@Override
	public BookingDetails removeBookingDetails(BookingDetails bookingDetails) {
		bDao.deleteById(bookingDetails.getBooking_id());
		return  bookingDetails;
	}
	/**
	 * @author Harshitha 
	 * @return List<BookingDetails>
	 */

	@Override
	public List<BookingDetails> showAllBookingDetails() {
		return bDao.findAll();
	}
	
	/**
	 * @author Harshitha
	 * @param booking_id
	 * @return BookingDetails
	 */

	@Override
	public BookingDetails showBookingDetails(int booking_id) {
		return bDao.findById(booking_id).get();
	}

}
