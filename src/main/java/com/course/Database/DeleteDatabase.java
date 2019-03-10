package com.course.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDatabase {
    public void delete(int id) {//删除数据库中的数据
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from bindingWithShop where id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int a = ps.executeUpdate();
            if (a > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) { ps.close(); }
                if (conn != null) { conn.close(); }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

