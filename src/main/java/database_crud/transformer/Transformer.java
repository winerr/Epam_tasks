package database_crud.transformer;

import database_crud.annotation.Column;
import database_crud.annotation.ID;
import database_crud.annotation.OneToOne;
import database_crud.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
//import java.sql.Date;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Transformer<T> {
    private Class<T> aClass;

    public Transformer(Class<T> aClass){
        this.aClass = aClass;
    }

    public T fromResultSetToEntity(ResultSet resultSet) throws SQLException {
        T entity = null;

        try {
            entity = aClass.getConstructor().newInstance();
            if (aClass.isAnnotationPresent(Table.class)){

                Field[] fields = aClass.getDeclaredFields();
                for (Field field : fields){
                    if (field.isAnnotationPresent(Column.class)){
                        fillColumnField(entity, field, resultSet);
                    }else if(field.isAnnotationPresent(ID.class)){
                        fillIdField(entity, field, resultSet);
                    }else if (field.isAnnotationPresent(OneToOne.class)){
                        field.setAccessible(true);
                        Class fieldType = field.getType();
                        Object myObject = fieldType.getConstructor().newInstance();
                        field.set(entity, myObject);
                        Field[] fieldsInner = fieldType.getDeclaredFields();
                        for (Field fieldInner: fieldsInner){
                            if (fieldInner.isAnnotationPresent(Column.class)){
                                fillColumnField(myObject, fieldInner, resultSet);
                            }else if(fieldInner.isAnnotationPresent(ID.class)){
                                fillIdField(myObject, fieldInner, resultSet);
                            }
                        }
                    }
                }


            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return entity;
    }

    private void fillColumnField(Object entity, Field field, ResultSet resultSet) throws SQLException, IllegalAccessException {
        Column column = (Column) field.getAnnotation(Column.class);
        String name = column.name();
        field.setAccessible(true);
        Class fieldType = field.getType();
        if(fieldType == String.class){
            field.set(entity, resultSet.getString(name));
        } else if (fieldType == Integer.class){
            field.set(entity, resultSet.getInt(name));
        } else if (fieldType == Date.class){
            field.set(entity, resultSet.getDate(name));
        }
    }

    private void fillIdField(Object entity, Field field, ResultSet resultSet) throws SQLException, IllegalAccessException {
        ID id = (ID) field.getAnnotation(ID.class);
        String name = id.name();
        field.setAccessible(true);
        field.set(entity, resultSet.getInt(name));
    }


}
