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


	<div class="container col-sm-5 col-right cards" style="width: 80%">

		<div class="panel panel-default">

			<div class="panel-heading">
				<h4 class="capital">
					<spring:message code="cards.save" text="Cards" />
				</h4>

			</div>

			<!-- List of cards -->
			<div class="panel-body">
				
				<table class="table">
					<thead>
						<tr>
							<th>Card Number</th>
							<th>Name On Card</th>
							<th>Expiry Month/Year</th>
						</tr>
					</thead>
					<tbody id="cardsList">
						<c:forEach items="${cardsList}" var="card">
							<tr class="cards margintop-15 padding-3">
								<td> ${card.cardNumber} </td>
								<td> ${card.nameOnCard} </td>
								<td> ${card.expiryMonth}/${card.expiryYear} </td>
								
								<td>	<font><strong class="fontstyle" ><a href="deleteCard?cardNumber=${card.cardNumber}" class="removeCard" >Remove
																Card</a></strong></font></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<br>
						
			</div>
			<!-- EndList of cards -->

			<div class="panel-body">

				<form:form method="POST" action="saveCard"
					modelAttribute="card">
					<form:hidden path="cardId" class="form-control" />
					<div class="row">
						<div class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">
							<spring:message code="cards.cardNumber" text="Card Number" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:input maxlength="16" path="cardNumber" class="form-control" />
							<br>
							<form:errors path="cardNumber" />
						</div>
						<br>
					</div>

					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="card.Name" text="Name On Card" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:input maxlength="15" path="nameOnCard" class="form-control" />
							<br>
							<form:errors path="nameOnCard" />
						</div>
						<br>
					</div>

					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="card.month" text="Expiry Month/Year" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:select path="expiryMonth">
								<form:option value="-" label="-Please Select-" />
								<form:options items="${monthList}" />
							</form:select>/
							<form:select path="expiryYear">
								<form:option value="-" label="-Please Select-" />
								<form:options items="${yearList}" />
							</form:select>

							<br>
							<form:errors path="expiryYear" />
						</div>
						<br>
					</div>

					<div class="row">
						<div class="form-group col-sm-offset-1 col-sm-3 text-right fontstyle">

						</div>
						<div class="col-sm-6">
							<input type="submit" class="btn btn-primary"
								value="<spring:message code="cards.submit" text="Save Card"/>" />
						</div>
						<div class="col-md-12 text-center">
							<div class="text-center text-danger">${message}</div>
						</div>
					</div>
					<br>
					<c:if test="${successMessage ne null}">
						<div class="alert alert-success col-md-12" align="center">${successMessage}
							<br>
						</div>
					</c:if>
				</form:form>

			</div>
		</div>

	</div>

</body>
</html>