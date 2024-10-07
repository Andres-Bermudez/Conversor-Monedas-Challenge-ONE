package conexionapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import credencialesAPI.CredencialesAPI;
import modelos.RespuestaConversionMonedas;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class ConexionHttp extends CredencialesAPI {

    public static void solicitudGET(double valorAConvertir, String monedaOrigen, String monedaDestino) {
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
                RespuestaConversionMonedas monedaConvertida = gson.fromJson(json,
                                                            RespuestaConversionMonedas.class);

                // Imprimir la respuesta.
                // Formatear la conversion a un tipo de dato que lo soporte
                String valor = String.valueOf(valorAConvertir * monedaConvertida.resultadoConversion());
                BigDecimal operacionConversion = new BigDecimal(valor);

                String encabezadoResultado = "\n******************************************************************************" +
                                             "\nConversion de (" + monedaOrigen + ") a" + " (" + monedaDestino + ")";

                String resultado = "\nRESULTADO DE LA CONVERSION: La cantidad de " + valorAConvertir + " (" + monedaOrigen + ")" +
                                   " equivale a: " + operacionConversion + " (" + monedaDestino + ")";

                System.out.println(encabezadoResultado + resultado + monedaConvertida);

                // Generar un archivo .txt que almacene la ultima consulta.
                File file = new File("src/main/java/archivosgenerados/ultimaConsulta.txt");
                // Escribir el archivo en la ruta especificada
                FileWriter writer = new FileWriter(file);
                writer.write(encabezadoResultado + resultado + monedaConvertida);
                writer.close();
            } else {
                System.out.println("\nNo fue posible realizar la conversion.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
