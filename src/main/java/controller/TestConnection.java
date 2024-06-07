package controller;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection connection = connectdatabase.getConnection();
        if (connection != null) {
            System.out.println("Kết nối thành công đến cơ sở dữ liệu MySQL!");
            connectdatabase.closeConnection(connection);
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu MySQL.");
        }
    }
}