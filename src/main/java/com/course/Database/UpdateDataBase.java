package com.course.Database;

import com.course.model.bindingWithShopTypeCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataBase {
    //用于将传递过来的news对象中的值，根据id主键，改变数据库中的值
   public void update(bindingWithShopTypeCase bWST){
       Connection conn = BaseConnection.getConnection();
       PreparedStatement ps = null;
       String sql="update bindingWithShopType set deviceId=?,shopType=?"+
               "where id=?";
       try {
           ps = conn.prepareStatement(sql);
           ps.setInt(1,bWST.getDeviceId());
           ps.setInt(2,bWST.getShopType());
           int a=ps.executeUpdate();
           if(a>0){
               System.out.println("修改成功");
           }else{
               System.out.println("修改失败");
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }finally{
           try{
               if(ps!=null){
                   ps.close();
               }if(conn!=null){
                   conn.close();
               }
           }catch(Exception e2){
               e2.printStackTrace();
           }
       }
   }
}
