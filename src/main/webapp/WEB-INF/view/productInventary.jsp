<%--
  Created by IntelliJ IDEA.
  User: GUN
  Date: 29.04.2016
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">
  <div class="container">
    <div class="page-header">
      <h1>Product Inventary Page</h1>

      <p class="lead">This is the product inventory page!</p>
    </div>

    <table class="table table-striped table-hover">
      <thead>
      <tr class="bg-success">
        <th>Photo</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Status</th>
        <th>Amount</th>
        <th>Detail</th>
      </tr>
      </thead>
      <c:forEach items="${products}" var="product">
        <tr>
          <td ><img src="<c:url value="/resources/images/${product.productId}.jpg" />" alt="image" style="width: 100%"/></td>
          <td>${product.productName}</td>
          <td>${product.productCategory}</td>
          <td>${product.productCondition}</td>
          <td>${product.productPrice} USD</td>
          <td>${product.productManufacturer}</td>
          <td>${product.productStatus}</td>
          <td>${product.unitInStock}</td>
          <td>
            <a href="<spring:url value="/product/viewProduct/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
            <a href="<spring:url value="/admin/product/deleteProduct/${product.productId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
            <a href="<spring:url value="/admin/product/editProduct/${product.productId}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
          </td>
        </tr>
      </c:forEach>
    </table>

    <a href="<spring:url value="/admin/product/addProduct"/>" class="btn btn-primary">Add Product</a>

    <%@include file="/WEB-INF/view/template/footer.jsp"%>




