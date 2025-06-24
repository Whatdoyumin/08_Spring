<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그아웃</title>
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

    .logout-box {
      background-color: white;
      width: 360px;
      padding: 40px;
      border-radius: 16px;
      box-shadow: 0 6px 16px rgba(0, 0, 0, 0.06);
      text-align: center;
    }

    .logout-box h1 {
      font-size: 20px;
      font-weight: 600;
      margin-bottom: 24px;
    }

    .logout-box a {
      display: inline-block;
      padding: 12px 24px;
      background-color: var(--primary-color);
      color: white;
      text-decoration: none;
      border-radius: 12px;
      font-weight: 600;
      transition: background-color 0.2s ease;
    }

    .logout-box a:hover {
      background-color: #1655c0;
    }
  </style>
</head>
<body>
<div class="logout-box">
  <h1>로그아웃 되었습니다.</h1>
  <a href="/">홈으로 이동</a>
</div>
</body>
</html>