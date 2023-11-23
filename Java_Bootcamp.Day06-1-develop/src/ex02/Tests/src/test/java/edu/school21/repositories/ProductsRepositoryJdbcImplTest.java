package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImplTest {
    ProductsRepository productsRepository;
    EmbeddedDatabase dataSource;
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0L, "Product 1", 100),
            new Product(1L, "Product 2", 150),
            new Product(2L, "Product 3", 200),
            new Product(3L, "Product 4", 50),
            new Product(4L, "Product 5", 300),
            new Product(5L, "Product 6", 120),
            new Product(6L, "Product 7", 180)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(4L, "Product 5", 300);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(2L, "Product 22", 4500);
    final Product EXPECTED_SAVED_PRODUCT = new Product(7L, "Product 8", 111);

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }
    @Test
    void testFindAll()  {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }
    @Test
    void testFindById() {
        Optional<Product> foundProduct = productsRepository.findById(4L);
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, foundProduct.get());
    }
    @Test
    void testUpdate() {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Optional<Product> foundProduct = productsRepository.findById(2L);
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(foundProduct.get(), EXPECTED_UPDATED_PRODUCT);
    }
    @Test
    void testSave() {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Optional<Product> foundProduct = productsRepository.findById(7L);
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(foundProduct.get(), EXPECTED_SAVED_PRODUCT);
    }

    @Test
    void testDelete() {
        Assertions.assertThrows(RuntimeException.class, () -> productsRepository.delete(44L));
        Assertions.assertFalse(productsRepository.findById(44L).isPresent());
        productsRepository.delete(3L);
        Assertions.assertFalse(productsRepository.findById(3L).isPresent());
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }
}
