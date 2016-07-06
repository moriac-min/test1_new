<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- [dataAccessFailure]-->
데이터베이스 접근 에러
%&*$$### <c:out value="${exception.message}"/>
%&*$$### -1001