package hellotest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private  Integer id;
  private  String name;
  private  String sex;
  private  Integer age;
  private  String tel;
  private  String address;
  private Date createdAt;
  private Date updateAt;
}
