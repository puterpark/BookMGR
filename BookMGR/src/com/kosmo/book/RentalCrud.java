package com.kosmo.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosmo.db.DBConnect;

public class RentalCrud {
	
	public ArrayList<WrapperVO> possibleBookList() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> possibleBookList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

//			String sql = "select b.bcode, b.btitle, b.bauthor, nvl(r.status, '대여가능') as status "
//					+ "from book b, (select * from rental where rcode = (select max(rcode) from rental)) r "
//					+ "where b.bcode = r.bcode(+) "
//					+ "and (status in ('대여가능') or status is null)"
//					+ "and b.bcheckrent = 'n' "
//					+ "order by b.bcode";
			
			String sql = "select bcode, btitle, bauthor, '대여가능' as status from book where bcode not in (select bcode from rental where rcode in (select max(rcode) from rental group by bcode) and status='대여중') and bcheckrent = 'n'";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();

				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				bvo.setBauthor(rs.getString("bauthor"));
				rvo.setStatus(rs.getString("status"));
				
//				bvo.setBcode(rs.getString("bcode"));
//				bvo.setBtitle(rs.getString("btitle"));
//				bvo.setBauthor(rs.getString("bauthor"));
//				bvo.setBpublisher(rs.getString("bpublisher"));
//				rvo.setStatus(rs.getString("status"));
				
				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				possibleBookList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return possibleBookList;
	}
	
	public ArrayList<BookVO> toRentBookList() {
	
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
	
			DBConnect db = new DBConnect();
			
			ArrayList<BookVO> toRentBookList = new ArrayList<BookVO>();
			
			try {
				// ------------------------------------
				conn = db.dbConn();
				// ------------------------------------
	
				String sql = "select bcode, btitle, bauthor from book where bcheckrent = 'y'";
				pstmt = conn.prepareStatement(sql);
	
				rs = pstmt.executeQuery();
				
				
				while (rs.next()) {
					BookVO bvo = new BookVO();
	
					bvo.setBcode(rs.getString("bcode"));
					bvo.setBtitle(rs.getString("btitle"));
					bvo.setBauthor(rs.getString("bauthor"));
					
	//				bvo.setBcode(rs.getString("bcode"));
	//				bvo.setBtitle(rs.getString("btitle"));
	//				bvo.setBauthor(rs.getString("bauthor"));
	//				bvo.setBpublisher(rs.getString("bpublisher"));
	//				rvo.setStatus(rs.getString("status"));
					
					toRentBookList.add(bvo);
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { // 꼭 해줘
				// ------------------------------------
				db.dbClose(rs, pstmt, conn);
				// ------------------------------------
			}
			
			return toRentBookList;
		}

	
	
	public void rentBook(String bcode, String mcode) {
		

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
//			insert into rental 
//			values(lpad(rental_seq.nextval, 8, '0'), '00000099', '00000031', '대여중', sysdate, null);

			
			String sql = "insert into rental values(lpad(rental_seq.nextval, 8, '0'), ?, ?, '대여중', sysdate, null)"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bcode);
			pstmt.setString(2, mcode);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		    
	}
	
	
	
	
	public ArrayList<WrapperVO> impossibleBookList() {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> impossibleBookList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

//				String sql = "select distinct b.bcode, b.btitle, m.mname, nvl(r.status, '대여가능') as status "
//						+ "from book b, rental r, mem m "
//						+ "where b.bcode = r.bcode(+) and m.mcode(+) = r.mcode "
//						+ "and status in ('대여중') "
//						+ "and b.bcheckreturn = 'n' "
//						+ "order by b.bcode";
			
			String sql = "select b.bcode, b.btitle, m.mname, r.status from book b, (select r.* from rental r where rcode in (select max(rcode) from rental group by bcode) and status='대여중') r, mem m where b.bcode=r.bcode and r.mcode = m.mcode and b.bcheckreturn = 'n'";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();
				MemVO mvo = new MemVO();

				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				mvo.setMname(rs.getString("mname"));
				rvo.setStatus(rs.getString("status"));
				
//				bvo.setBcode(rs.getString("bcode"));
//				bvo.setBtitle(rs.getString("btitle"));
//				bvo.setBauthor(rs.getString("bauthor"));
//				bvo.setBpublisher(rs.getString("bpublisher"));
//				rvo.setStatus(rs.getString("status"));
				
				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				wvo.setMvo(mvo);
				impossibleBookList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return impossibleBookList;
	}
	
	public ArrayList<WrapperVO> toReturnBookList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> toReturnBookList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

			//String sql = "select b.bcode, b.btitle, b.bauthor, r.rcode from book b, rental r where b.bcode=r.bcode and bcheckreturn='y'";
			String sql = "select b.bcode, b.btitle, b.bauthor, r.rcode from book b, (select r.* from rental  r where rcode in (select max(rcode) from rental group by bcode)  and status='대여중') r where b.bcode = r.bcode and bcheckreturn='y'";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();

				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				bvo.setBauthor(rs.getString("bauthor"));
				rvo.setRcode(rs.getString("rcode"));
				
				
//				bvo.setBcode(rs.getString("bcode"));
//				bvo.setBtitle(rs.getString("btitle"));
//				bvo.setBauthor(rs.getString("bauthor"));
//				bvo.setBpublisher(rs.getString("bpublisher"));
//				rvo.setStatus(rs.getString("status"));
				
				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				toReturnBookList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return toReturnBookList;
	}
//	public ArrayList<BookVO> toReturnBookList() {
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		DBConnect db = new DBConnect();
//		
//		ArrayList<BookVO> toReturnBookList = new ArrayList<BookVO>();
//		
//		try {
//			// ------------------------------------
//			conn = db.dbConn();
//			// ------------------------------------
//			
//			String sql = "select b.bcode, b.btitle, b.bauthor, r.rcode from book b, rental r where b.bcode=r.bcode and bcheckreturn='y'";
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			
//			while (rs.next()) {
//				BookVO bvo = new BookVO();
//				
//				bvo.setBcode(rs.getString("bcode"));
//				bvo.setBtitle(rs.getString("btitle"));
//				bvo.setBauthor(rs.getString("bauthor"));
//				
//				
////				bvo.setBcode(rs.getString("bcode"));
////				bvo.setBtitle(rs.getString("btitle"));
////				bvo.setBauthor(rs.getString("bauthor"));
////				bvo.setBpublisher(rs.getString("bpublisher"));
////				rvo.setStatus(rs.getString("status"));
//				
//				toReturnBookList.add(bvo);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally { // 꼭 해줘
//			// ------------------------------------
//			db.dbClose(rs, pstmt, conn);
//			// ------------------------------------
//		}
//		
//		return toReturnBookList;
//	}
	

	public void yCheckRent(BookVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			//update book
			//set bcheck='y'
			//where bcode='00000098';
			
			String sql = "update book set bcheckrent='y' where bcode=?"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBcode());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void nCheckRent(BookVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			//update book
			//set bcheck='y'
			//where bcode='00000098';
			
			String sql = "update book set bcheckrent='n' where bcode=?"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBcode());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void yCheckReturn(BookVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			//update book
			//set bcheck='y'
			//where bcode='00000098';
			
			String sql = "update book set bcheckreturn='y' where bcode=?"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBcode());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void nCheckReturn(BookVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			//update book
			//set bcheck='y'
			//where bcode='00000098';
			
			String sql = "update book set bcheckreturn='n' where bcode=?"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBcode());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void returnBook(String rcode) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		try {
			conn = db.dbConn();
			
			//update book
			//set bcheck='y'
			//where bcode='00000098';
			
			String sql = "update rental set status='대여가능', returndate=sysdate where rcode=?"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rcode);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public ArrayList<WrapperVO> searchPossibleBook(String searchStr) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> searchPossibleBookList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

					
			String sql = "select bcode, btitle, bauthor, '대여가능' as status "
					+ "from book "
					+ "where bcode not in (select bcode from rental where rcode in (select max(rcode) from rental group by bcode) and status='대여중') "
					+ "and bcheckrent = 'n' "
					+ "and ((bcode like '%' || ? || '%') or (btitle like '%' || ? || '%') or (bauthor like '%' || ? || '%'))";
			
			//where (bcode like '%' || ? || '%') or (btitle like '%' || ? || '%') or (bauthor like '%' || ? || '%') or (btranslator like '%' || ? || '%') or (bpublisher like '%' || ? || '%') or (bisbn like '%' || ? || '%')
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchStr);
			pstmt.setString(2, searchStr);
			pstmt.setString(3, searchStr);

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();
				
				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				bvo.setBauthor(rs.getString("bauthor"));
				rvo.setStatus(rs.getString("status"));
				
				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				searchPossibleBookList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return searchPossibleBookList;
	}
	
	public ArrayList<WrapperVO> searchImpossibleBook(String searchStr) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> searchImpossibleBookList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

//				String sql = "select distinct b.bcode, b.btitle, m.mname, nvl(r.status, '대여가능') as status "
//						+ "from book b, rental r, mem m "
//						+ "where b.bcode = r.bcode(+) and m.mcode(+) = r.mcode "
//						+ "and status in ('대여중') "
//						+ "and b.bcheckreturn = 'n' "
//						+ "order by b.bcode";
			
			String sql = "select b.bcode, b.btitle, m.mname, r.status "
					+ "from book b, (select r.* from rental r where rcode in (select max(rcode) from rental group by bcode) and status='대여중') r, mem m "
					+ "where b.bcode=r.bcode and r.mcode = m.mcode and b.bcheckreturn = 'n'"
					+ "and ((b.bcode like '%' || ? || '%') or (b.btitle like '%' || ? || '%') or (m.mname like '%' || ? || '%'))";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, searchStr);
			pstmt.setString(2, searchStr);
			pstmt.setString(3, searchStr);
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();
				MemVO mvo = new MemVO();
				
				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				mvo.setMname(rs.getString("mname"));
				rvo.setStatus(rs.getString("status"));

				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				wvo.setMvo(mvo);
				searchImpossibleBookList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return searchImpossibleBookList;
	}
}
