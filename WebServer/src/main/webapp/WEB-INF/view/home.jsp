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
	<div class="container col-sm-5 col-right signup" style="width: 40%">

		<div class="panel panel-default">

			<div class="panel-heading">
				<h4 class="capital">
					<spring:message code="account.modify" text="Welcome ${userId}" />
				</h4>

			</div>
			<div class="panel-body">
			<table>
				<tbody id="homeList">
						<tr class="home margintop-15 padding-3">
								<td>	<font><strong class="fontstyle" ><a href="viewAddresses" class="viewAddresses" >Manage Address</a></strong></font></td>
						</tr>
						<tr>
								<td>	<font><strong class="fontstyle" ><a href="viewCards" class="viewCards" >Manage Cards</a></strong></font></td>									
						</tr>
						<tr>
								<td>	<font><strong class="fontstyle" ><a href="modifyAccount" class="modifyAccount" >Manage Account</a></strong></font></td>									
						</tr>				

					</tbody>

				</table>
			
			
			</div>
		</div>
	</div>

</body>
</html>