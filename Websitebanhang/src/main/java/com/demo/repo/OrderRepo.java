package com.demo.repo;

import com.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO
public interface OrderRepo extends JpaRepository<Order,String> {
}
