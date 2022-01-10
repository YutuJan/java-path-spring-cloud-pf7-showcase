package gr.codelearn.spring.cloud.showcase.loyalty.service;

import gr.codelearn.spring.cloud.showcase.core.transfer.KeyValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderReportServiceImpl implements OrderReportService {
	@Override
	public List<KeyValue<String, Integer>> findProductSaleFrequency() {
		return Collections.emptyList();
	}

	@Override
	public List<KeyValue<String, BigDecimal>> findCustomersPurchasedMostExpensiveProduct() {
		return Collections.emptyList();
	}

	@Override
	public List<KeyValue<String, BigDecimal>> findAverageOrderCostPerCustomer() {
		return Collections.emptyList();
	}

	@Override
	public Long countByCustomer(final String email) {
		return 0L;
	}

	@Override
	public Long countByCouponCodeIsNotNullAndCustomer(final String email) {
		return 0L;
	}
}
