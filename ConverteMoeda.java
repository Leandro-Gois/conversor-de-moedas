import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteMoeda {
    public Moeda converteMoeda(String origem, String destino, double quantia) throws RuntimeException {

        String myKey = "92bda0a31bb2f4b0a76d4378";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+
                                  myKey+"/pair/"+origem+"/"+destino+"?amount="+quantia);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response ;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível converter os valores.");
        }

        return new Gson().fromJson(response.body(),Moeda.class);

    }
}