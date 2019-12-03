/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Menu;
import com.poly.dao.MenuDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MenuService {
    @Autowired
    private MenuDAO mDAO;

   public List<Menu> getFather(){
      return mDAO.getFather();
   }
    public List<Menu> getSon(){
        return mDAO.getSon();
    }
}
