package Controller;

import DAO.Mapper.ArticleMapper;
import DAO.Mapper.StarMapper;
import DAO.Mapper.TypeMapper;
import DTO.In.UserModifyInfo;
import DTO.Out.Error;
import DTO.Out.Response;
import DTO.Out.UserInfo;
import DAO.Entity.User;
import DAO.Mapper.UserMapper;
import Helper.MD5Util;
import Helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by p on 2017/7/23.
 */

@RestController
@RequestMapping("/set")
@CrossOrigin
public class ModifyUserInfoController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private StarMapper starMapper;
    /**
     * 修改用户信息
     * @param info 用户传入数据
     * @return 响应
     */
    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.POST)
    public Response modifyUserInfo(@RequestBody UserModifyInfo info){
        try{
            String userEmail = String.valueOf(request.getAttribute("email"));
            System.out.println(userEmail);
            User user1 = userMapper.findByEmail(userEmail);
            if (user1.getPassword().equals(MD5Util.md5Encode(info.getOldPassword()))){
                user1.setUserName(info.getUserName());
                user1.setPassword(MD5Util.md5Encode(info.getNewPassword()));
                user1.setAvatar(info.getAvatar());
                user1.setIntro(info.getIntro());
                user1.setMale(info.isIsMale());
                userMapper.updateInfo(user1);
                //修改之后的用户信息
                UserInfo res_info = new UserInfo();
                res_info.setUserName(user1.getUserName());
                res_info.setAvatar(user1.getAvatar());
                res_info.setIntro(user1.getIntro());
                res_info.setIsMale(user1.isMale()?"男":"女");
                res_info.setArtNum(articleMapper.getArtNum(userEmail));
                res_info.setTypeNum(typeMapper.getTypeNum(userEmail));
                res_info.setStars(starMapper.getStars(userEmail));
                return new Response<UserInfo>(new Error(1,"修改成功"),res_info);
            }
            else {
                return ResponseHelper.PSW_ERROR;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 得到用户信息
     * @param email 传入用户email
     * @return 响应
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Response getUserInfo(String email) {
        try {
            User user = userMapper.findByEmail(email);
            if (user == null) {
                return ResponseHelper.NO_USER_ERROR;
            }
            UserInfo info = new UserInfo();
            info.setUserName(user.getUserName());
            info.setAvatar(user.getAvatar());
            info.setIntro(user.getIntro());
            info.setIsMale(user.isMale()?"男":"女");
            info.setArtNum(articleMapper.getArtNum(email));
            info.setTypeNum(typeMapper.getTypeNum(email));
            info.setStars(starMapper.getStars(email));
            return new Response<UserInfo>(new Error(1, "获取成功"), info);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 得到当前用户信息
     * @return 响应
     */
    @RequestMapping(value = "/getMyInfo", method = RequestMethod.POST)
    public Response getMyInfo() {
        try {
            String email = String.valueOf(request.getAttribute("email"));
            User user = userMapper.findByEmail(email);
            if (user == null) {
                return ResponseHelper.NO_USER_ERROR;
            }
            UserInfo info = new UserInfo();
            info.setUserName(user.getUserName());
            info.setAvatar(user.getAvatar());
            info.setIntro(user.getIntro());
            info.setIsMale(user.isMale()?"男":"女");
            info.setArtNum(articleMapper.getArtNum(email));
            info.setTypeNum(typeMapper.getTypeNum(email));
            info.setStars(starMapper.getStars(email));
            return new Response<UserInfo>(new Error(1, "获取成功"), info);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
}
