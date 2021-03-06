<#include "macro-head.ftl">
<#include "macro-comments.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="${article.articleTitle} - ${blogTitle}">
        <#--<meta name="keywords" content="${article.articleTags!}" />-->
        <meta name="description" content="${article.articleSummary?html}" />
        </@head>
        <#if previousArticlePermalink??>
            <link rel="prev" title="${previousArticleTitle}" href="${servePath}${previousArticlePermalink}">
        </#if>
        <#if nextArticlePermalink??>
            <link rel="next" title="${nextArticleTitle}" href="${servePath}${nextArticlePermalink}">
        </#if>
    </head>
    <body>
        <#include "header.ftl">
        <main class="main wrapper">
            <div class="content">
                <article class="posts-expand">
                    <header class="post-header">
                        <h1 class="post-title">
                            ${article.articleTitle}
                            <#if article.articlePutTop ??>
                            <sup>
                                ${topArticleLabel}
                            </sup>
                            </#if>
                            <#if article.hasUpdated ??>
                            <sup>
                                ${updatedLabel}
                            </sup>
                            </#if>
                        </h1>
                        <div class="post-meta">
                            <span class="post-time">
                                ${postTimeLabel}
                                <time>
                                    ${article.articleCreated?string("yyyy-MM-dd")}
                                </time>
                            </span>
                            <span class="post-comments-count">
                                &nbsp; | &nbsp;
                                <a href="${servePath}${article.articlePermalink!}#comments">
                                    ${article.commentCount !} ${cmtLabel}</a>
                            </span>
                            &nbsp; | &nbsp; ${viewsLabel}
                            ${article.articleView}°C
                        </div>
                    </header>

                    <div class="post-body article-body">
                        ${article.articleText}
                        <#--<#if "" != article.articleSign.signHTML?trim>-->
                        <#--<div>-->
                            <#--${article.articleSign.signHTML}-->
                        <#--</div>-->
                        <#--</#if>-->
                    </div>
                    <footer>
                        <div class="post-tags">
                            <#if article.articleTags ??>
                            <#list article.articleTags as articleTag>
                            <a rel="tag" href="${servePath}/tags/?tagId=${articleTag.taxId}">
                                ${articleTag.taxTitle}</a>
                            </#list>
                            </#if>
                        </div>
                        <div class="post-nav fn-clear">
                            <#if previousArticleId ??>
                            <div class="post-nav-prev post-nav-item fn-right">
                                <a href="${servePath}/article/show?articleId=${previousArticleId}" rel="prev" title="${previousArticleTitle}">
                                    ${previousArticleTitle} >
                                </a>
                            </div>
                            </#if>
                            <#if nextArticlePermaId ??>
                            <div class="post-nav-next post-nav-item fn-left">
                                <a href="${servePath}/article/show?articleId=${nextArticlePermaId}" rel="next" title="${nextArticleTitle}">
                                   < ${nextArticleTitle} 
                                </a>
                            </div>
                            </#if>
                        </div>
                    </footer>
                </article>
            </div>
            <@comments commentList=articleComments article=article></@comments>
            <div id="externalRelevantArticles"></div>
            <#include "side.ftl">
        </main>
        <#include "footer.ftl">
        <@comment_script oId=article.articleId>
        <#--page.tips.externalRelevantArticlesDisplayCount = "${externalRelevantArticlesDisplayCount!}";-->
        <#--<#if 0 != externalRelevantArticlesDisplayCount>-->
        <#--page.loadExternalRelevantArticles("-->
            <#--<#list article.articleTags?split(",") as articleTag>-->
            <#--${articleTag}-->
                <#--<#if articleTag_has_next>,-->
                <#--</#if>-->
            <#--</#list>");-->
        <#--</#if>-->
        </@comment_script>
    </body>
</html>
