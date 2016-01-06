package com.dc.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dc.test.dao.IEntityDao;
import com.dc.test.entity.Student;

@Service
public class StudentService {
//	@Autowired
	private IEntityDao entityDao;

	@Transactional
	public List<Object> getStudentList() {
		StringBuffer sff = new StringBuffer();
		sff.append("select a from ").append(Student.class.getSimpleName())
				.append(" a ");
		List<Object> list = entityDao.createQuery(sff.toString());
		return list;
	}

	public void save(Student st) {
		entityDao.save(st);
	}

	public void delete(Object obj) {
		entityDao.delete(obj);
	}
}
