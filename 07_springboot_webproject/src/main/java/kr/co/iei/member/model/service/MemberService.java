package kr.co.iei.member.model.service;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.iei.member.model.dao.MemberDao;
import kr.co.iei.member.model.dto.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public Member selectOneMember(Member m) {
		
		Member member = memberDao.selectOneMember(m);
		return member;
	}

	public Member selectOneMember(String checkId) {
		Member member = memberDao.selectOneMember(checkId); //오버로딩 메소드의 이름이 같아도 매개변수가 다르면 사용 가능
		return member;
	}

	@Transactional
	public int insertMember(Member m) {
		int result = memberDao.insertMember(m);
		return result;
	}

	@Transactional
	public int updateMember(Member m) {
		int result = memberDao.update(m);
		return result;
	}
	
	@Transactional
	public int deleteMember(int memberNo) {
		int result = memberDao.deleteMember(memberNo);
		return result;
	}

	public List selectAllMember() {
		List list = memberDao.selectAllMember();
		return list;
	}

	@Transactional
	public int changeLevel(Member m) {
		int result = memberDao.changeLevel(m);
		return result;
	}
	
	@Transactional
	public boolean checkedChangeLevel(String no, String level) {
		//디비작업을 여러번 처리할때, 데이터 편집할때
		StringTokenizer sT1 = new StringTokenizer(no,"/");
		StringTokenizer sT2 = new StringTokenizer(level,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int memberNo = Integer.parseInt(sT1.nextToken());
			int memberLevel = Integer.parseInt(sT2.nextToken());
			Member m = new Member();
			m.setMemberNo(memberNo);
			m.setMemberLevel(memberLevel);
			int intResult = memberDao.changeLevel(m);
			if(intResult == 0) {
				result = false;
				break;
			}
		}
		return result;
	}
	
}
