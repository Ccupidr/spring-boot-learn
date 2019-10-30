package cn.hrhr7.demo.services;

import cn.hrhr7.demo.dao.ArticleJDBCDAO;
import cn.hrhr7.demo.model.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component("ArticleRestServiceImp")
@Service
public class ArticleRestServiceImp implements ArticleRestService {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Override
    public Article saveArticle(Article article) {
        articleJDBCDAO.saveArticle(article);
        return article;
    }

    @Override
    public void deleteArticle(int id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article);
    }

    @Override
    public Article getArticle(int id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
