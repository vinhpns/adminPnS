<%-- 
    Document   : insert-model
    Created on : Dec 2, 2019, 6:45:22 PM
    Author     : hieuh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-xs-12 col-sm-12">
        <div class="widget-box">
            <div class="widget-body">
                <div class="widget-main">
                    <div>
                        <div>
                            <label for="form-field-8">Tên Menu</label>
                            <input id="txt_box" type="text" required="" placeholder="Tên Menu"
                                   class="autosize-transition form-control" name="name"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        </div>
                        <br>
                        <div>
                            <label for="form-field-8">Thuộc Menu</label>
                            <input id="txt_box" type="text" required="" placeholder="Tên Menu"
                                   class="autosize-transition form-control" readonly="" value="${menuFatherName}"
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            <input hidden="" value="0" name="postion">
                            <input hidden="" value="${menuFatherId}" name="parentId">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
