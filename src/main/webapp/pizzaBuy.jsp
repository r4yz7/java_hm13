<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmish
  Date: 29.10.2023
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Pizza</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
</head>
<body>
<header class="d-flex justify-content-center py-3">
  <ul class="nav nav-pills">
    <li class="nav-item"><a href="pizzaServet" class="nav-link active" aria-current="page">Home</a></li>
    <li class="nav-item"><a href="#" class="nav-link">Pizza constructor</a></li>
    <li class="nav-item"><a href="#" class="nav-link">Pricing</a></li>
    <li class="nav-item"><a href="#" class="nav-link">FAQs</a></li>
    <li class="nav-item"><a href="#" class="nav-link">About</a></li>
  </ul>
</header>
<div class="container">
  <h1>You want to buy ${pizza.name}</h1>
  <form>
    <div class="mb-3">
      <label class="form-label" for="firstname">Firstname:</label>
      <input required type="text" name="firstname" id="firstname" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label" for="number">Number of phone:</label>
      <input required type="number" name="number" id="number" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label" for="email">Email:</label>
      <input required type="email" name="email" id="email" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label" for="address">Address:</label>
      <select class="form-select" id="address" name="address" aria-label="Default select example">
        <c:forEach var="i" items="${deliveries}">
          <option>${i.streetName}, ${i.houseNumber}</option>
        </c:forEach>
      </select>
    </div>
    <a href="pizzaServet" class="btn btn-outline-success">BUY</a>
  </form>
</div>


<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
  <div class="col-md-4 d-flex align-items-center">
    <a href="/" class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1">
      <svg class="bi" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>
    </a>
    <span class="mb-3 mb-md-0 text-body-secondary">© 2023 Company, Inc</span>
  </div>

  <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
    <li class="ms-3"><a class="text-body-secondary" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"></use></svg></a></li>
    <li class="ms-3"><a class="text-body-secondary" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"></use></svg></a></li>
    <li class="ms-3"><a class="text-body-secondary" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"></use></svg></a></li>
  </ul>
</footer>
</body>
</html>
