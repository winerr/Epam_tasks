package database_crud.entities.metadata;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TableMetaData {
    @Getter @Setter
    private String dataBaseName;
    @Getter @Setter
    private String tableName;
    @Getter @Setter
    private List<ColumnMetaData> columnsMetaData;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
                .append("data base name: ")
                .append(dataBaseName)
                .append('\n')
                .append("table name: ")
                .append(tableName)
                .append('\n');
        for (ColumnMetaData columnMetaData: columnsMetaData)
            result.append(columnMetaData.toString()).append('\n');
        return result.toString();
    }
}
