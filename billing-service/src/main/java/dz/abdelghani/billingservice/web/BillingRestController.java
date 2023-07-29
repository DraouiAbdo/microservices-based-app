package dz.abdelghani.billingservice.web;

import dz.abdelghani.billingservice.entities.Bill;
import dz.abdelghani.billingservice.feign.CustomerRestClient;
import dz.abdelghani.billingservice.feign.ProductRestClient;
import dz.abdelghani.billingservice.model.Product;
import dz.abdelghani.billingservice.repositories.BillRepository;
import dz.abdelghani.billingservice.repositories.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillingRestController(BillRepository billRepository,
                                 ProductItemRepository productItemRepository,
                                 CustomerRestClient customerRestClient,
                                 ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }
    @GetMapping(path="/fullBill/{id}")
    public Bill getBill(@PathVariable(name="id") Long id){
        Bill bill =  billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        PagedModel<Product> products = productRestClient.productsPage();
        bill.getProductItems().forEach(pi->{
            Product p = productRestClient.getProductById(pi.getProductId());
            //pi.setProduct(p);
            pi.setProductName(p.getName());
        });
        return bill;
    }
}
