package com.sg.flm.service;

import com.sg.flm.dao.FlooringMasteryOrderDao;
import com.sg.flm.dao.FlooringMasteryOrderDaoStub;
import com.sg.flm.dao.FlooringMasteryProductDao;
import com.sg.flm.dao.FlooringMasteryProductDaoImpl;
import com.sg.flm.dao.FlooringMasteryTaxDao;
import com.sg.flm.dao.FlooringMasteryTaxDaoImpl;
import com.sg.flm.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class FlooringMasteryServiceTest {

    FlooringMasteryOrderDao dao1 = new FlooringMasteryOrderDaoStub();
    FlooringMasteryProductDao dao2 = new FlooringMasteryProductDaoImpl();
    FlooringMasteryTaxDao dao3 = new FlooringMasteryTaxDaoImpl();
    FlooringMasteryService service = new FlooringMasteryService(dao1, dao2, dao3);
    LocalDate date = LocalDate.of(2018, Month.APRIL, 3);

    @Before
    public void setUp() throws Exception {

        List<Order> orders = dao1.searchOrders(date);

        for (Order order : orders) {
            dao1.removeOrder(date, order.getOrderNumber());
        }
    }

    @Test
    public void testAreaLessThanZero() throws Exception {

        List<Order> itemList = dao1.searchOrders(date);
        Order stubOrder = new Order();
        BigDecimal area = new BigDecimal(-25);

        stubOrder.setCustomerName("SoftwareGuild");
        stubOrder.setState("IN");
        stubOrder.setProductType("Wood");
        stubOrder.setArea(area);

        try {
            service.calculateCost(stubOrder);
            fail("Expected Exception was not thrown.");
        } catch (Exception ex) {

        }
    }
    
    @Test
    public void testCustomerNameNull() throws Exception {
        
        List<Order> itemList = dao1.searchOrders(date);
        Order stubOrder = new Order();
        BigDecimal area = new BigDecimal(25);

        stubOrder.setCustomerName("");
        stubOrder.setState("IN");
        stubOrder.setProductType("Wood");
        stubOrder.setArea(area);
        
        try {
            service.addOrder(stubOrder);
            fail("Expected Exception was not thrown.");
        } catch (Exception ex) {

        }
        
    }
}
