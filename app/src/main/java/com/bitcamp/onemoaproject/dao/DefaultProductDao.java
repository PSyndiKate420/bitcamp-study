package com.bitcamp.onemoaproject.dao;

import com.bitcamp.onemoaproject.vo.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //현재 클래스를 dao bean으로 등록
public class DefaultProductDao implements ProductDao{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Product> findAll(int start, int end, String searchOption, String keyword) throws Exception {
        // 검색옵션, 키워드 맵에 저장
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("searchOption", searchOption);
        map.put("keyword", keyword);
        // BETWEEN #{start}, #{end}에 입력될 값
        map.put("start", start);
        map.put("end", end);
        return sqlSession.selectList("product.findAll", map);
    }

    @Override
    public int countArticle(String searchOption, String keyword) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("searchOption", searchOption);
        map.put("keyword", keyword);
        return sqlSession.selectOne("board.countArticle", map);
    }
}
