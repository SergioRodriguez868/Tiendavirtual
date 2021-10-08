package co.edu.unbosque.Ciclo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TestJSON {
	
	private static URL url; 
	private static String sitio = "http://localhost:8080/";
	
	public static ArrayList<Usuarios> parsingUsuarios(String json) throws ParseException, org.json.simple.parser.ParseException { 
        JSONParser jsonParser = new JSONParser(); 
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>(); 
        JSONArray usuarios = (JSONArray) jsonParser.parse(json); 
        Iterator i = usuarios.iterator(); 
        while (i.hasNext()) { 
            JSONObject innerObj = (JSONObject) i.next(); 
            Usuarios usuario = new Usuarios(); 
            usuario.setNombres(innerObj.get("Nombres").toString());  
            usuario.setApellidos(innerObj.get("Apellidos").toString()); 
            usuario.setIDadmin(Long.valueOf(innerObj.get("IDadmin").toString())); 
            usuario.setCorreo(innerObj.get("Correo").toString());
            usuario.setCelular(Long.valueOf(innerObj.get("Celular").toString()));
            usuario.setUsuario(innerObj.get("Usuario").toString());
            usuario.setPassword(innerObj.get("Password").toString());  
            lista.add(usuario); 
        } 
        return lista; 
	}
	
	public static ArrayList<Usuarios> getJSON() throws IOException, ParseException, org.json.simple.parser.ParseException{ 
		url = new URL(sitio + "usuarios/listar"); 
		 HttpURLConnection http = (HttpURLConnection)url.openConnection(); 
		 http.setRequestMethod("get"); 
		 http.setRequestProperty("Accept", "application/json"); 
		 InputStream respuesta = http.getInputStream(); 
		 byte[] inp = respuesta.readAllBytes(); 
		 String json = ""; 
		 for (int i = 0; i < inp.length ; i++) { 
		 json += (char)inp[i]; 
		 } 
		 ArrayList<Usuarios> lista = new ArrayList<Usuarios>(); 
		 lista = parsingUsuarios(json); 
		 http.disconnect(); 
		 return lista; 
	}
	
	public static int postJSON(Usuarios usuario) throws IOException { 
		 url = new URL(sitio + "usuarios/guardar"); 
		 
		 HttpURLConnection http; 
		 http = (HttpURLConnection)url.openConnection(); 
		 try { 
		  http.setRequestMethod("POST"); 
		 } catch (ProtocolException e) { 
		  e.printStackTrace(); 
		 } 
		 http.setDoOutput(true); 
		 http.setRequestProperty("Accept", "application/json"); 
		 http.setRequestProperty("Content-Type", "application/json"); 
		 String data = "{" 
		  + "\"Nombres\":\""+ usuario.getNombres() 
		  +"\",\"Apellidos\": \""+usuario.getApellidos() 
		  +"\",\"IDadmin\": \""+usuario.getIDadmin() 
		  +"\",\"Correo\": \""+usuario.getCorreo()
		  +"\",\"Celular\": \""+usuario.getCelular()
		  +"\",\"Password\":\""+usuario.getPassword() 
		  +"\",\"Usuario\":\""+usuario.getUsuario() 
		  + "\"}"; 
		 byte[] out = data.getBytes(StandardCharsets.UTF_8); 
		 OutputStream stream = http.getOutputStream(); 
		 stream.write(out); 
		 int respuesta = http.getResponseCode(); 
		 http.disconnect(); 
		 return respuesta;
	}
}
