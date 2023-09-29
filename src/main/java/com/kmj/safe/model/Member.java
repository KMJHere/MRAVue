package com.kmj.safe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Data
public class Member extends Common {
	private Integer USER_NO;  // 사용자번호 
	private String USER_ID;  // 사용자ID
	private String PASS_ID;  // 암호
	private String USER_NM;  // 사용자명
	private String TEL_NO;  // 전화번호
	private String MOBILE_NO;  // 휴대폰번호
	private String EMAIL;  // 이메일ID
	private String USER_GB;  // 사용자구분 [ADMIN:관리자 NORMAL:일반사용자 GUEST:게스트]
	private String POSITION_CD;  // 직위
	private String USE_TF;  // 사용여부 [T, F]
}
