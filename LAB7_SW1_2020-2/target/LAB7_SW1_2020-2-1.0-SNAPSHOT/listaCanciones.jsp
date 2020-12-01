<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCanciones"/>
<jsp:useBean type="java.lang.Boolean" scope="request" id="ordenada"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones<%=ordenada ? " Ordenadas" : ""%>
                    </h1>
                </div>
                <%=ordenada ? "" : "<a class='btn btn-warning' href='" + request.getContextPath() + "/listaCanciones?order=on' >Ordenar por nombre de canción</a>"%>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                    </thead>
                    <%
                        for (Cancion cancion : listaCanciones) {
                    %>
                    <tr>
                        <td><%=cancion.getIdCancion()%>
                        </td>
                        <td><%=cancion.getNombre_cancion()%>
                        </td>
                        <td><%=cancion.getIdBanda()%>
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
