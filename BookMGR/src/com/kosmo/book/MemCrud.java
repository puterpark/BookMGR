package com.kosmo.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosmo.db.DBConnect;

public class MemCrud {

	public ArrayList<MemVO> memList() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<MemVO> memList = new ArrayList<MemVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

			String sql = "select mcode, mname, to_char(mbirth, 'yyyy-mm-dd') as mbirth, mphone, to_char(mregdate, 'yyyy-mm-ss hh24:mi:ss') as mregdate from mem order by mcode";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				MemVO mvo = new MemVO();
				
				mvo.setMcode(rs.getString("mcode"));
				mvo.setMname(rs.getString("mname"));
				mvo.setMbirth(rs.getString("mbirth"));
				mvo.setMphone(rs.getString("mphone"));
				mvo.setMregdate(rs.getString("mregdate"));
				
				
//				bvo.setBcode(rs.getString("bcode"));
//				bvo.setBtitle(rs.getString("btitle"));
//				bvo.setBauthor(rs.getString("bauthor"));
//				bvo.setBpublisher(rs.getString("bpublisher"));
//				rvo.setStatus(rs.getString("status"));
				
				memList.add(mvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return memList;
	}
	
	public int memInsert(MemVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		DBConnect db = new DBConnect();
		
		try {
			conn = db.dbConn();
			
			//insert into book
			//values(
			//lpad(book_seq.nextval, 8, '0'), 	
			//'우리는 언젠가 만난다', 	1 getBtitle
			//'채사장', 				2 getBauthor
			//'', 						3 getBtranslator()
			//'웨일북', 				4 getBpublisher()
			//9791188248124, 			5 getBisbn()
			//14000, 					6 getBprice()
			//256, 						7 getBpage()
			//sysdate);					
			
			
			
			String sql = "insert into mem values(lpad(mem_seq.nextval, 8, '0'), ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMname());
			pstmt.setString(2, vo.getMbirth());
			pstmt.setString(3, vo.getMphone());
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return rows;
	}
	
	public void memUpdate(MemVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			//update book
			//set btitle='', bauthor='1111', btranslator='2222', bpublisher='3333', bisbn=4444, bprice=55555, bpage=6666
			//where bcode = '00000033';
			
			String sql = "update mem set mname=?, mbirth=?, mphone=? where mcode=?"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMname());
			pstmt.setString(2, vo.getMbirth());
			pstmt.setString(3, vo.getMphone());
			pstmt.setString(4, vo.getMcode());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void memDelete(String mcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			String sql = "delete from mem where mcode=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mcode);
			
			pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public ArrayList<WrapperVO> memTraceList(MemVO vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> memTraceList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

			
			/*select b.bcode, b.btitle, decode(returndate, null, rentdate, returndate) as trace
			from book b, mem m, rental r
			where b.bcode = r.bcode and m.mcode = r.mcode
			and m.mcode='00000036';*/
			
			String sql = "select b.bcode, b.btitle, to_char(decode(r.returndate, null, r.rentdate, r.returndate), 'yyyy-mm-dd hh24:mi:ss') as trace "
					+ "from book b, mem m, rental r "
					+ "where b.bcode = r.bcode and m.mcode = r.mcode "
					+ "and m.mcode=?"
					+ "order by trace desc";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMcode());

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();
//				MemVO mvo = new MemVO();
				
				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				rvo.setReturndate(rs.getString("trace"));
				
				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				memTraceList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return memTraceList;
	}
	
	public ArrayList<MemVO> searchMem(String searchStr) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<MemVO> searchMemList = new ArrayList<MemVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

			//select *
			//from mem
			//where (mcode like '%박%') or (mname like '%박%') or (mbirth like '%박%') or (mphone like '%박%');
			
			String sql = "select mcode, mname, to_char(mbirth, 'yyyy-mm-dd') as mbirth, mphone, to_char(mregdate, 'yyyy-mm-ss hh24:mi:ss') as mregdate "
					+ "from mem "
					+ "where (mcode like '%' || ? || '%') "
					+ "or (mname like '%' || ? || '%') "
					+ "or (mbirth like '%' || ? || '%') "
					+ "or (mphone like '%' || ? || '%')";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchStr);
			pstmt.setString(2, searchStr);
			pstmt.setString(3, searchStr);
			pstmt.setString(4, searchStr);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemVO mvo = new MemVO();
				
				mvo.setMcode(rs.getString("mcode"));
				mvo.setMname(rs.getString("mname"));
				mvo.setMbirth(rs.getString("mbirth"));
				mvo.setMphone(rs.getString("mphone"));
				mvo.setMregdate(rs.getString("mregdate"));
				
				searchMemList.add(mvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		return searchMemList;
	}
	
	
	
	
}
