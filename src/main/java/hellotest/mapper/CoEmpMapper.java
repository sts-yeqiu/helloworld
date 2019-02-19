package hellotest.mapper;

import hellotest.domain.CoEmp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CoEmpMapper {
  @Select("select * from co_emp")
  List<CoEmp> listAllCoEmp();
}
