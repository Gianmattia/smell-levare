<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import = "logic.applicationController.SessionArtistController"  %>
<%@page import = "logic.utils.SessionArtist"  %>
<%@page import = "logic.applicationController.HomepageArtistController"  %>
<%@page import = "logic.bean.EventBean" %>


<% 
    HomepageArtistController hac = new HomepageArtistController();
    
	SessionArtistController sac = new SessionArtistController();
	sac.sessionArtistSetup();
	SessionArtist instanceA = SessionArtist.getInstance();
    String username = instanceA.getUsername();
    EventBean eventname = hac.getLiveEventWeb();

 %>


<!DOCTYPE html>
<html>
  <head>
    <title>Prova</title>
  </head>
  <body style="    height: 512px; background-color: white;"><img src="https://image.flaticon.com/icons/png/512/26/26362.png"

 

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome </h1>
    
    <h1 style="margin-top:-58px; margin-left: 1150px;">
      
    </h1>
    <h1 style="margin-top:84px;margin-left:3px;">
       <form action="TastoChart" method="post">
        <p style="margin-top:-74px;margin-left:160px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;">Chart</button>
        </p>
      </form>
      <form action="TastoMap" method="post">
        <p style="margin-top:-74px;margin-left:-180px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;">Map</button>
        </p>
      </form>
      <form action="Homepage" method="post">
        <p style="margin-top:-74px;margin-left:-555px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;background-color: #4D4D4D;color:white;">Homepage</button>
        </p>
      </form>
      <form action="HostShowWebController" method="get">
        <p style="margin-top:-74px;margin-left:937px;"><button name="Proposte" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;">Proposte</button></p>
      </form>
    </h1>
    <h1 style="margin-top: -74px;margin-left:px ;background-color: white;">
      <style>
#rectangle {
    width: 1250px;
    height: 50px;
    background: #10030F;
}
</style> <div id="rectangle"></div>
    </h1>
              <h1 style="margin-top: -159px; margin-left: 1100px;"> <input value=<%=username %> size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1>
      <form action="Logout" method="post">          <h1 style="margin-left: 1190px;margin-top: -57px;" > <input value="logout" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1></form> 
    
    <h1 style="margin-top: -20px; margin-left: 1170px;">
     
    </h1>
    <!-- Primo artista  -->
    <p style="margin-top: 300px; margin-left: 5px;"> <img src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

 

        style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista"></label></h2>
    <li>
      <h3 style=" margin-top: px;margin-left: 400px;">
        <ul>
          <input readonly="readonly" value=<%= instanceA.getUsername() %> id="Nome" name="Nome" style="height: 25px; width: 225px;"

 

            type="text">
        </ul>
        <ul>
          <input readonly="readonly" value=<%= instanceA.getTalent() %> id="Talent" name="Talent"

 

            style="height: 25px; width: 225px;" type="text">
        </ul>
        <ul>
          <input readonly="readonly" value=<%= instanceA.getEmail() %> id="password" name="password"

 

            style="height: 25px; width: 225px;" type="text">
            
        </ul>
         <input readonly="readonly" value=<%= instanceA.getDescription() %> id="descrizione" name="descrizione"

 

            style="height: 25px; width: 225px;margin-left:40px;" type="text">
           
      </h3>
    </li>
    <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
      <button name="Dona" style="height: 35px; width: 90px; margin-top: -150px; margin-left:520px; background-color: #4d4d4d;">Modifica</button>
    </form>
    <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
      <button name="Informazioni" style="height: 35px; width: 90px; margin-buttom:200px; margin-left: 70px; background-color: #4d4d4d;">Modifica
        foto</button></form>
    <h2 style="margin-left:950px;margin-top: -300px;">Le tue prenotazioni:</h2>
      
    
    <%if ((String)session.getAttribute("Hosting") != "noshow"){ %>
    <form action="Homepage" method="get">
      <h3 style="margin-left:960px;margin-top: 30px;"><%=eventname.getName() %></h3>
    <button name="Informazioni" style="height: 60px; width: 120px; margin-left: 980px; background-color: #4d4d4d;">Dismiss</button>
    </form>
    <% }%>	
  </body>
</html>

 

 
