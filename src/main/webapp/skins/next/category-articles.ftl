<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="${category.categoryTitle} - ${blogTitle}">
        <meta name="keywords" content="${metaKeywords},${category.categoryTitle}"/>
        <meta name="description" content="<#list articles as article>${article.articleTitle}<#if article_has_next>,</#if></#list>"/>
        </@head>
    </head>
    <body>
        <#include "header.ftl">
        <main class="main wrapper">
            <div class="content posts-collapse">
                <div class="collection-title">
                    <h2>
                        ${category.categoryTitle}
                        <small>${categoryLabel}</small>
                    </h2>
                </div>
                <#include "article-list.ftl">
            </div>
            <#include "side.ftl">
        </main>
        <#include "footer.ftl">
    </body>
</html>
