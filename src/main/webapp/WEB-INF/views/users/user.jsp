<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<div
			class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
			<c:if test="${not empty msg}">
				<div class="alert alert-${css} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>${msg}</strong>
				</div>
			</c:if>
			<c:if test="${empty msg}">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Profile User</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
								<img alt="User Pic"
									src="https://cdn1.iconfinder.com/data/icons/business-charts/512/customer-512.png"
									class="img-circle img-responsive">
							</div>
							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>First Name</td>
											<td>${user.first_name}</td>
										</tr>
										<tr>
											<td>Last Name</td>
											<td>${user.last_name}</td>
										</tr>
										<tr>
											<td>Email</td>
											<td>${user.email}</td>
										</tr>
										<tr>
											<td>Description</td>
											<td>${user.bio}</td>
										</tr>
										<tr>
											<td>Employee Code</td>
											<td>${user.employee_code}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>