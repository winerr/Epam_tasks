package database_crud.entities;

import lombok.Getter;
import lombok.Setter;

public class CompositeKey {
    @Getter @Setter
    private int emp_no;
    @Getter @Setter
    private String project_no;
}
