package com.igr76.news.exception;

public class FeedNotFoundException extends RuntimeException{
    private final long id;

    public FeedNotFoundException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Новость с id ="+id +" не найдена";
    }
}
