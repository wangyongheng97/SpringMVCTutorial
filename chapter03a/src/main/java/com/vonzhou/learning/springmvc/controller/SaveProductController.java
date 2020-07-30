package com.vonzhou.learning.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vonzhou.learning.springmvc.domain.Product;
import com.vonzhou.learning.springmvc.form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//此处的映射在配置文件里 修改自idea
public class SaveProductController implements Controller {

    private static final Log logger = LogFactory
            .getLog(SaveProductController.class);

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) {
        logger.info("SaveProductController called");
        ProductForm productForm = new ProductForm();
        // populate action properties
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        // create model
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        // insert code to save Product

        return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp", "product",
                product);
    }

}
