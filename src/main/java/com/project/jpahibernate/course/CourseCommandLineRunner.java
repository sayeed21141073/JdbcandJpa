package com.project.jpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.jpahibernate.course.Course;
import com.project.jpahibernate.course.jdbc.CourseJdbcRepository;
import com.project.jpahibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

/*Here I used same Command Line Runner for both Jdbc and Jpa
 * currently the program is running jpa. To run Jdbc, please
 * turn of commenting line 19,20 and turn on commenting 
 * line 23,24 */	

	
//	@Autowired
//	private CourseJdbcRepository repository;

	@Autowired
	private CourseJpaRepository repository;

	
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course (1,"Intro To Java and Spring Boot", "Udemy"));
		repository.insert(new Course (2,"Intro To Core Java", "Udacity"));
		repository.insert(new Course (3,"Intro To Database", "Coursera"));
		repository.insert(new Course (4,"Learn How To Code", "Bucky"));
		repository.insert(new Course (5,"Intro To Spring Boot", "Code With Mosh"));

        repository.deleteById(5);
      
        System.out.println(repository.findById(1));
        System.out.println(repository.findById(3));

	
	}

}
