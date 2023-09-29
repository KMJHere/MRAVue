package com.kmj.safe.model;

import java.util.Date;

import lombok.Data;

@Data
public class Common {
	private Integer COMPANY_ID;  // 회사ID
	private String	PROJ_CODE;  // 현장코드
	private Integer CRTUSERNO;  // 최초생성자
	private Date CRTDATE;  // 최초생성일	
	private Integer MODUSERNO;  // 최종수정자     
	private Date MODDATE;  // 최종수정일

}
