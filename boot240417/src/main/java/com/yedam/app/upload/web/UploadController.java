package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
class UploadController {
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
			
			String uploadPath = "C:\\upload"; // 업로드할 폴더 경로
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
}
