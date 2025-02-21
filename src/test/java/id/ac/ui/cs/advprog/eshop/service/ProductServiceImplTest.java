package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.create(product1)).thenReturn(product1);

        Product createdProduct = productService.create(product1);

        assertNotNull(createdProduct);
        assertEquals("Sampo Cap Bambang", createdProduct.getProductName());
        assertEquals(100, createdProduct.getProductQuantity());

        verify(productRepository, times(1)).create(product1);
    }

    @Test
    void testFindAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        Iterator<Product> productIterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(productIterator);

        List<Product> retrievedProducts = productService.findAll();

        assertNotNull(retrievedProducts);
        assertEquals(2, retrievedProducts.size());
        assertEquals("Sampo Cap Bambang", retrievedProducts.get(0).getProductName());
        assertEquals("Sampo Cap Usep", retrievedProducts.get(1).getProductName());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindAllWhenEmpty() {
        Iterator<Product> emptyIterator = new ArrayList<Product>().iterator();
        when(productRepository.findAll()).thenReturn(emptyIterator);

        List<Product> retrievedProducts = productService.findAll();

        assertNotNull(retrievedProducts);
        assertTrue(retrievedProducts.isEmpty());

        verify(productRepository, times(1)).findAll();
    }
}