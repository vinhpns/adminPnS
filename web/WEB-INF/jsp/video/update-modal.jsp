<%-- 
    Document   : insert-model
    Created on : Dec 2, 2019, 6:45:22 PM
    Author     : hieuh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <div>
                            <label for="form-field-8">Tiêu Đề Video</label>
                            <input id="txt_box" type="text" required="" value="${video.title}"
                                   class="autosize-transition form-control" name="title" 
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Link Video</label>
                            <input id="txt_box" type="text" required="" value="${video.link}"
                                   class="autosize-transition form-control" name="link" 
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <input value="${video.id}" hidden="" name="id" />
                        <div>
                            <iframe src="${video.link}" width="100%"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
