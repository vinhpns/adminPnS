<%-- 
    Document   : insert-modal.jsp
    Created on : Dec 2, 2019, 6:13:21 PM
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
                        <label for="form-field-8">Tên Menu</label>
                        <input id="txt_box" type="text" required="" placeholder="Tên Menu"
                               class="autosize-transition form-control" name="name"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                        <input id="txt_box" type="text" required="" placeholder="Tên Menu"
                               class="autosize-transition form-control" name="parentId" hidden="" value="0"
                               style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                    </div>
                    <div>
                        <label for="form-field-8">Vị trí Menu</label>
                        <input hidden="" value="menu" name="url" />
                        <select id="txt_box" type="select" placeholder="Vai Trò"
                                class="autosize-transition form-control" name="position"
                                style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 40px;">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
