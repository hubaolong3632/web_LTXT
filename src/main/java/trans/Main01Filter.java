//package Spring;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
////过滤器
//@WebFilter("/index")
//public class Main01Filter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException { //初始化
//
//    }
//
//    @Override   //服务
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("拦截第一次放行hello a-----");
//
//        //放行
//        filterChain.doFilter(servletRequest,servletResponse);
//
//        //放行之后
//        System.out.println("拦截之后传回去放行hello b----");
//    }
//
//    @Override  //销毁
//    public void destroy() {
//
//    }
//}
