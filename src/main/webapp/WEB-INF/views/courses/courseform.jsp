<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<c:choose>
		<c:when test="${status == 'add'}">
			<h1>Add course</h1>
		</c:when>
		<c:otherwise>
			<h1>Update course</h1>
		</c:otherwise>
	</c:choose>
	<br />
	<div class="col-md-6">
		<spring:url value="/course" var="courseActionUrl" />
		<form:form class="form-horizontal" method="post"
			modelAttribute="courseForm" action="${courseActionUrl}">
			<form:hidden path="course_id" />
			<div class="form-group">
				<label class="col-sm-2 control-label">Course Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name"
						placeholder="Course Name" />
					<form:errors path="name" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Category</label>
				<div class="col-sm-10">
					<form:input path="category" type="text" class="form-control "
						id="category" placeholder="category" />
					<form:errors path="category" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Description</label>
				<div class="col-sm-10">
					<form:input path="description" class="form-control"
						id="description" placeholder="description" />
					<form:errors path="description" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Code</label>
				<div class="col-sm-10">
					<form:input path="code" class="form-control" id="code"
						placeholder="code" />
					<form:errors path="code" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Price</label>
				<div class="col-sm-10">
					<form:input path="price" class="form-control" id="price"
						placeholder="price" />
					<form:errors path="price" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Course Duration</label>
				<div class="col-sm-10">
					<form:input path="duration" class="form-control" id="duration"
						placeholder="duration" />
					<form:errors path="duration" class="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Level</label>
				<div class="col-sm-10">
					<form:input path="level" class="form-control" id="level"
						placeholder="level" />
					<form:errors path="level" class="error" />
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