<%-- 
    Document   : account
    Created on : Mar 11, 2020, 10:46:47 AM
    Author     : 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <li class="nav-item has-treeview">
        <a href="#" class="nav-link">
            <i class="nav-icon fa fa-pie-chart"></i>
            <p>
                Tài Khoản
                <i class="right fa fa-angle-left"></i>
            </p>
        </a>
        <ul class="nav nav-treeview">
            <li class="nav-item">
                <a href="ListUser.htm?type=1" class="nav-link">
                    <i class="fa fa-circle-o nav-icon"></i>
                    <p>Tài Khoản Nhân Viên</p>
                </a>
            </li>
        </ul>
        <ul class="nav nav-treeview">
            <li class="nav-item">
                <a href="ListUser.htm?type=2" class="nav-link">
                    <i class="fa fa-circle-o nav-icon"></i>
                    <p>Tài Khoản Khách Hàng</p>
                </a>
            </li>
        </ul>
    </li>
</html>
