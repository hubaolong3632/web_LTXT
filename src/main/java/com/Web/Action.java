package com.Web;

import com.Model.Father;
import com.Model.Pzwj;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/***
 * 通过子类实现此方法用来进行spring操作
 */

public abstract class Action {
    public abstract void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
