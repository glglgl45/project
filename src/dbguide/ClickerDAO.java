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
		String url = "jdbc:oracle:thin:@192.168.0.15:1521:orcl";	// 데이터베이스 서버 주소 및 연결 문자열
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
	public int insertUser(ClickerUserVO vo) {
		int result=0;
		String sql="insert into ClickerUserInfo(id, pwd) values(?, ?)";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
	}
	
	//로그인 - 데이터 조회
	public ClickerUserVO searchUser(String id) {
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
				vo.setPickName(rs.getString("pickname"));
				vo.setCurrentEnhance(rs.getInt("currentenhance"));
				vo.setCurrentDurability(rs.getInt("currentdurability"));
				vo.setGold(rs.getInt("gold"));
				vo.setScore(rs.getInt("score"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return vo;
	}
	
	//데이터 저장
	public int saveUser(ClickerUserVO vo) {
		int result=0;
		String sql="update ClickerUserInfo set pickname=?, gold=?, score=?, currentenhance=?, currentdurability=? where id=?";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
						
			pstmt.setString(1, vo.getPickName());
			pstmt.setInt(2, vo.getGold());
			pstmt.setInt(3, vo.getScore());
			pstmt.setInt(4, vo.getCurrentEnhance());
			pstmt.setInt(5, vo.getCurrentDurability());
			pstmt.setString(6, vo.getId());
			result=pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return  result;
	}
	
	//아이템 조회 - itemName, currentenhance로 해당 아이템의 설정 정보 조회
	public ClickerItemVO searchItem(String pickName, int enhance) {
		ClickerItemVO vo=null;
		String sql="select * from ClickerItemInfo where pickname=? and enhance=?";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, pickName);
			pstmt.setInt(2, enhance);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new ClickerItemVO();
				vo.setPickName(rs.getString("pickname"));
				vo.setPickLevel(rs.getInt("picklevel"));
				vo.setMul(rs.getInt("mul"));
				vo.setEnhance(rs.getInt("enhance"));
				vo.setAttack(rs.getInt("attack"));
				vo.setTotalDurability(rs.getInt("totaldurability"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return vo;
	}
}
