

<%@page import="db_kosan.koneksi"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            koneksi aaa = new koneksi();
            out.println("koneksi kita" + aaa.getkon() + "<br/>");
  
        %>
        
        
        <%
            koneksi aaa = new koneksi();
            out.println("koneksi kita" + aaa.getkon() + "<br/>");
            
            try{
            Connection con = aaa.getkon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from nama_tabel");
            while (rs.next()){
                out.println(rs.getString("nama_kolom1") + " " + rs.getString("nama_kolom2") + "<br/>" ); 
            } 
            
            con.close();
            } catch (exeption e) {
                out.println(e);
            }
            }
  
        %>
        
        
    </body>
</html>
