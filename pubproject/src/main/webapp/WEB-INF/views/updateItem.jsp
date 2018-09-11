<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Item</title>
</head>
<body>
        <form action="/updateItem" method="post">
         <input id="id" name="id" type="hidden" value="${product.id}">
        <table border="1" cellpadding="5">
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" id="name" name="name" size="45"
                           value="${product.name}"/>
                       
                </td>
            </tr>
            <tr>
                <th>Type: </th>
                <td>
                    <input type="text" id="type" name="type" size="45"
                             value="${product.type}"/>

                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" id="price" name="price" size="45"
                           value="${product.price}"/>
                </td>
            </tr>
        </table>
        <button type="submit" value="submit">Update</button>
        </form>
</body>
</html>