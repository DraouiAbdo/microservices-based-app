package dz.abdelghani.billingservice.feign;

import dz.abdelghani.billingservice.model.Customer;
import dz.abdelghani.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping(path="/products")
//    PagedModel<Product> productsPage(@RequestParam(name="page") int page,
//                                     @RequestParam(name="page") int size);
    PagedModel<Product> productsPage();
    @GetMapping(path="/products/{id}")
    Product getProductById(@PathVariable(name="id") Long id);
}
