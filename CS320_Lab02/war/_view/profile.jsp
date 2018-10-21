<%--
  Created by IntelliJ IDEA.
  User: edwardnardo
  Date: 10/20/18
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Profile</title>
</head>
<body>
    <div class="para">
        <c:out value="${loginId}" escapeXml="false"/>
        <c:out value="${username}" escapeXml="false"/>
        <c:out value="${password}" escapeXml="false"/>
        <c:out value="${email}" escapeXml="false"/>
        <c:out value="${name}" escapeXml="false"/>
        <c:out value="${gender}" escapeXml="false"/>
        <c:out value="${age}" escapeXml="false"/>
        <c:out value="${location}" escapeXml="false"/>
    </div>
</body>
</html>
