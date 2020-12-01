<%@ page import="Beans.Banda" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Banda>" scope="request" id="listaBandas"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Bandas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="bandas"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Bandas</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>BANDA</th>
                        <th>LIDER</th>
                    </thead>
                    <%
                        for (Banda banda : listaBandas) {
                    %>
                    <tr>
                        <td><%=banda.getIdBanda()%>
                        </td>
                        <td><%=banda.getNombre_banda()%>
                        </td>
                        <td><%=banda.getIdlider()%>
                        </td>

                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>