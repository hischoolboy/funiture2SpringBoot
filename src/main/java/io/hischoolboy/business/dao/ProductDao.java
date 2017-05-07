package io.hischoolboy.business.dao;

import io.hischoolboy.beans.PageQuery;
import io.hischoolboy.business.domain.Product;
import io.hischoolboy.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@DBRepository
public interface ProductDao {

    List<Product> getValidProductList(PageQuery pageQuery);

    int countValid();

    void save(Product product);

    void invalid(@Param("id") int id);
}
