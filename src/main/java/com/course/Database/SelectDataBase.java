package com.course.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.course.model.bindingWithShopTypeCase;


import java.sql.SQLException;
import java.util.ArrayList;

public class SelectDataBase {


    public ArrayList<bindingWithShopTypeCase> getList(){/**单表查询*/

        ArrayList<bindingWithShopTypeCase> arrayList =
                new ArrayList<bindingWithShopTypeCase>();/**存储从数据库中取出来的数据*/
        Connection conn = BaseConnection.getConnection();  /**获取数据库连接,并创建数据库*/

        //sql执行器
        PreparedStatement preparedStatement = null;

        //对象结果采集
        ResultSet resultSet = null;//查询出来的数据先放到resultSet中

        try {
            String sql = "select * from bindingWithShop where deviceId = 0";

            preparedStatement = conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();//执行数据库查询的方法，放到resultSet中

            while (resultSet.next()){//resultSet对象相当于一个指针，指向数据库的一横行数据
                bindingWithShopTypeCase BWSTC = new bindingWithShopTypeCase();//封装数据
                BWSTC.setDeviceId(resultSet.getInt("deviceId"));//resultSet指针指向deviceId一行获取deviceId一行数据，存储到BWSTC中
                BWSTC.setShopType(resultSet.getInt("shopType"));//resultSet指针指向shopType一行获取shopType一行数据，存储到BWSTC中
                System.out.println("查询成功");
                arrayList.add(BWSTC);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {//重点下面代码必须写，当数据库使用后必须关闭，如果没有关闭数据库的接口有限，下次就不能连接
            try {

                if(resultSet!=null){ resultSet.close();}
                if(preparedStatement!=null){preparedStatement.close();}
                if(conn!=null){conn.close();}

                }catch (Exception e2){
                e2.printStackTrace();
            }

        }
        return arrayList;//返回arrayList
    }
    public static void main(String[] args){
        ArrayList<bindingWithShopTypeCase> arrayList = new SelectDataBase().getList();
        for (bindingWithShopTypeCase BWSTC:arrayList){
            System.out.println(BWSTC.getDeviceId()+"    "+BWSTC.getShopType());
        }
    }

}

















