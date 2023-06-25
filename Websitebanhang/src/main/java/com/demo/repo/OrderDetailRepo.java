package com.demo.repo;

import com.demo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO
public interface OrderDetailRepo extends JpaRepository<OrderDetail,String> {
}
