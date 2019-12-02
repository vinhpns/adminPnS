/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.request;

/**
 *
 * @author SGDG Company
 */
public class AccountPassword {

    public String id;
    public String oldPassword;
    public String newPassword;
    public String reNewPassword;

    public AccountPassword() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

}
