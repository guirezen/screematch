package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.dynalink.linker.LinkerServices;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        var filme = "";
        var titulos = new ArrayList<Titulo>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!filme.equalsIgnoreCase("sair")) {
            System.out.println("digite o filme desejado: ");
            filme = entrada.next();

            if (filme.equalsIgnoreCase("sair")) {
                break;
            }
            var endereco = "https://www.omdbapi.com/?t=" + filme + "&apikey=4af949b1";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                var json = response.body();
                System.out.println("json puro: "+json);


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println("TituloOmdb: "+meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Deu merda");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Deu outro erro");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("lista de titulos: " + titulos);
            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(gson.toJson(titulos));
            escrita.close();
            System.out.println("programa finalizado");
        }
    }
}
