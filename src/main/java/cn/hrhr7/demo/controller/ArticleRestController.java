package cn.hrhr7.demo.controller;


import cn.hrhr7.demo.model.AjaxResponse;
import cn.hrhr7.demo.model.Article;
import cn.hrhr7.demo.services.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name = "ArticleRestServiceImp")
    public ArticleRestService articleRestService;

    @RequestMapping(value = "/articles", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody  AjaxResponse saveArticle(@RequestBody Article article){

        log.info("save article: {}", articleRestService.saveArticle(article));

        return AjaxResponse.success(article);
    }


    @DeleteMapping("/articles/{id}")
    public @ResponseBody  AjaxResponse deleteArticle(@PathVariable int id){

        log.info("delete article: {}", id);
        articleRestService.deleteArticle(id);
        return AjaxResponse.success();

    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable int id, @RequestBody Article article){

        article.setId(id);
        articleRestService.updateArticle(article);
        log.info("delete article: {}",article);

        return AjaxResponse.success(article);
    }

    @GetMapping( "/articles/{id}")
    public @ResponseBody  AjaxResponse getArticle(@PathVariable int id) {
        log.info("get Article by ",id);
        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @GetMapping( "/articles")
    public @ResponseBody  AjaxResponse getAllArticle() {

        return AjaxResponse.success(articleRestService.getAll());
    }

}
