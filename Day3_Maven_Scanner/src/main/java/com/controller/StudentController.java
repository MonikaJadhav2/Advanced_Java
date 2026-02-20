package com.controller;

import com.service.StudentService;
import java.util.Scanner;

public class StudentController {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();

		while (true) {

			System.out.println("\n=======STUDENT MANAGEMENT SYSTEM=======");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Fetch All");
			System.out.println("5.Drop Table");
			System.out.println("6.Exit");

			System.out.println("Enter choice:");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Name: ");
				String name = sc.nextLine();

				System.out.print("Enter City: ");
				String city = sc.nextLine();

				service.insertData(id, name, city);
				break;

			case 2:
				System.out.print("Enter ID to Update: ");
				int uid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter New Name: ");
				String uname = sc.nextLine();

				System.out.print("Enter New City: ");
				String ucity = sc.nextLine();

				service.updateData(uid, uname, ucity);
				break;

			case 3:
				System.out.print("Enter ID to Delete: ");
				int did = sc.nextInt();
				service.deleteData(did);
				break;

			case 4:
				service.fetchAllRecord();
				break;

			case 5:
				service.drop();
				break;

			case 6:
				System.out.println("Exiting... Thank You!");
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid Choice!");

			}

		}
//		
	}

}