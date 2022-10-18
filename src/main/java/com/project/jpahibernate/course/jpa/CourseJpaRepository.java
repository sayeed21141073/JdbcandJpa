package com.project.jpahibernate.course.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.jpahibernate.course.Course;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entitymanager;
	
public void insert (Course course) {
	entitymanager.merge(course);
}

public Course findById(long id) {
	
	return entitymanager.find(Course.class, id);
	
}
public void deleteById(long id) {
	Course course = entitymanager.find(Course.class, id);
	entitymanager.remove(course);

}
}
