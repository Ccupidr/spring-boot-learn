package cn.hrhr7.demo.services;

import cn.hrhr7.demo.jpa.testdb.Article;
import cn.hrhr7.demo.jpa.testdb.ArticleRepository;
import cn.hrhr7.demo.jpa.testdb2.Message;
import cn.hrhr7.demo.jpa.testdb2.MessageRepository;
import cn.hrhr7.demo.model.ArticleVO;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import cn.hrhr7.demo.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //事务生命，出现错误回滚
@Service(value = "ArticleRestServiceImp")
public class ArticleRestServiceImp implements ArticleRestService {

    @Resource(name = "articleRepository")
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);
        messageRepository.save(new Message(2,"whr","学spring boot"));
        int makeError = 2 / 0; // 制造错误，看数据库是否提交成功
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
