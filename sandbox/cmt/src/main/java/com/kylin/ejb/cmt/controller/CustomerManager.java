package com.kylin.ejb.cmt.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


import com.kylin.ejb.cmt.ejb.CustomerManagerEJB;
import com.kylin.ejb.cmt.model.Customer;

@Named("customerManager")
@RequestScoped
public class CustomerManager {
    private Logger logger = Logger.getLogger(CustomerManager.class.getName());

    @Inject
    private CustomerManagerEJB customerManager;

    public List<Customer> getCustomers() throws SecurityException, IllegalStateException, NamingException,
            NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        return customerManager.listCustomers();
    }

    public String addCustomer(String name) {
        try {
            customerManager.createCustomer(name);
            return "customerAdded";
        } catch (Exception e) {
            logger.warning("Caught a duplicate: " + e.getMessage());
            // Transaction will be marked rollback only anyway utx.rollback();
            return "customerDuplicate";
        }
    }
}
