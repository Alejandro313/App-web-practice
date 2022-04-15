package TP4JPACliente;

import ar.org.centro8.curso.java.web.entities.Articulo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class TP4JPACliente {

    public static void main(String[] args) throws Exception{
        
        String server="http://localhost:8080/server/webresources/articulos/v1";
        String url;

        System.out.println("****************************************************");
        System.out.println("-- Server ");
        System.out.println("****************************************************");
        url=server;
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosAlta 1");
        System.out.println("****************************************************");
        url=server+"/ArticulosAlta?nombre=CatShow&descripcion=carne&tipo=ALIMENTO&especieRecomendada=FELINO&costo=500&precio=800&stock=10&stockMinimo=5&stockMaximo=20&comentario=null&activo=true";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosAlta 2");
        System.out.println("****************************************************");
        url=server+"/ArticulosAlta?nombre=Collar&descripcion=azul&tipo=ACCESORIO&especieRecomendada=FELINO&costo=300&precio=500&stock=10&stockMinimo=5&stockMaximo=20&comentario=null&activo=true";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosAll");
        System.out.println("****************************************************");
        url=server+"/ArticulosAll";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosLikeNombre");
        System.out.println("****************************************************");
        url=server+"/LikeNombre?nombre=ca";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("-- ArticulosLikeEspecie");
        System.out.println("****************************************************");
        url=server+"/LikeEspecieRecomendada?especieRecomendada=FELINO";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("--ArticulosActivos");
        System.out.println("****************************************************");
        url=server+"/LikeActivo?activo=true";
        System.out.println(responseBody(url));
        
        System.out.println("****************************************************");
        System.out.println("--ArticulosLikeTipo");
        System.out.println("****************************************************");
        url=server+"/LikeTipo?tipo=ALIMENTO";
        System.out.println(responseBody(url));
               
      System.out.println("*******************************************");
      System.out.println("*******************************************");
      url=server+"/ArticulosAll";
      Type listTypeArt=new TypeToken<List<Articulo>>(){}.getType();
      List<Articulo>listAr= new Gson().fromJson(responseBody(url),listTypeArt);
      listAr.forEach(System.out::println);
    }
    
    private static String responseBody(String url) throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode()==200){
            System.out.println("\033[32mstatus: "+response.statusCode()+"\033[0m");
        }else{
            System.out.println("\033[31mstatus: "+response.statusCode()+"\033[0m");
        }
        response.headers().map().forEach((k, v) -> System.out.println(k + " " + v));
        return response.body();
    }
}
