package coma.Utio;

import java.io.Serializable;

/**
 * Created by zhumaer on 17/5/24.
 */
public class Result implements Serializable {//9 用来标志代码

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code; //操作代码 (1)

    private String msg;  //代码对应的东西( 成功)

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() { //获取操作代码 (1)
        return code;
    }

    public void setCode(Integer code) { //设置操作代码  (1)
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() { //输出 放入的data
        return data;
    }

    public void setData(Object data) { //放入data(null)
        this.data = data;
    }

    private Object data; //返回放入的东西   (null)

    public Result() {}

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static Result success(Object data) {  //传入一个data类型(null)
        Result result = new Result();  //创建一个自己
        result.setResultCode(ResultCode.SUCCESS);  //返回一个SUCCESS(1, "成功"), 调用了枚举类型
        result.setData(data); //传输上去(null)
        return result;//返回一个自己的   result
    }

    //如果用户名和账号不存在的情况下访问
     public static Result failure(ResultCode resultCode) {  //放入了  (20002, "账号不存在或密码错误"),
        Result result = new Result(); //new一个自己
        result.setResultCode(resultCode); //放入 (20002, "账号不存在或密码错误"),
        return result; //返回新对象
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();   //传输操作代码 (1)
        this.msg = code.message(); //传输代码对应的东西( 成功)    2. 放入(20002, "账号不存在或密码错误"),
    }
}