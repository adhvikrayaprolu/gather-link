<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="components/header.jsp" %>

<div class="container my-5">
    <h2 class="text-center text-primary mb-4">Edit Profile</h2>

    <form method="post" action="${pageContext.request.contextPath}/profile/update" class="mx-auto" style="max-width: 500px;">
        <div class="mb-3">
            <label for="email" class="form-label"><b>Email (cannot be changed)</b></label>
            <input type="email" class="form-control" id="email" value="${loggedInUser.email}" disabled>
        </div>

        <div class="mb-3">
            <label for="username" class="form-label"><b>Username</b></label>
            <input type="text" class="form-control" name="username" id="username" value="${loggedInUser.username}" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label"><b>New Password</b></label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Enter new password">
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary px-4">Update</button>
        </div>
    </form>
</div>

<%@ include file="components/footer.jsp" %>
