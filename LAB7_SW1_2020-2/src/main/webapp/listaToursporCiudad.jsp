<%@ page import="Beans.TPC" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<jsp:useBean type="java.util.ArrayList<Beans.TPC>" scope="request" id="listaToursporCiudad"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Tours por Ciudad"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="tpc"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Tours por Ciudad</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>#</th>
                        <th>TOUR</th>
                        <th>CIUDAD</th>
                        <th>FECHA</th>
                    </thead>
                    <%
                        int i = 1;
                        for (TPC tpc : listaToursporCiudad) {
                    %>
                    <tr>
                        <td><%=i%>
                        </td>
                        <td><%=tpc.getNombre_tour()%>
                        </td>
                        <td><%=tpc.getNombre_ciudad()%>
                        </td>
                        <td><%=tpc.getFecha()%>
                        </td>

                    </tr>
                    <%
                            i++;
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
