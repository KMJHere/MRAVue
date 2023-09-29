package com.kmj.safe.service.common;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kmj.safe.common.UserInfo;
import com.kmj.safe.repository.common.CommonFileMP;


@Service
public class CommonFileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonFileService.class);

	@Autowired
	private CommonFileMP commonFileMP;	
	@Autowired
	private UserInfo userInfo;

	public List<Map<String, Object>> selectFilList(String asJfileGrpNo) throws Exception {
		String sCfgFileUploadRootDir = "";
		
		List<Map<String, Object>> lResult = commonFileMP.selectFileLst(asJfileGrpNo);
		
		for(Map<String, Object> mFile : lResult) {						
			Path pFile = Paths.get(sCfgFileUploadRootDir, (String)mFile.get("FILE_PATH"));
			mFile.put("EXISTS_TF", Files.exists(pFile) ? "T" : "F");
		}
		
		return lResult;		
	}	
	
	
	public void upload(MultipartHttpServletRequest aMultiPartRequest, HttpServletResponse aResponse) throws Exception {
	}
	
}
