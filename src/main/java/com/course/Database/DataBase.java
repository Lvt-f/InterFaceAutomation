package com.course.Database;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;



/**
 * 1.JDBC的介绍
 *       1）一种执行SQL语言的Java API
 *       2）可以对所以主流数据库进行统一访问（access，MySQL，sql server，Oracle）
 *       3）极大地减少了程序操作数据库的复杂性
 *       4）jdbc使用面向对象的方式操作数据，能更好的和Java语言衔接
 *       5）jdbc可以直接调用数据库存储过程
 *       6）jdbc操作数据库的效率很高
 *       7）学会了jdbc，什么数据库存取数据都会了
 *       8）但是唯一的缺点就是不安全，因为你会把数据库的用户名和密码写入代码里，别人可以反编译便可以获取你的数据库信息，所以看你怎么衡量吧
 * **/
/**
 * 2.连接数据库工具类的实现
 *      1）在IDE中建立项目
 *            创建包com jdbc.bean（实体类包），com jdbc.dao（操作数据库的方法），com jdbc.main（实际操作方法），com jdbc.util（工具类包）
 *      2）导入MySQL连接jar包到项目中（jar包下载地址：http://dev.mysql.com/downloads/file/?id=462850）
 *      3）利用导入的jar包完成连接数据库的工具类
 *      4）connection对象的讲解和使用
 *             在com jdbc.util包下，创建一个类BaseConnection，它的作用是连接数据库 ，写上以下代码
 *
 * */

public class DataBase {
    public static Connection getConnection(){
        //用这个方法获取mysql的连接
        Connection conn=null;
        try{
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //（url数据库的IP地址，user数据库用户名，password数据库密码）
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/course?useUnicode=true&characterEncoding=utf8","root","123456");
            Statement stat = conn.createStatement();

            //创建数据库mwee
            stat.executeUpdate("create database mwee");
            System.out.println("成功");

            //打开创建的数据库
            stat.close();
            conn.close();
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mwee?useUnicode=true&characterEncoding=utf8","root","123456");
            stat = conn.createStatement();

            //创建表bindingWithShopType
            stat.executeUpdate("create table bindingWithShop(deviceId int, shopType int)");
            stat.executeUpdate("create table dataCase(fsseed varchar(30), fsshopguid varchar(30),fsshopstauts varchar(30),fstoken varchar(30),fsupdatetime varchar(30))");

            //添加数
            stat.executeUpdate("insert into bindingWithShop values(1, 1)");
            stat.executeUpdate("insert into dataCase values(2, 1,2,3,4)");

            //查询数据
            ResultSet result = stat.executeQuery("select * from bindingWithShop");

            while (result.next())
            {
                System.out.println(result.getInt("deviceId") + " " + result.getInt("shopType"));

            }

            //关闭数据库
            result.close();
            stat.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args){//测试数据库是否连接成功的方法
        Connection conn= DataBase.getConnection();
        System.out.println(conn);
    }


}
