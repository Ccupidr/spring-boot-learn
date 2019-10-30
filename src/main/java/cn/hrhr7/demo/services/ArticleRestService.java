package cn.hrhr7.demo.services;

import cn.hrhr7.demo.model.ArticleVO;

import java.util.List;

public interface ArticleRestService {
    ArticleVO saveArticle(ArticleVO article);

    void deleteArticle(Integer id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Integer id);

    List<ArticleVO> getAll();
}
