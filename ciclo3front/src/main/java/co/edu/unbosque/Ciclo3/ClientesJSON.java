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

public class ClientesJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Clientes> parsingClientes(String json) throws ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		JSONArray clientes = (JSONArray) jsonParser.parse(json);
		Iterator i = clientes.iterator();
		while (i.hasNext()) {
		JSONObject innerObj = (JSONObject) i.next();
		Clientes cliente = new Clientes();
		cliente.setIDcliente(Long.valueOf(innerObj.get("IDcliente").toString()));
		cliente.setNombres(innerObj.get("Nombres").toString());
		cliente.setApellidos(innerObj.get("Apellidos").toString());
		cliente.setCorreo(innerObj.get("Correo").toString());
		cliente.setCelular(Long.valueOf(innerObj.get("Celular").toString()));
		cliente.setDireccion(innerObj.get("Direccion").toString());
		cliente.setPassword(innerObj.get("password").toString());
		cliente.setUsuario(innerObj.get("usuario").toString());
		lista.add(cliente);
		}
		return lista;
		}
	
	public static ArrayList<Clientes> getJSON() throws IOException, ParseException, org.json.simple.parser.ParseException {
		url = new URL(sitio+"clientes/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
		}
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
		}
	
	public static int postJSON(Clientes cliente) throws IOException {
		url = new URL(sitio+"usuarios/guardar");
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
		+ "\"IDcliente\":\""+ cliente.getIDcliente()
		+"\",\"Nombres\": \""+cliente.getNombres()
		+"\",\"Apellidos\": \""+cliente.getApellidos()
		+"\",\"Correo\": \""+cliente.getCorreo()
		+"\",\"Celular\": \""+cliente.getCelular()
		+"\",\"Direccion\": \""+cliente.getDireccion()
		+"\",\"password\":\""+cliente.getPassword()
		+"\",\"usuario\":\""+cliente.getUsuario()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		}
	
}
