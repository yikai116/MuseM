package Controller;

import DTO.Out.CommentResult;
import DTO.Out.Error;
import DTO.Out.Response;
import DAO.Entity.Comment;
import DAO.Mapper.CommentMapper;
import DAO.Mapper.UserMapper;
import Helper.ResponseHelper;
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
@RequestMapping("/set/Comment")
public class CommentController {
    @Autowired
    private
    CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public Response addComment(@RequestBody Comment comment) {
        try {
            String email = String.valueOf(request.getAttribute("email"));
            comment.setCmter(email);
            Calendar calendar = Calendar.getInstance();
            java.util.Date utilDate = calendar.getTime();
            //java.util.Date日期转换成转成java.sql.Date格式
            Date nowDate = new Date(utilDate.getTime());
            comment.setCreateDate(nowDate);
            commentMapper.insert(comment);
            return new Response<Comment>(new Error(1, "添加成功"),comment);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    public Response deleteComment(int cmtId) {
        try {
            Comment temp = commentMapper.selectByCmtId(cmtId);
            if (temp == null){
                return new Response(new Error(0,"没有该评论"));
            }
            commentMapper.delete(cmtId);
            return new Response<CommentResult>(new Error(1, "删除成功"),
                    new CommentResult(temp, userMapper.findByEmail(temp.getCmter()).getUserName()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
    @RequestMapping(value = "/getAllComment",method = RequestMethod.POST)
    @ResponseBody
    public Response getAllComment(int artId){
        try {
            List<Comment> list = commentMapper.getAllByArtId(artId);
            List<CommentResult> listResult = new ArrayList<CommentResult>();
            for (Comment comment:list){
                listResult.add(new CommentResult(comment, userMapper.findByEmail(comment.getCmter()).getUserName()));
            }
            return new Response<List<CommentResult>>(new Error(1, "查找成功"),listResult);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.SYSTEM_ERROR;
        }
    }
}
