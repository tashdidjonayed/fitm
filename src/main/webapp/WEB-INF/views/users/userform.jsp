<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<c:choose>
		<c:when test="${status == 'add'}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>
	<br />
	<div class="col-md-6">
		<spring:url value="/user" var="userActionUrl" />
		<form:form class="form-horizontal" method="post"
			modelAttribute="userForm" action="${userActionUrl}">
			<form:hidden path="user_id" />
			<div class="form-group">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-10">
					<form:input path="first_name" type="text" class="form-control "
						id="first_name" placeholder="Name" />
					<form:errors path="first_name" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-10">
					<form:input path="last_name" type="text" class="form-control "
						id="last_name" placeholder="Name" />
					<form:errors path="last_name" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email"
						placeholder="Email" />
					<form:errors path="email" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Username</label>
				<div class="col-sm-10">
					<form:input path="username" class="form-control" id="username"
						placeholder="username" />
					<form:errors path="username" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:input path="password" class="form-control" id="password"
						placeholder="password" />
					<form:errors path="password" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Employee code</label>
				<div class="col-sm-10">
					<form:input path="employee_code" class="form-control"
						id="employee_code" placeholder="employee_code" />
					<form:errors path="employee_code" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Description</label>
				<div class="col-sm-10">
					<form:input path="bio" class="form-control" id="bio"
						placeholder="description" />
					<form:errors path="bio" class="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${status == 'add'}">
							<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</div>