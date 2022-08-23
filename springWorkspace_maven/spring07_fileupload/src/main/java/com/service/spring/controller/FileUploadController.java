package com.service.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.model.UploadDataVO;

@Controller
public class FileUploadController {
	
	@RequestMapping("fileupload.do")
	public ModelAndView upload(UploadDataVO vo, HttpServletRequest request) throws Exception{
		// copy���� Ư���� ��η� �̵��ϴ� ���
		
		//1. ���ε�� ������ ������ ������ �ִ� MultipartFile�� ���� ���� �޾ƿ´�.
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile... " + mFile);
		
		//2. ���ε�� ������ �ִٸ�..���ε�� ���� ������ �޾ƺ���..(���� �̸�, �뷮)
		if(mFile.isEmpty()!=true) { //���ε� �� ������ �ִٸ�
			System.out.println("������ ������ " + mFile.getSize());
			System.out.println("���ε��� ���ϸ� " + mFile.getOriginalFilename());
			System.out.println("getName()?? " + mFile.getName());
		}
		
		//3. ���ε��� ������ �츮�� ������ ��ο� �̵�(�̶� copy���� �������̴�.)
		// ���� context path ��θ� �޾ƿ;� �Ѵ�.
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root " + root);
		
		String path = root + "\\upload\\";
		
		//4. ������ ���� path �ȿ� �̵��ϰ����ϴ� ������ ����
		File copyFile = new File(path + mFile.getOriginalFilename());
		
		//5. ������ ����(copyFile)�� �̵���Ŵ..
		mFile.transferTo(copyFile);	// �츮�� ���ε��� ������ ī�Ǻ��� �ش��ο� ����ȴ�...�̵��Ѵ�
		System.out.println("path " + path);
		
		return new ModelAndView("upload_result", "uploadFile", mFile.getOriginalFilename());
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(String filename, HttpServletRequest request) {
		System.out.println("filename " + filename);
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path", path);
		
		// ��¥ ����������� �ƴ϶� ��û�ϴ� ������ ��
		return new ModelAndView("downloadView", map);
	}
}
