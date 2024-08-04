package com.pos.system.repository;

import com.pos.system.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface OrderItemsRepo  extends JpaRepository<CustomerOrder,String> {
}
