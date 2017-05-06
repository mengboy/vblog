package com.vector.blog.model;

/**
 * Created by vector on 2017/4/16.
 */
public class Statistic {
    /**
     * 文章数量
     * 浏览量
     * 评论数量
     */
    private int statisticPublishedBlogArticleCount;
    private int statisticBlogViewCount;
    private int statisticPublishedBlogCommentCount;

    public Statistic(int statisticPublishedBlogArticleCount, int statisticBlogViewCount, int statisticPublishedBlogCommentCount) {
        this.statisticPublishedBlogArticleCount = statisticPublishedBlogArticleCount;
        this.statisticBlogViewCount = statisticBlogViewCount;
        this.statisticPublishedBlogCommentCount = statisticPublishedBlogCommentCount;
    }

    public Statistic() {
    }

    public int getStatisticPublishedBlogArticleCount() {
        return statisticPublishedBlogArticleCount;
    }

    public void setStatisticPublishedBlogArticleCount(int statisticPublishedBlogArticleCount) {
        this.statisticPublishedBlogArticleCount = statisticPublishedBlogArticleCount;
    }

    public int getStatisticBlogViewCount() {
        return statisticBlogViewCount;
    }

    public void setStatisticBlogViewCount(int statisticBlogViewCount) {
        this.statisticBlogViewCount = statisticBlogViewCount;
    }

    public int getStatisticPublishedBlogCommentCount() {
        return statisticPublishedBlogCommentCount;
    }

    public void setStatisticPublishedBlogCommentCount(int statisticPublishedBlogCommentCount) {
        this.statisticPublishedBlogCommentCount = statisticPublishedBlogCommentCount;
    }
}
