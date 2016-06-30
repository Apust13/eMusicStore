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

    <c:if test="${pageContext.request.userPrincipal.name != null}">

    <h2>
      Welcome:${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout"/>" >Logout</a>
    </h2>

    </c:if>

    <h3>
      <a href="<c:url value="/admin/productInventary"/>" >Product Inventory</a>
    </h3>

    <p>      Here you can view, check and modify the product inventary!    </p>

    <br><br>

    <h3>
      <a href="<c:url value="/admin/customer"/>" >Customer Management</a>
    </h3>

    <p>      Here you can view the customer information!   </p>


    <%@include file="/WEB-INF/view/template/footer.jsp"%>



