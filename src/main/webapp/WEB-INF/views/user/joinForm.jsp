<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %> 

<div class="container">
   <form class="was-validated" >
     
     <div class="form-group">
       <label for="username">Username:</label>
       <button id="btn-username-check" type="button" class="btn btn-warning float-right" onclick="usernameCheck()">중복확인</button>
       <input type="text" class="form-control" id="username" placeholder="Enter username" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>
     
     <div class="form-group">
       <label for="pwd">Password:</label>
       <input type="password" class="form-control" id="password" placeholder="Enter password" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>
     
     <div class="form-group">
       <label for="email">Email:</label>
       <input type="email" class="form-control" id="email" placeholder="Enter Email" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>
		<%-- type을 button으로 함으로써 클릭시 submit 방지 --%>
     <button id="btn-save" type="button" class="btn btn-primary">회원가입완료</button>
   </form>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
