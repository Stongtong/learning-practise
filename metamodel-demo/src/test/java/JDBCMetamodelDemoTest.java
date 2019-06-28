import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.data.Style;
import org.apache.metamodel.jdbc.JdbcDataContext;
import org.apache.metamodel.json.JsonDataContext;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/24 20:22
 * @Version 1.0
 **/
public class JDBCMetamodelDemoTest {

    private Connection connection;

    private JdbcDataContext context;

    @Test
    void testJdbc() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("");
        ResultSet resultSet = ps.executeQuery();
        String parentMetaCodeName = "rolname";
        String metaCodeName = "rolname";
        String[] valueNames = null;
        List<Object> valueList = new ArrayList<>();
        Arrays.stream(valueNames).forEach(column -> {
            try {
                valueList.add(resultSet.getObject(column));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Object parentMetaValue = resultSet.getObject(parentMetaCodeName);
        Object metaCodeValue = resultSet.getObject(metaCodeName);
        Object[] values = valueList.toArray();
    }

    @BeforeEach
    public void setup() throws SQLException, ClassNotFoundException {
//        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "000000";
        //2.获取与数据库的链接
        connection = DriverManager.getConnection(url, username, password);
        context = new JdbcDataContext(connection);
    }

    @AfterEach
    public void close() {
        context.close(connection);
    }

    @Test
    void getSchemaNames() {
        List<String> names = context.getSchemaNames();
        names.forEach(System.out::println);
    }

    @Test
    void getDefaultSchemaName() {
        System.out.println(context.getDefaultSchemaName());
    }

    @Test
    void getCatalogNames() {
        Arrays.asList(context.getCatalogNames()).stream().forEach(System.out::println);
    }

    private void print(DataSet rows) {
        rows.forEach(row -> {
            Object[] values = row.getValues();
            Arrays.asList(values).forEach(value -> System.out.print(value + "\t"));
            System.out.println();
        });
    }

    @Test
    void getPublicCustomTable() {
        DataSet rows = context.executeQuery("select name, age from student");
        print(rows);
    }

    @Test
    void getSystemMetaTable() {
        // not pass : no capable of
        DataSet rows = context.executeQuery("select spcname from pg_catalog.pg_tablespace");
        print(rows);
    }

    @Test
    void customSchemaCustomTable() {
        DataSet rows = context.executeQuery("select id, name from new_schema.student");
        print(rows);
    }
}
