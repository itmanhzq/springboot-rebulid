package com.fenlibao.pms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * @author Toby
 * @date 2018/11/29
 */
@Data
@Component
@ConfigurationProperties(prefix = "pms")
public class Config {
    @NotBlank
    private String[] permitUrls;
    @NotBlank
    private String[] swaggerUrls;
    @NotBlank
    private String[] securityUrls;
    @NotBlank
    private String[] excludeUri;
    @NotBlank
    private String jwtSecret;
    private int jwtExpirationInMs;

    @NotBlank
    private String marketing;


    private Config.Example example;

    private Config.Qiniu qiniu;

    private Config.Request request;

    private Config.MarketingService marketingService;

    @NotBlank
    private String origin;

    @Data
    public static class Request {
        private String salt;
    }

    @Data
    public static class Example {
        private String test;
    }

    @Data
    public static class Qiniu {
        private String qinniuAccessKey;
        private String qinniuSecretKey;
        private String bucket;
        private String url;
    }

    @Data
    public static class MarketingService {
        private String articleList;
        private String searchArticle;
        private String addArticle;
        private String updateArticle;
        private String stickTopArticle;
        private String deleteArticle;
        private String friendLinkList;
        private String searchFriendLink;
        private String addFriendLink;
        private String updateFriendLink;
        private String deleteFriendLink;
        private String postList;
        private String searchPost;
        private String addPost;
        private String updatePost;
        private String stickTopPost;
        private String deletePost;
    }
}
