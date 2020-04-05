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
                Dịch Vụ
                <i class="right fa fa-angle-left"></i>
            </p>
        </a>
        <ul class="nav nav-treeview">
            <li class="nav-item">
                <a href="service.htm" class="nav-link">
                    <i class="fa fa-circle-o nav-icon"></i>
                    <p>Danh Sách Dịch Vụ</p>
                </a>
            </li>
        </ul>
<!--        <ul class="nav nav-treeview">
            <li class="nav-item">
                <a href="service.htm?id=${sessionScope.service.id}" class="nav-link">
                    <i class="fa fa-circle-o nav-icon"></i>
                    <p>${sessionScope.service.title}</p>
                </a>
            </li>
        </ul>-->
    </li>
</html>
