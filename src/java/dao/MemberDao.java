/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lib.DBUtils;

/**
 *
 * @author penpen1112003
 */
public class MemberDao {
    public int insertMember(String phone, String fullName, String email) {
        int rs = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Member] ([phone], [fullName], [email]) VALUES (?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, phone);
                st.setString(2, fullName);
                st.setString(3, email);
                rs = st.executeUpdate();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    public Member getMembers(String phone){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Member member = new Member();
        try {
            connection = DBUtils.makeConnection();
            if(connection != null){
                String sql = "SELECT [member_id], [phone], [fullName], [email] FROM [dbo].[Member] WHERE [phone] LIKE ?";
                preparedStatement =  connection.prepareStatement(sql);
                preparedStatement.setString(1, phone.trim());
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    member.setMember_id(resultSet.getInt("member_id"));
                    member.setPhone(resultSet.getString("phone"));
                    member.setFullName(resultSet.getString("fullName"));
                    member.setEmail(resultSet.getString("email"));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return member;
        
    }
}
