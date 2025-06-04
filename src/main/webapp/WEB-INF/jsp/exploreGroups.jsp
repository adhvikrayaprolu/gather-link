<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="components/header.jsp" %>

<div class="container my-5">

    <div class="card shadow-sm border-0 mb-5">
        <div class="card-body">
            <h5 class="card-title mb-4 text-primary">Create a New Group</h5>
            <form method="post" action="${pageContext.request.contextPath}/groups/add">
                <div class="row g-3">
                    <div class="col-md-4">
                        <input type="text" name="groupName" class="form-control" placeholder="Group Name" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" name="description" class="form-control" placeholder="Description" required />
                    </div>
                    <div class="col-md-4">
                        <select name="owner.userId" class="form-select" required>
                            <option value="" disabled selected>Select Owner</option>
                            <c:forEach var="user" items="${users}">
                                <option value="${user.userId}">${user.username}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="mt-3 text-center">
                    <button type="submit" class="btn btn-primary px-4">Add Group</button>
                </div>
            </form>
        </div>
    </div>

    <h2 class="text-center mb-4 text-primary">Explore Groups</h2>
    <c:forEach items="${groups}" var="group">
        <div class="card mb-4 shadow-sm border border-primary-subtle">
            <div class="card-body">
                <h4 class="card-title fw-bold mb-2 text-primary">Group Name: ${group.groupName}</h4>
                <p class="card-text mb-1"><strong>Description:</strong> ${group.description}</p>
                <p class="card-text mb-1"><strong>Group Creator:</strong> ${group.owner.username}</p>
                <p class="card-text mb-3"><strong>Statistics:</strong></p>
                <span class="badge bg-secondary me-2">Members: ${group.memberCount}</span>
                <span class="badge bg-info text-dark">Posts: ${group.postCount}</span>
                <div class="mt-3">
                    <form action="#" method="post">
                        <button type="submit" class="btn btn-outline-primary btn-sm">Join Group</button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>

</div>

<%@ include file="components/footer.jsp" %>
