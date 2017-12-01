<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="margin-top: 50px">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<div class="row" style="margin-top: 20px">
		<div class="md-col-8">
			<fieldset>
				<legend>
					<h2>User List</h2>
				</legend>
				<table class="table table-hover table-dark">
					<thead class="bg-primary">
						<tr>
							<th scope="col">#</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email</th>
							<th scope="col">Description</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty msg}">
							<c:forEach items="${users}" var="user" varStatus="count">
								<tr>
									<th scope="row">${count.index + 1}</th>
									<td>${user.first_name}</td>
									<td>${user.last_name}</td>
									<td>${user.email}</td>
									<td>${user.bio}</td>
									<td><spring:url value="/${user.user_id}"
											var="detailActionUrl" />
										<button class="btn btn-info"
											onclick="location.href='${detailActionUrl}'">Detail</button>
										<spring:url value="/${user.user_id}/edit" var="editActionUrl" />
										<button class="btn btn-warning"
											onclick="location.href='${editActionUrl}'">Edit</button> <spring:url
											value="/${user.user_id}/delete" var="deleteActionUrl" />
										<button class="btn btn-danger"
											onclick="location.href='${deleteActionUrl}'">Delete</button></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</div>