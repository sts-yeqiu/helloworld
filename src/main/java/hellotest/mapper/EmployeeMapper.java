package hellotest.mapper;

import hellotest.domain.Employee;
import hellotest.domain.request.UpdateEmployeeRequest;
import hellotest.mapper.builders.EmployeeSqlBuilder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
  @Select("select * from employee")
  List<EmployeeMapper> listAllEmployee();

  @Insert("INSERT INTO employee (name,sex,age,tel,address,created_at,update_at)" +
    "VALUES (#{employee.name},#{employee.sex},#{employee.age},#{employee.tel}," +
    "#{employee.address},#{employee.createdAt},#{employee.updateAt}) ")
  @Options(useGeneratedKeys = true, keyProperty = "employee.id")
  void insert(@Param(value = "employee") Employee employee);

  @Select("SELECT * FROM employee WHERE id = #{id}")
  Employee getById(@Param(value = "id") Integer id);

  @Update("UPDATE employee SET tel=#{request.tel},address=#{request.address},update_at=#{request.updateAt}" +
    "where id=#{id}")
  void update(@Param(value = "id") Integer id, @Param(value = "request") UpdateEmployeeRequest request);

  @Delete("DELETE from employee WHERE id=#{id}")
  Integer delete(@Param(value = "id") Integer id);
  @SelectProvider(type = EmployeeSqlBuilder.class, method = "selectSqlBuild")
  List<Employee> select(@Param(value = "name") String name);
}
