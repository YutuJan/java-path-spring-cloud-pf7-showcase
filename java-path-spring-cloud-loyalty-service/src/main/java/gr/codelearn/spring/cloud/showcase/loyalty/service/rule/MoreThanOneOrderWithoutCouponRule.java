package gr.codelearn.spring.cloud.showcase.loyalty.service.rule;

import gr.codelearn.spring.cloud.showcase.core.transfer.resource.OrderResource;
import gr.codelearn.spring.cloud.showcase.loyalty.service.OrderReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoreThanOneOrderWithoutCouponRule implements Rule<OrderResource> {
	private final OrderReportService orderReportService;

	@Override
	public Float getDiscountPercent() {
		return 0.2F;
	}

	@Override
	public boolean matches(OrderResource order) {
		Long orderCount = orderReportService.countByCustomer(order.getEmail());
		Long orderWithCoupon = orderReportService.countByCouponCodeIsNotNullAndCustomer(order.getEmail());

		return orderCount > 1 && orderWithCoupon == 0;
	}

	@Override
	public Long getPriority() {
		return 100L;
	}
}
