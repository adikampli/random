package random;

import lombok.Data;

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
                    .map(comma::split)
                    .map(s -> new Employer(Long.parseLong(s[0]), s[1], s[2]))
                    .collect(Collectors.toList());

            List<EmployeeDomain> employeeDomainList = employeeReader.lines()
                    .skip(1)
                    .map(comma::split)
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
                    .forEach(l -> System.out.println(l.stream()
                            .max(Comparator.comparingDouble(EmployeeDomain::getSalary))
                            .orElse(null)
                    ));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

@Data
class Employer {
    private final long id;
    private final String name;
    private final String location;
}

@Data
class EmployeeDomain {
    private final String empId;
    private final String name;
    private final double salary;
    private final long companyId;

}