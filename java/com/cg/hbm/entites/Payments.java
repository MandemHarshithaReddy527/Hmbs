package com.cg.hbm.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payments")
public class Payments {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	
	private int payment_id;
	@ManyToOne(cascade= {CascadeType.ALL}) 
	@JoinColumn(name="booking_id",referencedColumnName="booking_id") 
	private BookingDetails bookingdetails;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="transaction_id",referencedColumnName="transaction_id") 
	private Transactions transactions;
	
	
	public  Payments(){
		
	}
	public Payments( BookingDetails bookingdetails,Transactions transactions ) {
		super();
		//this.payment_id=payment_id;
		this.bookingdetails=bookingdetails;
		this.transactions=transactions;
	}
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	
	public BookingDetails getBookingdetails() {
		return bookingdetails;
	}
	public void setBookingdetails(BookingDetails bookingdetails) {
		this.bookingdetails = bookingdetails;
	}
	public Transactions getTransactions() {
		return transactions;
	}
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
	
}
