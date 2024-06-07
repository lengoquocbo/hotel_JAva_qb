package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ThanhToanDAO {
//MATHANHTOAN, MADP, NGAYGIOTT, TONGCHIPHI.
	public boolean themthongtinthanhtoan(String mathanhtoan, String madp, LocalDateTime ngaygiott, int tongchiphi, Connection connect) throws SQLException {
	    
	    // Kiểm tra kết nối
	    if (connect == null || connect.isClosed()) {
	        // Trả về false nếu không có kết nối
	        return false;
	    }
	    
	    // Chuẩn bị câu lệnh SQL để thêm dữ liệu
	    String sql = "INSERT INTO THANHTOAN (MATHANHTOAN, MADP, NGAYGIOTT, TONGCHIPHI) VALUES (?, ?, ?, ?)";
	    
	    try (PreparedStatement statement = connect.prepareStatement(sql)) {
	        // Thiết lập giá trị cho các tham số
	        statement.setString(1, mathanhtoan);
	        statement.setString(2, madp);
	        statement.setObject(3, ngaygiott);
	        statement.setInt(4, tongchiphi);
	        
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
