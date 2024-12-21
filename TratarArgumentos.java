package Practica1;

public class TratarArgumentos {
    
    private boolean argT = false;
    private boolean argH = false;
    private String ficheroEntrada = "";
    private String ficheroSalida = "";

    public TratarArgumentos(String[] args) throws IllegalArgumentException{
        int n = (args.length>4) ? 4:args.length;
        for(int i= 0; i<n; i++){
            if(args[i].trim().equals("-t")){
                argT = true;
            }
            else if(args[i].trim().equals("-h")){
                mostrarAyuda();
                argH = true;
            }
            else if(ficheroEntrada.isEmpty()){
                ficheroEntrada = args[i];
            }
            else if(ficheroSalida.isEmpty()){
                ficheroSalida = args[i];
            }else{
                throw new IllegalArgumentException("[TratarArgumentos::TratarArgumentos] - error al tratar los argumentos");
            }
        }
    }

    private void mostrarAyuda(){
        System.out.println("\n SINTAXIX: tareas [-t] [-h] [fichero entrada] [fichero salida]");
        System.out.println("\n -t                       Traza el algoritmo");
        System.out.println("\n -h                       Muestra esta ayuda");
        System.out.println("\n [fichero entrada]        Nombre del fichero de entrada");
        System.out.println("\n [fichero salida]         Nombre del fichero de salida \n");
    }

    public boolean isArgT() {
        return argT;
    }

    public void setArgT(boolean argT) {
        this.argT = argT;
    }

    public boolean isArgH() {
        return argH;
    }

    public void setArgH(boolean argH) {
        this.argH = argH;
    }

    public String getFicheroEntrada() {
        return ficheroEntrada;
    }

    public void setFicheroEntrada(String ficheroEntrada) {
        this.ficheroEntrada = ficheroEntrada;
    }

    public boolean existeFicheroEntrada(){
        return !(ficheroEntrada.isEmpty() || ficheroEntrada.isBlank());
    }

    public String getFicheroSalida() {
        return ficheroSalida;
    }

    public void setFicheroSalida(String ficheroSalida) {
        this.ficheroSalida = ficheroSalida;
    }

    public boolean existeFicheroSalida(){
        return (ficheroSalida.isEmpty() || ficheroSalida.isBlank());
    }

    

}
