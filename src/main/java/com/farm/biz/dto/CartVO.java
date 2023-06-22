package com.farm.biz.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	private int ctseq;
	private String userid;
	private int pdseq;
	private String mname;
	private String pname;
	private int quantity;
	private int price2;
	private Date indate;
}
