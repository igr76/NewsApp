package com.igr76.news.service.impl;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.GreateFeedDto;
import com.igr76.news.dto.UpdateFeedDto;
import com.igr76.news.entity.Category;
import com.igr76.news.entity.Feed;
import com.igr76.news.exception.FeedDuplicateException;
import com.igr76.news.exception.FeedNotFoundException;
import com.igr76.news.mapper.FeedMapper;
import com.igr76.news.repository.FeedRepository;
import com.igr76.news.service.FeedService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Реализация {@link FeedService}
 */
@Service
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;
    private final FeedMapper feedMapper;

    public FeedServiceImpl(FeedRepository feedRepository, FeedMapper feedMapper) {
        this.feedRepository = feedRepository;
        this.feedMapper = feedMapper;
    }

    @Override
    public Collection<FeedDto> getAllFeed() {
        Collection<Feed> feedCollection = feedRepository.findAll();
        return feedMapper.toDTOList(feedCollection);
    }

    @Override
    public FeedDto getFeedById(Long id) {
        Feed feedId = feedRepository.findById(id).orElseThrow(() -> new FeedNotFoundException(id));
        return feedMapper.toDto(feedId);
    }

    @Override
    public Collection<FeedDto> findNewsByCategory(Category category) {
     //   Collection<Feed> feedCollection = feedRepository.findBy;
        return null;
    }

    @Override
    public Collection<FeedDto> findNewsByString(String like) {
        return null;
    }

    @Override
    public FeedDto path(Long id, UpdateFeedDto updateFeedDto) {
        Feed feed=feedRepository.findById(id).orElseThrow(() -> new FeedNotFoundException(id));
        feedMapper.patch(feed,updateFeedDto);
        return feedMapper.toDto(feedRepository.save(feed));
    }

    @Override
    public void addFeed(GreateFeedDto greateFeedDto) {
        Feed feed = new Feed();
        feed.setId(feedRepository.count() +1l);
        feed.setName(greateFeedDto.getName());
        feedRepository.save(feed);    }

    @Override
    public void deleteFeed(Long id) {
        if (!feedRepository.existsById(id)) {new FeedDuplicateException(id);        }
        Feed feed = feedRepository.findById(id).orElseThrow();
        feedRepository.delete(feed);}
}
