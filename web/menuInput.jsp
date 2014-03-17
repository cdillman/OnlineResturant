<%-- 
    Document   : menuInput
    Created on : Feb 16, 2014, 9:17:34 PM
    Author     : Corbin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Corby's Menu</h1>
        
        <form id='orderForm' method="POST" action="OC">
            <input type="text" name="itemName" value="" />
            <input type="text" name="itemPrice" value="" />
            <button id="button">Edit</button>
            <button id="button">Delete</button>
        </form>
        <form id='addForm' method="POST" action="OC">
            <button id="button">Add</button>
        </form>
        
    </body>
</html>
