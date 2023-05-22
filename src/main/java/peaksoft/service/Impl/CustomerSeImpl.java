package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Customer;
import peaksoft.repository.CustomerRE;
import peaksoft.service.CustomerSe;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerSeImpl implements CustomerSe {

    private final CustomerRE customerRE;

    @Override
    public void saveCustomer(Customer customer) {
        customerRE.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRE.getAllCustomer();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRE.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        customerRE.updateCustomer(id, customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRE.deleteCustomerById(id);
    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {
        customerRE.assignCustomerToAgency(customerId, agencyId);
    }
}
