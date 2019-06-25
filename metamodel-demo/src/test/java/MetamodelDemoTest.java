import org.apache.metamodel.ConnectionException;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.factory.*;
import org.junit.jupiter.api.Test;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/24 18:59
 * @Version 1.0
 **/
class MetamodelDemoTest {

    @Test
    void postgresTest() {
        final DataContextPropertiesImpl properties = new DataContextPropertiesImpl();
        properties.put("type", "jdbc");
        properties.put("driver-class", "org.postgresql.Driver");
        properties.put("url", "jdbc:postgresql://localhost:5432/postgres");
        properties.put("username", "postgres");
        properties.put("password", "000000");
        properties.put("table-types", "TABLE");
        DataContextFactoryRegistry defaultInstance = DataContextFactoryRegistryImpl.getDefaultInstance();
//       defaultInstance.addFactory();
        DataContext dataContext = defaultInstance.createDataContext(properties);
        System.out.println(dataContext.getSchemaNames());
    }
}
