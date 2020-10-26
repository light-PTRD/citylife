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

@WebServlet(name = "AddInfoServlet",urlPatterns = "/addInfoServlet")
public class AddInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收参数
        String infoType=req.getParameter("infoType");
        String infoTitle = req.getParameter("infoTitle");
        String inContent = req.getParameter("infoContent");
        String infoPhone = req.getParameter("infoPhone");
        String infoLinkMan = req.getParameter("infoLinkMan");
        String infoEmail = req.getParameter("infoEmail");
        //封装参数值
        Info info=new Info();
        info.setInfoType(Integer.parseInt(infoType));
        info.setLinkMan(infoLinkMan);
        info.setInfoPhone(infoPhone);
        info.setInfoTitle(infoTitle);
        info.setInfoContent(inContent);
        info.setInfoEmail(infoEmail);
        //给其它字段封装值
        info.setInfoState("0");
        info.setInfoPayFor(0);
        //调用InfoDao 的addInfo(Info info)
        InfoDao infoDao=new InfoDao();
        int row=infoDao.addInfo(info);

        if (row>0){
            //成功跳到default.jsp页面
            //重定向
            resp.sendRedirect("view/indextemp.jsp");
            /*List<Info> list=infoDao.getAllInfos();
            req.setAttribute("infoList",list);
            req.getRequestDispatcher("view/default.jsp").forward(req,resp);*/
            //req.getRequestDispatcher("view/indextemp.jsp").forward(req,resp);

        }else {
            //出错就跳到错误页面
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }

    }
}
