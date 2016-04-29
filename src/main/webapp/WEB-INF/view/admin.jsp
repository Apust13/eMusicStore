<%--
  Created by IntelliJ IDEA.
  User: GUN
  Date: 29.04.2016
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">
  <div class="container">
    <div class="page-header">
      <h1>Administrator Page</h1>

      <p class="lead">This is the administration page!</p>
    </div>

    <h3>
      <a href="<c:url value="/admin/productInventary"/>" >Product Inventory</a>
    </h3>

    <p>      Here you can view, check and modify the product inventary!    </p>


    <%@include file="/WEB-INF/view/template/footer.jsp"%>



