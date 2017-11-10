package com.liufei.pojo;

public class User {
    private Integer uid;

    private String username;

    private String pwd;

    private String level;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", pwd=" + pwd + ", level=" + level + "]";
	}
    
}