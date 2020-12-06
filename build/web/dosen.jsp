<%-- 
    Document   : dosen
    Created on : Dec 1, 2020, 9:59:14 PM
    Author     : RiZz
--%>

<%@page import="db_kosan.koneksi"%>
<%@page import="model.Dosen"%>
<%@page import="java.util.List"%>
<%@page import="dao.DosenDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Data Dosen</h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>Kode Dosen</th>
                <th>Nama Dosen</th>
                <th>Aksi</th>
            </tr>
            
            <%
                List<Dosen> listDosen = new DosenDao().getAll();
                for (int i = 0; i < listDosen.size(); i++){
                    %>
                    <tr>
                        <td><%= listDosen.get(i).getKodeDosen() %></td>
                        <td><%= listDosen.get(i).getNamaDosen() %></td>
                        <td><a href="hapus?kode_dosen=<%= listDosen.get(i).getKodeDosen() %>">Hapus</a></td>
                    </tr>
                    <%
                }
            
            %>
        </table>
    </body>
</html>
