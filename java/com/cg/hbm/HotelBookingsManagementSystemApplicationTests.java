package com.cg.hbm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.Payments;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.entites.Transactions;
import com.cg.hbm.entites.User;
import com.cg.hbm.service.IBookingDetailsService;
import com.cg.hbm.service.IHotelService;
import com.cg.hbm.service.IPaymentService;
import com.cg.hbm.service.IRoomDetailsService;
import com.cg.hbm.service.IUserService;

@SpringBootTest
class HotelBookingsManagementSystemApplicationTests extends AbstractTest {
	@Autowired
	IHotelService hService;
	@Autowired
	IPaymentService iService;
	@Autowired
	IBookingDetailsService bService;
	@Autowired
	IUserService uService;
	@Autowired
	IRoomDetailsService rService;

	

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	/**
	 * 
	 * @throws Exception
	 */

	@Test
	public void getHotel() throws Exception {
		String uri = "/hotel/20";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Hotel hotel = super.mapFromJson(content, Hotel.class);
		assertEquals("Vijayawada", hotel.getCity());
	}
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void addHotel() throws Exception{
	Hotel hotel=new Hotel();

	hotel.setAddress("Gandla Nagar");
	hotel.setCity("Gurgaon");
	hotel.setAvg_rate_per_day((double)1800);
	hotel.setDescription("Awesome Hotel");
	hotel.setEmail("kurr@gmail.com");
	hotel.setHotel_name("Bangar");
	hotel.setPhone1("9393158131");
	hotel.setPhone2("6789567845");
	hotel.setWebsite("udi.com");
	
	String uri="/hotel/add";
	String inputJson=super.mapToJson(hotel);
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    Hotel hotel1=super.mapFromJson(content, Hotel.class);
    assertEquals("Gurgaon",hotel1.getCity());
	}
	/**
	 * 
	 * @throws Exception
	 */
	
	

	@Test
	public void deleteHotel() throws Exception{
		String uri="/hotel/1";
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
	    int status=mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content=mvcResult.getResponse().getContentAsString();
	    Hotel ho=super.mapFromJson(content, Hotel.class);
	    String delUri="/hotel/remove";
	    String inputJson = super.mapToJson(ho);
	    this.mvc.perform(MockMvcRequestBuilders.delete(delUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	/**
	 * 
	 * @throws Exception
	 */

	@Test
	public void updateHotel() throws Exception{
	String uri="/hotel/20";
	String putUri="/hotel/update";
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    Hotel h=super.mapFromJson(content, Hotel.class);
    h.setHotel_name("Mayuri");
    h.setPhone1("6576578909");
    String inputJson = super.mapToJson(h);
	MvcResult mvcResult1=mvc.perform(MockMvcRequestBuilders.put(putUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status1 = mvcResult1.getResponse().getStatus();
    assertEquals(200,status1);
    String content1 = mvcResult1.getResponse().getContentAsString();
    Hotel h1=super.mapFromJson(content1, Hotel.class);
    assertEquals("Mayuri",h1.getHotel_name());
	assertEquals("6576578909",h1.getPhone1());
	}

	/**
	 * 
	 * @throws Exception
	 */
	 
	@Test
	public void getShowAllHotels() throws Exception {
		String uri = "/hotel/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Hotel hotel[] = super.mapFromJson(content, Hotel[].class);
		assertEquals("Anu", hotel[1].getHotel_name());
	}
	
	
	/*********************************************************************************************************************************************/
	
	
	
	/**
	 * 
	 * @throws Exception
	 */
	
	
	@Test
	public void getShowAllBookingDetails() throws Exception {
		String uri = "/bookingdetails/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		BookingDetails bookingdetails[] = super.mapFromJson(content, BookingDetails[].class);
		assertEquals(50000, bookingdetails[1].getAmount());
	}
	/**
	 * 
	 * @throws Exception
	 */

	@Test
	public void addBookingDetails() throws Exception {
		String uri="/bookingdetails/add";
		
		Hotel hotel=new Hotel("Vijayawada","kennara", "gjhjhkjlmll","Best Hotel", 18,"manikonda@gmail.com", "9898986788", "9898984530", "SmartHotelManerva.com"
				);
		RoomDetails roomdetails=new RoomDetails("102",1300, "DoubleDelux",true,hotel);


		User user=new User("Varshitha","hars@gmail.com","varsha","searching", "9876543210","jhbjkhnhjk");
		Date currentdate=new Date();
		Date todate=new Date(currentdate.getTime()+(10000*60*60*24));
		BookingDetails bookingdetails=new BookingDetails(currentdate,todate,480, 100,40000, hotel,roomdetails,user);
		bookingdetails.setAmount(45000);
		bookingdetails.setBooked_from(currentdate);
		bookingdetails.setBooked_from(todate);
		bookingdetails.setNo_of_adults(450);
		bookingdetails.setNo_of_children(80);
		bookingdetails.setBooking_id(3);
		bookingdetails.setHotel(hotel);
		bookingdetails.setRoomdetails(roomdetails);
		bookingdetails.setUser(user);
		String inputJson=super.mapToJson(bookingdetails);
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType. APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content=mvcResult.getResponse().getContentAsString(); 
		BookingDetails b=super.mapFromJson(content, BookingDetails.class);
		assertEquals(450,b.getNo_of_adults());
	}
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void getBookingDetails() throws Exception {
		String uri = "/bookingdetails/26";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		BookingDetails bookingdetails = super.mapFromJson(content, BookingDetails.class);
		assertEquals(160, bookingdetails.getNo_of_adults());
	}
		
	/***************************************************************************************************************************************************/	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void getPayments() throws Exception {
		String uri = "/payment/33";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Payments payments = super.mapFromJson(content, Payments.class);
		assertEquals(33, payments.getPayment_id());
	}
	/**
	 * 
	 * @throws Exception
	 */

	@Test
	public void addPayment() throws Exception{
		String uri="/payment/add";
		Date currentdate=new Date();
		Date todate=new Date(currentdate.getTime()+(10000*60*60*24));
		Hotel hotel=new Hotel("Hyderabad", "Ibaco", "FunTimesRoad", "bestest Hotel",200,"u@gmail.com", "6776767789", "6578956788", "mom.com");
		RoomDetails room=new RoomDetails("167",1208,"Ac Room",true,hotel);
		User u=new User( "Hari","fathima@gmail.com","tinu","customer","7654367890","Fathekan Nagar");
		BookingDetails bookingdetails=new BookingDetails(currentdate,todate,16,9,24000,hotel,room,u);
		Transactions transaction=new Transactions(58000);
		Payments p=new Payments(bookingdetails,transaction);
		p.setTransactions(transaction);
		p.setBookingdetails(bookingdetails);
		String inputJson=super.mapToJson(p);
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	    int status=mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content=mvcResult.getResponse().getContentAsString();
	    Payments p1=super.mapFromJson(content, Payments.class);
	    assertEquals(58000,p1.getTransactions().getAmount());
		}
	
	
}
