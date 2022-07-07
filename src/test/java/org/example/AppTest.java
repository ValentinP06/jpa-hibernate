package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("alin");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);

        assertTrue(true);
    }


    @Test
    public void findById(){

        Customer customer = new Customer();
        customer.setFirstName("alin");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);

       Customer customer1 = CustomerDAO.findById(customer.getId());

        assertEquals("alain", customer1.getFirstName());

    }

    @Test
    public void dontfindById(){

        Customer customer = CustomerDAO.findById(5);

        assertNull(customer);

    }
    @Test
    public void findAll(){

       CustomerDAO.create(new Customer("Marie"));
        CustomerDAO.create(new Customer("Michel"));
        CustomerDAO.create(new Customer("Alex"));

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    public void deleteCustomer(){
        Customer marie= new Customer("Marie");
        CustomerDAO.create(marie);
        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(1, customers.size());
        CustomerDAO.delete(marie);

         customers = CustomerDAO.findAll();
        assertEquals(0, customers.size());
    }

    @Test
    public void deleteCustomerById(){

        Customer customer1= new Customer("customer1");
        CustomerDAO.create(customer1);
        Customer customer2= new Customer("customer2");
        CustomerDAO.create(customer2);
        Customer customer3= new Customer("customer3");
        CustomerDAO.create(customer3);


        CustomerDAO.deleteCustomerById(customer1.getId());
    }

    @Test
    public void updateCustomer(){

        Customer customer1= new Customer("customer1");
        CustomerDAO.create(customer1);


        CustomerDAO.updateCustomer(customer1.getId());
    }

}

