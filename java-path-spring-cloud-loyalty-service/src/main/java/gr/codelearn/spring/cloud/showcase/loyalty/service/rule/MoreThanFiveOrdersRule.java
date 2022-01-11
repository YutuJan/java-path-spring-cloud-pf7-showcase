package gr.codelearn.spring.cloud.showcase.loyalty.service.rule;

import gr.codelearn.spring.cloud.showcase.core.transfer.resource.OrderResource;
import gr.codelearn.spring.cloud.showcase.loyalty.service.OrderReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoreThanFiveOrdersRule implements Rule<OrderResource> {
	private final OrderReportService orderReportService;

	@Override
	public Float getDiscountPercent() {
		return 0.1F;
	}

	@Override
	public boolean matches(OrderResource order) {
		Long orderCount = orderReportService.countByCustomer(order.getEmail());

		return orderCount > 5;
	}
}
