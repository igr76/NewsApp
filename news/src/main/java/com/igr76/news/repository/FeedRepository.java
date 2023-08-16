package com.igr76.news.repository;

import com.igr76.news.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**   Репозиторий новостей           */
@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
}
