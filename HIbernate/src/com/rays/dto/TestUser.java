package com.rays.dto;

import java.util.Date;

public class TestUser {

	public static void main(String[] args) {
		
		//testadd();
		//testUpdate();
		//testDelete();
		//testget();
		testAuth();
		
		
	}

	private static void testAuth() {

		UserModel model = new UserModel();
		
		UserDTO dto = model.authenticate("ab@gmail.com", "123");
		
		if (dto !=null) {
			
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
			
		} else {
			System.out.println("Authentication failed..dto..");

		}
		
		
	}

	private static void testget() {

		UserModel model = new UserModel();
		
		UserDTO dto = model.findByPk(1);
		
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());
		System.out.println(dto.getAddress());
		
	}

	private static void testDelete() {

		UserDTO dto = new UserDTO();
		dto.setId(3);
		
		UserModel model = new UserModel();
		model.Delete(dto);
	}

	private static void testUpdate() {
		
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("pqr");
		dto.setLastName("dcb");
		dto.setLoginId("pqr@gmail.com");
		dto.setPassword("1718");
		dto.setDob(new Date());
		dto.setAddress("dewas");
		
		UserModel model = new UserModel();
		model.Update(dto);
		
	}

	private static void testadd() {
		
		UserDTO dto = new UserDTO();
		
		dto.setFirstName("mno");
		dto.setLastName("dbc");
		dto.setLoginId("mno@gmail.com");
		dto.setPassword("1234");
		dto.setDob(new Date());
		dto.setAddress("Ujjain");
		
		UserModel model = new UserModel();
		model.Add(dto);
		
	}
	

}
