import com.vector.blog.service.TaxonomyService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by vector on 2017/4/25.
 */
public class test {

    @Resource
    TaxonomyService taxonomyService;

    @Test
    public void selectTaxid(){
        int t = taxonomyService.selectTagIdByTitle("linux");
        System.out.println(t);
    }
}
