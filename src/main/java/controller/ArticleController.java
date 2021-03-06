package controller;

import entity.Type;
import entity.User;
import dao.TypeMapper;
import dao.UserMapper;
import dto.Out.*;
import entity.Article;
import dao.ArticleMapper;
import dto.Out.Error;
import helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 通过id得到文章详细信息
     * @param id 用户传入的数据
     * @return 响应
     */
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

    /**
     * 根据id删除文章
     * @param id 用户传入的数据
     * @return 响应
     */
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

    /**
     * 更新文章内容
     * @param a 用户传入的数据
     * @return 响应
     */
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
            return new Response<List<Article>>(
                    new Error(1, "获得成功"),
                    getArtHelp(email));
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
            User user = userMapper.findByEmail(email);
            if (user == null){
                return ResponseHelper.NO_USER_ERROR;
            }
            return new Response<List<Article>>(
                    new Error(1, "获得成功"),
                    getArtHelp(email));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 得到当前用户文章列表信息
     * @return 响应
     */
    @RequestMapping(value = "/getMyArtList", method = RequestMethod.POST)
    public Response getMyArtList() {
        try {
            String email = String.valueOf(request.getAttribute("email"));
            return new Response< List<TypeArt>>(
                    new Error(1,"获取成功"),
                    getListHelp(email));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 通过email得到用户文章列表
     * @param email 用户email
     * @return 响应
     */
    @RequestMapping(value = "/getArtListByEmail", method = RequestMethod.POST)
    public Response getArtListByEmail(String email) {
        try {
            User user = userMapper.findByEmail(email);
            if (user == null){
                return ResponseHelper.NO_USER_ERROR;
            }
            return new Response< List<TypeArt>>(
                    new Error(1,"获取成功"),
                    getListHelp(email));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 得到当前用户文章时间列表信息
     * @return 响应
     */
    @RequestMapping(value = "/getMyTimeList", method = RequestMethod.POST)
    public Response getMyTimeList() {
        try {
            String email = String.valueOf(request.getAttribute("email"));
            return new Response< List<YearArt>>(
                    new Error(1,"获取成功"),
                    getYearHelp(email));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 得到当前用户文章时间列表信息
     * @return 响应
     */
    @RequestMapping(value = "/getTimeListByEmail", method = RequestMethod.POST)
    public Response getTimeListByEmail(String email) {
        try {
            User user = userMapper.findByEmail(email);
            if (user == null){
                return ResponseHelper.NO_USER_ERROR;
            }
            return new Response< List<YearArt>>(
                    new Error(1,"获取成功"),
                    getYearHelp(email));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    private List<Article> getArtHelp(String email){
        List<Article> arts = articleMapper.getArticlesByEmail(email);
        for (Article art : arts) {
            int lenth = art.getArtContent().length();
            lenth = lenth > 50 ? 50 : lenth;
            art.setArtContent(art.getArtContent().substring(0, lenth));
        }
        return arts;
    }

    private List<TypeArt> getListHelp(String email){
        List<TypeArt> data = new ArrayList<TypeArt>();
        List<Type> types = typeMapper.getType(email);
        for (Type type : types) {
            List<SimArt> simArts = new ArrayList<SimArt>();
            List<Article> articles = articleMapper.getArticlesByEmailType(email,type.getType());
            for (int i = 0; i < articles.size(); i++){
                SimArt simArt = new SimArt();
                simArt.setArtId(articles.get(i).getArtId());
                simArt.setArtTitle(articles.get(i).getArtTitle());
                simArts.add(simArt);
            }
            TypeArt typeArt = new TypeArt();
            typeArt.setType(type.getType());
            typeArt.setCount(articles.size());
            typeArt.setArts(simArts);
            data.add(typeArt);
        }
        return data;
    }

    private List<YearArt> getYearHelp(String email){
        List<YearArt> data = new ArrayList<YearArt>();
        List<Article> articles = articleMapper.getArticlesByEmail(email);
        List<Integer> years = new ArrayList<Integer>();
        for (Article article : articles){
            if (!years.contains(article.getCreateDate().getYear() + 1900)){
                years.add(article.getCreateDate().getYear() + 1900);
            }
        }
        for (int i = 0; i < years.size(); i++){
            YearArt yearArt = new YearArt();
            yearArt.setYear(years.get(i));
            List<TimeArt> timeArts = new ArrayList<TimeArt>();
            for (Article article : articles){
                if (years.get(i) == (article.getCreateDate().getYear() + 1900)){
                    TimeArt timeArt = new TimeArt();
                    timeArt.setArtId(article.getArtId());
                    timeArt.setArtTitle(article.getArtTitle());
                    timeArt.setTime(article.getCreateDate());
                    int lenth = article.getArtContent().length();
                    lenth = lenth > 50 ? 50 : lenth;
                    timeArt.setArtContent(article.getArtContent().substring(0, lenth));
                    timeArts.add(timeArt);
                }
            }
            yearArt.setArts(timeArts);
            yearArt.setCount(timeArts.size());
            data.add(yearArt);
        }
        return data;
    }
}
