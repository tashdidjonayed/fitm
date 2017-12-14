<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<div class="container">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<div class="row">
		<div class="md-col-8">
			<fieldset>
				<legend>
					<h2>course List</h2>
				</legend>
				<table class="table table-hover table-dark">
					<thead class="bg-primary">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Course Name</th>
							<th scope="col">Category</th>
							<th scope="col">Description</th>
							<th scope="col">Code</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty msg}">
							<c:forEach items="${courses}" var="course" varStatus="count">
								<tr>
									<th scope="row">${count.index + 1}</th>
									<td>${course.name}</td>
									<td>${course.category}</td>
									<td>${course.description}</td>
									<td>${course.code}</td>
									<td><spring:url value="/course/${course.course_id}"
											var="detailActionUrl" />
										<button class="btn btn-info"
											onclick="location.href='${detailActionUrl}'">Detail</button>
										<spring:url value="/course/${course.course_id}/edit"
											var="editActionUrl" />
										<button class="btn btn-warning"
											onclick="location.href='${editActionUrl}'">Edit</button> <spring:url
											value="/course/${course.course_id}/delete"
											var="deleteActionUrl" />
										<button class="btn btn-danger"
											onclick="location.href='${deleteActionUrl}'">Delete</button></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<div class="col-md-12 row-mt">
					<div class="col-sm-3">
						<tag:paginate max="${max}" offset="${offset}" count="${count}"
							uri="courseList" next="&raquo;" previous="&laquo;" />
					</div>
					<div class="col-sm-6"></div>
				</div>
			</fieldset>
		</div>
	</div>
</div>