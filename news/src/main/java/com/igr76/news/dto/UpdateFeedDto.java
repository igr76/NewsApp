package com.igr76.news.dto;

import jakarta.validation.constraints.Size;

public class UpdateFeedDto {
    @Size(min = 3, max = 100)
    private String name;
}
