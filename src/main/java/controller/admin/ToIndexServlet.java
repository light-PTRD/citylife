package controller.admin;


import dao.InfoDao;
import dao.JobTypeDao;
import pojo.Info;
import pojo.JobType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *点击 网站首页的按钮 跳转到首页
 */
@WebServlet("/toDefault")
public class ToIndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询tb_type表的求职信息标题 将数据绑定到default.jsp 页面
        JobTypeDao jobTypeDao=new JobTypeDao();
        List<JobType> list = jobTypeDao.findAllType();
        System.out.println(list.toString());

        InfoDao infoDao=new InfoDao();
        List<Info> infoList = infoDao.getAllInfos();

       /* for (Info info:infoList){
            System.out.println(info.toString());

        }*/
        if(infoList.size()==0){
            infoList=null;
        }
        req.setAttribute("infoList",infoList);


        req.getRequestDispatcher("view/default.jsp").forward(req,resp);
    }
}
