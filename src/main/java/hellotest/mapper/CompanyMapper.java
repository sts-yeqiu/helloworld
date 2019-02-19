package hellotest.mapper;

import hellotest.domain.Company;
import hellotest.domain.request.UpdateCompanyRequest;
import hellotest.mapper.builders.CompanySqlBuilder;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 公司接口
 * 注解@Mapper 映射接口
 */
@Mapper
public interface CompanyMapper {

  /**
   * 没有条件的查询所有的公司，mybatis查询注解@Select
   * @return
   */
  @Select("select * from company")
  List<Company> listAllCompany();

  /**
   * 插入数据,mybatis查询注解@Insert
   * @param company
   */
  @Insert("INSERT INTO company(name, city, createdAt)" +
    " VALUES(#{company.name}, #{company.city}, #{company.createdAt})")
  @Options(useGeneratedKeys = true, keyProperty = "company.id")
  void insert(@Param(value = "company") Company company);

  /**
   * 根据ID查询数据
   * @param id
   * @return
   */
  @Select("SELECT * FROM company WHERE id = #{id}")
  Company getById(@Param("id") Integer id);

  /**
   * 更新数据,mybatis查询注解@Update
   * @param id
   * @param request
   */
  @Update("UPDATE company SET city = #{request.city} WHERE id = #{id}")
  void update(@Param("id") Integer id, @Param("request") UpdateCompanyRequest request);

  /**
   * 拼接SQL语句查询
   * @param name
   * @return
   *
   * 注解@SelectProvider 用自定义的provider类构造SQL语句
   * type 属性用于指定获取sql语句的指定类
   * method 属性用于指定类中要执行获取sql语句的方法
   */
  @SelectProvider(type = CompanySqlBuilder.class, method = "searchSqlBuild")
  List<Company> search(@Param("name") String name);

  /**
   * 删除数据
   * @param id
   * @return
   */
  @Delete("DELETE FROM company WHERE id = #{id}")
  Integer delete(@Param("id") Integer id);
}
