package ReflectionAndAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class reflectionClass = Reflection.class;

        Arrays.stream(reflectionClass.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(String.format("%s must be private!", f.getName())));

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be public!", m.getName())));

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set"))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be private!", m.getName())));
    }
}