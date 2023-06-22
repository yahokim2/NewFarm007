package com.farm.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.farm.biz.dto.ProductVO;
import com.farm.biz.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/product_detail")
	public String productDetail(ProductVO vo, Model model) {
		
		// 상품 상세 조회
		ProductVO product = productService.getProduct(vo);
		
		// JSP에 결과 전달
		model.addAttribute("productVO", product);
		
		return "product/productDetail";
	}
	
	@GetMapping(value="/category")
	public String productKindActionl(ProductVO vo, Model model) {
		
		// 상품 상세 조회 category
		List<ProductVO> kindList = productService.getProductListByKind(vo.getKind());
		
		// JSP에 결과 전달
		model.addAttribute("kind", vo.getKind());	// hjh-0613 (kind를 전달 해 주고 사용)
		model.addAttribute("productKindList", kindList);
		
		return "product/productKind";
	}
} 
