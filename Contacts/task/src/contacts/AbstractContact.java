package contacts;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

public abstract class AbstractContact {
    protected boolean isPerson;
    protected LocalDateTime createdTime;
    protected LocalDateTime lastUpdateTime;

    AbstractContact(){
        createdTime = LocalDateTime.now().withSecond(0).withNano(0);
        lastUpdateTime = LocalDateTime.now().withSecond(0).withNano(0);
    }


    public abstract String toListString();
    public abstract String toSearchFormat();

    public void setLastUpdateTime(LocalDateTime lastUpdateTime){
        this.lastUpdateTime = lastUpdateTime;
    }

    public boolean isPerson(){
        return isPerson;
    }

    public String[] getFields(){

        Field[] fields = this.getClass().getDeclaredFields();
        String[] strFields = new String[fields.length];
        int n=0;
        for (Field field:
             fields) {
            strFields[n] = field.getName();
            n++;
        }
        return strFields;
    }

    public void setField(String field, String value){
        try {
            Field field1 = this.getClass().getDeclaredField(field);
            field1.setAccessible(true);
            field1.set(this, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Class getExtendedClass(){
        return this.getClass();
    }

    public String  getField(String field){
        try {
            Field field1 = this.getClass().getDeclaredField(field);
            field1.setAccessible(true);
            return (String) field1.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

}
