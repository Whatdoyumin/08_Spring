<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인</title>
  <style>
    :root {
      --primary-color: #1B64DA;
      --bg-color: #f9fafb;
      --text-color: #1c1c1e;
      --border-color: #d1d1d6;
      --error-color: #ff3b30;
    }

    body {
      margin: 0;
      padding: 0;
      background-color: var(--bg-color);
      font-family: 'Apple SD Gothic Neo', 'Segoe UI', sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: var(--text-color);
    }

    .login-box {
      background-color: white;
      width: 360px;
      padding: 40px;
      border-radius: 16px;
      box-shadow: 0 6px 16px rgba(0, 0, 0, 0.06);
    }

    .login-box h1 {
      font-size: 22px;
      font-weight: 600;
      margin-bottom: 30px;
      text-align: center;
    }

    .form-group {
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-size: 14px;
      color: #6e6e73;
    }

    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 12px;
      border: 1px solid var(--border-color);
      border-radius: 12px;
      background-color: #f2f2f7;
      font-size: 14px;
      outline: none;
      box-sizing: border-box;
      transition: border 0.2s ease;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
      border-color: var(--primary-color);
      background-color: #fff;
    }

    .error-message {
      color: var(--error-color);
      font-size: 13px;
      margin-bottom: 16px;
      text-align: center;
    }

    input[type="submit"] {
      width: 100%;
      padding: 14px;
      background-color: var(--primary-color);
      color: white;
      border: none;
      border-radius: 12px;
      font-size: 15px;
      font-weight: 600;
      cursor: pointer;
      transition: background-color 0.2s ease;
    }

    input[type="submit"]:hover {
      background-color: #1655c0;
    }
  </style>
</head>
<body>
<div class="login-box">
  <h1>로그인</h1>
  <form name='f' action='/security/login' method='POST'>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <c:if test="${param.error != null}">
      <div class="error-message">사용자 ID 또는 비밀번호가 틀립니다.</div>
    </c:if>

    <div class="form-group">
      <label for="username">아이디</label>
      <input type="text" id="username" name="username" />
    </div>

    <div class="form-group">
      <label for="password">비밀번호</label>
      <input type="password" id="password" name="password" />
    </div>

    <input type="submit" value="로그인" />
  </form>
</div>
</body>
</html>