<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String place = (String)session.getAttribute("Posto");
    String address = (String)session.getAttribute("Indirizzo");
    
    int capacity = (int)session.getAttribute("Capienza");
    
    %>
    
<!DOCTYPE html>
<html>
  <body style="height: 512px; background-color: white;"><img

 


      src="https://image.flaticon.com/icons/png/512/26/26362.png" alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome </h1>
    <h1 style="margin-top: -60px; margin-left: 1000px;"> <input value="" size="18"maxlength="40" type="text"> </h1>
    <h1 style="margin-top:-58px; margin-left: 1150px;"> <input value="Search artist"size="15" maxlength="40" ;style="background-color:" #993300="" type="submit"> </h1>
    <h1 style="margin-top:84px;margin-left:3px;">    
  
      
    <form action="TastoProfile" method="post"><p style="margin-top:-74px;margin-left:674px;"><button name="Chart" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Profile</button></p></form>
   
    <form action="TastoChart" method="post"> <p style="margin-top:-74px;margin-left:-49px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;">Chart</button> </p></form>
                 <form action="<%= request.getContextPath() %>/register" method="post"> <p style="margin-top:-74px;margin-left:-312px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;color:white;background-color: #4D4D4D;">Map</button> </p></form>
        
         <form action="Homepage" method="get"> <p style="margin-top:-74px;margin-left:-555px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;background-color: #4D4D4D;">Homepage</button> </p></form>
     
     <form action="Tasto2servlet" method="post" ><p style="margin-top:-74px;margin-left:937px;"><button name="Setting" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;">Setting</button></p></form>
     
 
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
    <h1 style="margin-top: -159px; margin-left: 1170px;">  <form action="Login" method="post"><input value="Login" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"></form> </h1>
    <h1 style="margin-top:110px; margin-left: px;"> 
    </h1>
 
 <div id="container2"  style="display:">
  <h1> <label  style="width: 300x; height: 40px;position:absolute;margin-top: 30px;z-index:0;margin-left:1000px"></label>    </h1> 
<textarea name="text1" id="text1" readonly="readonly";  style="resize: none; width: 300x; height: 40px;position:absolute;margin-top: 100px;z-index:0;margin-left:1000px"><%= place %></textarea>
<textarea name="text2" id="text2" readonly="readonly";  style="resize: none; width: 300x; height: 40px;position:absolute;margin-top: 180px;z-index:0;margin-left:1000px"><%= address %></textarea>
<textarea name="text3" id="text3" readonly="readonly";  style="resize: none; width: 300x; height: 40px;position:absolute;margin-top: 260px;z-index:0;margin-left:1000px"><%= capacity %></textarea>

 

</div>


<div id="container3"  style="display:">
  <h1> <label  style="width: 300x; height: 40px;position:absolute;margin-top: 30px;z-index:0;margin-left:1000px"></label>    </h1> 
<textarea value="title" name="title" id="title"   style="resize: none; width: 300x; height: 40px;position:absolute;margin-top: 500px;z-index:0;margin-left:1000px">title</textarea>
<textarea name="desc" id="desc"   style="resize: none; width: 300x; height: 40px;position:absolute;margin-top: 580px;z-index:0;margin-left:1000px">description</textarea>
<textarea name="plc" id="plc" readonly="readonly";  style="display:none; resize: none; width: 300x; height: 40px;position:absolute;margin-top: 660px;z-index:0;margin-left:1000px"><%= place %></textarea>
 <input name="title2" value="titolo" id="title2" tyle="height:30px;width:300px;"></input>

</div>
 
 <form action ="TastoMapArtista" method = "post">
 <div class="container">
     <img src="https://www.researchgate.net/profile/Francesco-Mensa/publication/330994606/figure/fig1/AS:724708081283073@1549795279179/Figura-125-Mappa-della-citta-di-Roma-I-punti-colorati-indicano-i-luoghi-visitati.png" alt="" style="width: 976x; height: 976px; margin-left: -2px; overflow:hidden; z-index:-1">
     
<button type="submit" name="action" value="Eur" onclick="myFunction()" style="width: 60x; height: 60px; background-color: Transparent; border: none; margin-top: 750px; position:absolute; margin-left:-600px; float:left;"><img src="https://image.flaticon.com/icons/png/512/48/48703.png" style="width: 55x; height: 55px;" /></button>
<button  type="submit" name="action" value="Villa" onclick="myFunction()" style="width: 60x; height: 60px; background-color: Transparent; border: none; margin-top: 470px; position:absolute; margin-left:-650px; float:left;"><img src="https://image.flaticon.com/icons/png/512/48/48703.png" style="width: 55x; height: 55px;" /></button>
<button  type="submit" name="action" value="Pigneto" onclick="myFunction()" style="width: 60x; height: 60px; background-color: Transparent; border: none; margin-top: 470px; position:absolute; margin-left:-350px; float:left;"><img src="https://image.flaticon.com/icons/png/512/48/48703.png" style="width: 55x; height: 55px;" /></button>
<button  type="submit" name="action" value="Statuario" onclick="myFunction()" style="width: 60x; height: 60px; background-color: Transparent; border: none; margin-top: 700px; position:absolute; margin-left:-270px; float:left;"><img src="https://image.flaticon.com/icons/png/512/48/48703.png" style="width: 55x; height: 55px;" /></button>
</div>
</form>

 


<script>
function myFunction() {
    elem=document.getElementById("container2");
    elem.style.display="block";

 

 

 

}
</script>
 
    
<div id="risultato"></div>
 
    <form action="Prenota" method="get"><p style="margin-top:-600px;margin-left:880px;">
    <button type="submit" name="prenota" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Prenota</button></p>
    </form>

 


</html>