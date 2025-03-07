package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> iterator = productRepository.findAll();
        assertTrue(iterator.hasNext());
        Product savedProduct = iterator.next();

        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllEmpty() {
        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product product_edited = new Product();
        product_edited.setProductId(product.getProductId());
        product_edited.setProductName("Sampo Cap Kasep");
        product_edited.setProductQuantity(150);
        productRepository.edit(product_edited);

        Product choosedProduct = productRepository.findById(product.getProductId());
        assertNotNull(choosedProduct);
        assertEquals("Sampo Cap Kasep", choosedProduct.getProductName());
        assertEquals(150, choosedProduct.getProductQuantity());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.delete(product);
        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEditNonExistentProduct() {
        Product product = new Product();
        product.setProductId("non-existent-id");
        product.setProductName("Non-Existent Product");
        product.setProductQuantity(10);

        Product result = productRepository.edit(product);

        assertNull(result);
    }

    @Test
    void testDeleteNonExistentProduct() {
        Product product = new Product();
        product.setProductId("non-existent-id");
        product.setProductName("Non-Existent Product");
        product.setProductQuantity(10);

        Product result = productRepository.delete(product);

        assertNull(result);
    }
}