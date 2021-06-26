<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Prova</title>
  </head>
  <body style=" height: 512px; background-color: white;"><img src="https://image.flaticon.com/icons/png/512/26/26362.png"

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome </h1>
    <h1 style="margin-top: -60px; margin-left: 1000px;"> <input value="" size="18"

        maxlength="40" type="text"> </h1>
     <h1 style="margin-top:-58px; margin-left: 1150px;"><form action="&lt;%= request.getContextPath() %&gt;/register" method="post"> <input value="Search artist"

                                                                                                                                            size="15" maxlength="40" ;style="background-color:" #993300="" type="submit"></form> </h1>
    <h1 style="margin-top:84px;margin-left:3px;">
      <form action="TastoProfile" method="post">
        <p style="margin-top:-74px;margin-left:674px;"><button name="Chart" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Profile</button></p>
      </form>
      <form action="TastoChart" method="post">
        <p style="margin-top:-74px;margin-left:-49px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;color:white;background-color: #4D4D4D;">Chart</button>
        </p>
      </form>
      <form action="<%= request.getContextPath() %>/register" method="post">
        <p style="margin-top:-74px;margin-left:-312px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;">Map</button>
        </p>
      </form>
      <form action="<%= request.getContextPath() %>/register" method="get">
        <p style="margin-top:-74px;margin-left:-555px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;background-color: #4D4D4D;">Homepage</button>
        </p>
      </form>
      <form action="Tasto2servlet" method="post">
        <p style="margin-top:-74px;margin-left:937px;"><button name="Setting" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;">Setting</button></p>
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
      <h1 style="margin-top: -159px; margin-left: 1170px;"> <form action="Login" method="post"><input value="Login" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"></form> </h1>
    <!-- Primo artista  -->
   
       <p style="margin-top: 300px; margin-left: 5px;"> <img src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">Scintilla
        Nuvolini</label></h2>
  <li> <h3 style=" margin-top: px;margin-left: 300px;"><ul>
    
     <label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label> </ul><ul><label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label></ul><ul><label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label></ul></h3></li>
  <form action="&lt;%= request.getContextPath() %&gt;/register" method="post" style=" margin-top: -150px;""> <textarea id="story" name="story" style=" margin-left: 950px;resize: none ;"rows="5" cols="33">
It was a dark and stormy night...
</textarea> <button name="Dona" style="height: 35px; width: 90px; margin-top: -150px; margin-left: 1030px; background-color: #4d4d4d;">Recensisci</button> </form>
  <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">   <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 480px; background-color: #4d4d4d;">Vedi altre</button></form>

    <hr align=âleftâ size=â1â³ width=â300â³ color=black noshade>
  
  
  
  
      
       <p style="margin-top: 300px; margin-left: 5px;"> <img src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">Scintilla
        Nuvolini</label></h2>
  <li> <h3 style=" margin-top: px;margin-left: 300px;"><ul>
    
     <label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label> </ul><ul><label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label></ul><ul><label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label></ul></h3></li>
  <form action="&lt;%= request.getContextPath() %&gt;/register" method="post" style=" margin-top: -150px;""> <textarea id="story" name="story" style=" margin-left: 950px;resize: none ;"rows="5" cols="33">
It was a dark and stormy night...
</textarea> <button name="Dona" style="height: 35px; width: 90px; margin-top: -150px; margin-left: 1030px; background-color: #4d4d4d;">Recensisci</button> </form>
  <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">   <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 480px; background-color: #4d4d4d;">Vedi altre</button></form>

    <hr align=âleftâ size=â1â³ width=â300â³ color=black noshade>
  
  
    
       <p style="margin-top: 300px; margin-left: 5px;"> <img src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">Scintilla
        Nuvolini</label></h2>
  <li> <h3 style=" margin-top: px;margin-left: 300px;"><ul>
    
     <label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label> </ul><ul><label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label></ul><ul><label form="Descrizione artista">-Borioso e arrogante non merita un soldo *</label></ul></h3></li>
  <form action="&lt;%= request.getContextPath() %&gt;/register" method="post" style=" margin-top: -150px;""> <textarea id="story" name="story" style=" margin-left: 950px;resize: none ;"rows="5" cols="33">
It was a dark and stormy night...
</textarea> <button name="Dona" style="height: 35px; width: 90px; margin-top: -150px; margin-left: 1030px; background-color: #4d4d4d;">Recensisci</button> </form>
  <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">   <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 480px; background-color: #4d4d4d;">Vedi altre</button></form>

    <hr align=âleftâ size=â1â³ width=â300â³ color=black noshade>
   <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
        <p style="margin-top:65px;margin-left:410px;"><button name="Chart" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Vedi altri</button></p>
      </form>
  
  </body>
</html>

