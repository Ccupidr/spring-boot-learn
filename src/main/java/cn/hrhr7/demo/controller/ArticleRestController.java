package cn.hrhr7.demo.controller;


import cn.hrhr7.demo.model.AjaxResponse;
import cn.hrhr7.demo.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @RequestMapping(value = "/articles", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody  AjaxResponse saveArticle(@RequestBody Article article){

        log.info("save article: {}", article);

        return AjaxResponse.success(article);
    }

    //@RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public @ResponseBody  AjaxResponse deleteArticle(@RequestBody int id){

        log.info("delete article: {}",id);

        return AjaxResponse.success();
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable int id, @RequestBody Article article){

        article.setId(id);
        log.info("update article:{}",article);

        return AjaxResponse.success(article);
    }

    @GetMapping( "/articles/{id}")
    public @ResponseBody  AjaxResponse getArticle(@PathVariable Long id) {

        Article article1 = Article.builder().id(1).author("zimug").content("spring boot 2.深入浅出").title("t1").build();
        return AjaxResponse.success(article1);
    }

}
