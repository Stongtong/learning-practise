import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.json.JsonDataContext;
import org.apache.metamodel.schema.Table;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/24 19:59
 * @Version 1.0
 **/
public class JsonMetamodelDemoTest {

    @Test
    void jsonTest() {
        JsonDataContext dc = new JsonDataContext(new File("src/test/resources/array_with_documents.json"));
        Table table = dc.getDefaultSchema().getTable(0);
        DataSet dataSet = dc.query().from(table).select("id", "name").where("id").gt(1000).execute();
        while (dataSet.next()) {
            Number id = (Number) dataSet.getRow().getValue(0);
            String name = (String) dataSet.getRow().getValue(1);
            System.out.println("id is " + id + ",name is " + name);
        }
        dataSet.close();
    }
}
