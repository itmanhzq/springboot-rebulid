package com.fenlibao.pms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * @author chen
 * @date 2018/11/29
 */
@Data
@Component
@ConfigurationProperties(prefix = "serverUrl")
public class ServiceUrlConfig {

    @Data
    public static class MarketingService {
        //文章列表
        private String articleList;
        //查询文章
        private String searchArticle;
        //新增文章
        private String addArticle;
        //更新文章
        private String updateArticle;
        //置顶文章
        private String stickTopArticle;
        //删除文章
        private String deleteArticle;
    }
}
