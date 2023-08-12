package com.igr76.news.dto;

import jakarta.validation.constraints.Size;

public class GreateFeedDto {
    @Size(min = 3, max = 100)
    private String name;
}
