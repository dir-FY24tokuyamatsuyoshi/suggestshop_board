<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url = "../layout/app.jsp">
    <c:param name = "content">
        <h2>id : ${suggestshop.id }の詳細</h2>
        
        <P>店名 : <c:out value = "${suggestshop.shopname }"/></P>
        <P>評価 : <c:out value = "${suggestshop.star }"/></P>
        <P>カテゴリー : <c:out value = "${suggestshop.category }"/></P>
        <P>一言コメント : <c:out value = "${suggestshop.comment }"/></P>
        <P>作成日時 : <fmt:formatDate value="${suggestshop.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <P>更新日時 : <fmt:formatDate value="${suggestshop.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        
        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${suggestshop.id}">このメッセージを編集する</a></p>        
        
    </c:param>
</c:import>