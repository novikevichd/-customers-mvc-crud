package com.myproject.customercrud.dao;

import com.myproject.customercrud.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Customer> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Customer> theQuery =
                currentSession.createQuery("from Customer");

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    @Transactional
    public Customer findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Customer customer = currentSession.get(Customer.class, theId);

        return customer;
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery(
                        "delete from Customer where id=:employeeId");

        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();


    }
}
