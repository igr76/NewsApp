package com.igr76.news.service;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.UpdateFeedDto;
import com.igr76.news.entity.Category;

import java.util.Collection;

public interface FeedService {

    /**     Получить список новостей     */
    Collection<FeedDto> getAllFeed();
    /**   Показать новость     */
    FeedDto getFeedById(Long id);
    /**     Наути новость по категории     */
    Collection<FeedDto> findNewsByCategory(Category category);
    /**     Найти новость по фразе    */
    Collection<FeedDto> findNewsByLike(String like);

    /**     * Обновляет новость     */
    FeedDto path(Long id, UpdateFeedDto updateFeedDto);
    /**     * Добавляем новость     */
    void addFeed(FeedDto feedDto) ;

    /**     * Удаляет новость     */
    void deleteFeed(int id);
}
