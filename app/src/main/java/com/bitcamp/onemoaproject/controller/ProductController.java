package com.bitcamp.onemoaproject.controller;

import javax.servlet.ServletContext;

import com.bitcamp.onemoaproject.service.ProductPager;
import com.bitcamp.onemoaproject.vo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.onemoaproject.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CRUD 요청을 처리하는 페이지 컨트롤러들을 한 개의 클래스로 합친다. 
@Controller // 페이지 컨트롤러에 붙이는 애노테이션 
@RequestMapping("/product/")
public class ProductController {

  ServletContext sc;
  ProductService productService;

  public ProductController(ProductService productService, ServletContext sc) {
    System.out.println("BoardController() 호출됨!");
    this.productService = productService;
    this.sc = sc;
  }

  @RequestMapping("list")
  public ModelAndView list(@RequestParam(defaultValue = "title") String searchOption,
                           @RequestParam(defaultValue = "") String keyword,
                           @RequestParam(defaultValue = "1") int curPage) throws Exception {
    // 레코드의 개수 계산
    int count = productService.countArticle(searchOption, keyword);

    // 페이지 나누기 관련 처리
    ProductPager productPager = new ProductPager(count, curPage);
    int start = productPager.getPageBegin();
    int end = productPager.getPageEnd();

    List<Product> list = productService.listAll(start, end, searchOption, keyword);

    // 데이터를 맵에 저장
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("list", list); //list
    map.put("count", count); // 레코드의 개수
    map.put("searchOption", searchOption); // 검색옵션
    map.put("keyword", keyword); //검색 키워드
    map.put("productPager", productPager);

    ModelAndView mav = new ModelAndView();
    mav.addObject("map", map); // 맵에 저장된 데이터를 mav에 저장
    mav.setViewName("product/list"); // 뷰를 list.jsp로 설정

    return mav; // list.jsp로 List가 전달
  }

  //  @GetMapping("detail")
  //  public Map detail(int no) throws Exception {
  //
  //    Board board = boardService.get(no);
  //
  //    if (board == null) {
  //      throw new Exception("해당 번호의 게시글이 없습니다!");
  //    }
  //
  //    Map map = new HashMap();
  //    map.put("board", board);
  //    return map;
  //  }
  //
  //  @PostMapping("update")
  //  public String update(
  //      Board board,
  //      Part[] files,
  //      HttpSession session) throws Exception {
  //
  //    board.setAttachedFiles(saveAttachedFiles(files));
  //
  //    checkOwner(board.getNo(), session);
  //
  //    if (!boardService.update(board)) {
  //      throw new Exception("게시글을 변경할 수 없습니다.");
  //    }
  //
  //    return "redirect:list";
  //  }  
  //
  //  private void checkOwner(int boardNo, HttpSession session) throws Exception {
  //    Member loginMember = (Member) session.getAttribute("loginMember");
  //    if (boardService.get(boardNo).getWriter().getNo() != loginMember.getNo()) {
  //      throw new Exception("게시글 작성자가 아닙니다.");
  //    }
  //  }
  //
  //  @GetMapping("delete")
  //  public String delete(
  //      @RequestParam("no") int no,
  //      HttpSession session) 
  //          throws Exception {
  //
  //    checkOwner(no, session);
  //    if (!boardService.delete(no)) {
  //      throw new Exception("게시글을 삭제할 수 없습니다!");
  //    }
  //
  //    return "redirect:list";
  //  }  
  //
  //  @GetMapping("fileDelete")
  //  public String fileDelete(
  //      @RequestParam("no") int no,
  //      HttpSession session) 
  //          throws Exception {
  //
  //    AttachedFile attachedFile = boardService.getAttachedFile(no);
  //
  //    // 게시글의 작성자가 로그인 사용자인지 검사한다. (남의 것 삭제할 수 있으면 안되니까)
  //    Member loginMember = (Member) session.getAttribute("loginMember");
  //    Board board = boardService.get(attachedFile.getBoardNo());
  //
  //    if (board.getWriter().getNo() != loginMember.getNo()) {
  //      throw new Exception("게시글 작성자가 아닙니다.");
  //    }
  //
  //    // 첨부파일을 삭제한다. 
  //    if (!boardService.deleteAttachedFile(no)) {
  //      throw new Exception("게시글 첨부파일 삭제 실패!");
  //    }
  //
  //    return "redirect:detail?no=" + board.getNo();
  //  }  
}






