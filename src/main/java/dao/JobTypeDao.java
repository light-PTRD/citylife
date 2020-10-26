package dao;

import pojo.JobType;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobTypeDao {

    //查询所有tb_type表的所有数据
    public List<JobType> findAllType(){
        List<JobType> list=new ArrayList<>();
        Connection conn = DBUtil.getConn();
        String sql="select * from tb_type";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            //遍历结果集
            while (r.next()){
                Integer type_sign = r.getInt("TYPE_SIGN");
                String type_name = r.getString("TYPE_NAME");
                String type_intro = r.getString("TYPE_INTRO");

                //创建对象
                JobType jobType=new JobType();
                jobType.setTypeSign(type_sign);
                jobType.setTypeName(type_name);
                jobType.setTypeIntro(type_intro);
                list.add(jobType);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  list;


    }


}
