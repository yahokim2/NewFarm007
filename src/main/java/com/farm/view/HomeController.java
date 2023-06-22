package com.farm.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.farm.biz.dto.ProductVO;
import com.farm.biz.service.ProductService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model) {
		// 신상품 조회
		List<ProductVO> newProductList = productService.getNewProductList();

		// 베스트 상품조회
		List<ProductVO> bestProductList = productService.getBestProductList();
		
		model.addAttribute("newProductList", newProductList);
		model.addAttribute("bestProductList", bestProductList);
		
		System.out.println("Now INFO : FarmProductMall_007 started  ~~~~~~~~~~~~ ");
		return "index";		// index가 리턴되어 presentation을 거처서 index.jsp가 실행 될 것임
		
	}
	
}
