package com.igr76.news.controller;

import com.igr76.news.dto.FeedDto;
import com.igr76.news.dto.GreateFeedDto;
import com.igr76.news.dto.UpdateFeedDto;
import com.igr76.news.entity.Category;
import com.igr76.news.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**   Контроллер новостей           */
@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
//@Tag()
public class FeedController {
    private  FeedService feedService;


    @Operation(summary = "Получить все новости")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = FeedDto.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found"
            )
    })
@GetMapping("/all")
    public ResponseEntity<Collection<FeedDto>> getAll() {
        return ResponseEntity.ok(feedService.getAllFeed());
    }
    @Operation(summary = "Получить новость по номеру")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = FeedDto.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found"
            )
    })
 @GetMapping("/{id}")
    public ResponseEntity<FeedDto> getFeedById(@PathVariable(name = "id")
                                                @NotBlank(message = "id не должен быть пустым")
                                                @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                @Parameter(description = "Идентификатор новости",
                                                        example = "1") Long id) {
        return ResponseEntity.ok(feedService.getFeedById(id));
    }
    @Operation(summary = "Получить новости по категории")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = FeedDto.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found"
            )
    })
    @GetMapping("/categories")
    public ResponseEntity<Collection<FeedDto>> getAllByCategories(@RequestBody @Valid Category category) {
        return ResponseEntity.ok(feedService.findNewsByCategory(category));
    }
    @Operation(summary = "Получить новость по фрагменту")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = FeedDto.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found"
            )
    })
    @GetMapping("/{string}")
    public ResponseEntity<Collection<FeedDto>> getAllByString(@PathVariable(name = "string")
                                                                  @NotBlank(message = "строка не должна быть пустой")
                                                                  @Parameter(description = "фраза поиска новости",
                                                                          example = "строка") String string) {
        return ResponseEntity.ok(feedService.findNewsByString(string));
    }
    @Operation(summary = "Обновить новость")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    schema = @Schema(ref = "#/components/schemas/AdsDTO"))
                    }
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found"
            )
    })
@PatchMapping("/{id}")
    public FeedDto pathFeed(@PathVariable("id") Long id, @RequestBody @Valid UpdateFeedDto updateFeedDto) {
    return feedService.path(id, updateFeedDto);
    }
    @Operation(summary = "Добавить новость")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = FeedDto.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {@Content(array = @ArraySchema(schema = @Schema()))}
            )
    })
    @PostMapping
     public void addFeed(@RequestBody @Valid GreateFeedDto greateFeedDto) {
    feedService.addFeed(greateFeedDto);
    }

    @Operation(summary = "Удалить новость")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = FeedDto.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found"
            )
    })
    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable(name = "id")
                           @NotBlank(message = "id не должен быть пустым")
                           @Min(value = 1, message = "Идентификатор должен быть больше 0")
                           @Parameter(description = "Идентификатор новости",
                                   example = "1") Long id) {
    feedService.deleteFeed(id);
    }

}
