package com.ll.exam.article;

import com.ll.exam.annotation.Controller;
import com.ll.exam.Ut;
import com.ll.exam.article.ArticleController;
import com.ll.exam.home.HomeController;
import javassist.tools.reflect.Reflection;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Container {
    private static final ArticleController articleController;
    private static final HomeController homeController;

    static {
        try {
            articleController = ArticleController.class.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        try {
            homeController = HomeController.class.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArticleController getArticleController() {
        return articleController;
    }

    public static HomeController getHomeController() {
        return homeController;
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
