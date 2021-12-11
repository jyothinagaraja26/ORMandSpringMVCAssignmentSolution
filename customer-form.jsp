<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer </title>
</head>

<body>

	<div class="container">

		<h3>Customer Form</h3>
		<hr>

		<form action="/Customer_Relationship_Management/customer/save" method="POST">

			<!-- Add hidden form field to handle update -->
			 <input type="hidden" name="id" value="${Customers.id}" />

			

            <div class="form-inline">
				<input type="text" name="firstName" value="${Customers.firstName}"
					class="form-control mb-4 col-4" placeholder="FirstName">



			</div>
			<div class="form-inline">

				<input type="text" name="lastName" value="${Customers.lastName}"
					class="form-control mb-4 col-4" placeholder="LastName">



			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${Customers.email}"
					class="form-control mb-4 col-4" placeholder="Email">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Customer_Relationship_Management/customer/list">Back to Customers List</a>

	</div>
</body>

</html>