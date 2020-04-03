/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Different;
import com.poly.dao.DifferentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinh1
 */
@Service
public class DifferentService {

    @Autowired
    DifferentDAO differentDAO;

    public Different getByCompanyId(String id) {
        return differentDAO.getByCompanyId(id);
    }

    public Boolean update(Different d) {
        return differentDAO.update(d);
    }
}
