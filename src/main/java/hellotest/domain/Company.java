package hellotest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 公司的实体
 * lombok 的@Data会在编译期间自动为所有字段添加@ToString方法 , @Equals方法，@HashCode方法, @Getter方法，
 * 为非final字段添加@Setter,和@RequiredArgsConstructor
 * 注解@NoArgsConstructor ： 生成一个无参数的构造方法
 * 注解AllArgsConstructor添加一个构造函数，该构造函数含有所有已声明字段属性参数
 */
@Data
@AllArgsConstructor //全参构造器
@NoArgsConstructor//无参构造器
public class Company {
  private Integer id; //数据Id
  private String name; //公司名称
  private String city; //所在城市
  private Date createdAt; //创建日期
}