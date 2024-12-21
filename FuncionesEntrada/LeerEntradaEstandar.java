package Practica1.FuncionesEntrada;

import java.util.Scanner;

public class LeerEntradaEstandar extends MatrizEntrada {

    Scanner scanner;

    public LeerEntradaEstandar() throws NumberFormatException {
        scanner = new Scanner(System.in);
        preguntarTamaño();
    }

    private void preguntarTamaño() {
        tamX = pedirNumero("\n introduce numero de filas: ");
        tamY = pedirNumero("\n Introduce número de columnas: ");

        matriz = new int[tamX][tamY];

        for (int x = 0; x < tamX; x++) {
            for (int y = 0; y < tamY; y++) {
                matriz[x][y] = pedirNumero("\n Introduce valor en posición [" + x + ", " + y + "] : ");
                if(matriz[x][y] < 0){
                    throw new IllegalArgumentException("[LeerFichero::rellenarMatriz] - En la matriz no estan permitidos los valores negativos");
                }
            }
        }
        System.out.println("\n Matriz rellenada correctamente");

    }

    private int pedirNumero(String pregunta) throws NumberFormatException {
        String valor = "";
        do{
            System.out.print(pregunta);
            valor = scanner.nextLine();
        }while(valor.trim()=="");
        return Integer.parseInt(valor);
    }

}
