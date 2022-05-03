package ds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReportGeneration {
    public static void main(String[] args) {
        Pattern comma = Pattern.compile(",");
        try (BufferedReader employeeReader = new BufferedReader(new FileReader("employee.csv"));
             BufferedReader employerReader = new BufferedReader(new FileReader("employers.csv"))) {

            List<Employer> employerList = employerReader.lines()
                    .skip(1)
                    .map(l -> comma.split(l))
                    .map(s -> new Employer(Long.parseLong(s[0]), s[1], s[2]))
                    .collect(Collectors.toList());

            List<EmployeeDomain> employeeDomainList = employeeReader.lines()
                    .skip(1)
                    .map(l -> comma.split(l))
                    .map(s -> new EmployeeDomain(s[0], s[1], Double.parseDouble(s[2]), Long.parseLong(s[3])))
                    .collect(Collectors.toList());

            // Find the top paying companies
            employeeDomainList.stream()
                    .sorted(Comparator.comparingDouble(EmployeeDomain::getSalary).reversed())
                    .limit(2)
                    .flatMap(e -> employerList.stream().filter(er -> er.getId() == e.getCompanyId()))
                    .distinct()
                    .forEach(System.out::println);

            // Find the highest salaried employees in each company
            employeeDomainList.stream()
                    .collect(Collectors.groupingBy(EmployeeDomain::getCompanyId))
                    .values()
                    .stream()
                    .forEach(l -> System.out.println(l.stream()
                            .collect(Collectors.maxBy(Comparator.comparingDouble(EmployeeDomain::getSalary)))
                            .get()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Employer {
    private long id;
    private String name;
    private String location;

    public Employer(long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


class EmployeeDomain {
    private String empId;
    private String name;
    private double salary;
    private long companyId;

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", companyId=" + companyId +
                '}';
    }

    public EmployeeDomain(String empId, String name, double salary, long companyId) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.companyId = companyId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}