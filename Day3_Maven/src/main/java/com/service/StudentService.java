package com.service;

import com.dao.StudentDao;

public class StudentService {

	public void insertData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.insertData();
	}

	public void updateData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.updateData();
	}

	public void deleteData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.deleteData();
	}

	public void fetchAllData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.fetchAllRecord();
	}

	public void dropData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.dropData();

	}

}