/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author penpen1112003
 */
public class Member {
    private int member_id;
    private String phone;
    private String fullName;
    private String email;

    public Member() {
    }

    public Member(int member_id, String phone, String fullName, String email) {
        this.member_id = member_id;
        this.phone = phone;
        this.fullName = fullName;
        this.email = email;
    }

    public Member(String phone, String fullName, String email) {
        this.phone = phone;
        this.fullName = fullName;
        this.email = email;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }
    
    

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
