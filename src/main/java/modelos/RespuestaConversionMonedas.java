package modelos;

import com.google.gson.annotations.SerializedName;

public record RespuestaConversionMonedas(

        @SerializedName("base_code")
        String monedaOrigen,

        @SerializedName("target_code")
        String monedaDestino,

        @SerializedName("conversion_rate")
        double resultadoConversion,

        @SerializedName("time_last_update_utc")
        String ultimaActualizacion,

        @SerializedName("documentation")
        String fuente
){

}


