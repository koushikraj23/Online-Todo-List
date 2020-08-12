
<html>
<head>
<%@ include file="static/header.jspf"%>
<%@ include file="static/navigation.jspf"%>
</head>
<body style="font-size: 17px !important;">
	<div class="container">
		<div class="panel-body">Welcome ${name}!!</div>
		<div>
			<a type="button" class="btn btn-primary btn-md" href="/add">Add
				Todo</a>
		</div>
		<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3>List of TODO's</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Created On</th>
							<th>Last Updated</th>
							<th>Checked</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
								<td>${todo.title}</td>
								<td>${todo.description}</td>
								<td>${todo.createdAt}</td>
								<td>${todo.lastUpdated}</td>
								<td>${todo.checked}</td>
								<td><a type="button" class="btn btn-success"
									href="/update?id=${todo.id}">Update</a> <a type="button"
									class="btn btn-warning" href="/delete?id=${todo.id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<%@ include file="static/footer.jspf"%>
</body>
</html>