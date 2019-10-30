package cn.hrhr7.demo.services;


import cn.hrhr7.demo.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ArticleRestService {

    public Article saveArticle(Article article);

    public void deleteArticle(int id);

    public void updateArticle(Article article);

    public Article getArticle(int id);

    public List<Article> getAll();
}

