<%@ page import="Beans.Artista" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Artista>" scope="request" id="listaArtistas"/>
<jsp:useBean type="java.lang.Boolean" scope="request" id="filtrada"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Artistas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="artistas"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista <%=filtrada ? "Filtrada " : ""%>de Artistas</h1>
                </div>
                <%=filtrada ? "" : "<a class='btn btn-warning' href='" + request.getContextPath() + "/listaArtistas?filter=on' >Solo mas de 5 canciones</a>"%>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>BANDA</th>
                        <th>INSTRUMENTO</th>
                    </thead>
                    <%
                        for (Artista artista : listaArtistas) {
                    %>
                    <tr class="<%=artista.getColorFila()%>">
                        <td><%=artista.getIdArtista()%>
                        </td>
                        <td><%=artista.getNombre_artista()%>
                        </td>
                        <td><%=artista.getIdbanda()%>
                        </td>
                        <td><%=artista.getIdinstrumento()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>

                <tr class="fila-red"...>


            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>