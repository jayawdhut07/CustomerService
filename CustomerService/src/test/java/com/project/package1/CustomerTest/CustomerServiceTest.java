package com.project.package1.CustomerTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.package1.entity.Customer;
import com.project.package1.exception.CustomerNotFoundException;
import com.project.package1.repository.CustomerRepository;
import com.project.package1.service.CustomerService;
import com.project.package1.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {

	
	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();
	
	@Mock
	private CustomerRepository customerRepository;

	
	@Test
    public void testSaveCustomer() {
       
		Customer customer = new Customer();
		customer.setCustomerId(333);
		customer.setCustomerName("Jay Awdhut");
		customer.setEmail("ajayawdhut@gmail.com");
		customer.setDob(LocalDate.of(1996, 11, 29));
		customer.setGender('M');
		customer.setAddress("Ner Parsopant , District - Yavatmal");
		customer.setAge(24);
		customer.setMobileNo("8208104586");
       
        when(customerRepository.save(customer)).thenReturn(customer);
       
        Customer newCustomer = customerService.saveCustomer(customer);
       
        //assertEquals(customer.customerName(), newCustomer.customerName());
       
        verify(customerRepository,times(1)).save(customer);       
       
    }
	
	@Test
    public void testGetCustomerByIdNotFound() {
       
        int customerId = 1011;       
           
        when(customerRepository.findById(customerId)).thenThrow(CustomerNotFoundException.class);
           
        assertThrows(CustomerNotFoundException.class,()->customerService.getCustomerById(customerId));
       
    }
}	
	
