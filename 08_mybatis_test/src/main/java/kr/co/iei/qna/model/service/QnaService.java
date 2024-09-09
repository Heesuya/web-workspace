package kr.co.iei.qna.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kr.co.iei.qna.model.dao.QnaDao;

@Service

public class QnaService {

	@Autowired

	private QnaDao qnaDao;

	public List searchQna(String qnaTitle) {

		List list = qnaDao.searchQna(qnaTitle);

		return list;

	}

}