package peaksoft.repository;

import peaksoft.entity.Agency;
import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerRE {
    void saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long id);
    void updateCustomer(Long id, Customer customer);
    void deleteCustomerById(Long id);
    void assignCustomerToAgency(Long customerId,Long agencyId);
}
