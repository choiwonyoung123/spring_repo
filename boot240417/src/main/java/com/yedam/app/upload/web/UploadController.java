package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
class UploadController {
	
	@Value("${file.upload.path}") // application.properties에서 경로 미리 변수로 지정, 환경변수 읽어 들이기
	private String uploadPath; // 필드에 value값 들어감
	
	@GetMapping("upload") // void >> 리턴하는 파일 이름, classpath:/templates/upload.html
	public void getUploadPage() {} // void >> 경로가 파일 경로와 같을 경우
		
	@PostMapping("formUpload")
	public String formUploadFile(@RequestPart MultipartFile[] images) {
		for(MultipartFile image : images) {
			if(image.getContentType().startsWith("image") == false) { // 이미지 파일을 받았는지 확인
				System.err.println("No Image");
				return null;
			}
			String originalName = image.getOriginalFilename(); // 오리지널 파일이름
			System.out.println("original : " + originalName);
			String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
			System.out.println("fileName : " + fileName);
			
			//String uploadPath = "C:\\upload"; // 업로드할 폴더 경로
			String saveName = uploadPath + File.separator + fileName; // 업로드 저장할 이름, File.separator >> 자바가 인식하는 경로 구분자(\\)
			System.out.println("saveName : " + saveName);
		
			Path savePath = Paths.get(saveName); // 문자열로된 경로를 실제 경로로 변환
			try {
				image.transferTo(savePath); // 실제 경로 밀어 넣기, 파일 이동
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "upload"; // 원래 페이지로 보내기
	}
	
	// ajax
	@PostMapping("/uploadsAjax")
	@ResponseBody // ajax 전용
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) {
	    
		List<String> imageList = new ArrayList<>();
		
	    for(MultipartFile uploadFile : uploadFiles){
	    	if(uploadFile.getContentType().startsWith("image") == false){ // 이미지 타입 확인
	    		System.err.println("this file is not image type");
	    		return null;
	        }
	    	
	    	// 파일 이름 가져오기
	        String originalName = uploadFile.getOriginalFilename();
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
	        
	        System.out.println("fileName : " + fileName);
	    
	        //날짜 폴더 생성
	        String folderPath = makeFolder();
	        //UUID
	        String uuid = UUID.randomUUID().toString();
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분
	        
	        // 업로드 파일 경로 정의
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName;
	        
	        String saveName = uploadPath + File.separator + uploadFileName;
	        
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	uploadFile.transferTo(savePath); // 파일 이동
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        // DB에 해당 경로 저장 코드 자리
	        // 1) 사용자가 업로드할 때 사용한 파일명
	        // 2) 실제 서버에 업로드할 때 사용한 경로
	        imageList.add(setImagePath(uploadFileName)); // 미리보기 관련
	     }
	    return imageList;
	}
	
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")); // 오늘 날짜 포맷
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator);
		
		File uploadPathFoler = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) { // 폴더 존재하지 않는 경우
			uploadPathFoler.mkdirs(); // 상위 디렉토리 모두 생성
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}
	 
	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}

}
