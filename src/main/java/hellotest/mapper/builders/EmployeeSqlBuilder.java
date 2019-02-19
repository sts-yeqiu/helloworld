package hellotest.mapper.builders;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;


public class EmployeeSqlBuilder {

  public String selectSqlBuild(
    @Param(value = "name") String name
  ) {

    return new SQL() {
      {
        SELECT("*");
        FROM("employee");
        if (StringUtils.isNotBlank(name)) {
          WHERE(" name LIKE CONCAT('%',#{name},'%') ");
        }
      }
    }.toString();
  }
}
