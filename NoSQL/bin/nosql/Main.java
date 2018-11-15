package nosql;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import util.HTTPSWebUtilDomi;

public class Main {	

	public static void main(String[] args) {
		try {
			Gson g = new Gson();
			
			HTTPSWebUtilDomi webutil = new HTTPSWebUtilDomi();
			
			String URL = "https://diabetesicesi.firebaseio.com/estudiantes.json";
			
			Estudiante estudiante = new Estudiante("Mateo","Matta","A7783244");
			
			String json = g.toJson(estudiante);
	
			//POST: Agregar a RAMA
			String respuesta = webutil.POSTrequest(URL, json);
			System.out.println(respuesta);
			
			//PUT: Reemplaza, escribe en la misma posicion
			//String URLEST = "https://diabetesicesi.firebaseio.com/estudiantes.json";
			//WEBUtilDomi.PUTrequest(URLEST, json);
			
			//GET: Adquirir informacion. Poner una URL en el navegador
			String datos = webutil.GETrequest(URL);
			System.out.println(datos);
			
			//HashMap<String, Estudiante>
			Type tipo = new TypeToken<  HashMap<String, Estudiante>  >() {
			}.getType();
			HashMap<String, Estudiante> estudiantes =  g.fromJson(datos, tipo);
			System.out.println(estudiantes.size());
			
			
			//GET: Adquirir un solo estudiante
			String URL_Aguirre = "https://diabetesicesi.firebaseio.com/estudiantes/-LRD3i7Twyr1Zu8mvDJs.json";
			String aguirre_json = webutil.GETrequest(URL_Aguirre);
			System.out.println(aguirre_json);
			
			//HashMap<String, Estudiante>
			Estudiante aguirre =  g.fromJson(aguirre_json, Estudiante.class);
			System.out.println(aguirre.getNombre());
			
			//DELETE
			//String URL_DELETE = "https://diabetesicesi.firebaseio.com/estudiantes/-LRD3pdDsj65M2v4tY0N.json";
			//webutil.DELETErequest(URL_DELETE,"");
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
