package com.test.rest;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {

	@Autowired private SqlSessionTemplate template;

	public int add(AddressDTO dto) {

		return template.insert("rest.add", dto);
	}

	public List<AddressDTO> list() {
		
		return template.selectList("rest.list");
	}

	public int edit(AddressDTO dto) {
		
		return template.update("rest.edit", dto);
	}

	public int del(String seq) {

		return template.delete("rest.del", seq);
	}

	public AddressDTO get(String seq) {

		return template.selectOne("rest.get", seq);
	}
	
}












