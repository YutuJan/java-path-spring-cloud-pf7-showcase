package gr.codelearn.spring.cloud.showcase.customer.bootstrap;

import gr.codelearn.spring.cloud.showcase.core.base.AbstractLogComponent;
import gr.codelearn.spring.cloud.showcase.core.domain.CustomerCategory;
import gr.codelearn.spring.cloud.showcase.customer.domain.Customer;
import gr.codelearn.spring.cloud.showcase.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("customer-sample-generator")
@Component
@RequiredArgsConstructor
public class CustomerSampleGenerator extends AbstractLogComponent implements CommandLineRunner {
	private final CustomerService customerService;

	@Override
	public void run(String... args) {
		//@formatter:off
		try{
			List<Customer> customers = List.of(
				Customer.builder().email("john.porter@gmail.com")
						.firstname("John").lastname("Porter")
						.address("2955 Blackwell Street")
						.customerCategory(CustomerCategory.BUSINESS).age(40).build(),
				Customer.builder().email("malcolm.paker@gmail.com")
						.firstname("Malcolm").lastname("Parker")
						.address("4071 Kelly Drive")
						.customerCategory(CustomerCategory.GOVERNMENT).age(32).build(),
				Customer.builder().email("terry.jones@gmail.com")
						.firstname("Terry").lastname("Jones")
						.address("3849 Hinkle Lake Road")
						.customerCategory(CustomerCategory.BUSINESS).age(57).build(),
				Customer.builder().email("peter.mercury@outlook.com")
						.firstname("Peter").lastname("Mercury")
						.address("Freddie Street 28th")
						.customerCategory(CustomerCategory.INDIVIDUAL).age(32).build());

			logger.debug("Saving some customers");
			customerService.saveAll(customers);
		} catch (DataIntegrityViolationException dive) {
			logger.warn("Unable to persist sample customer list as they probably already exist!");
		} catch (DataAccessException dae) {
			logger.error("Error occurred while interacting with underlying database, see the details", dae);
		}
		//@formatter:on
	}
}
