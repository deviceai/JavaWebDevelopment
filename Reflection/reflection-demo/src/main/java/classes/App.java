package classes;

import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // make instance as usual
        //Human human = new Human();


        // make instance with reflection

        Scanner scanner = new Scanner(System.in);   //classes.Human
       // String className = scanner.next();
        //Class aClass = Class.forName(className);

        Class aClass = Class.forName("classes.Human");

        Field[] fields = aClass.getFields();
        for(Field field : fields){
            System.out.println(field.getName());  //prints fields in Human
        }

       // Object object = aClass.newInstance();  //create object if in class presents default constructor
        //System.out.println(object);

        Class types[] = new Class[fields.length];

        for (int i = 0; i < types.length; i++) {
            types[i] = fields[i].getType();
        }

        Constructor constructor = aClass.getDeclaredConstructor(types);

        for (Class parameterType : constructor.getParameterTypes()) {
            System.out.print(parameterType.getName() + " ");
        }


        Integer intValue = 0;
        String stingValue = "";
        for (int i = 0; i < types.length; i++) {
            if (types[i].getName().equals("int")) {
                intValue = scanner.nextInt();
            } else if (types[i].getName().equals("java.lang.String")) {
                stingValue = scanner.next();
            }
        }
        Object arguments[] = {intValue, stingValue};
        Object object = constructor.newInstance(arguments);
        System.out.println(object);


    }
}
