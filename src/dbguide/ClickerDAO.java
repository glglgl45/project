package dbguide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbguide.ClickerUserVO;
import lombok.AllArgsConstructor;
import system.Pickax;


public class ClickerDAO {
	
	private Pickax pick = new Pickax();
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
//		String url = "jdbc:oracle:thin:@192.168.31.178:1521:orcl";	// 데이터베이스 서버 주소 및 연결 문자열
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
		String sql="insert into ClickerUserInfo values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getPickName());
			pstmt.setInt(4, vo.getEnhance());
			pstmt.setInt(5, vo.getPickLevel());
			pstmt.setInt(6, vo.getDurability());
			pstmt.setInt(7, vo.getGold());
			pstmt.setInt(8, vo.getScore());
			pstmt.setInt(9, vo.getDamage());
			pstmt.setDouble(10, vo.getMul());
			pstmt.setInt(11, vo.getProgress());
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
				vo.setId(rs.getString("ID"));
				vo.setPwd(rs.getString("PWD"));
				vo.setPickName(rs.getString("PickName"));
				vo.setEnhance(rs.getInt("Enhance"));
				vo.setPickLevel(rs.getInt("PickLevel"));
				vo.setDurability(rs.getInt("Durability"));
				vo.setGold(rs.getInt("Gold"));
				vo.setScore(rs.getInt("Score"));
				vo.setDamage(rs.getInt("Damage"));
				vo.setMul(rs.getInt("Mul"));
				vo.setProgress(rs.getInt("Progress"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return vo;
	}
	
	//데이터 저장
	public int saveUser() {
		int result=0;
		String sql="update ClickerUserInfo set pickname=?, enhance=?, picklevel=?, durability=?, gold=?, score=?, damage=?, mul=? where id=?";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
						
			pstmt.setString(1, pick.getPickName());
			pstmt.setInt(2, pick.getLevel());
			pstmt.setInt(3, pick.getPickLevel());
			pstmt.setInt(4, pick.getDura());
			pstmt.setInt(5, pick.getMoney());
			pstmt.setInt(6, pick.getScore());
			pstmt.setInt(7, pick.getDmg());
			pstmt.setDouble(8, pick.getMul());
			pstmt.setString(9, pick.getUserId());
			result=pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return  result;
	}
	
	public int saveEndUser() {
		int result=0;
		String sql="update ClickerUserInfo set pickname=?, enhance=?, picklevel=?, durability=?, gold=?, score=?, damage=?, mul=?, progress=1 where id=?";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, pick.getPickName());
			pstmt.setInt(2, pick.getLevel());
			pstmt.setInt(3, pick.getPickLevel());
			pstmt.setInt(4, pick.getDura());
			pstmt.setInt(5, pick.getMoney());
			pstmt.setInt(6, pick.getScore());
			pstmt.setInt(7, pick.getDmg());
			pstmt.setDouble(8, pick.getMul());
			pstmt.setString(9, pick.getUserId());
			result=pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return  result;
	}
	
	public ArrayList<ClickerUserVO> listAllUser() {
		ArrayList<ClickerUserVO> list = new ArrayList<>();
		String sql="select * from ClickerUserInfo";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery()) {
			
			while(rs.next()) {
				ClickerUserVO vo = new ClickerUserVO();	
				vo.setId(rs.getString("ID"));
				vo.setPwd(rs.getString("PWD"));
				vo.setPickName(rs.getString("PickName"));
				vo.setEnhance(rs.getInt("Enhance"));
				vo.setScore(rs.getInt("PickLevel"));
				vo.setDurability(rs.getInt("Durability"));
				vo.setGold(rs.getInt("Gold"));
				vo.setScore(rs.getInt("Score"));
				vo.setDamage(rs.getInt("Damage"));
				vo.setMul(rs.getInt("Mul"));
				vo.setProgress(rs.getInt("Progress"));
				list.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	public ArrayList<ClickerUserVO> listEndUser() {
		ArrayList<ClickerUserVO> list = new ArrayList<>();
		String sql="select * from ClickerUserInfo where progress=1";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery()) {
			
			while(rs.next()) {
				ClickerUserVO vo = new ClickerUserVO();	
				vo.setId(rs.getString("ID"));
				vo.setPwd(rs.getString("PWD"));
				vo.setPickName(rs.getString("PickName"));
				vo.setEnhance(rs.getInt("Enhance"));
				vo.setScore(rs.getInt("PickLevel"));
				vo.setDurability(rs.getInt("Durability"));
				vo.setGold(rs.getInt("Gold"));
				vo.setScore(rs.getInt("Score"));
				vo.setDamage(rs.getInt("Damage"));
				vo.setMul(rs.getInt("Mul"));
				vo.setProgress(rs.getInt("Progress"));
				list.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	public ArrayList<ClickerUserVO> listIngUser() {
		ArrayList<ClickerUserVO> list = new ArrayList<>();
		String sql="select * from ClickerUserInfo where progress=0";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery()) {
			
			while(rs.next()) {
				ClickerUserVO vo = new ClickerUserVO();	
				vo.setId(rs.getString("ID"));
				vo.setPwd(rs.getString("PWD"));
				vo.setPickName(rs.getString("PickName"));
				vo.setEnhance(rs.getInt("Enhance"));
				vo.setScore(rs.getInt("PickLevel"));
				vo.setDurability(rs.getInt("Durability"));
				vo.setGold(rs.getInt("Gold"));
				vo.setScore(rs.getInt("Score"));
				vo.setDamage(rs.getInt("Damage"));
				vo.setMul(rs.getInt("Mul"));	
				vo.setProgress(rs.getInt("Progress"));
				list.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	
	
	
	//아이템 조회 - itemName, currentenhance로 해당 아이템의 설정 정보 조회
//	public ClickerItemVO searchItem(String pickName, int enhance) {
//		ClickerItemVO vo=null;
//		String sql="select * from ClickerItemInfo where pickname=? and enhance=?";
//		
//		try(Connection con=getConnection();
//				PreparedStatement pstmt=con.prepareStatement(sql)) {
//			
//			pstmt.setString(1, pickName);
//			pstmt.setInt(2, enhance);
//			ResultSet rs=pstmt.executeQuery();
//			
//			if(rs.next()) {
//				vo=new ClickerItemVO();
//				vo.setPickName(rs.getString("pickname"));
//				vo.setPickLevel(rs.getInt("picklevel"));
//				vo.setMul(rs.getInt("mul"));
//				vo.setEnhance(rs.getInt("enhance"));
//				vo.setAttack(rs.getInt("attack"));
//				vo.setTotalDurability(rs.getInt("totaldurability"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//		return vo;
//	}
}
