package com.demo.repo;

import com.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo
        extends JpaRepository<Product,Integer>{
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
//    List<Product> findByPrice(double minPrice, double maxPrice);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
//    Page<Product> findByKeywords(String keywords, Pageable pageable);
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);
    @Query("SELECT o FROM Product o WHERE o.category.id=?1 and o.name like ?2 and o.price between ?3 and ?4")
    Page<Product> searchAllByCategoryNamePrice(String cid,String keyword,int min, int max, Pageable pageable);
    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1 and o.price between ?2 and ?3")
    Page<Product> searchByNamePrice(String keywords, int min,int max,Pageable pageable);

}
