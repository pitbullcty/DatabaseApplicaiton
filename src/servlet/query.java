package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import bean.Info;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class query extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");  //设置编码格式
        String key = request.getParameter("key");
        ArrayList<Info> team_info=null;
        if (key != null) {
            key = "%" + key + "%";
            team_info = getHobbies(key);
        }
        request.getSession().setAttribute("team_info", team_info);
        response.sendRedirect("../show_info.jsp");
    }

    public ArrayList<Info> getHobbies(String key) {
        ArrayList<Info> list = new ArrayList<Info>();
        String url = "jdbc:postgresql://localhost:5432/Team";
        String name = "admin";
        String password = "";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }  //加载驱动
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, name, password);  //链接数据库
            PreparedStatement st = connection.prepareStatement("select * from team_member where hobby like ?");
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Info temp = new Info();
                temp.setHobby(rs.getString("hobby"));
                temp.setBirthday(String.valueOf(rs.getDate("birthday")));
                temp.setName(rs.getString("name"));
                temp.setNum(rs.getString("num"));
                list.add(temp);  //结果加入list中
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
