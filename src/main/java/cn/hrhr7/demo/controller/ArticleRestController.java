package cn.hrhr7.demo.controller;


import cn.hrhr7.demo.dao.Article;
import cn.hrhr7.demo.model.AjaxResponse;
import cn.hrhr7.demo.model.ArticleVO;
import cn.hrhr7.demo.services.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name = "ArticleRestServiceImp")
    ArticleRestService articleRestService;

    @RequestMapping(value = "/articles", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody  AjaxResponse saveArticle(@RequestBody ArticleVO articleVO){

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        articleVO.setCreateTime(dateFormat.format(date));
        articleRestService.saveArticle(articleVO);

        log.info("save article: {}", articleVO);

        return AjaxResponse.success(articleVO);
    }

    //@RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public @ResponseBody  AjaxResponse deleteArticle(@PathVariable int id){

        log.info("delete article: {}",id);
        articleRestService.deleteArticle(id);

        return AjaxResponse.success();
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable int id, @RequestBody ArticleVO articleVO){

        articleVO.setId(id);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        articleVO.setCreateTime(dateFormat.format(date));

        articleRestService.updateArticle(articleVO);
        log.info("update article:{}", articleVO);

        return AjaxResponse.success(articleVO);
    }

    @GetMapping( "/articles/{id}")
    public @ResponseBody  AjaxResponse getArticle(@PathVariable int id) {
        ArticleVO articleVO = articleRestService.getArticle(id);

        return AjaxResponse.success(articleVO);
    }

    @GetMapping("/articles")
    public @ResponseBody AjaxResponse getAll(){

        List<ArticleVO> artiles = articleRestService.getAll();
        return AjaxResponse.success(artiles);
    }


}
