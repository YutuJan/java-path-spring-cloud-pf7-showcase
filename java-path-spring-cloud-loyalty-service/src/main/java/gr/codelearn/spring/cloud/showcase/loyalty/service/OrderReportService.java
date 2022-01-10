package gr.codelearn.spring.cloud.showcase.loyalty.service;

import gr.codelearn.spring.cloud.showcase.core.transfer.KeyValue;

import java.math.BigDecimal;
import java.util.List;

public interface OrderReportService {
	List<KeyValue<String, Integer>> findProductSaleFrequency();

	List<KeyValue<String, BigDecimal>> findCustomersPurchasedMostExpensiveProduct();

	List<KeyValue<String, BigDecimal>> findAverageOrderCostPerCustomer();

	Long countByCustomer(String email);

	Long countByCouponCodeIsNotNullAndCustomer(String email);
}
