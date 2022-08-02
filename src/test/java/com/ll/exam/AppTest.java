package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.article.Cont;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void junit_assertThat() {
        int rs = 10 + 20;

        assertThat(rs).isEqualTo(30);
    }

    @Test
    public void ioc__articleController__싱글톤() {
        ArticleController articleController1 = Cont.getArticleController();
        ArticleController articleController2 = Cont.getArticleController();

        assertThat(articleController2).isEqualTo(articleController1);
    }
}
