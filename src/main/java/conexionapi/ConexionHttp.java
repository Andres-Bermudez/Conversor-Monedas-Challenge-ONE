package conexionapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import credencialesAPI.CredencialesAPI;
import modelos.RespuestaConversionMonedasXPares;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConexionHttp extends CredencialesAPI {

    public static void solicitudGET(String monedaOrigen, String monedaDestino) {
        // Construir la URL
        String URL = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/" +
                                                             monedaOrigen + "/" + monedaDestino;

        // Crear una instancia de OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // Construir la solicitud
        Request request = new Request.Builder().url(URL).build();

        //Ejecutar la solicitud
        try {
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                String json = response.body().string();

                // Formatear la respuesta JSON
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                RespuestaConversionMonedasXPares monedaConvertida = gson.fromJson(json, RespuestaConversionMonedasXPares.class);

                // Imprimir la respuesta.
                System.out.println(monedaConvertida);

                // Generar un archivo .txt que almacene la ultima consulta.
                File file = new File("src/main/java/archivosgenerados/ultimaConsulta.txt");
                // Escribir el archivo en la ruta especificada
                FileWriter writer = new FileWriter(file);
                writer.write(monedaConvertida.toString());
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
