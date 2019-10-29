package cn.hrhr7.demo.services;


import cn.hrhr7.demo.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestService {


    public String saveArticle(Article article){

        log.info("Service save {}", article);
        return "service test";
    }

}
