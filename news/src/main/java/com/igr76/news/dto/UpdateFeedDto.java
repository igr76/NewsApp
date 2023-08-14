package com.igr76.news.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UpdateFeedDto {
    @Size(min = 3, max = 100)
    private String name;
}
