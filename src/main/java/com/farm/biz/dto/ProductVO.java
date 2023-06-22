package com.farm.biz.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	
	private int pdseq;
	private String name;
	private String kind;
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private String image;
	private String useyn;
	private String bestyn;
	private String origin;
	private Date regdate;
	// Getters, Setters
	
}
