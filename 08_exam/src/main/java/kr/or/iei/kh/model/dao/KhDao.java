package kr.or.iei.kh.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import kr.or.iei.kh.model.dto.KhDTO;

import kr.or.iei.kh.model.dto.KhRowMapper;

@Repository

public class KhDao {

	@Autowired

	private JdbcTemplate jdbc;

	@Autowired

	private KhRowMapper khRowMapper;

	public KhDTO searchKH(KhDTO kh) {

		String query = "select * from kh_tbl where kh_name=?";

		Object[] params = { kh.getKhName() };

		List list = jdbc.query(query, khRowMapper, params);

		if (list.isEmpty()) {

			return null;

		} else {

			return (KhDTO) list.get(0);

		}

	}

}