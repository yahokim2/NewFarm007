package com.farm.biz.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaVO {

	private int qaseq;
	private String subject;
	private String content;
	private String reply;
	private String userid;
	private String rep;
	private Date indate;

}
