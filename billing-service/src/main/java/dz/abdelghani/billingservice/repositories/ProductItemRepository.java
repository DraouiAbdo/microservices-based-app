package dz.abdelghani.billingservice.repositories;

import dz.abdelghani.billingservice.entities.Bill;
import dz.abdelghani.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
