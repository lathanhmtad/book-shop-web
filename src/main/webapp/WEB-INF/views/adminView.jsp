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
    <div class="card bg-light">
      <div class="card-body p-5">
        <h1 class="display-5 mb-3">Quản lý Shop Bán Sách</h1>
        <div class="mb-3">
	        <a href="${pageContext.request.contextPath}/admin-report-books-sold" class="btn btn-primary">In thông tin bán sách</a>
	        <a href="${pageContext.request.contextPath}/category-sales-report" class="btn btn-warning text-white">
	        Báo cáo doanh thu sách theo thể loại</a>
	    </div>
        <div class="row">
          <div class="col-6 col-lg-3">
            <figure class="card">
              <div class="p-3">
                <h4 class="title">${requestScope.totalUsers}</h4>
                <span>người dùng</span>
              </div>
            </figure>
          </div>
          <div class="col-6 col-lg-3">
            <figure class="card">
              <div class="p-3">
                <h4 class="title">${requestScope.totalCategories}</h4>
                <span>thể loại sách</span>
              </div>
            </figure>
          </div>
          <div class="col-6 col-lg-3">
            <figure class="card">
              <div class="p-3">
                <h4 class="title">${requestScope.totalProducts}</h4>
                <span>sách</span>
              </div>
            </figure>
          </div>
          <div class="col-6 col-lg-3">
            <figure class="card">
              <div class="p-3">
                <h4 class="title">${requestScope.totalOrders}</h4>
                <span>đơn hàng</span>
              </div>
            </figure>
          </div>
        </div>
      </div>
    </div> <!-- card.// -->
  </div> <!-- container.// -->
</section> <!-- section-content.// -->

<section>
	<div class="container">
		<h3>Biểu đồ thống kê tổng số sách theo danh mục</h3>
		<canvas id="myChart"></canvas>
	</div>
</section>

<jsp:include page="_footerAdmin.jsp"/>

<script src="${pageContext.request.contextPath }/js/chart.umd.js"></script>

<script type="text/javascript">
	const ctx = document.getElementById('myChart').getContext('2d');
	
	const totalBooksInCategories = ${totalBooksInCategories};
	const labels = totalBooksInCategories.map(item => item.categoryName);
	const values = totalBooksInCategories.map(item => item.totalBooks);

	new Chart(ctx, {
	    type: 'bar',
	    data: {
	      labels: labels,
	      datasets: [{
	        label: 'Tổng số sách',
	        data: values,
	        borderWidth: 1
	      }]
	    },
	    options: {
	      scales: {
	        y: {
	          beginAtZero: true
	        }
	      }
	    }
	});

</script>
</body>

</html>
