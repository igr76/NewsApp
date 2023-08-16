package com.igr76.news.service;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.GreateFeedDto;
import com.igr76.news.dto.UpdateFeedDto;
import com.igr76.news.entity.Feed;
import com.igr76.news.mapper.FeedMapper;
import com.igr76.news.repository.FeedRepository;
import com.igr76.news.service.impl.FeedServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FeedServiceTest {
    @InjectMocks
    private FeedServiceImpl feedService;
    @Mock
    private FeedRepository feedRepository;
    @Mock
    private FeedMapper feedMapper;
    Feed feed;

    @BeforeEach
     void init() {
        Feed feed1 = new Feed(1l,"one","string",
                LocalDateTime.of(2023, 02, 20, 14, 20, 10),null);
        FeedDto feedDto = new FeedDto(1l,"one","string",
                LocalDateTime.of(2023, 02, 20, 14, 20, 10),null);
        GreateFeedDto greateFeedDto = new GreateFeedDto(1l,"one","string",
                LocalDateTime.of(2023, 02, 20, 14, 20, 10),null);
        UpdateFeedDto updateFeedDto = new UpdateFeedDto(1l,"one","string",
                LocalDateTime.of(2023, 02, 20, 14, 20, 10),null);

    }
    @Test
    void getAllFeedTest() {
        Collection<Feed> feedCollection = new ArrayList<>();
        feedCollection.add(getFeed());
        Collection<FeedDto> feedDtoCollection = new ArrayList<>();
        feedDtoCollection.add(getFeedDto());
        when(feedRepository.findAll()).thenReturn((List<Feed>) feedCollection);
        when(feedMapper.toDto(any())).thenReturn((FeedDto) feedDtoCollection);
        assertThat(feedService.getAllFeed()).isEqualTo(feedDtoCollection);
        verify(feedRepository, times(1)).findAll();
    }
    @Test
    void deleteFeedTest() {
        when(feedRepository.existsById(any())).thenReturn(true);
        when(feedRepository.findById(any())).thenReturn(Optional.of(getFeed()));
        doNothing().when(feedService).deleteFeed(any());
        verify(feedRepository, times(1)).findById(any());
    }
    private Feed getFeed() {
        Feed feed1 = new Feed(1l,"one","string",
                LocalDateTime.of(2023, 02, 20, 14, 20, 10),null);
        return feed1;
    }

    private FeedDto getFeedDto() {
        FeedDto feedDto = new FeedDto(1l,"one","string",
                LocalDateTime.of(2023, 02, 20, 14, 20, 10),null);
        return feedDto;
    }

}
