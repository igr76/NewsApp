package com.igr76.news.repository;

import com.igr76.news.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
/**   Репозиторий категорий          */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
