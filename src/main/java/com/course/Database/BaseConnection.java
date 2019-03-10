package com.course.Database;


import java.sql.Connection;
import java.sql.DriverManager;

    public class BaseConnection {
        public static Connection getConnection(){//用这个方法获取mysql的连接
            Connection conn=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");//加载驱动类
                conn=DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/mwee?useUnicode=true&characterEncoding=utf8","root","123456");//（url数据库的IP地址，user数据库用户名，password数据库密码）
            }catch(Exception e){
                e.printStackTrace();
            }
            return conn;
        }
        public static void main(String[] args){//测试数据库是否连接成功的方法
            Connection conn=BaseConnection.getConnection();
            System.out.println(conn);
        }

    }

