<%-- 
    Document   : index
    Created on : 13.10.2016, 13:21:09
    Author     : surzhin.konstantin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Статистика игроков</title>
        </head>
        <frameset rows="10,80,10" >
            <frame src="faces/frame1.jsp" name="f1"/>
            <frameset cols="15%,*">
                <frame src="faces/frame2.jsp" name="f2"/>
                <frame src="faces/frame3.jsp" name="f3"/>
            </frameset>
            <frame src="faces/frame4.jsp" name="f4"/>
        </frameset>
    </html>
</f:view>
