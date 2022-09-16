
package com.sg.flm.dao;

import com.sg.flm.dto.Order;
import java.util.List;
import java.time.LocalDate;

public interface FlooringMasteryOrderDao {
    
    Order addOrder(Order order);

    List<Order> searchOrders(LocalDate date);
    
    void removeOrder(LocalDate date, int orderNumber);
    
    void editOrder (LocalDate date);
    
    Order getOrder(List<Order> orderList, int orderNumber);
    
    List<String> getFileNamesFromDirectory();
}
