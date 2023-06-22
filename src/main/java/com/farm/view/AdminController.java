package com.farm.view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.farm.biz.dto.AdminVO;
import com.farm.biz.dto.ProductVO;
import com.farm.biz.service.AdminService;
import com.farm.biz.service.ProductService;

import utils.Criteria;
import utils.PageMaker;

@Controller
@SessionAttributes("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ProductService productService;
	
	@GetMapping("/admin_login_form")
	public String adminLoginView() {

		return "admin/main";
	}
	
	@PostMapping("/admin_login")
	public String adminLogin(AdminVO vo, Model model) {
		// (1) 관리자 ID 인증
		int result = adminService.adminCheck(vo);
		
		// (2) 정상관리자 이면
		//     -- 관리자 정보 조회
		//     -- 상품목록 화면으로 이동
		if (result == 1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getAid()));
			
			return "redirect:admin_product_list";
		} else {
		
			// (3) 비정상 관리자이면
			//     -- 메시지를 설정하고 로그인화면으로 이동
			if (result == 0 || result == -1) {
				model.addAttribute("message", "아이디, 비밀번호를 확인해 주세요.");
			} 
			
			return "admin/main";
		} 
	}
	
	@GetMapping("/admin_logout")
	public String adminLogout(SessionStatus status) {
		
		status.setComplete();  // 세션 해지
		
		return "admin/main"; 
	}
	
	@RequestMapping("/admin_product_list")
	public String adminProductList(
			@RequestParam(value="key", defaultValue="") String name,
			Criteria criteria, Model model) {
		// (1) 페이지별 상품목록 조회
		List<ProductVO> prodList = productService.getListProductWithPaging(criteria, name);
		
		// (2) 화면에 표시할 페이지 버튼 정보 설정
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		pageMaker.setTotalCount(productService.countProductList(name));  // 총 게시글의 수를 저장
		
		// (2) 내장 객체에 상품 목록 저장
		model.addAttribute("productList", prodList);
		model.addAttribute("productListSize", prodList.size());
		model.addAttribute("pageMaker", pageMaker);
		
		// (3) 화면 호출: productList.jsp
		return "admin/product/productList";
	}
	
	@RequestMapping("/admin_product_detail")
	public String adminProductDetail(Criteria cri, ProductVO vo, Model model) {
		String[] kindList = {"", "과일", "채소", "곡물", "견과류"};
		
		ProductVO product = productService.getProduct(vo);
		model.addAttribute("productVO", product);
		
		int index = Integer.parseInt(product.getKind());
		model.addAttribute("kind", kindList[index]);
		model.addAttribute("criteria", cri);
		
		return "admin/product/productDetail";
	}
	
	@GetMapping("/admin_product_write_form")
	public String adminProductWriteView(Model model) {
		String[] kindList = {"", "과일", "채소", "곡물", "견과류"};
		
		model.addAttribute("kindList", kindList);
		return "admin/product/productWrite";
	}
	
	@PostMapping("/admin_product_write")
	public String adminProductWriteAction(ProductVO vo, HttpSession session,
		@RequestParam(value="product_image") MultipartFile uploadFile) {
		
		// 업로드 파일이 업로드 되었는지 확인
//		if(!uploadFile.isEmpty()){
//			String fileName = uploadFile.getOriginalFilename();
//			vo.setImage(fileName);	// 파일명을 추출하여 저장
//
//			System.out.println("등록시 입력된 파일명? : "+ fileName);
//
//			// 이미지를 저장할 위치 지정
//			// getServletContext() - 프로젝트 관련 정보 리턴
//			// getRealPath() - 지정된 경로의 실제 디스크 상의 위치를 알려줌.
//			String image_path = session.getServletContext()
//			.getRealPath("WEB-INF/resources/product_images/");
//			
//			System.out.println("image_path(1)=" + image_path);
//
//			try {
//					uploadFile.transferTo(new File(image_path + fileName));
//				} catch (IllegalStateException | IOException e) {
//					e.printStackTrace();
//				}
//		}

//------------hjh0621 상품등록시 이미지 없을 경우 포함 처리--------------
//		// 파일 저장 경로 설정 (이미지가 있는 폴더)
//		String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
//		String fileName;
//		// 파일 저장 (그림파일 유/무에 따라 처리)
//			if (!uploadFile.isEmpty()) {
//			    fileName = uploadFile.getOriginalFilename();
//			} else {
//				fileName = "default.jpg";
//			}
//			try {
//		    	uploadFile.transferTo(new File(image_path + fileName));
//		        vo.setImage(fileName);
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		        // 파일 저장 실패 시 예외 처리
//		    }
		
		// 파일 저장 경로 설정 (이미지가 있는 폴더)
		String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
		String fileName;
		// 파일 저장 (그림파일 유/무에 따라 처리)
		if (!uploadFile.isEmpty()) {
		    fileName = uploadFile.getOriginalFilename();
		    try {
		    	uploadFile.transferTo(new File(image_path + fileName));
		        vo.setImage(fileName);
		    } catch (IOException e) {
		        e.printStackTrace();
		        // 파일 저장 실패 시 예외 처리
		    }
		} else {
		    fileName = "default.jpg";
		    vo.setImage(fileName);
		}
//---------------------------------------------------------
		// 입력한 상품정보 저장
		System.out.println("ProductVO :"+vo);	// hjh-test:0620
		
		productService.insertProduct(vo);
		
		return "redirect:admin_product_list";
	}
	
	@GetMapping("/admin_product_update_form")
	public String adminProductUpdateView(ProductVO vo, Model model) {
		String kindList[] = {"과일", "채소", "곡물", "견과류"};
		
		// (1) 상품 상세 조회
		ProductVO product = productService.getProduct(vo);
		// (2) Model 객체에 상품 데이터 저장
		model.addAttribute("productVO", product);
		model.addAttribute("kindList", kindList);
		// (3) 화면 호출 : productUpdate.jsp
		return "admin/product/productUpdate";
	}
	
	@PostMapping("/admin_product_update")
	public String adminProductUpdate(ProductVO vo, HttpSession session,
			@RequestParam(value="nonmakeImg") String org_image,
			@RequestParam(value="product_image") MultipartFile uploadFile) {
		
		// 업로드 파일이 업로드 되었는지 확인
		if(!uploadFile.isEmpty()){		// 상품이미지가 변경된 경우
			String fileName = uploadFile.getOriginalFilename();

			System.out.println("입력된 파일명? : "+ fileName);

			vo.setImage(fileName);	// 파일명을 추출하여 저장
			
			// 이미지를 저장할 위치 지정
			// getServletContext() - 프로젝트 관련 정보 리턴
			// getRealPath() - 지정된 경로의 실제 디스크 상의 위치를 알려줌.
			String image_path = session.getServletContext()
			.getRealPath("WEB-INF/resources/product_images/");
			
			System.out.println("image_path(2)=" + image_path);

			try {
					uploadFile.transferTo(new File(image_path + fileName));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
		}else {		// 상품의 기존 이미지 사용
			vo.setImage(org_image);
		}



		// 베스트 상품, 신규상품
		System.out.println("useyn = " + vo.getUseyn());
		System.out.println("bestyn = " + vo.getBestyn());
		if(vo.getUseyn() == null || vo.getUseyn().contentEquals("n")) {
			vo.setUseyn("n");
		}else {
			vo.setUseyn("y");
		}
		
		if(vo.getBestyn() == null || vo.getBestyn().contentEquals("n")) {
			vo.setBestyn("n");
		}else {
			vo.setBestyn("y");
		}
		
		productService.updateProduct(vo);
		
		return "redirect:admin_product_list";
	}
	
}
