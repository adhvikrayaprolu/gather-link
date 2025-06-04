<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp" %>

<div class="container mt-5">
    <h2 class="text-center mb-4 text-primary">Login</h2>
    <form action="${pageContext.request.contextPath}/login" method="post" class="mx-auto" style="max-width: 400px;">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" name="username" required />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" name="password" required />
        </div>
        <button type="submit" class="btn btn-primary w-100">Login</button>
    </form>
</div>

<%@ include file="components/footer.jsp" %>
