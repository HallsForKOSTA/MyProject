<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품목록</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="css/namoosori.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<article>
			<h2>상품 목록</h2>
			<form action="order.do" method="post">
				<table class="table table-bordered">
					<colgroup>
						<col width="60" />
						<col width="100" />
						<col width="*" />
						<col width="150" />
						<col width="120" />
					</colgroup>
					<thead>
						<tr>
							<th class="text-center"></th>
							<th class="text-center">상품번호</th>
							<th class="text-center">상품명</th>
							<th class="text-center">가격</th>
							<th class="text-center">평점</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product" varStatus="status">
							<tr>
								<td class="text-center"><label><input
										type="checkbox" name="buyItems" value=${product.serialNo } /></label></td>
								<td class="text-center">${status.count }</td>
								<td>${product.name }</td>
								<td class="text-right">${product.price }원</td>
								<td><p>
										<span class="starRating"><span
											style="width:${product.star}%">${product.like}점</span></span>
									</p></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
				<div class="btn-wrap">
					<button class="btn btn-primary" type="submit">주문하기</button>

				</div>
			</form>
		</article>

	</div>
</body>
</html>