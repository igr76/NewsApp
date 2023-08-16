package com.igr76.news.mapper;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.UpdateFeedDto;
import com.igr76.news.entity.Feed;
import org.mapstruct.*;

import java.util.Collection;

/**
 * маппер для {@link Feed} готовый DTO {@link FeedDto}
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeedMapper {
    @Mapping(target = "name", source = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patch(@MappingTarget Feed target, UpdateFeedDto source);
    FeedDto toDto(Feed feed);
    Feed toEntity(FeedDto feedDto);
    Collection<FeedDto> toDTOList(Collection<Feed> feedCollection);
}
