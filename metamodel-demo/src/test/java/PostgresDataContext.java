import org.apache.metamodel.ConnectionException;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.MetaModelException;
import org.apache.metamodel.QueryPostprocessDataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.factory.AbstractDataContextFactory;
import org.apache.metamodel.factory.DataContextProperties;
import org.apache.metamodel.factory.ResourceFactoryRegistry;
import org.apache.metamodel.factory.UnsupportedDataContextPropertiesException;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

import java.util.List;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/24 19:44
 * @Version 1.0
 **/
public class PostgresDataContext extends AbstractDataContextFactory {

    public DataContext create(DataContextProperties contextProperties, ResourceFactoryRegistry
            resourceFactoryRegistry) throws UnsupportedDataContextPropertiesException, ConnectionException {
        return new QueryPostprocessDataContext(){
            protected Schema getMainSchema() throws MetaModelException {
                return null;
            }

            protected String getMainSchemaName() throws MetaModelException {
                return null;
            }

            protected DataSet materializeMainSchemaTable(Table table, List<Column> columns, int maxRows) {
                return null;
            }
        };
    }

    protected String getType() {
        return null;
    }

}
