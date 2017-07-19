<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/8 0008
  Time: 下午 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <table width="90%" height="629" border="0" cellpadding="0"
           cellspacing="0" align="center">
        <tr>
            <td width="200" height="101">
                <img src="images/eleme-icon.png" width="64" height="64" />
                <strong><span
                        style="font-size: 20px;">网上订餐系统</span> </strong>
            </td>
            <td width="640" style="padding-left: 40px;">
            </td>
        </tr>
        <tr>
            <td height="41" colspan="2"
                style="background-image:url(images/001.gif);" align="center">
                |
                <a href="toShowMeal.action">网站首页</a> |
                <s:if test="(#session.admin==null) && (#session.user==null)">
                    <a href="">用户注册</a> |
                    <a href="login.jsp?role=user">用户登录</a> |
                    <a href="login.jsp?role=admin">管理员登录</a> |
                </s:if>
                <s:if test="#session.user!=null">
                    <a href="">修改个人信息</a> |
                    <a href="">我的购物车</a> |
                    <a href="">我的订单</a> |
                    <a href="logOut?type=userlogout">注销</a> &nbsp;&nbsp; &nbsp;&nbsp;
                    <font style="color: red">欢迎您：${sessionScope.user.trueName }</font>
                </s:if>
                <s:if test="#session.admin!=null">
                    <a href="">添加餐品</a> |
                    <a href="">管理餐品</a> |
                    <a href="">订单处理</a> |
                    <a href="logOut?type=adminlogout">注销</a> &nbsp;&nbsp; &nbsp;&nbsp;
                    <font style="color: red">欢迎您：${sessionScope.admin.loginName }</font>
                </s:if>
            </td>
        </tr>
        <tr>
            <td valign="top">
                <p>
                    <img src="images/left_top.jpg" width="215" height="100" />
            </td>
            <td valign="top" width="80%">
                <img src="images/001.jpg" width="595" height="72" />
                <br />

                <div style="background-image:url(images/004.gif)">
                    &nbsp;
                </div>
                <div style="background-color:#FFCC99;" align="center">
                    网上订餐系统用户请直接登录
                </div>
                <br>
                <br />

                <s:if test="#parameters.role[0]=='user'">
                    <form action="validateLogin?type=userlogin" method="post" name="ufrm">
                        <table width="263" border="0" cellspacing="0" cellpadding="4"
                               align="center">
                            <tr>
                                <td width="74">
                                    用户名：
                                </td>
                                <td width="189">
                                    <input type="text" name="loginName" style="width:150;" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    密 &nbsp;&nbsp;码：
                                </td>
                                <td>
                                    <input type="password" name="loginPwd" style="width:150;" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    &nbsp;
                                </td>
                                <td>
                                    <input type="submit" name="login" value="登 录" />
                                </td>
                            </tr>
                        </table>
                    </form>
                </s:if>


                <s:if test="#parameters.role[0]=='admin'">
                    <form action="validateLogin?type=adminlogin" method="post" name="afrm">
                        <table width="263" border="0" cellspacing="0" cellpadding="4"
                               align="center">
                            <tr>
                                <td width="74">
                                    登录名：
                                </td>
                                <td width="189">
                                    <input type="text" name="loginName" style="width:150;" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    密 &nbsp;&nbsp;码：
                                </td>
                                <td>
                                    <input type="password" name="loginPwd" style="width:150;" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    &nbsp;
                                </td>
                                <td>
                                    <input type="submit" name="login" value="登 录" />
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2">

                                </td>
                            </tr>

                        </table>
                    </form>
                </s:if>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <br>
                <hr width=100%>
                <br>
                <br>
                <br>
            </td>
        </tr>
    </table>
</body>
</html>
