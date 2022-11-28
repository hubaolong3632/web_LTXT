package coma.Utio;

import com.alibaba.fastjson.JSON;

public class Utio {
    public static String JSON(Object obj){
        String json = JSON.toJSONString(obj); //序列化
        return json;
    }
}
