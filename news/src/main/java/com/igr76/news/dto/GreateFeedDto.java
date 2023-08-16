package com.igr76.news.dto;

import com.igr76.news.entity.Category;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

/**
 * A greateDTO for the {@link com.igr76.news.entity.Feed} entity
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GreateFeedDto {
    /**    Идентификатор новости     */
    private Long id;
    /**    Заголовок новости     */
    @Size(min = 3, max = 100)
    public String name;
    /**    Содержание новости     */
    private String content;
    /**    Дата новости     */
    private LocalDateTime data;
    /**    Категория новости     */
    private Category category;
}
