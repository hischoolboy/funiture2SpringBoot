package io.hischoolboy.business.service;

import io.hischoolboy.acl.convert.BaseConvert;
import io.hischoolboy.beans.PageQuery;
import io.hischoolboy.beans.PageResult;
import io.hischoolboy.business.dao.ProductDao;
import io.hischoolboy.business.domain.Product;
import io.hischoolboy.business.vo.ProductPara;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductDao productDao;

    public PageResult<Product> getPage(PageQuery page) {
        BaseConvert.checkPara(page);
        int count = productDao.countValid();
        if (count > 0) {
            List<Product> list = productDao.getValidProductList(page);
            return PageResult.<Product>builder().data(list).total(count).build();
        }
        return PageResult.<Product>builder().build();
    }

    public void save(ProductPara para) {
        BaseConvert.checkPara(para);
        Product product = Product.builder().id(para.getId()).title(para.getTitle()).image(para.getImage()).build();
        productDao.save(product);
    }

    public void delete(int id) {
        productDao.invalid(id);
    }
}
