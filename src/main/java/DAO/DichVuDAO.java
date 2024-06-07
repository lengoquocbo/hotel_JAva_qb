package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DichVuDAO {
// MADV, TENDV, GIACA
	public boolean themthongtindichvu(String madv, String tendv, int giaca, Connection connect) throws SQLException {
	    
	    // Kiểm tra kết nối
	    if (connect == null || connect.isClosed()) {
	        // Trả về false nếu không có kết nối
	        return false;
	    }
	    
	    // Chuẩn bị câu lệnh SQL để thêm dữ liệu
	    String sql = "INSERT INTO DICHVU (MADV, TENDV, GIACA) VALUES (?, ?, ?)";
	    
	    try (PreparedStatement statement = connect.prepareStatement(sql)) {
	        // Thiết lập giá trị cho các tham số
	        statement.setString(1, madv);
	        statement.setString(2, tendv);
	      
	        statement.setInt(3, giaca);
	        
	        // Thực thi câu lệnh SQL
	        int rowsInserted = statement.executeUpdate();
	        
	        // Kiểm tra xem có dữ liệu được thêm hay không
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        // Xử lý ngoại lệ nếu có
	        e.printStackTrace();
	        return false;
	    }
	}
}
