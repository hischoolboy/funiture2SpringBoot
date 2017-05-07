package io.hischoolboy.business.controller;

import io.hischoolboy.beans.JsonData;
import io.hischoolboy.beans.PageQuery;
import io.hischoolboy.business.service.ProductService;
import io.hischoolboy.business.vo.ProductPara;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @RequestMapping(value = "page.json", method = RequestMethod.GET)
    public JsonData productQuery(PageQuery pageQuery) throws Exception {
        return JsonData.success(productService.getPage(pageQuery));
    }

    @ResponseBody
    @RequestMapping(value = "save.json")
    public JsonData save(ProductPara para) throws Exception {
        productService.save(para);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete.json")
    public JsonData delete(@RequestParam("id") int id) throws Exception {
        productService.delete(id);
        return JsonData.success();
    }
}
