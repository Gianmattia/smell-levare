<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
String ids = (String)session.getAttribute("id_reg");
%>
<!DOCTYPE html>
<html  lang="it">
  <head>
    <title>Prova</title>
  </head>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome </h1>
    <p style="margin-top: -45.5667px; margin-left: 115px;"> </p>
    <h3 style=" margin-top: 70px;margin-left: 480px;">
     <ul>
             <label  name="login" value="" style="height: 60px; width: 150px; margin-top: 50px; margin-left:px;">Selezionare: </label>
    
    </ul>
    <form action="Registrazione" method="post">
    <ul>
        <button  value="User" id="email" name="id" style="height: 25px; width: 60px;margin-top: -130px; margin-left:150px;">User</button>
      </ul>    

 

  <ul>
        <button  value="Performer" id="email" name="id" style="height: 25px; width: 60px;margin-top: -150px; margin-left:150px; color:white">Artist</button>
      </ul>
      
  <ul>
        <button  value="Sponsor" id="email" name="id" style="height: 25px; width: 60px;margin-top: -130px; margin-left:150px;">Sponsor</button>
      </ul>
    
    </form>
    
    <form action="Registrazione" method="get">
        <input  value=<%= ids %> id="username" name="ids" style="display:none; height: 25px; width: 225px;"><%= ids %></input>
    
      <ul>
        <input  value="Nome Utente" id="username" name="username" style="height: 25px; width: 225px;"type="text"></input>
      </ul>
      <ul>
        <input  value="password" id="password" name="password"

 

          style="height: 25px; width: 225px;" type="text"></input>
      </ul>
      <ul>
        <input  value="email" id="email" name="param1" style="height: 25px; width: 225px;"
    type="text"></input>
      </ul>
         
         <ul>
        <input  value="descrizione" id="email" name="descrizione" style="height: 25px; width: 225px;"

 

          type="text"></input>
          </ul> 
             <ul>
        <input  value="talent" id="email" name="param2" style="height: 25px; width: 225px;"type="text"></input>
          </ul>        
           
    </h3>
      <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 60px; margin-left: 595px; background-color: #4d4d4d;">Registrati</button></form>
      
     
 </form>
 

 

  </body>
</html>