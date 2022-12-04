package coma.Utio;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Utio {
    public static String JSON(Result obj){ //传输json格式
        String json = JSON.toJSONString(obj); //序列化
        return json;
    }


//    public static boolean HTMLJSONResult(HttpServletResponse resp,ResultCode success,Object obj){
//        try {
//             resp.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型
//              resp.getWriter().println(Utio.JSON(Result.failure(success,obj)));
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
}
