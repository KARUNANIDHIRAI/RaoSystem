<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
	<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1" charset="ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
</head>
<body>
	<form id="abc" name="knrai" action="Inventory/RwaSubscriptionReport" method="post"
		class="form-horizontal needs-validation" autocomplete="off" novalidate>
		<div class="row justify-content-md-center">
			<div class="col-sm-12">
				<div class="form-row">
					<div>
						<c:forEach items="${EmpList}" var="product" >
								<tr>
									<td>${product. }</td>
									<td>${product.name }</td>
									<td>${product.price }</td>
									<td>${product.quantity }</td>
								</tr>
							</c:forEach>

					</div>
				</div>
			</div>
		</div>

	</form>
<div class="treeview-colorful w-20 border border-secondary mx-4 my-4">
  <h6 class="pt-3 pl-3">Folders</h6>
  <hr>
  <ul class="treeview-colorful-list mb-3">
    <li class="treeview-colorful-items">
      <a class="treeview-colorful-items-header">
        <i class="fas fa-plus-circle"></i>
        <span><i class="far fa-envelope-open ic-w mx-1"></i>Mail</span>
      </a>
      <ul class="nested">
        <li>
          <div class="treeview-colorful-element"><i class="far fa-bell ic-w mr-1"></i>Offers
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="far fa-address-book ic-w mr-1"></i>Contacts
        </li>
        <li class="treeview-colorful-items">
          <a class="treeview-colorful-items-header">
            <i class="fas fa-plus-circle"></i>
            <span><i class="far fa-calendar-alt ic-w mx-1"></i>Calendar</span></a>
          <ul class="nested">
            <li>
              <div class="treeview-colorful-element"><i class="far fa-clock ic-w mr-1"></i>Deadlines
            </li>
            <li>
              <div class="treeview-colorful-element"><i class="fas fa-users ic-w mr-1"></i>Meetings
            </li>
            <li>
              <div class="treeview-colorful-element"><i class="fas fa-basketball-ball ic-w mr-1"></i>Workouts
            </li>
            <li>
              <div class="treeview-colorful-element"><i class="fas fa-mug-hot ic-w mr-1"></i>Events
            </li>
          </ul>
        </li>
      </ul>
    </li>
    <li class="treeview-colorful-items">
      <a class="treeview-colorful-items-header">
        <i class="fas fa-plus-circle"></i>
        <span><i class="far fa-folder-open ic-w mx-1"></i>Inbox</span>
      </a>
      <ul class="nested">
        <li>
          <div class="treeview-colorful-element"><i class="far fa-folder-open ic-w mr-1"></i>Admin
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="far fa-folder-open ic-w mr-1"></i>Corporate
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="far fa-folder-open ic-w mr-1"></i>Finance
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="far fa-folder-open ic-w mr-1"></i>Other
        </li>
      </ul>
    </li>
    <li class="treeview-colorful-items">
      <a class="treeview-colorful-items-header">
        <i class="fas fa-plus-circle"></i>
        <span><i class="far fa-gem mx-1"></i>Favourites</span>
      </a>
      <ul class="nested">
        <li>
          <div class="treeview-colorful-element"><i class="fas fa-pepper-hot ic-w mr-1"></i>Restaurants
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="far fa-eye ic-w mr-1"></i>Places
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="fas fa-gamepad ic-w mr-1"></i>Games
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="fas fa-cocktail ic-w mr-1"></i>Coctails
        </li>
        <li>
          <div class="treeview-colorful-element"><i class="fas fa-pizza-slice ic-w mr-1"></i>Food
        </li>
      </ul>
    </li>
    <li>
      <div class="treeview-colorful-element"><i class="far fa-comment ic-w mr-1"></i>Notes
    </li>
    <li>
      <div class="treeview-colorful-element"><i class="fas fa-cogs ic-w mr-1"></i>Settings
    </li>
    <li>
      <div class="treeview-colorful-element"><i class="fas fa-desktop ic-w mr-1"></i>Devices
    </li>
    <li>
      <div class="treeview-colorful-element"><i class="fas fa-trash-alt ic-w mr-1"></i>Deleted Items
    </li>
  </ul>
</div>
$(document).ready(function() {
  $('.treeview-colorful').mdbTreeview();
});
</body>
</html>