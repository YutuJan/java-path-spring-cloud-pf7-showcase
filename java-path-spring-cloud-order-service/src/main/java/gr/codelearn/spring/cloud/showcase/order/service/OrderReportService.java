package gr.codelearn.spring.cloud.showcase.order.service;

import gr.codelearn.spring.cloud.showcase.core.transfer.KeyValue;
import gr.codelearn.spring.cloud.showcase.order.transfer.PurchasesPerCustomerCategoryDto;

import java.math.BigDecimal;
import java.util.List;

public interface OrderReportService {
	List<KeyValue<String, Integer>> findProductSaleFrequency();

	List<KeyValue<String, BigDecimal>> findCustomersPurchasedMostExpensiveProduct();

	List<PurchasesPerCustomerCategoryDto> findTotalNumberAndCostOfPurchasesPerCustomerCategory();

	List<KeyValue<String, BigDecimal>> findAverageOrderCostPerCustomer();

	Long countByCustomer(String email);

	Long countByCouponCodeIsNotNullAndCustomer(String email);
}
