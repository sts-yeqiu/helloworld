package hellotest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoEmp {
  private Integer coId;
  private Integer empId;
  private String department;
  private Date createdAt;
}
