package com.igr76.news.dto;

import com.igr76.news.entity.Category;
import lombok.*;

import java.time.LocalDateTime;
/**
 * A DTO for the {@link com.igr76.news.entity.Feed} entity
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FeedDto {
    /**    Идентификатор новости     */
    private Long id;
    /**    Заголовок новости     */
    public String name;
    /**    Содержание новости     */
    private String content;
    /**    Дата новости     */
    private LocalDateTime data;
    /**    Категория новости     */
    private Category category;
}
