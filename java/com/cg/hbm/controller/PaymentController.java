/*
 * package com.cg.hbm.controller; import java.util.List;
 * 
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * 
 * import com.cg.hbm.entites.Payments; import
 * com.cg.hbm.exceptions.PaymentNotFoundException; import
 * com.cg.hbm.service.IPaymentService;
 * 
 * @RestController
 * 
 * @RequestMapping("/payment") public class PaymentController {
 * 
 * @Autowired IPaymentService iService;
 * 
 * 
 * @PostMapping public ResponseEntity<Payments> addPayment(@RequestBody Payments
 * payments) throws PaymentNotFoundException { Payments
 * resultPayments=iService.addPayment(payments); return new
 * ResponseEntity<Payments>(resultPayments,HttpStatus.OK) ; }
 * 
 * 
 * @GetMapping
 * 
 * public ResponseEntity<List<Payments>> showAllPayments() throws
 * PaymentNotFoundException{ List<Payments>
 * resultPayments=iService.showAllPayments(); return new
 * ResponseEntity<List<Payments>>(resultPayments, HttpStatus.OK); }
 * 
 * 
 * @GetMapping("/{id}") public
 * ResponseEntity<Payments>showPayments(@PathVariable int id) throws
 * PaymentNotFoundException { Payments p=iService.showPayments(id); if(p!=null)
 * { return new ResponseEntity<Payments>(p,HttpStatus.OK); } else { return new
 * ResponseEntity<Payments>(HttpStatus.NOT_FOUND); }
 * 
 * } }
 * 
 */
package com.cg.hbm.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.Payments;
import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.HotelNotFoundException;
import com.cg.hbm.exceptions.PaymentNotFoundException;
import com.cg.hbm.exceptions.RoomDetailsNotFoundException;
import com.cg.hbm.service.IHotelService;
import com.cg.hbm.service.IPaymentService;
import com.cg.hbm.service.IRoomDetailsService;
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	IPaymentService iSer;
	
	/**
	 * 
	 * 
	 * @param roomDetails
	 * @return
	 */
	
	@PostMapping("/add")
	public Payments addPayment(@RequestBody Payments payment) {
		return iSer.addPayment(payment);
	}
	
	/**
	 * 
	 * 
	 * @param roomDetails
	 * @return
	 */

	
	/**
	 * 
	 * 
	 * 
	 * @param roomDetails
	 * @return
	 * @throws RoomDetailsNotFoundException
	 */
	
	/**
	 * 
	 * 
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<Payments> showAllPayments(){
		return iSer.showAllPayments();
	}
	
	/**
	 * 
	 * 
	 * @param roomDetails_id
	 * @return
	 * @throws RoomDetailsNotFoundException
	 */
	
	@GetMapping("/{payment_id}")
	public Payments showPayments(@PathVariable int payment_id)throws PaymentNotFoundException {
		
		try {
		return iSer.showPayments(payment_id);
		}catch(Exception e)
		{
			throw new PaymentNotFoundException("payment id not available.....give valid number");
		}
		}
	
}

