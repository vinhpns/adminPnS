/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Register;
import com.poly.dao.RegisterDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class RegisterService {
     @Autowired
    RegisterDAO registerDAO;
    
    public List<Register> getListRegister() {
        return registerDAO.getListRegister();
    }
    
}
