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


	<div class="container col-sm-5 col-right address" style="width: 80%">

		<div class="panel panel-default">

			<div class="panel-heading">
				<h4 class="capital">
					<spring:message code="address.save" text="Address" />
				</h4>

			</div>

			<!-- List of addresses -->
			<div class="panel-body">
				
				<table class="table">
					<thead>
						<tr>
							<th>Address<span class="red">*</span></th>
							<th>City<span class="red">*</span></th>
							<th>State<span class="red">*</span></th>
							<th>Pincode<span class="red">*</span></th>
							<th>Phone Number<span class="red">*</span></th>
						</tr>
					</thead>
					<tbody id="addressList">
						<c:forEach items="${addressList}" var="addr">
							<tr class="address margintop-15 padding-3">
								<td> ${addr.address} </td>
								<td> ${addr.city} </td>
								<td> ${addr.state} </td>
								<td> ${addr.pincode} </td>
								<td> ${addr.phoneNumber}</td>
								<td>	<font><strong class="fontstyle" ><a href="deleteAddress?addressId=${addr.addressId}" class="removeAddress" >Remove
																Address</a></strong></font></td>
								<td>	<font><strong class="fontstyle" ><a href="modifyAddress?addressId=${addr.addressId}" class="modifyAddress" >Modify
																Address</a></strong></font></td>
												
																			
							</tr>
							
						</c:forEach>
						

					</tbody>

				</table>
				<br>
						
			</div>
			<!-- EndList of addresses -->

			<div class="panel-body">

				<form:form method="POST" action="saveAddress"
					modelAttribute="adrForm">
					<form:hidden path="addressId" class="form-control" />
					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">
							<spring:message code="address.address" text="Address" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:input maxlength="50" path="address" class="form-control" />
							<br>
							<form:errors path="address" />
						</div>
						<br>
					</div>

					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="address.pincode" text="Pincode" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:input maxlength="6" path="pincode" class="form-control" />
							<br>
							<form:errors path="pincode" />
						</div>
						<br>
					</div>

					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="address.city" text="City" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:input path="city" class="form-control" />
							<br>
							<form:errors path="city" />
						</div>
						<br>
					</div>


					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="address.state" text="State" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:select path="state">
								<form:option value="-" label="-Please Select-" />
								<form:options items="${stateOptions}" />
							</form:select>

							<br>
							<form:errors path="state" />
						</div>
						<br>
					</div>

					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-4 text-right fontstyle">

							<spring:message code="address.phonenum" text="PhoneNumber" />
							<span style="color: red">*</span>
						</div>
						<div class="col-sm-6">
							<form:input path="phoneNumber" class="form-control" maxlength="10" />
							<br>
							<form:errors path="phoneNumber" />
						</div>
						<br>
					</div>


					<div class="row">
						<div
							class="form-group col-sm-offset-1 col-sm-3 text-right fontstyle">

						</div>
						<div class="col-sm-6">
							<input type="submit" class="btn btn-primary"
								value="<spring:message code="address.submit" text="Save Address"/>" />
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