package com.eeee.sh2.sales.repositories;

import com.eeee.sh2.sales.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Charles on 28/07/2017.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
