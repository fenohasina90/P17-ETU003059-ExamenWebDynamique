<%@ page import="java.util.List" %>
<%@ page import="main.java.ETU003059.Prevision" %> 
<%
    List<Prevision> prev = (List<Prevision>) session.getAttribute("select");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste</title>
</head>
<body>
    <form action="" method="post">
        <select name="libelle" id="">
            <%  for (Prevision dept : prev) {
                %>
                    <option value="<%= dept.getId() %>"><%= dept.getLibelle() %></option>
                <%
                    }

            
            
            %>
        </select>
        <input type="number" value="montant" name="montant">
        <input type="submit" value="valider">
    </form>


    </form>

</body>
</html>