package controller;

import dto.Out.Error;
import dto.Out.Response;
import entity.Type;
import entity.User;
import dao.TypeMapper;
import dao.UserMapper;
import helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by DELL on 2017-07-24.
 */
@RestController
@RequestMapping("/set/Type")
public class TypeController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户email得到用户所有分类
     * @param email 用户email
     * @return 响应
     */
    @RequestMapping(value = "/getAllByEmail", method = RequestMethod.POST)
    public Response getAllByEmail(String email) {
        try {
            System.out.println(email);
            User user = userMapper.findByEmail(email);
            if (user == null){
                return ResponseHelper.NO_USER_ERROR;
            }
            List<Type> list = typeMapper.getType(email);
            if(!list.isEmpty())
                return new Response<List<Type>>(new Error(1, "查找成功"), list);
            else
                return new Response(new Error(0, "该用户未进行分类"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 得到当前用户的分类
     * @return 响应
     */
    @RequestMapping(value = "/getMyType", method = RequestMethod.POST)
    public Response getMyType() {
        try {
            String email = String.valueOf(request.getAttribute("email"));
            List<Type> list = typeMapper.getType(email);
            if(!list.isEmpty())
                return new Response<List<Type>>(new Error(1, "查找成功"), list);
            else
                return new Response(new Error(0, "抱歉，您还没有进行分类"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }


    /**
     * 当前用户添加分类
     * @param type 分类名字
     * @return 响应
     */
    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    public Response addType(String type) {
        System.out.println(type);
        try {
            Type t = new Type(String.valueOf(request.getAttribute("email")), type);
            if(typeMapper.isExist(t)==0){
                typeMapper.insert(t);
                return new Response<Type>(new Error(1,"添加成功"),t);
            }
            else {
                return new Response<Type>(new Error(0, "添加失败，该标签已存在"),t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 当前用户删除分类
     * @param type 分类名字
     * @return 响应
     */
    @RequestMapping(value = "/deleteType", method = RequestMethod.POST)
    public Response deleteType(String type) {
        System.out.println(type);
        try {
            Type t = new Type(String.valueOf(request.getAttribute("email")), type);
            if(typeMapper.isExist(t)==0){
                return new Response<Type>(new Error(0, "该标签不存在"),t);
            }
            else {
                typeMapper.delete(t);
                return new Response<Type>(new Error(1, "删除成功"),t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
}
