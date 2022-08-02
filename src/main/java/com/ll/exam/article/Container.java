package com.ll.exam.article;

import com.ll.exam.annotation.Controller;
import com.ll.exam.Ut;
import com.ll.exam.article.ArticleController;
import com.ll.exam.home.HomeController;
import javassist.tools.reflect.Reflection;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private static Map<Class, Object> objects;


    static {
        objects = new HashMap<>();

        objects.put(ArticleController.class, new ArticleController());
        objects.put(HomeController.class, new HomeController());
    }

    public static <T> T getObj(Class<T> cls) {
        return (T)objects.get(cls);
    }


    public static List<String> getControllerNames() {
        List<String> names = new ArrayList<>();

        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)) {
            String name = cls.getSimpleName(); // HomeController
            name = name.replace("Controller", ""); // Home
            name = Ut.str.decapitalize(name); // home

            names.add(name.replace("Controller", name));
        }

        return names;
    }
}
