package database_crud.entities.metadata;

import lombok.Getter;
import lombok.Setter;

public class ColumnMetaData {
    @Getter @Setter
    private String columnName;
    @Getter @Setter
    private String dataType;
    @Getter @Setter
    private String columnSize;
    @Getter @Setter
    private boolean nullable;
    @Getter @Setter
    private boolean autoincrement;
    @Getter @Setter
    private boolean pk;


    @Override
    public String toString() {
        return  "column name: " + columnName + '\t' +
                "data type: " + dataType + '\t' +
                "column size: " + columnSize + '\t' +
                (nullable ? "NULL\t": "NOT NULL\t") +
                (autoincrement ? "AutoIncrement\t" : "") +
                (pk ? "PK" : "");
    }
}
