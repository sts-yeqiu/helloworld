package hellotest.mapper.builders;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class CompanySqlBuilder {

    /**
     * 动态生成sql 语句
     *
     * @param name
     * @return
     */
    public String searchSqlBuild(@Param("name") String name) {
        return new SQL() {{
            SELECT("*");
            FROM("company");
            /**判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成，等于!isBlank(String str)*/
            if (StringUtils.isNotBlank(name)) {
                WHERE(" name LIKE CONCAT('%',#{name},'%') ");
            }
        }}.toString();
    }
}
