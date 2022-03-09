package com.project.package1.CustomerTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.package1.entity.Customer;
import com.project.package1.exception.CustomerNotFoundException;
import com.project.package1.model.CustomerModel;
import com.project.package1.repository.CustomerRepository;
import com.project.package1.service.CustomerService;
import com.project.package1.service.CustomerServiceImpl;
import com.project.package1.util.Conversion;

@SpringBootTest
public class CustomerServiceTest {

	
	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();
	
	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private Conversion conversion;
	
	@Test
    void testSaveCustomer() {
       
		CustomerModel customerModel = new CustomerModel();

		customerModel.setCustomerId(333);
		customerModel.setCustomerName("Jay Awdhut");
		customerModel.setEmail("ajayawdhut@gmail.com");
		customerModel.setDob(LocalDate.of(1996, 11, 29));
		customerModel.setGender('M');
		customerModel.setAddress("Ner Parsopant , District - Yavatmal");
		customerModel.setAge(24);
		customerModel.setMobileNo("8208104586");
		
        Customer customer = new Customer();
		
        customer.setAddress(customerModel.getAddress());
        customer.setAge(customerModel.getAge());
        customer.setCustomerId(customerModel.getCustomerId());
        customer.setCustomerName(customerModel.getCustomerName());
        customer.setDob(customerModel.getDob());
        customer.setEmail(customerModel.getEmail());
        customer.setGender(customerModel.getGender());
        customer.setGovtId(customerModel.getGovtId());
        customer.setMobileNo(customerModel.getMobileNo());
        
        when(conversion.modelToEntity(customerModel)).thenReturn(customer);
		
		when(conversion.entityToModel(customer)).thenReturn(customerModel);
		
     	when(customerRepository.save(customer)).thenReturn(customer);		
    	
     	customerModel = customerService.saveCustomer(customerModel);	
     	
     	verify(customerRepository,times(1)).save(customer);      
       
    }
	
	@Test
    void testGetCustomerByIdNotFound() {
       
        int customerId = 1011;       
           
        when(customerRepository.findById(customerId)).thenThrow(CustomerNotFoundException.class);
           
        assertThrows(CustomerNotFoundException.class,()->customerService.getCustomerById(customerId));
       
    }
	
	@Test
    public void testUpdatePost() {

		CustomerModel customerModel = new CustomerModel();

		customerModel.setCustomerId(333);
		customerModel.setCustomerName("Jay Awdhut");
		customerModel.setEmail("ajayawdhut@gmail.com");
		customerModel.setDob(LocalDate.of(1996, 11, 29));
		customerModel.setGender('M');
		customerModel.setAddress("Ner Parsopant , District - Yavatmal");
		customerModel.setAge(24);
		customerModel.setMobileNo("8208104586");
		
        Customer customer = new Customer();

        customer.setCustomerId(333);
        customer.setCustomerName("Jay Awdhut");
        customer.setEmail("ajayawdhut@gmail.com");
        customer.setDob(LocalDate.of(1996, 11, 29));
		customer.setGender('M');
		customer.setAddress("Ner Parsopant , District - Yavatmal");
		customer.setAge(24);
		customer.setMobileNo("8208104586");
		
          Optional<Customer> optionalCustomer = Optional.of(customer);

          when(customerRepository.findById(333)).thenReturn(optionalCustomer);

          Customer updatedCustomerEntity = customerRepository.save(customer);
 
          conversion.entityToModel(updatedCustomerEntity);
          
          customerService.updateCustomerProfile(conversion.entityToModel(customer));

          verify(customerRepository, times(1)).save(customer);
    }

}	
	
