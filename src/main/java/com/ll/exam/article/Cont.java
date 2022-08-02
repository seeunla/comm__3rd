package com.ll.exam.article;

public class Cont {
    private static final ArticleController articleController;
    static {
        articleController = new ArticleController();
    }
    public static ArticleController getArticleController() {
        return articleController;
    }
}
