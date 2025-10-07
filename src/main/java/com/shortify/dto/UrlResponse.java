package com.shortify.dto;
import lombok.Data;

@Data
public class UrlResponse {
    private String shortUrl;

    public UrlResponse(String shortUrl){
        this.shortUrl = shortUrl;
    }

    public String getShortUrl(){
        return shortUrl;
    }
}
