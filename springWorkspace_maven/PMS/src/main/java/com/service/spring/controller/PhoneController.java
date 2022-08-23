package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ��� ��");
		
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			// ���� ������
			phoneService.insert(phone);
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ���� ����");
			
			return "Result";
		} catch(Exception e) {
			// ���� ������
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ���� ����");
			return "Error";
		}
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Phone phone, Model model) {
		try {
			List<Phone> list = phoneService.select();
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ����Ʈ");
			model.addAttribute("phones", list);
			
			return "PhoneList";
		} catch(Exception e) {
			model.addAttribute("title", "�ڵ��� ���� - ����");
			model.addAttribute("message", "���� ���� - �� ��� ��ȸ �� ���� �߻�");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Phone phone, Model model) {
		try {
			Phone selected = phoneService.select(phone);
			
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ����ȸ");
			model.addAttribute("phone", selected);
			
			return "PhoneView";
		} catch (Exception e) {
			model.addAttribute("title", "�ڵ��� ���� - ����");
			model.addAttribute("message", "���� ���� - �� ����ȸ �� ���� �߻�");
			return "Error";
		}
	}
	
	@PostMapping("deleteAjax.do")
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List<String> temp = new ArrayList<String>();
		
		try {
			for(String n: num) temp.add(n);
			
			phoneService.delete(temp);
			
			return "JsonView";
		} catch(Exception e) {
			model.addAttribute("title", "�ڵ��� ���� - ����");
			model.addAttribute("message", "���� ���� - �� ���� �� ���� �߻�");
			return "Error";
		}

	}
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return  "Login";
	}
	
	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		// request�� ����� ��쿡�� session ��� request �޾ƿ��� ��
		try {
			UserInfo selected = phoneService.select(user);
			if(selected!=null) {	// ã�� ������ ������ ���
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			} else {	// ���� ������ ���
				return "Login";
			}
			
		} catch (Exception e) {
			model.addAttribute("title", "ȸ�� �α��� - ����");
			model.addAttribute("message", "���� ���� - ȸ�� �α��� �� ���� �߻�");
			return "Error";
		}
		
	}

}
