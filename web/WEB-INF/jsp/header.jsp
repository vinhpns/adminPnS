<%-- 
    Document   : header
    Created on : Jan 4, 2019, 9:08:18 PM
    Author     : VinhNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="assets/images/favicon.png" type="image/png" sizes="32x32">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta charset="utf-8"/>
        <title>SGDG Admin</title>
        <meta name="description" content="Static &amp; Dynamic Tables"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="assets/css/button-css.css"/>

        <!-- page specific plugin styles -->
        <link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css"/>
        <link rel="stylesheet" href="assets/css/fullcalendar.min.css"/>

        <!-- text fonts -->
        <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css"/>

        <!-- ace styles -->
        <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style"/>
        <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
        <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <script src="assets/js/ace-extra.min.js"></script>
        <style>
            section {
                width: 100%;
                margin: auto;
                text-align: left;
            }

        </style>
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
            function doBefore() {
            <c:if test="${errors != null}">
                Swal.fire(
                        'Thông báo!',
                        '${errors}',
                        'warning'
                        )
            </c:if>
            <c:if test="${okNotification != null}">
                Swal.fire(
                        'Thông báo!',
                        '${okNotification}',
                        'success'
                        )
            </c:if>
            }
        </script>
        <script type="text/javascript">
            /*code: 48-57 Numbers
             8  - Backspace,
             35 - home key, 36 - End key
             37-40: Arrow keys, 46 - Delete key*/
            function restrictAlphabets(e) {
                var x = e.which || e.keycode;
                if ((x >= 48 && x <= 57) || x == 8 ||
                        (x >= 35 && x <= 40) || x == 46)
                    return true;
                else
                    return false;
            }
        </script>
    </head>
    <body onload="doBefore()">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                    <span class="sr-only">Toggle sidebar</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="navbar-header pull-left">
                    <a href="index.htm" class="navbar-brand">
                        <small>
                            <img src="assets/images/favicon.png">
                            Sài Gòn Đấu Giá Admin
                        </small>
                    </a>
                </div>

                <div class="navbar-buttons navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">
                        <li class="light-blue dropdown-modal">
                            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                                <img class="nav-user-photo" src="assets/images/avatars/user.png" alt="Jason's Photo"/>
                                <span class="user-info">
                                    <small>Welcome,</small>
                                    ${sessionScope.loginName}
                                </span>

                                <i class="ace-icon fa fa-caret-down"></i>
                            </a>

                            <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                                <li>
                                    <c:url value="index.htm?logout" var="logout"/>
                                    <a href="${logout}">
                                        <i class="ace-icon fa fa-sign-out"></i>
                                        Đăng xuất
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div><!-- /.navbar-container -->
        </div>
    </body>
</html>
