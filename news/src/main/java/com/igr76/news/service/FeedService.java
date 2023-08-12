package com.igr76.news.service;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.UpdateFeedDto;

public interface FeedService {
    FeedDto path(Long id, UpdateFeedDto updateFeedDto);
}
