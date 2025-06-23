<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Page</title>
  <style>
    :root {
      --primary-color: #1B64DA;
      --bg-color: #f9fafb;
      --text-color: #1c1c1e;
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

    .admin-box {
      background-color: white;
      width: 400px;
      padding: 40px;
      border-radius: 16px;
      box-shadow: 0 6px 16px rgba(0, 0, 0, 0.06);
      text-align: center;
    }

    .admin-box h1 {
      font-size: 22px;
      font-weight: 700;
      margin-bottom: 24px;
    }

    .admin-box form {
      margin-top: 24px;
    }

    .admin-box input[type="submit"] {
      background-color: var(--primary-color);
      color: white;
      padding: 12px 24px;
      border: none;
      border-radius: 12px;
      font-weight: 600;
      font-size: 14px;
      cursor: pointer;
      transition: background-color 0.2s ease;
    }

    .admin-box input[type="submit"]:hover {
      background-color: #1655c0;
    }
  </style>
</head>
<body>
<div class="admin-box">
  <h1>멤버 페이지</h1>
  <form action="/security/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="로그아웃" />
  </form>
</div>버
</html>