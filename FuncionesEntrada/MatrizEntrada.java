package Practica1.FuncionesEntrada;

public abstract class MatrizEntrada {
    protected int[][] matriz;
    protected int tamX;
    protected int tamY;

    public void mostrarMatriz(){
        System.out.print("\n Imprimiendo matriz: \n");
        System.out.print(tamX+"  "+tamY+"\n");
        for(int x=0; x<tamX; x++){
            for(int y=0; y<tamY; y++){
                System.out.print(matriz[x][y]+"  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public int[][] getMatriz() {
        return matriz;
    }
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    public int getTamX() {
        return tamX;
    }
    public void setTamX(int tamX) {
        this.tamX = tamX;
    }
    public int getTamY() {
        return tamY;
    }
    public void setTamY(int tamY) {
        this.tamY = tamY;
    }
    


    
}
