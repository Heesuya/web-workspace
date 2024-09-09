package kr.or.iei.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.iei.kh.model.dto.KhDTO;

import kr.or.iei.kh.model.service.KhService;

@Controller
@RequestMapping(value = "/kh")
public class KhController {

	@Autowired
	private KhService khService;

	@ResponseBody
	@GetMapping(value = "/search")
	public KhDTO searchKH(KhDTO kh) {

		KhDTO khDto = khService.searchKH(kh);

		return khDto;

	}

}