<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="components/header.jsp" %>



<div class="container mt-5">

	<h1 class="text-center custom-heading mb-4">Users for *insert interest group*</h1>

    <div class="card shadow-sm mb-5 form-card">
        <div class="card-body">
            <h5 class="card-title" style="color: #337ab7;">Add New User</h5>
            <form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/users/add">
                <div class="row g-3">
                    <div class="col-md-4">
                        <input type="text" name="username" placeholder="Username" class="form-control" required />
                    </div>
                    <div class="col-md-4">
                        <input type="email" name="email" placeholder="Email" class="form-control" required />
                    </div>
                    <div class="col-md-4">
                        <input type="password" name="password" placeholder="Password" class="form-control" required />
                    </div>
                </div>
                <div class="mt-3">
                    <button type="submit" class="btn btn-custom">Add User</button>
                </div>
            </form>
        </div>
    </div>
    
    <h1 class="text-center custom-heading mb-4">View All Users</h1>
   
    <div class="table-responsive">
        <table class="table table-striped table-bordered shadow-sm custom-table">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th class="text-center">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td class="text-center">
                            <button class="btn btn-sm btn-outline-primary me-2">Edit</button>
                            <button class="btn btn-sm btn-outline-danger">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="components/footer.jsp" %>
