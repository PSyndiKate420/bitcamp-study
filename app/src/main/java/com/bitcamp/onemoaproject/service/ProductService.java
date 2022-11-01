package com.bitcamp.onemoaproject.service;

import java.util.List;

import com.bitcamp.onemoaproject.vo.Board;
import com.bitcamp.onemoaproject.vo.Product;

public interface ProductService {
  
  // 게시글 전체 목록
  public List<Product> listAll(int start, int end, String searchOption, String keyword) throws Exception;

  //  게시글 레코드 갯수
   public int countArticle(String searchOption, String keyword) throws Exception;
}
