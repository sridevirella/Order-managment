package com.egen.repository;

import com.egen.model.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> findAll() {

        return entityManager.createQuery("SELECT order from Order order ORDER BY order.orderCreationDate DESC", Order.class)
                            .getResultList();
    }

    public Order findById(String orderId) {
        return entityManager.find(Order.class, orderId);
    }

    public List<Order> findAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime) {

        return entityManager.createQuery("SELECT o FROM Order o WHERE o.orderCreationDate BETWEEN :startTime AND :endTime")
                            .setParameter("startTime", startTime, TemporalType.TIMESTAMP)
                            .setParameter("endTime", endTime, TemporalType.TIMESTAMP)
                            .getResultList();
    }

    public List<Order> OrdersWithHighestDollarAmountInZip(String zip) {

        // Yet to be check
        String sqlQuery = "SELECT S.order_id\n" +
                          "FROM (SELECT o.order_id, max(o.order_total)  as order_total" +
                                "  FROM orders o, shipping s" +
                                "  WHERE o.order_id = s.order_order_id and s.order_shipping_zip = \"10\"" +
                                "  GROUP BY o.order_id" +
                                "  ORDER BY o.order_total DESC" +
                                "  limit 10" +
                                ") highestAmount" +
                                " INNER JOIN orders S" +
                                "  ON highestAmount.order_id = S.order_id" +
                                "  AND highestAmount.order_total = S.order_total";
       return entityManager.createNativeQuery(sqlQuery).getResultList();
    }

    public Order create(Order order) {
        entityManager.persist(order);
        return order;
    }

    public Order update(Order order) {
        return entityManager.merge(order);
    }
}
