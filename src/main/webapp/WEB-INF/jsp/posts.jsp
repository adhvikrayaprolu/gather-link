<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="components/header.jsp" %>

<div class="container my-5">
    
    <h2 class="mb-4 text-primary text-center">${group.groupName}</h2>

    <div class="d-flex justify-content-end mb-4">
        <form action="${pageContext.request.contextPath}/posts/create" method="get">
		    <input type="hidden" name="groupId" value="${group.groupId}" />
		    <button type="submit" class="btn btn-primary">Create New Post</button>
		</form>
    </div>

    <div class="scrollable-posts" style="max-height: 600px; overflow-y: auto;">
    <c:forEach var="post" items="${posts}">
        <div class="card mb-3 shadow-sm">
            <div class="card-body">
                <p class="card-text">${post.content}</p>
                
                <div style="background-color: #e7f3ff;" class="p-2 rounded border mt-3">
                    <small class="text-muted">
                        Posted by <strong>${post.postCreator.username}</strong> on ${post.formattedDate}
                    </small>
                </div>
            </div>
        </div>
    </c:forEach>
	</div>

</div>

<%@ include file="components/footer.jsp" %>
