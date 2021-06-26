<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Prova</title>
  </head>
  <body style="background-color: white; background-image: url(&quot;https://www.cilentonotizie.it/public/images/11122020_foto-PalaSele_phangelotortorella_03.jpg&quot;);"><img

      src="https://image.flaticon.com/icons/png/512/26/26362.png" alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome </h1>
    <p style="margin-top: -45.5667px; margin-left: 115px;"> </p>
    <h3 style=" margin-top: 150px;margin-left: 480px;">
    <form action="Prova" method="post">
      <ul>
        <input  value="Nome Utente" id="username" name="username" style="height: 25px; width: 225px;"

          type="text">
      </ul>
      <ul>
        <input  value="password" id="password" name="password"

          style="height: 25px; width: 225px;" type="text">
      </ul>
      <ul>
        <input  value="email" id="email" name="email" style="height: 25px; width: 225px;"

          type="text">
      </ul>
    </h3>
    
      <input type="submit" name="login" value="login" style="height: 35px; width: 90px; margin-top: -150px; margin-left: 595px; background-color: #4d4d4d;">Login</input>
    </form>
    <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
      <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 595px; background-color: #4d4d4d;">Registrati</button></form>
    <form action="register" method="get">
      <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 595px; background-color: #4d4d4d;">Continua
        senza login</button></form>
    
  </body>
</html>
