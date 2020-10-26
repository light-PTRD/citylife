package controller.admin;

import dao.InfoDao;
import pojo.Info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 搜错查询
 */
@WebServlet(name = "SearchInfoServlet",urlPatterns = "/searchInfoServlet")
public class SearchInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("utf-8");
        //接收参数
        String sqlvalue = req.getParameter("sqlvalue");
        String subsql = req.getParameter("subsql");
        //String type = req.getParameter("type");

        //将参数传给InfoDao 的searchInfo(sqlvalue,subsql);
        InfoDao infoDao=new InfoDao();
        List<Info> list=infoDao.searchInfo(sqlvalue,subsql);

        //将集合绑定到searchshow.jsp页面  使用session来绑定数据
        HttpSession session = req.getSession();
        session.setAttribute("list",list);
        req.getRequestDispatcher("view/searchshow.jsp").forward(req,resp);

    }
}
