package cn.hrhr7.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false,length = 32)
    private String author;

    @Column(nullable = false, unique = true,length = 32)
    private String title;

    @Column(length = 512)
    private String content;

    private String createTime;


}