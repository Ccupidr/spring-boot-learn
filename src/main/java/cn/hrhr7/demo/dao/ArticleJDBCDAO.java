package cn.hrhr7.demo.dao;

import cn.hrhr7.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    // 保存文章
    public void saveArticle(Article article){
        jdbcTemplate.update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    //删除文章
    public void deleteById(int id){
        jdbcTemplate.update("delete from article where id = ?", new Object[]{id});
    }

    //更新文章
    public void updateById(Article article){
        jdbcTemplate.update("update article set author = ?, title = ?, content = ?, create_time = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getCreateTime(),
                article.getId());
    }

    //查找文章
    public Article findById(int id) {
        //queryForObject用于查询单条记录返回结果
        return (Article) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper(Article.class));
    }

    // 查询全部
    public List<Article> findAll(){
        //query用于查询结果列表
        return (List<Article>) jdbcTemplate.query("SELECT * FROM article ",  new BeanPropertyRowMapper(Article.class));
    }
}
