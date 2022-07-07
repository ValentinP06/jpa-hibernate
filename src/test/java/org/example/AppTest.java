package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDAO;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.junit.Assert;
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

        Customer customer1= new Customer();
        customer1.setFirstName("Alain");
        customer1.setLastName("Delon");
        customer1.setAddress("rue des Delon");
        customer1.setCity("Deloncity");
        customer1.setCompanyName("DelonInc");
        customer1.setCountry("Delonpays");
        customer1.setEmail("Delon@gmail.fr");
        customer1.setPhone("123456789");
        customer1.setZipCode("12345");
        customer1.setState(1);

        CustomerDAO.create(customer1);

        /*******************************/

        Customer newCustomerData = new Customer();
        newCustomerData.setFirstName("jean paul");
        newCustomerData.setLastName("Gautier");


        CustomerDAO.update(customer1.getId(), newCustomerData);
    }

    @Test
    public void selectWhere() {

        Customer customer1 = new Customer();
        customer1.setFirstName("Alain");
        customer1.setLastName("Delon");
        CustomerDAO.create(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Alain");
        customer2.setLastName("Prost");
        CustomerDAO.create(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Marie");
        customer3.setLastName("Dupont");
        CustomerDAO.create(customer3);


        /***************************/

        List <Customer> alains = CustomerDAO.findByFirstName("Alain");

        /***************************/
        for (Customer c: alains)
            System.out.println(c);
        assertEquals(2,alains.size());

    }
    /***************************/
    /***************************/
    /***************************/
    /***************************/
    /*************PAYMENT**************/

    @Test
    public void createPayment() {
        Payment payment = new Payment();
        payment.setBank("bnb paribas");
        payment.setCardNumber("1234567890");
        payment.setConfidentialCode("1234");
        PaymentDAO.create(payment);

        assertTrue(true);
    }
    @Test
    public void findByIdCard(){
        Payment payment = new Payment();
        payment.setBank("bnb paribas");
        payment.setCardNumber("1234567890");
        payment.setConfidentialCode("1234");;
        PaymentDAO.create(payment);

        Customer customer1 = CustomerDAO.findById(payment.getId());

        assertEquals("1234567890", payment.getCardNumber());
    }

    @Test
    public void findAllPayment(){

        PaymentDAO.create(new Payment("bnp paribas"));
        PaymentDAO.create(new Payment("credit du nord"));
        PaymentDAO.create(new Payment("revolut"));

        List<Payment> payments = PaymentDAO.findAllPayment();
        assertEquals(3, payments.size());
    }

    @Test
    public void deletePayment(){
        Payment payment = new Payment("bnp paribas");

        PaymentDAO.create(payment);

        List<Payment> payments = PaymentDAO.findAllPayment();

        assertEquals(1, payments.size());

        PaymentDAO.deletePayment(payment);

        payments = PaymentDAO.findAllPayment();
        assertEquals(0, payments.size());
    }
    @Test
    public void updatePayment(){

        Payment payment= new Payment();
        payment.setBank("bnp");
        payment.setConfidentialCode("1234");
        payment.setCardNumber("12345678904");

        PaymentDAO.create(payment);

        /**************changement du code de carte*****************/

        Payment newPaymentData = new Payment();
        newPaymentData.setConfidentialCode("jesuisuncodedecartelol");

        PaymentDAO.updatePayment(payment.getId(), newPaymentData);
    }

    @Test
    public void selectWherePayment() {

        Payment payment1 = new Payment();
        payment1.setCardNumber("1234567890");
        payment1.setConfidentialCode("1234");
        PaymentDAO.create(payment1);

        Payment payment2 = new Payment();
        payment2.setCardNumber("12345671234890");
        payment2.setConfidentialCode("1234");
        PaymentDAO.create(payment2);


        /***************************/

        List <Payment> code = PaymentDAO.findByCode("1234");

        /***************************/
        for (Payment c: code)
            System.out.println(c);
        assertEquals(2,code.size());

    }



    }



