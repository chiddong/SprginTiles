package com.test.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//MVC > @Controller

//REST 서비스를 구현하는 컨트롤러
@RestController
public class AddressController {

	@Autowired
	private AddressDAO dao;

	// REST 서비스 개발
	// - REST Client 전용 프로그램
	// - 화면이 있는 페이지를 구현 안함 > 클라이언트 역할을 하는 프로그램
	// - 브라우저(확장), VSCode(확장), Postman, Insomnia 등..

	@GetMapping(value = "/test")
	public void test() {
		System.out.println("test");
	}

	// tblAddress > [C]RUD

	// 요소 추가하기
	// 1. http://localhost:8090/rest/address
	// 2. POST
	// 3. return int

	// @RequestBody > 붙혀주면 JSON 형태로 받은 데이터를 자동으로 해석해서 DTO에 데이터를 붙혀준다.

	@PostMapping("/address")
	public int add(@RequestBody AddressDTO dto) {

		return dao.add(dto);
	}

	// 요소 가져오기 > C[R]UD
	// 1. http://localhost:8090/rest/address
	// 2. GET
	// 3. return JSON
	@GetMapping("/address")
	@ResponseBody
	public List<AddressDTO> list() {

		return dao.list();
	}

	// 요소 수정하기 > CR[U]D
	// 1. http://localhost:8090/rest/address/82
	// 2. PUT
	// 3. return int

	@PutMapping("/address/{seq}")
	public int edit(@PathVariable("seq") String seq, @RequestBody AddressDTO dto) {

		dto.setSeq(seq);

		return dao.edit(dto);
	}

	// 요소 삭제하기 > CRU[D]
	// 1. http://localhost:8090/rest/address/82
	// 2. DELETE
	// 3. return int

	@DeleteMapping("/address/{seq}")
	public int del(@PathVariable("seq") String seq) {

		return dao.del(seq);
	}
	
	
	//요소 1개 가져오기(검색)	> DTO 한개 보기
	//1. http://localhost:8090/rest/address/1
	//2. GET
	//3. return JSON
	@GetMapping("/address/{seq}")
	@ResponseBody
	public AddressDTO get(@PathVariable("seq") String seq) {
		
		return dao.get(seq);
	}
	
	
}





















