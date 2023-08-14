package com.igr76.news.service.impl;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.UpdateFeedDto;
import com.igr76.news.entity.Feed;
import com.igr76.news.exception.FeedNotFoundException;
import com.igr76.news.mapper.FeedMapper;
import com.igr76.news.repository.FeedRepository;
import com.igr76.news.service.FeedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;
    private final FeedMapper feedMapper;
    @Override
    public FeedDto path(int id, UpdateFeedDto updateFeedDto) {
        Feed feed=feedRepository.findById(id).orElseThrow(() -> new FeedNotFoundException(id));
        feedMapper.patch(feed,updateFeedDto);
        return feedMapper.toDto(feedRepository.save(feed));
    }
}
