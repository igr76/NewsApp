package com.igr76.news.controller;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.UpdateFeedDto;
import com.igr76.news.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
//@Tag()
public class FeedController {
    private final FeedService feedService;
    @Operation(summary = "...",
    description = "....",
    responses = {
            @ApiResponse(responseCode = "200", description = ".."),
            @ApiResponse(responseCode = "404", description = ".."),
            @ApiResponse(responseCode = "400", description = "..")
    })
@PatchMapping("/{id}")
    public FeedDto pathFeed(@PathVariable("id") int id, @RequestBody @Valid UpdateFeedDto updateFeedDto) {
    return feedService.path(id, updateFeedDto);
    }
}
