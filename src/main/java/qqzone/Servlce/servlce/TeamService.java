package qqzone.Servlce.servlce;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component("module")
public class TeamService {


    public void add(){
        System.out.println("执行成功");
    }
}
