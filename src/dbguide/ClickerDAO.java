package dbguide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbguide.ClickerUserVO;

public class ClickerDAO {
	// 드라이버 클래스 로드
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 연결
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@192.168.31.178:1521:orcl";	// 데이터베이스 서버 주소 및 연결 문자열
		String user = "javadb";	// 허가받은 사용자 아이디
		String password = "12345";	// 비밀번호
		
		Connection con = null;
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//회원가입
	public int signUp(ClickerUserVO vo) {
		int result=0;
		String sql="insert into ClickerUserInfo(id, pwd, itemname, CurrentDurability) values(?, ?, ?, ?)";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getItemName());
			pstmt.setInt(4, vo.getCurrentDurability());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
	}
	
	//로그인
	public ClickerUserVO login(String id) {
		ClickerUserVO vo=null;
		String sql="select * from ClickerUserInfo where id=?";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new ClickerUserVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setItemName(rs.getString("itemname"));
				vo.setGold(rs.getInt("gold"));
				vo.setCurrentEnhance(rs.getInt("currentenhance"));
				vo.setCurrentDurability(rs.getInt("currentdurability"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return vo;
	}
	
	public int logout(ClickerUserVO vo) {
		int result=0;
		String sql="update ClickerUserInfo set itemname=?, gold=?, where id=?;";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
						
			pstmt.setString(1, vo.getItemName());
			pstmt.setInt(2, vo.getGold());
			pstmt.setString(3, vo.getId());
			result=pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return  result;
	}
	
	//아이템 조회
	public ClickerItemVO searchItem(String itemName) {
		ClickerItemVO vo=null;
		String sql="select * from ClickerItemInfo where itemname=?";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, itemName);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new ClickerItemVO();
				vo.setItemName(rs.getString("itemname"));	
				vo.setEnhance(rs.getInt("enhance"));
				vo.setAttack(rs.getInt("attack"));
				vo.setTotalDurability(rs.getInt("totaldurability"));
				vo.setSuccessPercent(rs.getInt("successPercent"));
				vo.setFailPercent(rs.getInt("failPercent"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
