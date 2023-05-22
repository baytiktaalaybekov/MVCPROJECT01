package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRE;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerReImpl implements CustomerRE {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return entityManager.createQuery("from Customer c",Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Customer customer1 = entityManager.find(Customer.class, id);
        customer1.setName(customer.getName());
        customer1.setSurname(customer.getSurname());
        customer1.setEmail(customer.getEmail());
        customer1.setGender(customer.getGender());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setDate_of_birth(customer.getDate_of_birth());
        entityManager.merge(customer1);
    }

    @Override
    public void deleteCustomerById(Long id) {
        entityManager.remove(entityManager.find(Customer.class,id));
    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Agency agency = entityManager.find(Agency.class, agencyId);
        customer.getAgencies().add(agency);
        agency.getCustomers().add(customer);
        entityManager.persist(customer);
    }
}
