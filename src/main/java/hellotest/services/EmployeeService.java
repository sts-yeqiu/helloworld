package hellotest.services;

import hellotest.domain.Employee;
import hellotest.domain.request.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {
  Employee create(Employee employee);

  Employee getById(Integer id);

  Employee update(Integer id, UpdateEmployeeRequest request);

  Integer delete(Integer id);

  List<Employee> selectEmplyees(String name);
}
