
package com.shortify.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    @Column(nullable = false, unique = true)
    private String shortCode;

    private long clickCount;

    public Url(String originalUrl, String shortCode, int clickCount) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.clickCount = clickCount;
    }
    // docker hub test text
    public void setClickCount(Long count){
        clickCount = count;
    }

    public void setOriginalUrl(String url){
        originalUrl = url;
    }

    public Long getClickCount(){
        return clickCount;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}

