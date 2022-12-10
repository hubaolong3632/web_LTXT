package coma.Web.JSON;

import coma.Form.Father;
import coma.Form.PersonalData;
import coma.Form.Pzwj;
import coma.Model.NoModel;
import coma.Service.Main01Filter;
import coma.Utio.Result;
import coma.Utio.ResultCode;
import coma.Utio.Utio;
import coma.Web.Action;
import ljx.TextModio;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("TextJSON")
public class TextJSON extends Action {
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        try{
            resp.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型
            PersonalData data= (PersonalData) father;
            System.out.println("当前页数:"+data.getName());
            System.out.println("老师需要的模拟数据操作被调用!");

            int sum = Integer.parseInt(data.getName());
            if(sum>10000){
                resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.PARAM_IS_INVALID,new NoModel("数据过大超过了1W 请注意数据量",null)))); //打印模糊查询
                return;
            }


            List<TextModio> text=new ArrayList<>();
            for(int i=1;i<=sum;i++){
                int x=(int)(Math.random()*100); //产生随机100位随机数
                text.add(new TextModio(i,"张三"+i,x));

             }
            resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.SUCCESS,new NoModel("查询"+text.size()+"条数据成功!",text)))); //打印模糊查询

        }catch (Exception e){
            resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST,new NoModel("可能是因为传输的name错误",null)))); //打印模糊查询
        }

    }
}
