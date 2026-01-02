package main;

import java.util.Scanner;

import dao.StudentDAO;
import model.Student;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Student student = new Student(id, name, dept, email, phone);
                    if (dao.addStudent(student)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Failed to add student.");
                    }
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    Student updatedStudent = new Student(updateId, newName, newDept, newEmail, newPhone);
                    if (dao.updateStudent(updatedStudent)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Update failed. Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (dao.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Delete failed. Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
