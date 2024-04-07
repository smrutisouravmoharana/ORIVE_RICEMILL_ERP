package com.orive.ProductCategory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orive.ProductCategory.Entity.CategoryDetails;


public interface CategoryRepository extends JpaRepository<CategoryDetails, Long>{

	@Query("SELECT s FROM CategoryDetails s WHERE s.categoryName = :categoryName")
    List<CategoryDetails> findByCategoryName(@Param("categoryName") String categoryName);
}
