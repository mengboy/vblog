<div class="sidebar-toggle">
    <span class="sidebar-toggle-line sidebar-toggle-line-first"></span>
    <span class="sidebar-toggle-line sidebar-toggle-line-middle"></span>
    <span class="sidebar-toggle-line sidebar-toggle-line-last"></span>
</div>

<aside class="sidebar">
    <section>
        <img class="site-author-image" src="${adminUser.userAvatar}" title="${userName}"/>
        <p class="site-author-name">${userName}</p>
        <#if "" != noticeBoard>
        <p class="site-description motion-element">${blogSubtitle}</p>
        </#if>
        <nav>
            <div class="site-state-item">
                <a href="${serverPath}/archives.html">
                    <span class="site-state-item-count">${statistic.statisticPublishedBlogArticleCount}</span>
                    <span class="site-state-item-name">${articleLabel}</span>
                </a>
            </div>

            <div class="site-state-item site-state-categories">
                <span class="site-state-item-count">${statistic.statisticBlogViewCount}</span>
                <span class="site-state-item-name">${viewLabel}</span>
            </div>

            <div class="site-state-item site-state-tags">
                <a href="${serverPath}/dynamic.html">
                    <span class="site-state-item-count">${statistic.statisticPublishedBlogCommentCount}</span>
                    <span class="site-state-item-name">${commentLabel}</span>
                </a>
            </div>
        </nav>

        <div class="feed-link">
            <a href="${serverPath}/blog-articles-rss.do" rel="alternate">
                <i class="icon-rss"></i>
                RSS
            </a>
        </div>

        <div class="links-of-author">
            <#if Session.isLogin ??>
            <span class="links-of-author-item">
                <a href="${serverPath}/admin-index.do#main" title="${adminLabel}">
                    <i class="icon-setting"></i> ${adminLabel}
                </a>
            </span>

            <span class="links-of-author-item">
                <a href="${serverPath}/admin/logout">
                    <i class="icon-logout"></i> ${logoutLabel}
                </a>
            </span>
            <#else>
            <span class="links-of-author-item">
                <a href="${serverPath}/admin/login_page">
                    <i class="icon-login"></i> ${loginLabel}
                </a>
            </span>

            <span class="links-of-author-item">
                <a href="${serverPath}/register">
                    <i class="icon-register"></i> ${registerLabel}
                </a>
            </span>
            </#if> 
        </div>

        <#--?? 判断noticeBoard是否存在-->
        <#if noticeBoard??>
        <div class="links-of-author">
            ${noticeBoard}
        </div>
        </#if>

        <#if 0 != links?size>
        <div class="links-of-author">
            <p class="site-author-name">Links</p>
            <#list links as link>
            <span class="links-of-author-item">
                <a rel="friend" href="${link.linkAddress}" 
                   title="${link.linkDescription}" target="_blank">
                    ${link.linkTitle}
                </a>
            </span>
            </#list>
        </div>
        </#if>
    </section>
</aside>