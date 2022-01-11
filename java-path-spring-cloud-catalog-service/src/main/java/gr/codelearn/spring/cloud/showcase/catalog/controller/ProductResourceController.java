package gr.codelearn.spring.cloud.showcase.catalog.controller;

import gr.codelearn.spring.cloud.showcase.catalog.domain.Product;
import gr.codelearn.spring.cloud.showcase.catalog.mapper.ProductMapper;
import gr.codelearn.spring.cloud.showcase.catalog.service.ProductService;
import gr.codelearn.spring.cloud.showcase.core.base.BaseMapper;
import gr.codelearn.spring.cloud.showcase.core.controller.AbstractController;
import gr.codelearn.spring.cloud.showcase.core.service.BaseService;
import gr.codelearn.spring.cloud.showcase.core.transfer.ApiResponse;
import gr.codelearn.spring.cloud.showcase.core.transfer.resource.ProductResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResourceController extends AbstractController<Product, ProductResource> {
	private final ProductService productService;
	private final ProductMapper productMapper;

	@Override
	public BaseService<Product, Long> getBaseService() {
		return productService;
	}

	@Override
	protected BaseMapper<Product, ProductResource> getMapper() {
		return productMapper;
	}

	@GetMapping(params = {"serial"})
	public ResponseEntity<ApiResponse<Product>> findBySerial(@RequestParam(name = "serial") String serial) {
		return ResponseEntity.ok(ApiResponse.<Product>builder().data(productService.findBySerial(serial)).build());
	}
}
