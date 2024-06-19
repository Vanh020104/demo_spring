package com.example.demospring;

import com.example.demospring.dao.ClassRoomDAO;
import com.example.demospring.entity.ClassRoom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
		System.out.println("Hello World!");

	}
	@Bean
	public CommandLineRunner commandLineRunner(ClassRoomDAO classRoomDAO) {
		return args -> {
			getClassById(classRoomDAO);
//			addNewClass(classRoomDAO);

		};
	}

//	private static void addNewClass(ClassRoomDAO classRoomDAO) {
//		ClassRoom classRoom = new ClassRoom();
//		classRoom.setClass_name("A1");
//		classRoom.setNumber_member(20);
//		classRoomDAO.saveClassRoom(classRoom);
//	}
	private static void getClassById(ClassRoomDAO classRoomDAO) {
		ClassRoom classRoom = classRoomDAO.getClassRoomById(1);
		System.out.println(classRoom.toString());
	}


}
