package com.ll.exam.article;

import javassist.tools.reflect.Reflection;

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


    }
}
