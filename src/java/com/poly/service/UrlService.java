/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.service;

import com.poly.bean.Url;
import com.poly.dao.UrlDAO;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1
 */
@Service
public class UrlService {

    @Autowired
    private UrlDAO udao;

    public Boolean insertUrl(Url u) {
        return !Objects.equals(udao.insert(u), Boolean.FALSE);
    }

    public Boolean deleteUrl(int id) {
        return !Objects.equals((id), Boolean.FALSE);
    }

    public Url getById(String url) {
        return udao.getByUrl(url);
    }

    public Boolean update(Url u) {
        return !Objects.equals(udao.update(u), Boolean.FALSE);
    }
}
