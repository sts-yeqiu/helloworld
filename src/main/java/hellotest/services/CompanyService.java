package hellotest.services;

import hellotest.domain.Company;
import hellotest.domain.request.UpdateCompanyRequest;

import java.util.List;

/**
 * 定义接口方法
 */
public interface CompanyService {

  Company create(Company company); //新建公司

  Company getById(Integer id); //根据Id查询公司信息

  Company update(Integer id, UpdateCompanyRequest request); //更新公司的信息

  List<Company> searchCompanies(String name); //查询满足条件的公司

  List<Company> searchAllCompany();//查询全部

  Integer delete(Integer id); //删除一个公司
}
