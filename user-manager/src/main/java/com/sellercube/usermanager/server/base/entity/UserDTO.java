package com.sellercube.usermanager.server.base.entity;

/**
 * Created by Chenjing on 2017/7/10.
 */
public class UserDTO extends User {
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
