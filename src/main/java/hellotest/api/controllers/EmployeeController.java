package hellotest.api.controllers;

import hellotest.domain.Employee;
import hellotest.domain.request.UpdateEmployeeRequest;
import hellotest.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api")
@Api(description = "员工信息API接口")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")//查询
    @ApiOperation(value = "获取员工信息", produces = "application/json")
    public List<Employee> listAll(
            @ApiParam(value = "员工名称") @RequestParam(value = "name", required = false) String name
    ) {
        return employeeService.selectEmplyees(name);
    }

    @GetMapping("employee/{id}")
    @ApiOperation(value = "获取单条员工信息", produces = "application/json")
    public Employee selectCompanyInfo(
            @ApiParam(value = "员工ID", required = true) @PathVariable(value = "id") Integer id
    ) {
        return employeeService.getById(id);
    }

    @PostMapping("employees")
    @ApiOperation(value = "创建员工", produces = "application/json")
    public Employee createEmployee(
            @ApiParam(value = "创建员工") @RequestBody Employee employee
    ) {
        return employeeService.create(employee);
    }

    @PutMapping("employees/{id}")
    @ApiOperation(value = "更新员工", produces = "application/json")
    public Employee updateEmployee(
            @ApiParam(value = "更新员工", required = true) @PathVariable(value = "id") Integer id,
            @ApiParam(value = "修改的字段信息", required = true) @RequestBody UpdateEmployeeRequest request
    ) {
        return employeeService.update(id, request);
    }

    @DeleteMapping("employees/{empId}")
    @ApiOperation(value = "删除员工", produces = "application/json")
    public String deleteEmployee(
            @ApiParam(value = "删除员工", required = true) @PathVariable(value = "empId") Integer id
    ) {
        if (employeeService.delete(id) > 0) {
            return "Success";
        } else {
            return "false";
        }
    }
}
