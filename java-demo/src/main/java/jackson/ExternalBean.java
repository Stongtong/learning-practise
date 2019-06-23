package jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExternalBean
 * @Description TODO
 * @Author tongtong
 * @Date 2019/6/14 17:43
 * @Version 1.0
 **/
public class ExternalBean {

    public String name ;
    private Map<String, String> map;

    public ExternalBean(String name) {
        this.name = name;
        this.map = new HashMap<>();
    }

    public void add(String key, String value){
        map.put(key, value);
    }

    /**
     * @Description map to normal attribute
     * @Param []
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    @JsonAnyGetter(enabled = false)
    public Map<String, String> getMap() {
        return map;
    }
}
