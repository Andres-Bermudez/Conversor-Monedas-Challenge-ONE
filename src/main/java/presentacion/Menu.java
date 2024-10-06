package presentacion;

import conexionapi.ConexionHttp;
import lecturaarchivos.LecturaArchivos;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int eleccionUsuario;
        String menu = """
                      \n:::::::::: Conversor de monedas ::::::::::
                      
                      \t1. Convertir un valor.
                      \t2. Ver ultima consulta.
                      \t0. Salir.
                      """;
        System.out.print(menu + "Tu eleccion: ");
        try {
            eleccionUsuario = sc.nextInt();

            switch (eleccionUsuario) {
                case 0:
                    System.out.println("\nFin del programa.");
                    System.exit(0);
                    break;
                case 1:
                    menuConvertirValor();
                    break;
                case 2:
                    LecturaArchivos.verUltimaConsulta();
                    break;
                default:
                    System.out.println("\n>>> Recuerda elegir solo entre las opciones disponibles <<<");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("\n>>> Caracter no valido <<<");
        }
    }

    private static void menuConvertirValor() {
        Scanner sc = new Scanner(System.in);

        String menu = """
                      \nIngresando al conversor de moneda.....
                            1. Ingresar a convertir un valor.
                            2. Ver codigos de moneda por pais.
                            0. Salir
                      """;
        System.out.print(menu + "Tu eleccion: ");
        try {
            int eleccionUsuario = sc.nextInt();

            if (eleccionUsuario == 0) {
                System.out.println("\nFin del programa.");
                System.exit(0);
            } else if (eleccionUsuario == 1) {
                convertirValor();
            } else if (eleccionUsuario == 2) {
                verCodigosMonedas();
            } else {
                System.out.println("\n>>> Recuerda elegir solo entre las opciones disponibles <<<");
            }
        }catch (InputMismatchException e) {
            System.out.println("\n>>> Caracter no valido <<<");
        }
    }

    private static void convertirValor() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\nRealizando conversion...");
            System.out.print("Escribe el codigo de la moneda que vas a convertir: ");
            String codigoMonedaOrigen = sc.nextLine().toUpperCase();

            System.out.print(">>>>>> Ingresa el valor a convertir: ");
            float valorAConvertir = sc.nextFloat();
            sc.nextLine();

            System.out.print("Escribe el codigo de la moneda en que lo quieres convertir: ");
            String codigoMonedaDestino = sc.nextLine().toUpperCase();

            System.out.println("\nEjecutando conversion.....");

            // Solicitud GET a la API para hacer la conversion
            ConexionHttp.solicitudGET(codigoMonedaOrigen, codigoMonedaDestino);

        } catch (InputMismatchException e) {
            System.out.println("\n>>> Los datos que ingresaste no son validos <<<");
        }
    }

    private static void verCodigosMonedas() {
        String monedas = """
                         \nCODIGOS DE MONEDAS POR PAIS:
                         **********************************************************************************************************************************************
                         "USD": "Dólar estadounidense",              "AED": "Dírham de los Emiratos Árabes Unidos",   "AFN": "Afgani afgano",
                         "ALL": "Lek albanés",                       "AMD": "Dram armenio",                           "ANG": "Florín antillano neerlandés",
                         "AOA": "Kwanza angoleño",                   "ARS": "Peso argentino",                         "AUD": "Dólar australiano",
                         "AWG": "Florín arubeño",                    "AZN": "Manat azerbaiyano",                      "BAM": "Marco convertible de Bosnia-Herzegovina",
                         "BBD": "Dólar de Barbados",                 "BDT": "Taka de Bangladesh",                     "BGN": "Lev búlgaro",
                         "BHD": "Dinar bareiní",                     "BIF": "Franco burundés",                        "BMD": "Dólar bermudeño",
                         "BND": "Dólar de Brunéi",                   "BOB": "Boliviano boliviano",                    "BRL": "Real brasileño",
                         "BSD": "Dólar bahameño",                    "BTN": "Ngultrum butanés",                       "BWP": "Pula botsuano",
                         "BYN": "Rublo bielorruso",                  "BZD": "Dólar beliceño",                         "CAD": "Dólar canadiense",
                         "CDF": "Franco congoleño",                  "CHF": "Franco suizo",                           "CLP": "Peso chileno",
                         "CNY": "Yuan chino",                        "COP": "Peso colombiano",                        "CRC": "Colón costarricense",
                         "CUP": "Peso cubano",                       "CVE": "Escudo caboverdiano",                    "CZK": "Corona checa",
                         "DJF": "Franco yibutiano",                  "DKK": "Corona danesa",                          "DOP": "Peso dominicano",
                         "DZD": "Dinar argelino",                    "EGP": "Libra egipcia",                          "ERN": "Nakfa eritreo",
                         "ETB": "Birr etíope",                       "EUR": "Euro",                                   "FJD": "Dólar fiyiano",
                         "FKP": "Libra malvinense",                  "FOK": "Corona feroesa",                         "GBP": "Libra esterlina",
                         "GEL": "Lari georgiano",                    "GGP": "Libra de Guernsey",                      "GHS": "Cedi ghanés",
                         "GIP": "Libra gibraltareña",                "GMD": "Dalasi gambiano",                        "GNF": "Franco guineano",
                         "GTQ": "Quetzal guatemalteco",              "GYD": "Dólar guyanés",                          "HKD": "Dólar de Hong Kong",
                         "HNL": "Lempira hondureño",                 "HRK": "Kuna croata",                            "HTG": "Gourde haitiano",
                         "HUF": "Forinto húngaro",                   "IDR": "Rupia indonesia",                        "ILS": "Nuevo shéquel israelí",
                         "IMP": "Libra de la Isla de Man",           "INR": "Rupia india",                            "IQD": "Dinar iraquí",
                         "IRR": "Rial iraní",                        "ISK": "Corona islandesa",                       "JEP": "Libra de Jersey",
                         "JMD": "Dólar jamaicano",                   "JOD": "Dinar jordano",                          "JPY": "Yen japonés",
                         "KES": "Chelín keniano",                    "KGS": "Som kirguís",                            "KHR": "Riel camboyano",
                         "KID": "Dólar de Kiribati",                 "KMF": "Franco comorense",                       "KRW": "Won surcoreano",
                         "KWD": "Dinar kuwaití",                     "KYD": "Dólar caimano",                          "KZT": "Tenge kazajo",
                         "LAK": "Kip laosiano",                      "LBP": "Libra libanesa",                         "LKR": "Rupia de Sri Lanka",
                         "LRD": "Dólar liberiano",                   "LSL": "Loti lesothense",                        "LYD": "Dinar libio",
                         "MAD": "Dírham marroquí",                   "MDL": "Leu moldavo",                            "MGA": "Ariary malgache",
                         "MKD": "Dinar macedonio",                   "MMK": "Kyat birmano",                           "MNT": "Tugrik mongol",
                         "MOP": "Pataca de Macao",                   "MRU": "Uguiya mauritano",                       "MUR": "Rupia mauriciana",
                         "MVR": "Rufiyaa maldiva",                   "MWK": "Kwacha malauí",                          "MXN": "Peso mexicano",
                         "MYR": "Ringgit malayo",                    "MZN": "Metical mozambiqueño",                   "NAD": "Dólar namibio",
                         "NGN": "Naira nigeriana",                   "NIO": "Córdoba nicaragüense",                   "NOK": "Corona noruega",
                         "NPR": "Rupia nepalí",                      "NZD": "Dólar neozelandés",                      "OMR": "Rial omaní",
                         "PAB": "Balboa panameño",                   "PEN": "Sol peruano",                            "PGK": "Kina de Papúa Nueva Guinea",
                         "PHP": "Peso filipino",                     "PKR": "Rupia pakistaní",                        "PLN": "Zloty polaco",
                         "PYG": "Guaraní paraguayo",                 "QAR": "Rial catarí",                            "RON": "Leu rumano",
                         "RSD": "Dinar serbio",                      "RUB": "Rublo ruso",                             "RWF": "Franco ruandés",
                         "SAR": "Rial saudí",                        "SBD": "Dólar de las Islas Salomón",             "SCR": "Rupia de Seychelles",
                         "SDG": "Libra sudanesa",                    "SEK": "Corona sueca",                           "SGD": "Dólar de Singapur",
                         "SHP": "Libra de Santa Elena",              "SLE": "Leona de Sierra Leona",                  "SLL": "Leone sierraleonés",
                         "SOS": "Chelín somalí",                     "SRD": "Dólar surinamés",                        "SSP": "Libra sursudanesa",
                         "STN": "Dobra santotomense",                "SYP": "Libra siria",                            "SZL": "Lilangeni suazi",
                         "THB": "Baht tailandés",                    "TJS": "Somoni tayiko",                          "TMT": "Manat turcomano",
                         "TND": "Dinar tunecino",                    "TOP": "Pa'anga tongano",                        "TRY": "Lira turca",
                         "TTD": "Dólar de Trinidad y Tobago",        "TVD": "Dólar tuvaluano",                        "TWD": "Nuevo dólar taiwanés",
                         "TZS": "Chelín tanzano",                    "UAH": "Grivna ucraniana",                       "UGX": "Chelín ugandés",
                         "UYU": "Peso uruguayo",                     "UZS": "Som uzbeko",                             "VES": "Bolívar venezolano",
                         "VND": "Dong vietnamita",                   "VUV": "Vatu vanuatuense",                       "WST": "Tala samoano",
                         "XAF": "Franco CFA BEAC",                   "XCD": "Dólar del Caribe Oriental",              "XDR": "Derechos Especiales de Giro",
                         "XOF": "Franco CFA BCEAO",                  "XPF": "Franco CFP",                             "YER": "Rial yemení",
                         "ZAR": "Rand sudafricano",                  "ZMW": "Kwacha zambiano",                        "ZWL": "Dólar zimbabuense"
                         **********************************************************************************************************************************************
                         """;
        System.out.println(monedas);
        menuConvertirValor();
    }
}
