package org.example.dao;

import org.example.entity.Customer;
import org.example.entity.Payment;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PaymentDAO {

// création d'un paiement
    public static void create(Payment paymentToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(paymentToCreate);
        tx.commit();
    }


    public static Payment findByIdCard(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Payment payment = entityManager.find(Payment.class, id);
        return payment;
    }

    public static List<Payment> findAllPayment() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Payment c");

        return findAllQuery.getResultList();
    }

    public static void deletePayment(Payment payment){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(payment);
        tx.commit();
    }

    public static void updatePayment(long id, Payment newPaymentData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Payment paymentToUpdate = entityManager.find(Payment.class, id);
        paymentToUpdate.setNotNullDataPayment(newPaymentData);


        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(paymentToUpdate);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }
    }

    public static List<Payment> findByCode(String confidentialCode) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();


        Query queryToFindPaymentByFirstName = entityManager.createQuery("select c from Payment c where c.confidentialCode = :confidentialCode");
        queryToFindPaymentByFirstName.setParameter("confidentialCode",confidentialCode);
        return queryToFindPaymentByFirstName.getResultList();

    }

}




