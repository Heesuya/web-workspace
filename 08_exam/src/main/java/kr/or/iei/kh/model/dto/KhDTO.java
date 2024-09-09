package kr.or.iei.kh.model.dto;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KhDTO {

	private int khNo;

	private String khName;

	private String addr;

	private String fax;

}