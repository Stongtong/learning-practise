package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/**
 * @ClassName AnnotationTest
 * @Description 对jackson的annotation进行测试
 * @Author tongtong
 * @Date 2019/6/14 17:38
 * @Version 1.0
 **/
public class AnnotationTest {

    @Test
    void testJsonAnyGetter() throws JsonProcessingException {
        ExternalBean myBean = new ExternalBean("my bean");
        myBean.add("attr1", "value1");
        myBean.add("attr2", "value2");
        String json = new ObjectMapper().writeValueAsString(myBean);
        System.out.println(json);
    }
}
