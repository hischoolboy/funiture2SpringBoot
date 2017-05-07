package io.hischoolboy.business.dao;import io.hischoolboy.beans.PageQuery;import io.hischoolboy.business.domain.Article;import io.hischoolboy.common.DBRepository;import org.apache.ibatis.annotations.Param;import java.util.List;@DBRepositorypublic interface ArticleDao {    void save(Article article);    void update(Article article);    void incrReadTime(@Param("id") int id);    Article findById(@Param("id") int id);    List<Article> getPage(PageQuery page);    int count();}