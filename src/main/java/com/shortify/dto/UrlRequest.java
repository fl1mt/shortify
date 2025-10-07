package com.shortify.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UrlRequest {
    @NotBlank
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }
}
