package com.igr76.news.dto;

import com.igr76.news.entity.Category;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FeedDto {
    private Long id;
    public String name;
    private String content;
    private LocalDateTime data;
    private Category category;
}
