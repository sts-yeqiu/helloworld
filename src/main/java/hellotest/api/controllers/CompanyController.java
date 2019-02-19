package hellotest.api.controllers;

import hellotest.domain.Company;
import hellotest.domain.request.UpdateCompanyRequest;
import hellotest.services.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api")
@Api(description = "公司信息API接口")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * 根据公司名查询公司信息
     *
     * @param name
     * @return
     * @GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
     * @RequestParam 注解的required = false 不必传，true 必传
     */
    @GetMapping("companies")
    @ApiOperation(value = "获取公司信息", produces = "application/json")
    public List<Company> searchCompanies(
            @ApiParam(value = "公司名称") @RequestParam(value = "name", required = false) String name
    ) {
        return companyService.searchCompanies(name);//传参调用查询方法
    }

    @GetMapping("companies/all")
    @ApiOperation(value = "获取全部公司信息", produces = "application/json")
    public List<Company> searchAllCompanies( Pageable pageable) {
        return companyService.searchAllCompany();
    }

    /**
     * 根据Id查询公司的信息
     *
     * @param id
     * @return
     * @PathVariable 绑定URL中的路径参数
     */
    @GetMapping("companies/{id}")
    @ApiOperation(value = "获取单条信息", produces = "application/json")
    public Company selectCompanyInfo(
            @ApiParam(value = "公司ID", required = true) @PathVariable(value = "id") Integer id
    ) {
        return companyService.getById(id);
    }

    /**
     * 新建公司
     *
     * @param company
     * @return
     * @RequestBody 1) 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
     * 2) 再把HttpMessageConverter返回的对象数据绑定到controller中方法的参数上。
     */
    @PostMapping("companies")
    @ApiOperation(value = "创建公司", produces = "application/json")
    public Company createCompany(
            @ApiParam(value = "创建公司") @RequestBody Company company
    ) {
//        System.out.println(company);
        return companyService.create(company);
    }

    /**
     * 根据公司Id更新公司信息
     *
     * @param id
     * @param request
     * @return
     */
    @PutMapping("companies/{companyId}")
    @ApiOperation(value = "更新公司", produces = "application/json")
    public Company updateCompany(
            @ApiParam(value = "公司ID", required = true) @PathVariable(value = "companyId") Integer id,
            @ApiParam(value = "修改信息", required = true) @RequestBody UpdateCompanyRequest request
    ) {
        return companyService.update(id, request);
    }

    /**
     * 根据公司Id删除一个公司
     *
     * @param id
     * @return
     */
    @DeleteMapping("companies/{id}")
    @ApiOperation(value = "删除公司", produces = "application/json")
    public String deleteCompany(
            @ApiParam(value = "删除", required = true) @PathVariable(value = "id") Integer id
    ) {
        if (companyService.delete(id) > 0) {
            return "success";
        } else {
            return "false";
        }
    }
}
