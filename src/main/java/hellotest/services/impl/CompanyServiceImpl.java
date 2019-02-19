package hellotest.services.impl;

import hellotest.domain.Company;
import hellotest.domain.request.UpdateCompanyRequest;

import hellotest.mapper.CompanyMapper;
import hellotest.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component //组件
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 新建公司
     *
     * @param company 公司实体
     * @return
     */
    @Override
    public Company create(Company company) {
        company.setCreatedAt(new Date());
        companyMapper.insert(company);
        return company;
    }

    /**
     * 根据公司Id查询公司的信息
     *
     * @param id
     * @return
     */
    @Override
    public Company getById(Integer id) {
        return companyMapper.getById(id);
    }

    /**
     * 根据ID更新公司信息
     *
     * @param id
     * @param companyRequest 需要更新的字段模型
     * @return
     */
    @Override
    public Company update(Integer id, UpdateCompanyRequest companyRequest) {
        companyMapper.update(id, companyRequest);
        return companyMapper.getById(id);
    }

    /**
     * 根据公司名称查询公司
     *
     * @param name
     * @return
     */
    @Override
    public List<Company> searchCompanies(String name) {
        return companyMapper.search(name);
    }

    @Override
    public List<Company> searchAllCompany() {
        return companyMapper.listAllCompany();
    }

    /**
     * 删除公司
     *
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        return companyMapper.delete(id);
    }
}
