<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>ShowRoome</title>
  </head>
  <body style="                                     height: 512px; background-color: white;"><img

      src="https://image.flaticon.com/icons/png/512/26/26362.png" alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome </h1>
    <h1 style="margin-top: -60px; margin-left: 1000px;"> <input value="" size="18"

        maxlength="40" type="text"> </h1>
    <h1 style="margin-top:-58px; margin-left: 1150px;"> <input value="Search artist"

size="15" maxlength="40" ;style="background-color:" #993300="" type="submit"> </h1>
    <h1 style="margin-top:-10px;margin-left:3px;">
    <form action="<%= request.getContextPath() %>/register" method="post">
     <button name="Homepage" style="height: 35px; width: 95px; margin-top: -48px;margin-left : 15px ;background-color: #4D4D4D;">Homepage</button>
      <button name="Map" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 140px; background-color: #4d4d4d; color: white;">Map</button>
      <button name="Chart" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Chart</button>
      <button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;">Profile</button>
      <button name="Setting" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;">Setting</button>
   </form>
    </h1>
    <h1 style="margin-top: -62px;margin-left:px ;background-color: white;">
      <style>
#rectangle {
    width: 1250px;
    height: 50px;
    background: #10030F;
}
</style> <div id="rectangle"></div>
    </h1>
    <h1 style="margin-top: -160px; margin-left: 1170px;"> <input value="Login"

size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1>
    <h1 style="margin-top:110px; margin-left: px;"> <iframe src="https://www.google.com/maps/embed?pb=%211m18%211m12%211m3%211d23769.533882435524%212d12.476125338439449%213d41.86722107939201%212m3%211f0%212f0%213f0%213m2%211i1024%212i768%214f13.1%213m3%211m2%211s0x13258a78722565a7%3A0xfac955af434abdf5%212s00154%20Garbatella%20RM%215e0%213m2%211sit%212sit%214v1609426835144%215m2%211sit%212sit"

        style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0" ;=""

        ;margin-left:600px;margin-top:600px;;="" height="450" frameborder="3" width="1250"></iframe>
    </h1>
  </body>
</html>
