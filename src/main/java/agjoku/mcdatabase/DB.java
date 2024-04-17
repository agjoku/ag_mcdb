package agjoku.mcdatabase;

import java.sql.*;

public class DB {

        static Connection con = null;
        static String url = "jdbc:mysql://localhost/mydb";
        static String user = "users";
        static String password = "aqsw1324asd.";

        public static Admin agDBAccess(String[] args){

            String sql = "select * from acount where name = ? and pass = ?;";

            Admin admin = new Admin();

            try {
//            Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, args[0]);
                pstmt.setString(2, args[1]);
                ResultSet rs = pstmt.executeQuery();

                if(rs.next()){
                    admin.setName(rs.getString("name"));
                    admin.setPassword(rs.getString("pass"));
                    admin.setLogin_flag(true);
                } else {
                    admin.setLogin_flag(false);
                }

                rs.close();
                pstmt.close();
                con.close();

            } catch (SQLException e) {
                System.out.println("データベースとの接続を閉じます");
                throw new RuntimeException(e);
            }
            return admin;
        }
}
