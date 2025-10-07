package com.shortify.service;

import com.shortify.dto.UrlRequest;
import com.shortify.dto.UrlResponse;
import com.shortify.entity.Url;
import com.shortify.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private static final String BASE_URL = "http://localhost:8080/s/";

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public UrlResponse shortenUrl(UrlRequest request) {
        String shortCode = generateShortCode();
        Url entity = new Url(request.getOriginalUrl(), shortCode, 0);


        urlRepository.save(entity);
        return new UrlResponse(BASE_URL + shortCode);
    }

    public String getOriginalUrl(String code) {
        Url entity = urlRepository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        entity.setClickCount(entity.getClickCount() + 1);
        urlRepository.save(entity);
        return entity.getOriginalUrl();
    }

    private String generateShortCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(r.nextInt(chars.length())));
        }
        return code.toString();
    }
}
