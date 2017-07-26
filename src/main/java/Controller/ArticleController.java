package Controller;

import DTO.Out.Error;
import DTO.Out.Response;
import DAO.Entity.Article;
import DAO.Mapper.ArticleMapper;
import Helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by DELL on 2017-07-24.
 */
@RestController
@RequestMapping(value = "/set/Article")
public class ArticleController {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/getArt", method = RequestMethod.POST)
    public Response getArticleById(int id) {
        try {
            System.out.println(id);
            Article a = articleMapper.getArticleById(id);
            if (a != null) {
                return new Response<Article>(new Error(1, "获取成功"), a);
            } else {
                return ResponseHelper.NO_ARTICLE_ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteArt", method = RequestMethod.POST)
    public Response deleteArticle(int id) {
        try {
            Article a = articleMapper.getArticleById(id);
            if (a == null) {
                return new Response(new Error(0, "没有该篇文章"));
            }
            articleMapper.delete(id);
            return new Response<Article>(new Error(1, "删除成功"),a);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateArt", method = RequestMethod.POST)
    public Response updateArticle(@RequestBody Article a) {
        try {
            System.out.println(a.getArtId());
            Article temp = articleMapper.getArticleById(a.getArtId());
            if (temp == null) {
                return new Response(new Error(0, "没有该篇文章"));
            }
            articleMapper.update(a);
            a.setCreateDate(temp.getCreateDate());
            a.setAuthor(temp.getAuthor());
            a.setCmtNum(temp.getCmtNum());
            return new Response<Article>(new Error(1, "更新成功"),a);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 添加文章
     * @param a
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertArt", method = RequestMethod.POST)
    public Response insertArticle(@RequestBody Article a) {
        try {
            String email = String.valueOf(request.getAttribute("email"));
            a.setAuthor(email);
            Calendar calendar = Calendar.getInstance();
            java.util.Date utilDate = calendar.getTime();
            //java.util.Date日期转换成转成java.sql.Date格式
            Date nowDate = new Date(utilDate.getTime());
            a.setCreateDate(nowDate);
            articleMapper.insert(a);
            return new Response<Article>(new Error(1, "添加成功"),a);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 得到当前用户所有文章信息
     * @return 响应
     */
    @ResponseBody
    @RequestMapping(value = "/getMyArt", method = RequestMethod.POST)
    public Response getMyArt() {
        try {
            String email = String.valueOf(request.getAttribute("email"));
            List<Article> arts = articleMapper.getArticlesByEmail(email);
            for (Article art : arts) {
                int lenth = art.getArtContent().length();
                lenth = lenth > 50 ? 50 : lenth;
                art.setArtContent(art.getArtContent().substring(0, lenth));
            }
            return new Response<List<Article>>(new Error(1, "获得成功"), arts);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 根据email得到用户文章信息
     * @param email 传入数据email
     * @return 响应
     */
    @ResponseBody
    @RequestMapping(value = "/getArtsByEmail", method = RequestMethod.POST)
    public Response getArtsByEmail(String email) {
        try {
            List<Article> arts = articleMapper.getArticlesByEmail(email);
            for (Article art : arts) {
                int lenth = art.getArtContent().length();
                lenth = lenth > 50 ? 50 : lenth;
                art.setArtContent(art.getArtContent().substring(0, lenth));
            }
            return new Response<List<Article>>(new Error(1, "获得成功"), arts);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
}
