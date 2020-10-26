package controller.admin;

import dao.InfoDao;
import pojo.Info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectInfoByIdServlet",urlPatterns = "/singleShowServlet")
public class SelectInfoByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String infoid = req.getParameter("infoid");
        //将这个infoid 传给InfoDao 的一个方法  findInfoById(){}
        InfoDao infoDao=new InfoDao();
        Info info=infoDao.findInfoById(infoid);

        req.setAttribute("info",info);
        req.getRequestDispatcher("admin/singleshow.jsp").forward(req,resp);



    }
}
