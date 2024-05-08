<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<!DOCTYPE html>
<html lang="vi">
<head>
  <jsp:include page="_meta.jsp"/>
  <title>Trang chủ Admin</title> 
</head>

<body>
<jsp:include page="_headerAdmin.jsp"/>

<section class="section-content padding-y">
  <div class="container">
  	<header class="section-heading pb-4 d-flex justify-content-between">
      <h3 class="section-title">Báo cáo doanh thu sách theo danh mục</h3>
    </header> <!-- section-heading.// -->
    <main class="col-md-9">
            <div class="table-responsive-xxl">
              <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                  <th scope="col" style="min-width: 125px;">Tên danh mục</th>
                  <th scope="col" style="min-width: 100px;">Tổng số sách tồn kho</th>
                  <th scope="col" style="min-width: 300px;">Số sách đã bán</th>
                  <th scope="col" style="min-width: 100px;">Doanh thu</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${requestScope.categorySalesReports}">
                  <tr>
                    <th>${item.categoryName}</th>
                    <td>${item.inventory}</td>
                    <td>${item.booksSold}</td>
                    <td><fmt:formatNumber pattern="#,##0" value="${item.revenue}"/>₫</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>

          </main> <!-- col.// -->
  </div> <!-- container.// -->
</section> <!-- section-content.// -->


<jsp:include page="_footerAdmin.jsp"/>
<script type="text/javascript">

	
</script>
</body>

</html>
