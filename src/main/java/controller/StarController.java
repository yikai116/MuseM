package controller;

import dto.Out.Error;
import dto.Out.Response;
import entity.User;
import dao.StarMapper;
import dao.UserMapper;
import helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by p on 2017/7/24.
 */
@RestController
@RequestMapping(value = "/set/Star")
public class StarController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StarMapper starMapper;

    /**
     * 关注
     * @param friendEmail 被关注人的email
     * @return 响应
     */
    @RequestMapping(value = "/star", method = RequestMethod.POST)
    public Response star(String friendEmail){
        try {
            System.out.println(friendEmail);
            String hostEmail = String.valueOf(request.getAttribute("email"));
            User user = userMapper.findByEmail(friendEmail);
            if (user == null){
                return ResponseHelper.NO_USER_ERROR;
            }
            if (starMapper.find(hostEmail,friendEmail) == 1){
                return new Response(new Error(0,"已关注"));
            }
            starMapper.insert(hostEmail,friendEmail);
            return new Response(new Error(1,"关注成功"));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 取关
     * @param friendEmail 被取消关注的用户email
     * @return 响应
     */
    @RequestMapping(value = "/unstar", method = RequestMethod.POST)
    public Response unStar(String friendEmail){
        try {
            String hostEmail = String.valueOf(request.getAttribute("email"));
            User user = userMapper.findByEmail(friendEmail);
            if (user == null) {
                return ResponseHelper.NO_USER_ERROR;
            }
            starMapper.delete(hostEmail,friendEmail);
            return new Response(new Error(1,"取关成功"));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 判断是否关注
     * @param friendEmail 被判断的用户email
     * @return 响应
     */
    @RequestMapping(value = "/isStar", method = RequestMethod.POST)
    public Response isStar(String friendEmail){
        try {
            String hostEmail = String.valueOf(request.getAttribute("email"));
            User user = userMapper.findByEmail(friendEmail);
            if (user == null){
                return ResponseHelper.NO_USER_ERROR;
            }
            if (starMapper.find(hostEmail,friendEmail) == 1)
                return new Response<Boolean>(new Error(1, "已关注"), true);
            return new Response<Boolean>(new Error(1,"未关注"),false);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
}
