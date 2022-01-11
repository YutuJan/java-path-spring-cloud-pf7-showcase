package gr.codelearn.spring.cloud.showcase.order.service;

import gr.codelearn.spring.cloud.showcase.core.transfer.resource.CouponResource;
import gr.codelearn.spring.cloud.showcase.order.domain.Order;

import java.util.Optional;

public interface LoyaltyService {
	Optional<CouponResource> apply(Order order);

	void declare(CouponResource coupon);
}
