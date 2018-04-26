package com.kosmo.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosmo.db.DBConnect;
import com.kosmo.member.MemberVO;

public class BookCrud {

	public ArrayList<WrapperVO> bookList() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> bookList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

//			String sql = "select b.bcode, b.btitle, b.bauthor, nvl(b.btranslator, ' ') as btranslator, b.bpublisher, b.bisbn, b.bprice, b.bpage, to_char(b.bregdate, 'yyyy-mm-ss hh24:mi:ss') as bregdate, nvl(r.status, '대여가능') as status, b.bcheckrent, b.bcheckreturn "
//					+ "from book b, rental r "
//					+ "where b.bcode = r.bcode(+) order by bcode";
			
			String sql = "select bcode, btitle, bauthor, nvl(btranslator, ' ') as btranslator, bpublisher, bisbn, bprice, bpage, to_char(bregdate, 'yyyy-mm-ss hh24:mi:ss') as bregdate, nvl(status, '대여가능') as status, bcheckrent, bcheckreturn from (select b.*, '대여가능' as status from book b where bcode not in (select bcode from rental where rcode in (select max(rcode) from rental group by bcode) and status='대여중') union (select b.* , '대여중' as status from book b where bcode in (select bcode from rental where rcode in (select max(rcode) from rental group by bcode) and status='대여중' )))order by bcode";
			
			
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();

				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				bvo.setBauthor(rs.getString("bauthor"));
				bvo.setBtranslator(rs.getString("btranslator"));
				bvo.setBpublisher(rs.getString("bpublisher"));
				bvo.setBisbn(rs.getString("bisbn"));
				bvo.setBprice(rs.getInt("bprice"));
				bvo.setBpage(rs.getString("bpage"));
				bvo.setBregdate(rs.getString("bregdate"));
				rvo.setStatus(rs.getString("status"));
				bvo.setBcheckRent(rs.getString("bcheckrent"));
				bvo.setBcheckReturn(rs.getString("bcheckreturn"));
				
//				bvo.setBcode(rs.getString("bcode"));
//				bvo.setBtitle(rs.getString("btitle"));
//				bvo.setBauthor(rs.getString("bauthor"));
//				bvo.setBpublisher(rs.getString("bpublisher"));
//				rvo.setStatus(rs.getString("status"));
				
				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				bookList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return bookList;
	}
	
	public void bookUpdate(BookVO vo) {
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			//update book
			//set btitle='', bauthor='1111', btranslator='2222', bpublisher='3333', bisbn=4444, bprice=55555, bpage=6666
			//where bcode = '00000033';
			
			String sql = "update book "
					+ "set btitle=?, bauthor=?, btranslator=?, "
					+ "bpublisher=?, bisbn=?, bprice=?, "
					+ "bpage=? "
					+ "where bcode=?"; 

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBauthor());
			pstmt.setString(3, vo.getBtranslator());
			pstmt.setString(4, vo.getBpublisher());
			pstmt.setString(5, vo.getBisbn());
			pstmt.setInt(6, vo.getBprice());
			pstmt.setString(7, vo.getBpage());
			pstmt.setString(8, vo.getBcode());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}

	public void bookDelete(String bcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnect db = new DBConnect();
		
		
		try {
			conn = db.dbConn();
			
			String sql = "delete from book where bcode=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bcode);
			
			pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public int bookInsert(BookVO vo) {
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
			
			
			
			String sql = "insert into book values(lpad(book_seq.nextval, 8, '0'), ?, ?, ?, ?, ?, ?, ?, sysdate, 'n', 'n')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBauthor());
			pstmt.setString(3, vo.getBtranslator());
			pstmt.setString(4, vo.getBpublisher());
			pstmt.setString(5, vo.getBisbn());
			pstmt.setInt(6, vo.getBprice());
			pstmt.setString(7, vo.getBpage());
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return rows;
	}
	
	public ArrayList<WrapperVO> searchBook(String searchStr) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnect db = new DBConnect();
		
		ArrayList<WrapperVO> searchBookList = new ArrayList<WrapperVO>();
		
		try {
			// ------------------------------------
			conn = db.dbConn();
			// ------------------------------------

					
			String sql = "select bcode, btitle, bauthor, nvl(btranslator, ' ') as btranslator, bpublisher, bisbn, bprice, bpage, to_char(bregdate, 'yyyy-mm-ss hh24:mi:ss') as bregdate, nvl(status, '대여가능') as status, bcheckrent, bcheckreturn from (select b.*, '대여가능' as status from book b where bcode not in (select bcode from rental where rcode in (select max(rcode) from rental group by bcode) and status='대여중') union (select b.* , '대여중' as status from book b where bcode in (select bcode from rental where rcode in (select max(rcode) from rental group by bcode) and status='대여중' )))"
					+ "where ((bcode like '%' || ? || '%') or (btitle like '%' || ? || '%') or (bauthor like '%' || ? || '%') or (btranslator like '%' || ? || '%') or (bpublisher like '%' || ? || '%') or (bisbn like '%' || ? || '%')) "
					+ "order by bcode";
			
			//where (bcode like '%' || ? || '%') or (btitle like '%' || ? || '%') or (bauthor like '%' || ? || '%') or (btranslator like '%' || ? || '%') or (bpublisher like '%' || ? || '%') or (bisbn like '%' || ? || '%')
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchStr);
			pstmt.setString(2, searchStr);
			pstmt.setString(3, searchStr);
			pstmt.setString(4, searchStr);
			pstmt.setString(5, searchStr);
			pstmt.setString(6, searchStr);

			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				WrapperVO wvo = new WrapperVO();
				BookVO bvo = new BookVO();
				RentalVO rvo = new RentalVO();
				
				bvo.setBcode(rs.getString("bcode"));
				bvo.setBtitle(rs.getString("btitle"));
				bvo.setBauthor(rs.getString("bauthor"));
				bvo.setBtranslator(rs.getString("btranslator"));
				bvo.setBpublisher(rs.getString("bpublisher"));
				bvo.setBisbn(rs.getString("bisbn"));
				bvo.setBprice(rs.getInt("bprice"));
				bvo.setBpage(rs.getString("bpage"));
				bvo.setBregdate(rs.getString("bregdate"));
				rvo.setStatus(rs.getString("status"));
				bvo.setBcheckRent(rs.getString("bcheckrent"));
				bvo.setBcheckReturn(rs.getString("bcheckreturn"));
				
				wvo.setBvo(bvo);
				wvo.setRvo(rvo);
				searchBookList.add(wvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 꼭 해줘
			// ------------------------------------
			db.dbClose(rs, pstmt, conn);
			// ------------------------------------
		}
		
		return searchBookList;
	}
	
}
