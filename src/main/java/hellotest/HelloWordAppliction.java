package hellotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @RestController注解相当于@ResponseBody ＋ @Controller
 * 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，
 * 配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 注解 @EntityScan用来扫描和发现指定包及其子包中的Entity定义
 * 注解 @MapperScan可以指定要扫描的Mapper类的包的路径
 */
@SpringBootApplication
@EntityScan(basePackageClasses = HelloWordAppliction.class)
//@MapperScan(basePackages = {"hellotest.mapper"})
@RestController
public class HelloWordAppliction {

    /**
     * 项目程序的入口
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloWordAppliction.class, args);
        System.out.println("wozuishuai");
    }

    /**
     * 测试服务接口是否是正常启动
     *
     * @param name 姓名
     * @param num 编号
     * @return
     */
    @GetMapping(path = "/hello")
    public String hello(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "num", required = false) String num
    ) {
        return "hello world 您好:姓名 " + name + ", 编号 " + num + "帅哥出世了。";
    }
}
