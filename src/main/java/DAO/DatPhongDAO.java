package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DatPhongDAO {
	// MADP, MAKH, MAPHONG, NGAYGIOVP, NGAYGIOTP, CHIPHI
	
	public boolean themthongtindatphong(String madp, String makh, String maphong, LocalDateTime ngaygiovp, LocalDateTime ngaygiotp, Connection connect) throws SQLException {
	    
	    // Kiểm tra kết nối
	    if (connect == null || connect.isClosed()) {
	        // Trả về false nếu không có kết nối
	        return false;
	    }
	    
	    // Chuẩn bị câu lệnh SQL để thêm dữ liệu
	    String sql = "INSERT INTO DATPHONG (MADP, MAKH, MAPHONG, NGAYGIOVP, NGAYGIOTP) VALUES (?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement statement = connect.prepareStatement(sql)) {
	        // Thiết lập giá trị cho các tham số
	        statement.setString(1, madp);
	        statement.setString(2, makh);
	        statement.setString(3, maphong);
	        statement.setObject(4, ngaygiovp);
	        statement.setObject(5, ngaygiotp);
	        
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
