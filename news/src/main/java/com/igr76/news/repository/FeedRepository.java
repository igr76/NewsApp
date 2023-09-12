package com.igr76.news.repository;

import com.igr76.news.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**   Репозиторий новостей           */
@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
    @Query(nativeQuery = true, value = "CREATE PROCEDURE String @string CHAR(20)" +
            "AS SELECT content FROM ads WHERE content LIKE '%@string%'")
    Collection<Feed> findNewsByString(String string);
}
