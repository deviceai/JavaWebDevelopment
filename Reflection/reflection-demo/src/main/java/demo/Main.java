package demo;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {

        SomeClass someObject = new SomeClass();
        Class<SomeClass> someClassAsClass = (Class<SomeClass>) someObject.getClass();

        Field someField = someClassAsClass.getField("someField");
        //System.out.println(someField.getType());

        Field[] fields = someClassAsClass.getFields();
        for(Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

        System.out.println(someObject.someField);
        someField.set(someObject, 777);
        System.out.println(someObject.someField);

        //get access to private fields
        Field pField = someClassAsClass.getDeclaredField("somePrivateString");
        System.out.println(pField.getType() + " " + pField.getName());
        pField.setAccessible(true);
        pField.set(someObject, "John");
        System.out.println(someObject.getSomePrivateString());



    }
}
