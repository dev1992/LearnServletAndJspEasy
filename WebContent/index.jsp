<?xml version="1.0" encoding="UTF-8"?>
<html>
  	<body>
        <h2>Body Mass Index!</h2>
        <form name="form" action="FirstServlet" method="POST">
           <table>
           		<tr>
                    <td>Please Enter Your Name :</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Please Enter Your Weight (in kg) :</td>
                    <td><input type="text" name="weight"/></td>
                </tr>
                 <tr>
                    <td>Please Enter Your Height (in m) :</td>
                    <td><input type="text" name="height"/></td>
                </tr>
                <th><input type="submit" value="Submit"/></th>
            </table>
        </form>
        <h2>${result}</h2>
        <pre>
		   <c:out value="${xmlString != '' ? xmlString : 'no schema found'}" />
		</pre>
    </body>
</html>