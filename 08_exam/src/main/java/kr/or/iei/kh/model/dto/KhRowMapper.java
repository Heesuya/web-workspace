package kr.or.iei.kh.model.dto;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;

@Component

public class KhRowMapper implements RowMapper<KhDTO> {

	@Override

	public KhDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		KhDTO kh = new KhDTO();

		kh.setAddr(rs.getString("addr"));

		kh.setFax(rs.getString("fax"));

		kh.setKhName(rs.getString("kh_name"));

		kh.setKhNo(rs.getInt("kh_no"));

		return kh;

	}

}