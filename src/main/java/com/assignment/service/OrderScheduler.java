package com.assignment.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.assignment.entity.Order;
import com.assignment.entity.Status;
import com.assignment.repo.OrderRepo;

@Service
public class OrderScheduler {

	@Autowired
	private OrderRepo orderRepo;

	@Scheduled(cron = "0 0/5 * * * ?")
	public void test() {
		System.out.println("Schedule Started after Five min");
		List<Order> orders = orderRepo.findAll();
		Date  date = Date.valueOf(LocalDate.now().plusDays(-90));
		for (Order order : orders) {
			if(date.compareTo(order.getOrderDate()) >= 0){
				if(order.getStatus() ==  Status.CANCELLED  || order.getStatus() == Status.DELIVERED) {
						order.setIsOrderComplete('Y');
						orderRepo.save(order);
				}
			}
		}
	}

}
