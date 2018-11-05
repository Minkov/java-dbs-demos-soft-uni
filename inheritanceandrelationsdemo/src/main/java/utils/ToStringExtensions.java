package utils;

import entities.Department;
import entities.Person;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface ToStringExtensions {
    default String toString(Class klass) {
        return Arrays.stream(klass.getDeclaredFields())
                .filter(field -> field.getType() != Department.class)
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        String name = field.getName();
                        Object value = field.get(this);
                        return name + ": " + value;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.joining("; "));
    }
}
