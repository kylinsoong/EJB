package com.kylin.ejb.cmt.ejb;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.kylin.ejb.cmt.model.Customer;

@Stateless
public class CustomerManagerEJB {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private InvoiceManagerEJB invoiceManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createCustomer(String name) throws RemoteException, JMSException {

        Customer c1 = new Customer();
        c1.setName(name);
        entityManager.persist(c1);

        invoiceManager.createInvoice(name);
    }

    /**
     * List all the customers.
     * 
     */
    @TransactionAttribute(TransactionAttributeType.NEVER)
    @SuppressWarnings("unchecked")
    public List<Customer> listCustomers() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }
}
