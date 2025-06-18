<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>오늘의 날씨</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background: linear-gradient(to bottom, #dbe9f4, #ffffff);
      color: #333;
      text-align: center;
      padding: 50px;
    }

    .weather-box {
      background-color: #ffffff;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      margin: auto;
    }

    .weather-box h2 {
      margin-bottom: 10px;
      font-size: 28px;
    }

    .description {
      font-size: 20px;
      margin-bottom: 15px;
    }

    .icon {
      width: 60px;
      vertical-align: middle;
    }

    .info {
      font-size: 18px;
      margin-top: 10px;
    }
  </style>
</head>
<body>

<div class="weather-box">
  <h2>${city}</h2>
  <div class="description">
    오늘의 날씨: ${weather.weather[0].description}
    <img class="icon" src="${iconUrl}" alt="날씨 아이콘"/>
  </div>
  <div class="info">
    온도: ${weather.main.temp}°<br/>
    습도: ${weather.main.humidity}%
  </div>
</div>

</body>
</html>