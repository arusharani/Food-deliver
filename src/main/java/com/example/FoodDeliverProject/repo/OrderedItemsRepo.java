package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderedItemsRepo extends JpaRepository<OrderedItems,Integer> {
//    @Transactional
//    @Query("DELETE FROM OrderedItems o WHERE o.orderId = :orderId")
//    void deleteorder(@Param("orderId")int id);

    List<OrderedItems> findByOrderId(int id);
}
