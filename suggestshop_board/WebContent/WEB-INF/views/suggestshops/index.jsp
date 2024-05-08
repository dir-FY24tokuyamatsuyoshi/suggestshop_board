<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url= "../layout/app.jsp">
    <c:param name = "content">
        <h2>お店の一覧</h2>
        <ul>
            <c:forEach var = "suggestshop" items = "${suggestshops}">
                <li>
                    <a href = "${pageContext.request.contextPath}/show?id=${suggestshop.id}">
                        <c:out value = "${suggestshop.id }"/>
                    </a>
                    :<c:out value = "${suggestshop.shopname }"></c:out> &gt; <c:out value="${suggestshop.star}" />
                </li>
            </c:forEach>
        </ul>
        
        <p><a href = "${pageContext.request.contextPath }/new">新しく見つけたお店の投稿</a>
    </c:param>
</c:import>