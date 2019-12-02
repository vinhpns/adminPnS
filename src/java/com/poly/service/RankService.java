/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Rank;
import com.poly.dao.RankDAO;
import com.poly.tool.ConstantManager;
import com.poly.tool.checkLogin;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VinhNT
 */
@Service
public class RankService {

    @Autowired
    private RankDAO rankDAO;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        return (checkLogin.checkLoginRoleAdmin(Integer.parseInt(String.valueOf(session.getAttribute(ConstantManager.ROLEID)))) == true);
    }

    public List<Rank> getListRank() {
        return rankDAO.getListRank();
    }

    public Rank getById(int id) {
        Rank r = rankDAO.getRankById(id);
        if (r == null) {
            return null;
        }
        return r;
    }

    public List<Rank> checkExits(int point, String name, int id) {
        List<Rank> r = rankDAO.checkExits(point, name);
        if (r.isEmpty()) {
            return null;
        }
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).getId() == id) {
                return null;
            }
        }
        return r;
    }

    public Boolean insert(Rank rank) {
        return !Objects.equals(rankDAO.insert(rank), Boolean.FALSE);
    }

    public Boolean update(Rank rank, int type) {
        return !Objects.equals(rankDAO.update(rank, type), Boolean.FALSE);
    }
}
