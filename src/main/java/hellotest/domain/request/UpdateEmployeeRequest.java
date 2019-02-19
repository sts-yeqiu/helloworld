package hellotest.domain.request;

import lombok.Data;

import java.util.Date;

/**
 * lombok 的@Data会在编译期间自动生成get set方法、toString方法、hashCode方法、equals方法
 *
 */
@Data
public class UpdateEmployeeRequest {
  private String tel;
  private String address;
  private Date updateAt;
}
