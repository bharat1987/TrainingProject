<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>MS-Project</title>


<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

	<!-- SIGNUP -->


	<div class="container col-sm-5 col-right signup" style="width: 40%">

		<div class="panel panel-default">

			<div class="panel-heading">
				<h4 class="capital">
					<spring:message code="account.modify" text="Modify Account" />
				</h4>

			</div>
			<div class="panel-body">
				<form:form method="POST" action="updateAccount" modelAttribute="command">
					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">
							<spring:message code="account.userid" text="User Id" />
						</div>
						<div class="col-sm-6">
							<form:input readonly="true"  path="userId" class="form-control" />
							<br>
						</div>
						<br>
					</div>

					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="account.pwd" text="Password" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:password path="password" class="form-control" />
							<br>
							<form:errors path="password" />
						</div>
						<br>
					</div>

					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="account.confirm.pwd" 	text="Confirm Password" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:password path="confirmPassword" class="form-control" />
							<br>
							<form:errors path="confirmPassword" />
						</div>
						<br>
					</div>


					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="account.name" text="Name" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:input path="name" class="form-control" />
							<br>
							<form:errors path="name" />
						</div>
						<br>
					</div>


					<div class="row">
						<div class="form-group col-sm-offset-1 col-sm-3 text-right fontstyle">

						</div>
						<div class="col-sm-6">
							<input type="submit" class="btn btn-primary" value="<spring:message code="account.submit" text="Submit"/>" />
						</div>
					</div>
					<br>
					<c:if test="${successMessage ne null}">
						<div class="alert alert-success col-md-12" align="center">${successMessage}

						</div>
					</c:if>
				</form:form>

			</div>
		</div>

	</div>

</body>
</html>