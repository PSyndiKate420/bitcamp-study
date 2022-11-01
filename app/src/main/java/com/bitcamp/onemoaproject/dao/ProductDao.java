package com.bitcamp.onemoaproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bitcamp.onemoaproject.vo.Product;

@Mapper
public interface ProductDao {
  // 게시글 전체 목록
  List<Product> findAll(int start, int end, String searchOption, String keyword) throws Exception;

  public int countArticle(String searchOption, String keyword) throws Exception;
}














