package kr.or.iei.kh.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kr.or.iei.kh.model.dao.KhDao;

import kr.or.iei.kh.model.dto.KhDTO;

@Service

public class KhService {

	@Autowired

	private KhDao khDao;

	public KhDTO searchKH(KhDTO kh) {

		KhDTO khDto = khDao.searchKH(kh);

		return khDto;

	}

}