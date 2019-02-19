package hellotest.services.impl;

import hellotest.domain.Employee;
import hellotest.domain.request.UpdateEmployeeRequest;
import hellotest.mapper.EmployeeMapper;
import hellotest.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeMapper employeeMapper;

  public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
    this.employeeMapper = employeeMapper;
  }


  @Override
  public Employee create(Employee employee) {
    employee.setCreatedAt(new Date());
    employee.setUpdateAt(new Date());
    employeeMapper.insert(employee);
    return employee;
  }

  @Override
  public Employee getById(Integer id) {
    return employeeMapper.getById(id);
  }

  @Override
  public Employee update(Integer id, UpdateEmployeeRequest request) {
    request.setUpdateAt(new Date());
    employeeMapper.update(id,request);
    return employeeMapper.getById(id);
  }

  @Override
  public Integer delete(Integer id) {
    return employeeMapper.delete(id);
  }

  @Override
  public List<Employee> selectEmplyees(String name) {
    return employeeMapper.select(name);
  }
}
