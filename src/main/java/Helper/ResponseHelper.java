package Helper;

import DTO.Out.Error;
import DTO.Out.Response;

/**
 * Created by p on 2017/7/22.
 */
public class ResponseHelper {
    //服务器错误
    public static final Response SYSTEM_ERROR = new Response(new Error(0, "发生错误"));

    //登陆相关错误
    public static final Response NO_USER_ERROR = new Response(new Error(0, "用户不存在"));
    public static final Response PSW_ERROR = new Response(new Error(0,"密码错误"));

    //注册相关错误
    public static final Response HAVE_REGISTERED_ERROR = new Response(new Error(0,"该邮箱已被使用"));

    //Token报错
    public static final Response NO_TOKEN_ERROR = new Response(new Error(0,"缺少验证信息，请检查或重新登录"));
    public static final Response INVALIED_TOKEN_ERROR = new Response(new Error(0,"验证信息错误，请检查或重新登录"));
    public static final Response EXPIRED_DATE_ERROR = new Response(new Error(0,"验证信息失效，请检查或重新登录"));

    public static final Response UPDATE_ERROR = new Response(new Error(0, "更新失败，用户无权限"));
    public static final Response INSERT_ERROR = new Response(new Error(0, "添加失败，用户无权限"));
    public static final Response DELETE_ERROR = new Response(new Error(0, "删除失败，用户无权限"));
    public static final Response NO_ARTICLE_ERROR = new Response(new Error(0, "查找失败，没有该文章"));

}
