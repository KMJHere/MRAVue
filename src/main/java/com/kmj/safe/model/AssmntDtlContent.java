package com.kmj.safe.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Data
public class AssmntDtlContent extends AssmntContent {
	private String CONSTRCT_NAME;
	private String PLACE;
	private String RISK_FACT;
	private String DISASTER_FORM;
	private String ASSMNT_RANK;
	private String PRIORITY;
	private String IMPRV_MTHD;
	private String WORK_FROM;
	private String IMPRV_FROM;
	private String WORK_STAFF;
	private String IMPRV_CHECK_USER;
	private Date WORK_TO;
	private Date IMPRV_TO;
	private Integer CONSTRCT_CODE;
	private Integer IMPROV_EDU_USER;
	private Integer REGIS_DETAIL_SEQ;
	private String EXAMINE_CONSTRCT;
	private Integer EXAMINE_SAFETY;
	private Integer IMPRV_CHK_USER_NO;
	private Integer IMPRV_EDU_USER_NO;
	private Integer SORT_NO;
	private String ACC_TF;
	private Integer PRE_REGIS_DETAIL_SEQ;
	private Integer REG_MNG_CD;
}