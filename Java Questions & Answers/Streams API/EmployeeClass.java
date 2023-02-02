import java.util.*;
import java.util.stream.Collectors;

class StreamsAPIQuestionAnswers {
    static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("John Smith", 1, 50000.0,"M","IT"),
            new Employee("Jane Doe", 2, 60000.0,"F","HR"),
            new Employee("Bob Johnson", 3, 55000.0,"M","IT"),
            new Employee("Ben Johnson", 4, 35000.0,"M","HR"),
            new Employee("Jon", 5, 66000.0,"M","Testing"),
            new Employee("Rivera", 6, 66000.0,"F","IT"),
            new Employee("Rivald", 7, 105000.0,"M","IT"),
            new Employee("Arvind", 8, 84000.0,"M","HR"),
            new Employee("Jose", 9, 78000.0,"M","Testing"),
            new Employee("Angel", 10, 54000.0,"F","HR")
    ));
    public static void main(String[] args) {
        //Q. Count the total employees
        Long totalCount = employees.stream().count();
        //System.out.println(totalCount);
        //Q. Print the details of Rivera
        employees.stream().filter(e->e.getName().equals("Rivera")).forEach(System.out::println);
        //Q. Sort the list according to salary
        List<Employee>SortedEmployeesAccordingToSalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        //System.out.println(SortedEmployeesAccordingToSalary);
        //Q. Sort the list according to salary in descending order
        List<Employee>SortedEmployeesAccordingToSalaryDecending =employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        //System.out.println(SortedEmployeesAccordingToSalaryDecending);
        //Q. Print all the departments of the office
        employees.stream().map(employee -> employee.getDepartment()).distinct().forEach(n-> System.out.println(n));
        //Q. Print all the employee belongs to IT department
        employees.stream().filter(e -> "IT".equals(e.getDepartment())).forEach(System.out::println);
        //Q. Collect all the Female employees in a new list
        List<Employee>femaleEmployeeList=employees.stream().filter(e->"F".equals(e.getGender())).collect(Collectors.toList());
        //System.out.println(femaleEmployeeList);
        //Q. Print all the employees which are getting salary more than 60000
        employees.stream().filter(n->n.getSalary()>60000).forEach(System.out::println);
        //Q. Collect the employees with id 4,6,7
        List<Employee>selectedEmployees = employees.stream().filter(e->e.getId()==4 || e.getId()==6 || e.getId()==7).collect(Collectors.toList());
        //System.out.println(selectedEmployees);
        //Q. Find the total salary paid to the employees
        Double totalSalary= employees.stream().mapToDouble(Employee::getSalary).sum();
        //System.out.println(totalSalary);
        //Q. Find the total salary paid to the employees with Id 2,5,7,8,10
        List<Integer>salaryIdList=Arrays.asList(2,5,7,8,10);
        Double totalSalaryOfSelectedEmployees=employees.stream().filter(e->salaryIdList.contains(e.getId())).mapToDouble(Employee::getSalary).sum();
        //System.out.println(totalSalaryOfSelectedEmployees);
        //Q. Count Employees by department
        Map<String,Long>CountOfEmployeesOfDepartmentVise= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        //System.out.println(CountOfEmployeesOfDepartmentVise);
        //Q. Count Employees gender vise
        Map<String,Long> CountOfEmployeesOfGenderVise=employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        //System.out.println(CountOfEmployeesOfGenderVise);
    }
}
class Employee {
    private String name;
    private int id;
    private double salary;
    private String gender;
    private String department;
    public Employee(String name, int id, double salary,String gender,String department) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.gender= gender;
        this.department= department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
    public String getGender() {
        return gender;
    }
    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}