package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product)  {
        productData.add(product);
        return product;
    }
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product delete(Product product) {
        boolean isRemoved = productData.remove(product);
        return isRemoved ? product : null;
    }

    public Product edit(Product updatedProduct) {
        for (Product product : productData) {
            product.setProductId(updatedProduct.getProductId());
            product.setProductName(updatedProduct.getProductName());
            product.setProductQuantity(updatedProduct.getProductQuantity());
        }
        return null;
    }
}