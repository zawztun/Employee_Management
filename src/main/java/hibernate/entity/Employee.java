package hibernate.entity;

public class Employee {
    private Integer empId;
    private  String empName;
    private Integer basic;
    private  Integer hra;
    private Integer da;
    private  Integer deduction;

    public Employee(Integer empId, String empName, Integer basic, Integer hra, Integer da, Integer deduction) {
        this.empId = empId;
        this.empName = empName;
        this.basic = basic;
        this.hra = hra;
        this.da = da;
        this.deduction = deduction;
    }

    public Employee() {

    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getBasic() {
        return basic;
    }

    public void setBasic(Integer basic) {
        this.basic = basic;
    }

    public Integer getHra() {
        return hra;
    }

    public void setHra(Integer hra) {
        this.hra = hra;
    }

    public Integer getDa() {
        return da;
    }

    public void setDa(Integer da) {
        this.da = da;
    }

    public Integer getDeduction() {
        return deduction;
    }

    public void setDeduction(Integer deduction) {
        this.deduction = deduction;
    }

    @Override
    public String toString() {
        return String.format("Student [%-3d | %-15s |%-3d |%-3d |%-3d |%-3d ]", empId, empName, basic, hra, da, deduction);
    }
}
