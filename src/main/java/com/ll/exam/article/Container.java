package com.ll.exam.article;

import com.ll.exam.annotation.Controller;
import com.ll.exam.Ut;
import com.ll.exam.article.ArticleController;
import javassist.tools.reflect.Reflection;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private static final ArticleController articleController;
    static {
        articleController = new ArticleController();
    }
    public static ArticleController getArticleController() {
        return articleController;
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
