/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.request;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SGDG Company
 */
public class AccountRequestEntity {

    private String id;
    private Boolean active;
    private String address;
    private String dob;
    private String email;
    private String fullName;
    private Boolean gender;
    private String password;
    private String phone;
    private int roleId;
    private MultipartFile avatar;
    private MultipartFile backIdCard;
    private MultipartFile frontIdCard;
    private int socialIdNumber;
    private int rankId;
    private int point;
    private String bankBranch;
    private String bankName;
    private String bankNameHolder;
    private String bankNumber;

    public AccountRequestEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public MultipartFile getBackIdCard() {
        return backIdCard;
    }

    public void setBackIdCard(MultipartFile backIdCard) {
        this.backIdCard = backIdCard;
    }

    public MultipartFile getFrontIdCard() {
        return frontIdCard;
    }

    public void setFrontIdCard(MultipartFile frontIdCard) {
        this.frontIdCard = frontIdCard;
    }

    public int getSocialIdNumber() {
        return socialIdNumber;
    }

    public void setSocialIdNumber(int socialIdNumber) {
        this.socialIdNumber = socialIdNumber;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNameHolder() {
        return bankNameHolder;
    }

    public void setBankNameHolder(String bankNameHolder) {
        this.bankNameHolder = bankNameHolder;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

}
