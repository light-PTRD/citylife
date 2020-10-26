package dao;

import pojo.Info;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InfoDao {
    //查询tb_info和tb_type的信息封装到对象中
    public List<Info> getAllInfos(){
        List<Info> list=new ArrayList<>();
        Connection conn = DBUtil.getConn();
        /**
         * 在两张表存在外键关联的情况下，如果关联的字段名一样，可以使用表面.字段名或者使用表的别名
         */
        //String sql="select * from tb_info,tb_type where info_type=type_sign";
        String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type=b.type_sign;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                int id=r.getInt("id");
                int info_type=r.getInt("info_type");
                String info_title = r.getString("info_title");
                String info_linkman = r.getString("info_linkman");
                String info_phone = r.getString("info_phone");
                Date info_date = r.getDate("info_date");
                String info_state = r.getString("info_state");
                String info_content = r.getString("info_content");
                String info_email = r.getString("info_email");
                int info_payFor = r.getInt("info_payfor");
                String type_name = r.getString("type_name");
                String type_intro = r.getString("type_intro");
                //将数据封装到对象
                Info info=new Info();
                info.setInfoContent(info_content);
                info.setInfoDate(info_date);
                info.setInfoEmail(info_email);
                info.setInfoId(id);
                info.setInfoPayFor(info_payFor);
                info.setInfoPhone(info_phone);
                info.setInfoTitle(info_title);
                info.setTypeName(type_name);
                info.setInfoState(info_state);
                info.setLinkMan(info_linkman);
                info.setTypeIntro(type_intro);
                info.setInfoType(info_type);

                list.add(info);

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
        return list;


    }

    //添加信息
    public int addInfo(Info info){
        Connection conn = DBUtil.getConn();
        int row=0;
        String sql="insert into tb_info(id,info_type,info_title,info_linkman,info_phone,info_state,info_content,info_email,info_date,info_payfor) values (null,?,?,?,?,?,?,?,now(),?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,info.getInfoType());
            ps.setString(2,info.getInfoTitle());
            ps.setString(3,info.getLinkMan());
            ps.setString(4,info.getInfoPhone());
            ps.setString(5,info.getInfoState());
            ps.setString(6,info.getInfoContent());
            ps.setString(7,info.getInfoEmail());
            ps.setInt(8,info.getInfoPayFor());
            //执行
            row=ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;

    }

    //根据id查询当前信息
    public Info findInfoById(String id){
        Connection conn = DBUtil.getConn();
        Info info=null;
        String sql="select * from tb_info a,tb_type b where a.id=? and a.info_type=b.type_sign";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ResultSet r = ps.executeQuery();
            if (r.next()){
                Integer id1=r.getInt("id");
                Integer info_type=r.getInt("info_type");
                String info_title = r.getString("info_title");
                String info_linkman = r.getString("info_linkman");
                String info_phone = r.getString("info_phone");
                Date info_date = r.getDate("info_date");
                String info_state = r.getString("info_state");
                String info_content = r.getString("info_content");
                String info_email = r.getString("info_email");
                Integer info_payfor = r.getInt("info_payfor");
                String type_intro = r.getString("type_intro");
                //将数据封装到对象
                info=new Info();
                info.setInfoContent(info_content);
                info.setInfoDate(info_date);
                info.setInfoEmail(info_email);
                info.setInfoId(id1);
                info.setInfoPayFor(info_payfor);
                info.setInfoPhone(info_phone);
                info.setInfoTitle(info_title);
                info.setTypeIntro(type_intro);
                info.setInfoState(info_state);
                info.setLinkMan(info_linkman);
                info.setInfoType(info_type);


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
        return info;


    }

    //搜索查询
    public List<Info> searchInfo(String sqlvalue,String subsql){
        Connection conn = DBUtil.getConn();
        List<Info> list=new ArrayList<>();
        String sql="select * from tb_info a,tb_type b where "+subsql+" like '%"+sqlvalue+"%' and a.info_type=b.type_sign";
     /*   if(type.equals("all")){
            //全字搜索
        }else {
            //模糊搜索
        }*/
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Integer id=r.getInt("id");
                Integer info_type=r.getInt("info_type");
                String info_title = r.getString("info_title");
                String info_linkman = r.getString("info_linkman");
                String info_phone = r.getString("info_phone");
                Date info_date = r.getDate("info_date");
                String info_state = r.getString("info_state");
                String info_content = r.getString("info_content");
                String info_email = r.getString("info_email");
                int info_payFor = r.getInt("info_payfor");
                String type_name = r.getString("type_name");
                String type_intro = r.getString("type_intro");
                //将数据封装到对象
                Info info=new Info();
                info.setInfoContent(info_content);
                info.setInfoDate(info_date);
                info.setInfoEmail(info_email);
                info.setInfoId(id);
                info.setInfoPayFor(info_payFor);
                info.setInfoPhone(info_phone);
                info.setInfoTitle(info_title);
                info.setTypeName(type_name);
                info.setInfoState(info_state);
                info.setLinkMan(info_linkman);
                info.setTypeIntro(type_intro);
                info.setInfoType(info_type);
                list.add(info);
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
        return list;

    }

    //根据id查询当前信息
    public List<Info> selectInfoById(String infoTypeId){
        Connection conn = DBUtil.getConn();
        Info info=null;
        List<Info> list=new ArrayList<>();
        String sql="select * from tb_info a,tb_type b where a.info_type=? and a.info_type=b.type_sign";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(infoTypeId));
            ResultSet r = ps.executeQuery();
            while (r.next()){
                Integer id1=r.getInt("id");
                Integer info_type=r.getInt("info_type");
                String info_title = r.getString("info_title");
                String info_linkman = r.getString("info_linkman");
                String info_phone = r.getString("info_phone");
                Date info_date = r.getDate("info_date");
                String info_state = r.getString("info_state");
                String info_content = r.getString("info_content");
                String info_email = r.getString("info_email");
                Integer info_payFor = r.getInt("info_payfor");
                String type_intro = r.getString("type_intro");
                //将数据封装到对象
                info=new Info();
                info.setInfoContent(info_content);
                info.setInfoDate(info_date);
                info.setInfoEmail(info_email);
                info.setInfoId(id1);
                info.setInfoPayFor(info_payFor);
                info.setInfoPhone(info_phone);
                info.setInfoTitle(info_title);
                info.setInfoState(info_state);
                info.setLinkMan(info_linkman);
                info.setTypeIntro(type_intro);
                info.setInfoType(info_type);
                list.add(info);

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
        return list;


    }


}
