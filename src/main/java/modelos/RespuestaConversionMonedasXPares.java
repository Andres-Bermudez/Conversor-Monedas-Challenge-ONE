package modelos;

import com.google.gson.annotations.SerializedName;

public record RespuestaConversionMonedasXPares(

        @SerializedName("base_code")
        String monedaOrigen,

        @SerializedName("target_code")
        String monedaDestino,

        @SerializedName("conversion_rate")
        String resultadoConversion,

        @SerializedName("time_last_update_utc")
        String ultimaActualizacion,

        @SerializedName("documentation")
        String referencias
){

    @Override
    public String toString() {
        return "\n**********************************************************************************" +
               "\nLa conversion de (" + monedaOrigen() + ") a (" + monedaDestino() + ") es: " +
               "\n                                               " +
               "\nResultado Conversion: " + resultadoConversion() +
               "\nMoneda Origen: " + monedaOrigen() +
               "\nMoneda Destino: " + monedaDestino() +
               "\nUltima Actualizacion: " + ultimaActualizacion() +
               "\nFuente resultado: " + referencias();
    }
}



/*
        {
        "base_code": "USD",
        "conversion_rate": 4191.0932,
        "documentation": "https://www.exchangerate-api.com/docs",
        "result": "success",
        "target_code": "COP",
        "terms_of_use": "https://www.exchangerate-api.com/terms",
        "time_last_update_unix": 1728172801,
        "time_last_update_utc": "Sun, 06 Oct 2024 00:00:01 +0000",
        "time_next_update_unix": 1728259201,
        "time_next_update_utc": "Mon, 07 Oct 2024 00:00:01 +0000"
        }

 */
