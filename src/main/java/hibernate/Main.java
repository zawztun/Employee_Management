package hibernate;

import hibernate.utils.HibernateUtils;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ApplicationContext context = new ClassPathXmlApplicationContext("ems.xml");
    HibernateUtils hibernate = (HibernateUtils) context.getBean("hibernate_utils");


    SessionFactory sfactory = hibernate.getSessionfactory();
    EmployeeOperation eop = new EmployeeOperation(sfactory);

    while (true) {
      System.out.println(
          "\n Enter an Option : \n 1. Create Employee  \n 2. Display Employee \n 3.Employee Net Salary ");
      System.out.println("\n");
      int opt = sc.nextInt();
      switch (opt) {
        case 1:
          eop.createEmployee();
          break;
        case 2:
          eop.DisplayEmployees();
          break;
        case 3:
          System.out.println("Enter employee Number :  ");
          int id = sc.nextInt();
          double netSalary = eop.getSalaryById(id);
          System.out.println("Employee Number" + id + " Net Salary is " + netSalary);
          break;
        default:
          break;
      }
    }
  }
}
