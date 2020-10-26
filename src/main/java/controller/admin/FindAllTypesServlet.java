package controller.admin;

import dao.JobTypeDao;
import pojo.JobType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllTypesServlet",urlPatterns = "/findAllTypes")
public class FindAllTypesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobTypeDao jobTypeDao=new JobTypeDao();
        List<JobType> list = jobTypeDao.findAllType();

        req.setAttribute("list",list);
        req.getRequestDispatcher("admin/addInfo.jsp").forward(req,resp);

    }
}
