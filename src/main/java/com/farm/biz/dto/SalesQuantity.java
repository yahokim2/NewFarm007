package com.farm.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SalesQuantity {
	private String pname;	// 제품명
	private int quantity;	// 제품 판매 수량
}
