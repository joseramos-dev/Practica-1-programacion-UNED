package Practica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Practica1.FuncionesEntrada.MatrizEntrada;
import Practica1.FuncionesEntrada.LeerEntradaEstandar;
import Practica1.FuncionesEntrada.LeerFichero;
import Practica1.LogicaAlgoritmo.AlgoritmoRamificacionYPoda;

public class Main {

    public static void main(String [] args){
        try{

            TratarArgumentos argumentos = new TratarArgumentos(args);
            MatrizEntrada entrada = getEntrada(argumentos);
            if( argumentos.isArgT() ) entrada.mostrarMatriz();

            long startTime = System.currentTimeMillis();

            AlgoritmoRamificacionYPoda algoritmo = new AlgoritmoRamificacionYPoda(entrada, argumentos.isArgT());
            algoritmo.iniciarAlgoritmo();

            long endTime = System.currentTimeMillis();
            long timeInMillis = endTime - startTime;
            System.out.println("\nTiempo de ejecucion: " + timeInMillis + " ms\n\n");

            salida(algoritmo.getRESULTADO(), argumentos.getFicheroSalida());

        }catch(IllegalArgumentException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static MatrizEntrada getEntrada(TratarArgumentos argumentos)
            throws IOException, NumberFormatException, Exception {
        if (argumentos.existeFicheroEntrada()) {
            return new LeerFichero(argumentos.getFicheroEntrada());
        }
        return new LeerEntradaEstandar();
    }

    public static void salida(String resultado, String ficheroString) {
        // comprobamos que el fichero existe
        File fichero = new File(ficheroString);
        if (fichero.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroString))) {
                writer.write(resultado);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(resultado);
        }

    }

}