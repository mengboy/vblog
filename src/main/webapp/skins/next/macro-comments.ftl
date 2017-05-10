<#macro comments commentList article>
<ul class="comments" id="comments">
    <#list commentList as comment>
    <li id="${comment.commentId}" class="fn-clear">
        <img class="avatar-48" title="${comment.commentAuthor}" src="${serverPath}/images/">
        <div class="comment-body">
            <div class="fn-clear comment-meta">
                <span class="fn-left">
                    <#if "http://" == comment.commentURL!>
                    <a>${comment.commentAuthor}</a>
                    <#else>
                    <a href="${comment.commentURL!}" target="_blank">${comment.commentAuthor}</a>
                    </#if>
                    <#if comment.parentComment ??>
                    @
                    <a href="${servePath}/article/show?articleId=${article.articleId}#${comment.parentComment.commentId}"
                       onmouseover="page.showComment(this, '${comment.parentComment.commentId}', 23);"
                       onmouseout="page.hideComment('${comment.parentComment.commentId}')"
                       >${comment.parentComment.commentAuthor}</a>
                    </#if>
                    <time>${comment.commentCreated?string("yyyy-MM-dd HH:mm")}</time>
                </span>
                <#if article.articleCommentEnable == "open">
                <a class="fn-right" href="javascript:replyTo('${comment.commentId}')">${replyLabel!}</a>
                </#if>
            </div>
            <div class="comment-content post-body article-body">
                ${comment.commentText}
            </div>
        </div>
    </li>
    </#list>
</ul>
<#if article.articleCommentEnable == "open">
<div class="comment-body fn-wrap">
    <table id="commentForm" class="form">
        <tbody>
            <#if  Session.isLogin ??>

            <#else >
            <tr>
                <td>
                    <input placeholder="${commentNameLabel}" type="text" class="normalInput" id="commentName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input placeholder="${commentEmailLabel}" type="email" class="normalInput" id="commentEmail"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input placeholder="${commentURLLabel}" type="url" id="commentURL"/>
                </td>
            </tr>
            </#if>
            <tr>
                <td id="emotions">
                    <span class="em00" title="${em00Label}"></span>
                    <span class="em01" title="${em01Label}"></span>
                    <span class="em02" title="${em02Label}"></span>
                    <span class="em03" title="${em03Label}"></span>
                    <span class="em04" title="${em04Label}"></span>
                    <span class="em05" title="${em05Label}"></span>
                    <span class="em06" title="${em06Label}"></span>
                    <span class="em07" title="${em07Label}"></span>
                    <span class="em08" title="${em08Label}"></span>
                    <span class="em09" title="${em09Label}"></span>
                    <span class="em10" title="${em10Label}"></span>
                    <span class="em11" title="${em11Label}"></span>
                    <span class="em12" title="${em12Label}"></span>
                    <span class="em13" title="${em13Label}"></span>
                    <span class="em14" title="${em14Label}"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea rows="10" cols="96" id="comment"></textarea>
                </td>
            </tr>
            <#if Session.isLogin ??>

            <#else >
            <tr>
                <td>
                    <input style="width:50%" placeholder="${captchaLabel}" type="text" class="normalInput" id="commentValidate"/>
                    <img id="captcha" alt="validate" src="${servePath}/kaptcha.do" />
                </td>
            </tr>
            </#if>
            <tr>
                <td colspan="2" align="right">
                    <span class="error-msg" id="commentErrorTip"></span>
                    <button id="submitCommentButton" onclick="page.submitComment(${article.articleId});">${submmitCommentLabel!}</button>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</#if>
</#macro>

<#macro comment_script oId>
<script type="text/javascript" src="${servePath}/js/page${miniPostfix!}.js?${staticResourceVersion!}" charset="utf-8"></script>
<script type="text/javascript">
                        var page = new Page({
                            "nameTooLongLabel": "${nameTooLongLabel!}",
                            "mailCannotEmptyLabel": "${mailCannotEmptyLabel!}",
                            "mailInvalidLabel": "${mailInvalidLabel!}",
                            "commentContentCannotEmptyLabel": "${commentContentCannotEmptyLabel!}",
                            "captchaCannotEmptyLabel": "${captchaCannotEmptyLabel!}",
                            "loadingLabel": "${loadingLabel!}",
                            "oId": "${oId!}",
                            "skinDirName": "${skinDirName!}",
                            "blogHost": "${blogHost!}",
                            "randomArticles1Label": "${randomArticles1Label!}",
                            "externalRelevantArticles1Label": "${externalRelevantArticles1Label!}"
                        });
                        var addComment = function (result, state) {
                            var commentable = $("#commentForm").length === 0 ? false : true;
                            var commentHTML = '<li class="fn-clear" id="' + result.oId +
                                    '"><img class="avatar-48" title="'
                                    + result.userName + '" src="' + result.commentThumbnailURL + '"><div class="comment-body">'
                                    + '<div class="fn-clear comment-meta"><span class="fn-left">' + result.replyNameHTML;
                            if (state !== "") {
                                var commentOriginalCommentName = $("#" + page.currentCommentId).find(".comment-meta a").first().text();
                                commentHTML += '&nbsp;@&nbsp;<a href="${servePath}' + result.commentSharpURL.split("#")[0] + '#' + page.currentCommentId + '"'
                                        + 'onmouseover="page.showComment(this, \'' + page.currentCommentId + '\', 23);"'
                                        + 'onmouseout="page.hideComment(\'' + page.currentCommentId + '\')">' + commentOriginalCommentName + '</a>';
                            }

                            commentHTML += '<time>' + result.commentDate
                                    + '</time></span>';
                            if (commentable) {
                                commentHTML += '<a class="fn-right" href="javascript:replyTo(\'' + result.oId + '\');">${replyLabel!}</a>';
                            }
                            commentHTML += '</div><div class="comment-content post-body article-body">' +
                                    Util.replaceEmString($("#comment" + state).val())
                                    + '</div></div></li>';
                            return commentHTML;
                        };
                        var replyTo = function (id) {
                            var commentFormHTML = "<table class='form comment-reply' id='replyForm'>";
                            page.addReplyForm(id, commentFormHTML);
                        };
                        (function () {
                            page.load();
                            NexT.initArticle();
                            // emotions
                            page.replaceCommentsEm("#comments .comment-content");
                            <#nested>
                        })();
</script>
</#macro>