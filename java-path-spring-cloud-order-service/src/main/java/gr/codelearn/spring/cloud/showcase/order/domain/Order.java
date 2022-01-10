package gr.codelearn.spring.cloud.showcase.order.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import gr.codelearn.spring.cloud.showcase.core.domain.BaseModel;
import gr.codelearn.spring.cloud.showcase.core.domain.PaymentMethod;
import gr.codelearn.spring.cloud.showcase.core.transfer.KeyValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Delegate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@formatter:off
@NamedNativeQuery(name = "Order.mostExpensiveProductPurchases",
		query =	"SELECT C.FIRSTNAME || ' ' || C.LASTNAME as fullname, COUNT(*) as purchases " +
				"FROM ORDERS O, ORDER_ITEMS OI, CUSTOMERS C " +
				"WHERE OI.ORDER_ID = O.ID " +
				"AND O.CUSTOMER_ID = C.ID " +
				"AND OI.PRODUCT_ID = (SELECT TOP 1 ID FROM PRODUCTS ORDER BY PRICE DESC) " +
				"GROUP BY O.CUSTOMER_ID " +
				"ORDER BY purchases, c.lastname, c.firstname",
		resultSetMapping = "customerMostExpensiveProductPurchases")
@SqlResultSetMappings({
		@SqlResultSetMapping(name="customerMostExpensiveProductPurchases",
				classes = @ConstructorResult(
						targetClass = KeyValue.class,
						columns = {
								@ColumnResult(name="fullname", type = String.class),
								@ColumnResult(name="purchases", type = BigDecimal.class)
						}
				)
		)
})

//@formatter:on

@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseModel {
	private interface MyDelegate {
		boolean add(OrderItem orderItem);

		boolean remove(OrderItem orderItem);
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customer;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date submitDate;

	@JsonManagedReference("orderItems")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Delegate(types = MyDelegate.class)
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private final Set<OrderItem> orderItems = new HashSet<>();

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private PaymentMethod paymentMethod;

	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal cost;

	@Column(length = 36)
	private String couponCode;
}
