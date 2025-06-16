<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="components/header.jsp" %>

<div class="container mt-5">
    <h2 class="text-center mb-4 text-primary">Members of "${group.groupName}"</h2>

    <div class="table-responsive">
        <table class="table table-striped table-bordered shadow-sm custom-table">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="membership" items="${memberships}">
                    <tr>
                        <td>${membership.user.userId}</td>
                        <td>${membership.user.username}</td>
                        <td>${membership.user.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
