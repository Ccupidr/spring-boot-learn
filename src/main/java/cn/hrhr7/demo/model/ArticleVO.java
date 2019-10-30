package cn.hrhr7.demo.model;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonPropertyOrder(value = {"author","content","title"}) // 自定义排序
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {
    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */

    @JsonIgnore
    private int id;

    private String author;
    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)

    private String createTime;

    private List<Reader> reader;

}
