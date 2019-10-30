package cn.hrhr7.demo.services;

import cn.hrhr7.demo.dao.Article;
import cn.hrhr7.demo.dao.ArticleRepository;
import cn.hrhr7.demo.model.ArticleVO;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import cn.hrhr7.demo.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

@Service(value = "ArticleRestServiceImp")
public class ArticleRestServiceImp implements ArticleRestService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);
        return article;
    }

    @Override
    public void deleteArticle(Integer id) {

        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getArticle(Integer id) {
        Optional<Article> article = articleRepository.findById(id);  //根据id查找一条数据
        return dozerMapper.map(article.get(),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articleLis = articleRepository.findAll();  //查询article表的所有数据
        return DozerUtils.mapList(articleLis,ArticleVO.class);
    }
}
