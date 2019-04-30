package ir.goldenmind.advancedandroid;

import android.util.Log;
import ir.goldenmind.advancedandroid.javaversion.imdb.Rating;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class Reflection {

    @Test
    public void checkReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Rating rating = new Rating();
        Class cls = rating.getClass();
        System.out.println("Class name:     " + cls.getName());

        Constructor constructor = cls.getConstructor();
        System.out.println("Constructor name:     " + constructor.getName());

        Method[] methods = cls.getMethods();
        for (Method method : methods){
            System.out.println("Method name:     " + method.getName());
        }

        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods){
            System.out.println("DeclaredMethod name:     " + declaredMethod.getName());
        }

        Method m1 = cls.getDeclaredMethod("getValue", String.class);
        System.out.println("getValue return type is:     " + m1.getReturnType().getName());
        System.out.println("Call getValue method:     " + m1.invoke(rating,"Hello"));

        Field[] fields =  cls.getDeclaredFields();
        for (Field field : fields){
            System.out.println("Field name:     " + field.getName());
            field.setAccessible(true);
            System.out.println("Value:     " + field.get(rating));
            field.set(rating,"AAAA");
            System.out.println("Value:     " + field.get(rating));
        }



    }
}
