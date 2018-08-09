//package com.bitoffice.service.document;
//
//import org.springframework.web.servlet.mvc.AbstractController;
//
//import com.bitoffice.service.domain.Files;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
// 
//public class FilesService2 extends JdbcDaoSupport {
//    String query = null;
// 
//    /**
//     * find
//     */
//    public Files find(int id) {
//        query = "select * from files where id = ?";
// 
//        try {
//            Files file = (Files) getJdbcTemplate().queryForObject(query, new Object[] {id},
//                new RowMapper() {
//                    Files fl;
//                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        fl = new Files();
//                        fl.setId(rs.getInt(1));
//                        fl.setFilename(rs.getString(2));
//                        fl.setNotes(rs.getString(3));
//                        fl.setType(rs.getString(4));
//                        fl.setFile(rs.getBytes(5));
// 
//                        return fl;
//                    }
//            });
// 
//            return file;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
// 
//        return null;
//    }
// 
//    /**
//     * listAll
//     */
//    public List<Files> listAll() {
//        query = "select id, filename, notes, type from files";
// 
//        try{
//            List<Files> files = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Files.class));
// 
//            return files;
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
// 
//        return null;
//    }
// 
//    /**
//     * save
//     */
//    public void save(final Files file) {
//        query = "insert into files (filename, notes, type, file) values (?, ?, ?, ?)";
// 
//        try {
//            synchronized(this) {
//                getJdbcTemplate().update(new PreparedStatementCreator() {
// 
//                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                        PreparedStatement statement = con.prepareStatement(query);
//                        statement.setString(1, file.getFilename());
//                        statement.setString(2, file.getNotes());
//                        statement.setString(3, file.getType());
//                        statement.setBytes(4, file.getFile());
//                        return statement;
//                    }
//                });
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
// 
//    /**
//     * delete
//     */
//    public void delete(int id) {
//        query = "delete from files where id = ?";
// 
//        try {
//            getJdbcTemplate().update(query, new Object[] {id});
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//}