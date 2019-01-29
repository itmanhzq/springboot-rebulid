package com.fenlibao.pms.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "url")
@PropertySource(value = "classpath:config/server-url.yml")
public class PropertiesConfig {

    @Autowired
    Environment env;

    public String getArticleList() {
        return env.getProperty("articleList");
    }

    public String getAddArticle() {
        return env.getProperty("addArticle");
    }

    public String getUpdateArticle() {
        return env.getProperty("updateArticle");
    }

    public String getStickTopArticle() {
        return env.getProperty("stickTopArticle");
    }

    public String getGetArticle() {
        return env.getProperty("getArticle");
    }

    public String getDeleteArticle() {
        return env.getProperty("deleteArticle");
    }

    public String getGetFriendLinkList() {
        return env.getProperty("getFriendLinkList");
    }

    public String getGetFriendLink() {
        return env.getProperty("getFriendLink");
    }

    public String getAddFriendLink() {
        return env.getProperty("addFriendLink");
    }

    public String getUpdateFriendLink() {
        return env.getProperty("updateFriendLink");
    }

    public String getDeleteFriendLink() {
        return env.getProperty("deleteFriendLink");
    }

    public String getGetPostList() {
        return env.getProperty("getPostList");
    }

    public String getGetPost() {
        return env.getProperty("getPost");
    }

    public String getAddPost() {
        return env.getProperty("addPost");
    }

    public String getUpdatePost() {
        return env.getProperty("updatePost");
    }

    public String getStickTopPost() {
        return env.getProperty("stickTopPost");
    }

    public String getDeletePost() {
        return env.getProperty("deletePost");
    }
}
