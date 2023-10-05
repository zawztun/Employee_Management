package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class EmployeeOperation {
  private static Scanner sc = new Scanner(System.in);
  SessionFactory factory;

  public EmployeeOperation(SessionFactory sfactory) {
    this.factory = sfactory;
  }

  public void createEmployee() {
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();

    String req = "Y";
    do {

      Employee st = getEmployee();

      Serializable sid = session.save(st);

      System.out.println("Employee Number : " + sid + " is saved.");

      System.out.print("\ndo you want to save more Employees[Y/N]: ");
      req = sc.next();

    } while (req.equalsIgnoreCase("Y"));

    tx.commit();
    session.close();
  }

  private static Employee getEmployee() {
   String name = " ";
    System.out.println("Enter Employee's ID  : ");
    int id = sc.nextInt();
      System.out.println("Enter Employee's Name  : ");
     name = sc.nextLine();
      name += sc.nextLine();
    System.out.println("Enter Employee's basic   : ");
    int basic = sc.nextInt();
    System.out.println("Enter Employee's hra   : ");
    int hra = sc.nextInt();
    System.out.println("Enter Employee's da   : ");
    int da = sc.nextInt();
    System.out.println("Enter Employee's deduction   : ");
    int deduction = sc.nextInt();
    return new Employee(id, name, basic, hra, da, deduction);
  }

  public void DisplayEmployees() {
    Session session = factory.openSession();

    Query<Employee> q = session.createQuery("FROM Employee");
    List<Employee> ls = q.list();
    for (Employee s : ls) {
      System.out.println(s);
    }
    session.close();
  }

  public Employee findEmp(Integer empId) {
    Session session = factory.openSession();
    Employee emp = session.get(Employee.class, empId);
    return emp;
  }

  public double getSalaryById(Integer empId) {
    Employee emp = findEmp(empId);
    return calculateSalary(emp);
  }

  public Double calculateSalary(Employee emp) {
    int gross = emp.getBasic() + emp.getHra() + emp.getDa();
    Double salary = gross - ((gross * 0.15) + emp.getDeduction());
    System.out.println(salary);
    return salary;
  }
}
