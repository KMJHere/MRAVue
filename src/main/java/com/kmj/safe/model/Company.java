package com.kmj.safe.model;

import lombok.Data;
import java.util.Date;

@Data
public class Company {
	private Integer COMPANY_ID;  // 회사ID
	private Integer CRTUSERNO;  // 최초생성자
	private Date CRTDATE;  // 최초생성일	
	private Integer MODUSERNO;  // 최종수정자     
	private Date MODDATE;  // 최종수정일
	private String BIZNO;  // 사업자번호
	private String COMPANY_NAME;  // 회사명         
	private String BOSS;  // 대표자명       
	private String BIZPLACE_ZIPCODE;  // 사업장 우편번호   
	private String BIZPLACE_ADDR1;  // 사업장 우편번호주소 
	private String BIZPLACE_ADDR2;  // 사업장 상세주소   
	private String TELNO;  // 전화번호       
	private String USE_TF;  // 사용여부 [T, F]
	private String CPN_LOGO_URL;  // 회사로고URL    
}
