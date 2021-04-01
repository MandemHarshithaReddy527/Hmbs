package com.cg.hbm.service;

import java.util.List;



import com.cg.hbm.entites.Payments;

public interface IPaymentService {
	
	public Payments addPayment(Payments payments);
	public List<Payments> showAllPayments();
	public Payments showPayments(int payment_id);
}
