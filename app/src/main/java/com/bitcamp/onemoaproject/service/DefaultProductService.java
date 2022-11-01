package com.bitcamp.onemoaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.onemoaproject.dao.ProductDao;
import com.bitcamp.onemoaproject.vo.Product;

@Service
public class DefaultProductService implements ProductService {

  @Autowired
  ProductDao productDao;

  @Override
  public List<Product> listAll(int start, int end, String searchOption, String keyword) throws Exception {
    return productDao.findAll(start, end, searchOption, keyword);
  }

  @Override
  public int countArticle(String searchOption, String keyword) throws Exception {
    return productDao.countArticle(searchOption, keyword);
  }
}
