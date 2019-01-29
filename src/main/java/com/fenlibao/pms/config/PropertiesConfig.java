package com.fenlibao.pms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource(value = "classpath:config/server-url.properties")
public class PropertiesConfig {

    @Autowired
    Environment env;

    private String articleList;

    public String getArticleList() {
        return env.getProperty("marketing.articleList");
    }

    public void setArticleList(String articleList) {
        this.articleList = articleList;
    }
}
