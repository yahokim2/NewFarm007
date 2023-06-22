package com.farm.biz.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	private int ordetailseq;
	private int orseq;
	private String userid;
	private Date indate;
	private String mname;
	private String zip_num;
	private String address;
	private String phone;
	private int pdseq;
	private String pname;
	private int quantity;
	private int price2;
	private String result;
	
}
