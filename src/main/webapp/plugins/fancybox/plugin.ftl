<script type="text/javascript">
    (function () {
        var $groups =  $("a[rel=group]"),
        $fancybox = $(".fancybox");
        if ($groups.length > 0 || $fancybox.length > 0) {
            if (document.createStyleSheet) {
                document.createStyleSheet("${servePath}/plugins/fancybox/js/jquery.fancybox.css");
            } else {
                $("head").append($("<link rel='stylesheet' href='${servePath}/plugins/fancybox/js/jquery.fancybox.css' type='text/css' charset='utf-8' />"));
            } 
            
            $.ajax({
                url: "${servePath}/plugins/fancybox/js/jquery.fancybox.pack.js",
                dataType: "script",
                cache: true,
                complete: function() {
                    $groups.fancybox({
                        openEffect  : 'none',
                        closeEffect : 'none',
                        prevEffect : 'none',
                        nextEffect : 'none'
                    });
                    $fancybox.fancybox({
                        openEffect  : 'none',
                        closeEffect : 'none',
                        prevEffect : 'none',
                        nextEffect : 'none'
                    });
                }
            });
        }
    })();
</script>
