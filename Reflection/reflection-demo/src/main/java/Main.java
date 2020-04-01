import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {

        SomeClass someObject = new SomeClass();
        Class<SomeClass> someClassAsClass = (Class<SomeClass>) someObject.getClass();

        Field someField = someClassAsClass.getField("someField");
        System.out.println(someField.getType());

    }
}
