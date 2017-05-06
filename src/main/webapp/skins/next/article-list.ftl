<section class="posts-expand">


    <#if queryBase.getResults() ??>
    <#list queryBase.getResults() as article>
    <article class="post-item">
        <header>
            <h1>
                <a class="post-title-link"  rel="bookmark" href="${servePath}/article/show?articleId=${article.article.articleId}">
                    ${article.article.articleTitle}
                </a>
                <#if article.article.articlePutTop ??>
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
                <span>
                    ${postTimeLabel}
                    <time>
                        ${article.article.articleCreated?string("yyyy-MM-dd")}
                    </time>
                </span>
                <span>
                    &nbsp; | &nbsp;
                    <a href="${servePath}/article/show?articleId={article.article.articleId}#comments">
                        ${article.article.commentCount !} ${cmtLabel}</a>
                </span>
                &nbsp; | &nbsp;${viewsLabel} ${article.article.articleView}°C
            </div>
        </header>
        <div class="article-body">
            ${article.article.articleSummary}
        </div>
        <div class="post-more-link">
            <a href="${servePath}/article/show?articleId=${article.article.articleId}#more" rel="contents">
                ${readLabel} &raquo;
            </a>
        </div>
    </article>
    </#list>
    </#if>


</section>

<#if 0 != queryBase.totalPage>

<nav class="pagination">
    <#if 1 !=  paginationPageNums ? first>
    <a href="${servePath}${path}/${paginationPreviousPageNum}" class="extend next"><<</a>
    <a class="page-number" href="${servePath}${path}/1">1</a> ...
    </#if>
    <#list paginationPageNums as paginationPageNum>
    <#if paginationPageNum == paginationCurrentPageNum>
    <span class="page-number current">${paginationPageNum}</span>
    <#else>
    <a class="page-number" href="${servePath}${path}/${paginationPageNum}">${paginationPageNum}</a>
    </#if>
    </#list>
    <#if paginationPageNums?last != paginationPageCount> ...
    <a href="${servePath}${path}/${paginationPageCount}" class="page-number">${paginationPageCount}</a>
    <a href="${servePath}${path}/${paginationNextPageNum}" class="extend next">>></a>
    </#if>
</nav>

</#if>