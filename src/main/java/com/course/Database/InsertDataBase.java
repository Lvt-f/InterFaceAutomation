package com.course.Database;

import com.course.model.bindingWithShopTypeCase;
//import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataBase {
    //该方法负责将传递过来的bindingWithShop对象中的数据存入到数据库中
    public void insert(bindingWithShopTypeCase bWST){
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps=null;
        String sql = "insert into bindingWithShop(deviceId,shopType)"+
                "values(' "+bWST.getDeviceId()+"','"+bWST.getShopType()+"')";

        try {

            ps=conn.prepareStatement(sql);//把写好的sql语句传递到数据库，让数据库知道我们要干什么

            int a = ps.executeUpdate();//这个方法用于改变数据库数据，a代表改变数据库的条数

            if(a>0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }try{

            if(ps!=null){ ps.close();}
            if(conn!=null){conn.close();}

        }catch(Exception e2){
            e2.printStackTrace();
        }
    }
    public static void main(String[] args){
        bindingWithShopTypeCase b=new bindingWithShopTypeCase();
        InsertDataBase insertDataBase = new InsertDataBase();
        b.setShopType(22);
        b.setDeviceId(0);
        insertDataBase.insert(b);
    }
}

