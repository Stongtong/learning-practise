package cc.tt.springdemo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/26 20:12
 * @Version 1.0
 **/
//@ConfigurationProperties(prefix = "person") 从全局配置文件中获取值
@Data
@PropertySource("classpath:person_temp.properties")
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
//@value()也可以，但是是加在字段上的
    private String name;
    private Integer age;
    private Boolean sex;
    private Date birth;

    private Map<String, Object> maps;
    private List<String> lists;

    private Dog dog;
}
