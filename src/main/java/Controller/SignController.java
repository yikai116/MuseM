package Controller;

import DTO.In.SignInInfo;
import DTO.In.SignUpInfo;
import DTO.Out.Error;
import DTO.Out.Response;
import DTO.Token;
import DAO.Entity.User;
import DAO.Mapper.UserMapper;
import Helper.DateHelper;
import Helper.MD5Util;
import Helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by p on 2017/7/19.
 * 与登录注册相关部分
 */
@RestController
@RequestMapping("/")
@CrossOrigin
public class SignController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param info 传入用户信息
     *             判断邮箱是否被注册
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Response signUp(@RequestBody SignUpInfo info) {
        try {
            //判断邮箱是否使用
            if (userMapper.findByEmail(info.getEmail()) != null) {
                return ResponseHelper.HAVE_REGISTERED_ERROR;
            }
            //存放数据
            User user = new User();
            user.setUserName(info.getUserName());
            user.setEmail(info.getEmail());
            user.setPassword(MD5Util.md5Encode(info.getPassword()));
            user.setIntro(info.getIntro());
            user.setMale(info.isIsMale());
            user.setExpiredDate(DateHelper.getExpiredDate(10));

            Token token = new Token(info.getEmail());
            user.setToken(token.getTokenStr());
            user.setExpiredDate(DateHelper.getExpiredDate(10));
            userMapper.insert(user);

            return new Response<Token>(new Error(1, "注册成功"), token);
        }
        //发生异常
        catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }

    /**
     * 登录
     * @param info 用户信息
     * @return 响应信息
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public Response signIn(@RequestBody SignInInfo info) {
        try {
            User user = userMapper.findByEmail(info.getEmail());
            if (user == null) {
                return ResponseHelper.NO_USER_ERROR;
            } else if (!user.getPassword().equals(MD5Util.md5Encode(info.getPassword()))) {
                return ResponseHelper.PSW_ERROR;
            } else {
                Token token = new Token(info.getEmail());
                //更新token
                userMapper.updateToken(token.getEmail(), token.getTokenStr(), DateHelper.getExpiredDate(10));
                return new Response<Token>(new Error(1, "登录成功"), token);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
}
