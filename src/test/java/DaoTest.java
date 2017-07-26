import DAO.Entity.Article;
import DAO.Entity.User;
import DAO.Mapper.ArticleMapper;
import DAO.Mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by p on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class DaoTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleMapper articleMapper;
    @Test
    public void name() throws Exception {

        List<Article> a = articleMapper.getArticlesByEmail("xxx@xx.com");
        System.out.println(a.size());
//        System.out.println(a.getArtId());
//        System.out.println(a.getArtContent());
    }
}
