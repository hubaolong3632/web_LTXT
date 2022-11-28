package coma.Form;

import javax.servlet.http.Part;
import java.util.Collection;

/***
 * 所有Model层的父类用于封装
 */
public class Father {
   private Collection<Part> parts;  //对于共有的文件保存

    public Father() {
    }

    public Collection<Part> getParts() {
        return parts;
    }

    public void setParts(Collection<Part> parts) {
        this.parts = parts;
    }


}
