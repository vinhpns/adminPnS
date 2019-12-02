/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.bean.Room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDAO {

    @Autowired
    private JdbcTemplate jdbc;

    protected List<Room> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<Room> getRowMapper() {
        return new BeanPropertyRowMapper<>(Room.class);
    }

    public List<Room> getAllRoom() {
        String sql = "SELECT * FROM room ORDER BY id DESC";
        return getBySql(sql);
    }

    public Room getRoomById(int id) {
        String sql = "SELECT * FROM room WHERE id=?";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

    public Boolean updateRoom(Room room) {
        try {
            String sql = "UPDATE room SET duration = ?, max = ?, min = ?, name = ?, step = ? WHERE id=?";
            jdbc.update(sql, room.getDuration(), room.getMax(), room.getMin(), room.getName(), room.getStep(), room.getId());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean deleteRoom(int id) {
        try {
            String sql = "DELETE FROM room WHERE id=?";
            jdbc.update(sql, id);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean insert(Room room) {
        try {
            String sql = "INSERT INTO room (duration, max, min, name, step) values (?,?,?,?,?)";
            jdbc.update(sql, room.getDuration(), room.getMax(), room.getMin(), room.getName(), room.getStep());
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public List<Room> getRoomId(double money) {
        String sql = "SELECT * FROM room WHERE max >= " + money + " and min < " + money;
        return getBySql(sql);
    }

    public List<Room> getListHigherMoney(double money) {
        String sql = "SELECT * FROM room WHERE max >= " + money;
        return getBySql(sql);
    }

    public List<Room> getListSmallerMoney(double money) {
        String sql = "SELECT * FROM room WHERE max <= " + money;
        return getBySql(sql);
    }

    public List<Room> getListSearchByTime(int hour) {
        try {
            String sql = "SELECT * FROM room WHERE duration = " + hour;
            return getBySql(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
