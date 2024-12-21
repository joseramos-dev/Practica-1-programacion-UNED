package Practica1.LogicaAlgoritmo;


public class TareaValor implements Comparable<TareaValor> {

    private int indiceUsuario;
    private int indiceTarea;
    private int valor;

    public TareaValor(int _indiceUsuario, int _indiceTarea, int _valor) {
        indiceUsuario = _indiceUsuario;
        indiceTarea = _indiceTarea;
        valor = _valor;
    }

    public int getIndiceUsuario() {
        return indiceUsuario;
    }

    public int getIndiceTarea() {
        return indiceTarea;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public int compareTo(TareaValor o) {
        return this.valor - o.valor;
    }

}
