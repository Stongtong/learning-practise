import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.jdbc.JdbcDataContext;
import org.apache.metamodel.json.JsonDataContext;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Table;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/24 20:22
 * @Version 1.0
 **/
public class JDBCMetamodelDemoTest {

    private static Connection connection;

    static {
        try {
//            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "000000";
            //2.获取与数据库的链接
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void postgresJdbcTest() {
        JdbcDataContext context = new JdbcDataContext(connection);
//        new JdbcMetadataLoader(context, true, "");
//        DataSet rows = context.executeQuery("select name, age from student");
        String[] catalogNames = context.getCatalogNames();
        for (String name : catalogNames) {
            System.out.println(name);
        }
        DataSet rows = context.executeQuery("select \"pg_cast\".\"castsource\", \"pg_cast\".\"castfunc\" from \"pg_catalog\".\"pg_cast\"");
        while (rows.next()){
////            Row row = rows.getRow();
////            List<SelectItem> selectItems = row.getSelectItems();
////            for (SelectItem selectItem : selectItems) {
////                System.out.println(selectItem.getColumn().getName());
////            }
            System.out.println(rows.toString());
        }
//        Table table = context.getDefaultSchema().getTable(0);
//        System.out.println(table.getSchema().getName());
//        DataSet dataSet = context.query().from(table).select("id", "name").where("id").gt(1000).execute();
//        while (dataSet.next()) {
//            Number id = (Number) dataSet.getRow().getValue(0);
//            String name = (String) dataSet.getRow().getValue(1);
//            System.out.println("id is " + id + ",name is " + name);
//        }
//        dataSet.close();
    }
}
