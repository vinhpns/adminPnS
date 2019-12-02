/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Room;
import com.poly.dao.RoomDAO;
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
public class RoomService {

    @Autowired
    private RoomDAO rDAO;

    public Boolean checkLogin(HttpSession session) {
        if (checkLogin.checkLogin(session) == false) {
            return false;
        }
        return checkLoginRole(session) != false;
    }

    public Boolean checkLoginRole(HttpSession session) {
        int role = Integer.parseInt(String.valueOf(session.getAttribute("roleiz")));
        return (checkLogin.checkLoginRoleAdmin(role) == true
                || checkLogin.checkLoginRoleSuperAdmin(role) == true);
    }

    public List<Room> getListRoom() {
        return rDAO.getAllRoom();
    }

    public Boolean deleteRoom(int id) {
        return !Objects.equals(rDAO.deleteRoom(id), Boolean.FALSE);
    }

    public Boolean insertRoom(Room room) {
        Boolean checkMax = checkMaxmoney(Double.valueOf(room.getMax()));
        Boolean checkMin = checkMinmoney(Double.valueOf(room.getMin()), Double.valueOf(room.getMax()));
        Boolean checkTime = checkByTime(room.getDuration());
        if (checkMax.equals(Boolean.FALSE) || checkMin.equals(Boolean.FALSE) || checkTime.equals(Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return !Objects.equals(rDAO.insert(room), Boolean.FALSE);
    }

    public Boolean updateRoom(Room room) {
        Room r = rDAO.getRoomById(room.getId());
        Boolean checkTime = Boolean.TRUE;
        if (!room.getMax().equals(r.getMax())) {
            List<Room> listHigher = rDAO.getListHigherMoney(Double.valueOf(room.getMax()));
            if (listHigher.size() > 0) {
                for (int i = 0; i < listHigher.size(); i++) {
                    if (Double.parseDouble(listHigher.get(i).getMin()) <= Double.valueOf(room.getMax())) {
                        if (r.getId() != room.getId()) {
                            return Boolean.FALSE;
                        }
                    }
                }
            }
        }
        if (!room.getMin().equals(r.getMin())) {
            List<Room> listSmaller = rDAO.getListSmallerMoney(Double.valueOf(room.getMax()));
            if (listSmaller.size() > 0) {
                for (int i = 0; i < listSmaller.size(); i++) {
                    if (Double.parseDouble(listSmaller.get(i).getMax()) >= Double.valueOf(room.getMin())) {
                        if (r.getId() != room.getId()) {
                            return Boolean.FALSE;
                        }
                    }
                }
            }
        }
        if (room.getDuration() != r.getDuration()) {
            checkTime = checkByTime(room.getDuration());
        }
        if (checkTime.equals(Boolean.FALSE)) {
            return Boolean.FALSE;
        }
        return !Objects.equals(rDAO.updateRoom(room), Boolean.FALSE);
    }

    public Room getRoomById(int id) {
        return rDAO.getRoomById(id);
    }

    public Boolean checkMaxmoney(double maxMoney) {
        List<Room> listHigher = rDAO.getListHigherMoney(maxMoney);
        if (listHigher.size() > 0) {
            for (int i = 0; i < listHigher.size(); i++) {
                if (Double.parseDouble(listHigher.get(i).getMin()) <= maxMoney) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    public Boolean checkMinmoney(double minMoney, double maxMoney) {
        List<Room> listSmaller = rDAO.getListSmallerMoney(maxMoney);
        if (listSmaller.size() > 0) {
            for (int i = 0; i < listSmaller.size(); i++) {
                if (Double.parseDouble(listSmaller.get(i).getMax()) >= minMoney) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    public Boolean checkByTime(int hour) {
        List<Room> listByHour = rDAO.getListSearchByTime(hour);
        if (listByHour.size() > 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<Room> getRoomIdByMoney(double money) {
        return rDAO.getRoomId(money);
    }
}
