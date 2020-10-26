package controller.admin;

import dao.InfoDao;
import pojo.Info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectInfoServlet",urlPatterns = "/selectInfoServlet")
public class SelectInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String infotypeid = req.getParameter("infotypeid");
        InfoDao infoDao=new InfoDao();
        List<Info> list = infoDao.selectInfoById(infotypeid);

        req.setAttribute("infoList",list);
        req.getRequestDispatcher("view/default.jsp").forward(req,resp);



    }
}
