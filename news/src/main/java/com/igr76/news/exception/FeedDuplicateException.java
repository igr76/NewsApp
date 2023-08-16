package com.igr76.news.exception;

public class FeedDuplicateException extends RuntimeException{
    private final long id;

    public FeedDuplicateException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Новость с id ="+id +" уже существует";
    }
}
