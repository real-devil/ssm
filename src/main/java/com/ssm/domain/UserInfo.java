package com.ssm.domain;



import java.util.List;

public class UserInfo {
    private int id;
    private String idStr;
    private String username;
    private String password;
    private  String  position;
    private String department;
    private int status;
    private String statusStr;
//    private List<Role> roleList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", status=" + status +
//                ", roleList=" + roleList +
                '}';
    }

//    public List<Role> getRoleList() {
//        return roleList;
//    }
//
//    public void setRoleList(List<Role> roleList) {
//        this.roleList = roleList;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdStr() {
        this.idStr=String.valueOf(this.id);
        return idStr;
    }

    public void setIdStr(String idStr) {

        this.idStr = idStr;
    }

    public String getStatusStr() {
        if (this.status==0){
            this.statusStr="未审核";
        }if (this.status==1) {
            this.statusStr="已审核";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr=statusStr;


    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

