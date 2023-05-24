package peaksoft.service;

import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerSe {
    void saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long id);
    void updateCustomer(Long id, Customer customer);
    void deleteCustomerById(Long id);
    void assignCustomerToAgency(Long customerId,List<Long> agencyId);
}
