package Practica1.FuncionesEntrada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero extends MatrizEntrada {

    public LeerFichero(String fichero) throws IOException, NumberFormatException, Exception {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        tratarPrimeraLinea(br.readLine());
        rellenarMatriz(br);
    }

    private void tratarPrimeraLinea(String primeraLinea) throws Exception, NumberFormatException {
        if (primeraLinea == null || primeraLinea.trim().isEmpty()) {
            throw new Exception("[LeerFichero::tratarPrimeraLinea] - el fichero esta vacio o el formato esta mal");
        }
        String[] valoresTamaño = primeraLinea.split("\\s+");
        if (valoresTamaño.length < 2 ) {
            throw new Exception(
                    "[LeerFichero::tratarPrimeraLinea] - no hay suficientes valores para indicar el tamaño de la matriz");
        }
        tamX = Integer.parseInt(valoresTamaño[0]);
        tamY = Integer.parseInt(valoresTamaño[1]);
        matriz = new int[tamX][tamY];
    }

    private void rellenarMatriz(BufferedReader br) throws Exception, NumberFormatException {
        String linea;
        if (matriz.length < tamY)
            throw new Exception(
                    "[LeerFichero::rellenarMatriz] - Hay menos filas de las que deberia");
        for (int x = 0; x < tamX; x++) {
            linea = br.readLine();
            if (linea == null || linea.trim().isEmpty()) {
                throw new Exception("[LeerFichero::rellenarMatriz] - el fichero esta vacio o el formato esta mal");
            }
            String[] valoresLinea = linea.split("\\s+");
            if (valoresLinea.length < tamX) {
                throw new Exception(
                        "[LeerFichero::rellenarMatriz] - Hay menos valores de los que deberia en la columna de la matriz");
            }
            for (int y = 0; y < tamY; y++) {
                matriz[x][y] = Integer.parseInt(valoresLinea[y]);
                if(matriz[x][y] < 0){
                    throw new IllegalArgumentException("[LeerFichero::rellenarMatriz] - En la matriz no estan permitidos los valores negativos");
                }
            }

        }
    }

}
