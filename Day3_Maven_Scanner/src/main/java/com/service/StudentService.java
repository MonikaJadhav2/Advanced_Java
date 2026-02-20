package com.service;

import com.dao.StudentDao;

public class StudentService {

	StudentDao dao;

	public StudentService() throws Exception {
		dao = new StudentDao();
	}

	public void insertData(int id, String name, String city) throws Exception {
		dao.insertData(id, name, city);
	}

	public void updateData(int id, String name, String city) throws Exception {
		dao.updateData(id, name, city);
	}

	public void deleteData(int id) throws Exception {
		dao.deleteData(id);
	}

	public void fetchAllRecord() throws Exception {
		dao.fetchAllRecord();
	}

	public void drop() throws Exception {
		dao.dropData();
	}
}