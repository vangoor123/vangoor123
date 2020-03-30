package com.assignment.service;

import java.sql.Date;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.Order;
import com.assignment.entity.Status;
import com.assignment.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@PostConstruct
	public void insertData() {

		for (int i = 1; i <=20; i++) {
			Order order = new Order();
			order.setId(i);
			if(i == 10) {
			order.setOrderDate(Date.valueOf(LocalDate.now().minusDays(90)));
			order.setStatus(Status.DELIVERED);
			order.setIsOrderComplete('N');
			order.setOrderNumber("order_" + i);
		order.setTotalAmount(1000.00);

			
			}
			
			else if(i <= 5) {
				order.setIsOrderComplete('N');
				order.setOrderNumber("order_" + i);
				order.setTotalAmount(1000.00);

				order.setOrderDate(Date.valueOf(LocalDate.now().minusDays(190)));
				order.setStatus(Status.CANCELLED);
				
			}
			else {
				order.setOrderDate(Date.valueOf(LocalDate.now()));
				order.setIsOrderComplete('N');
				order.setOrderNumber("order_" + i);
				order.setStatus(Status.CREATED);
				order.setTotalAmount(1000.00);

						
			}
		
			orderRepo.save(order);
		}

	}

}
