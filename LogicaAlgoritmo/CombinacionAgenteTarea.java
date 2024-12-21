package Practica1.LogicaAlgoritmo;

import java.util.ArrayList;


public class CombinacionAgenteTarea {

    private ArrayList<Integer> tareasEscogidas;
    private int valorCombinacion;

    public CombinacionAgenteTarea() {
        valorCombinacion = 0;
        tareasEscogidas = new ArrayList<Integer>();
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public CombinacionAgenteTarea(CombinacionAgenteTarea com) {
        valorCombinacion = com.valorCombinacion;
        tareasEscogidas = (ArrayList)com.tareasEscogidas.clone();
    }

    public int getTarea(int i){
        return tareasEscogidas.get(i);
    }
    public void añadirTarea(int nTarea, int valor) {
        valorCombinacion += valor;
        tareasEscogidas.add(nTarea);
    }
    public void quitarTarea(int valor){
        tareasEscogidas.removeLast();
        valorCombinacion -= valor;
    }
    public int getNumeroTareasEscogidas() {
        return tareasEscogidas.size();
    }
    public void setTareasEscogidas(ArrayList<Integer> _tareasEscogidas){
        tareasEscogidas = _tareasEscogidas;
    }
    public ArrayList<Integer> getTareasEscogidas(){
        return tareasEscogidas;
    }

    public int getValorCombinacion() {
        return valorCombinacion;
    }
    public void setValorCombinacion(int valor) {
        valorCombinacion = valor;
    }

    @Override
    public String toString() {
        return "CombinacionAgenteTarea [tareasEscogidas=" + tareasEscogidas
                + ", valorCombinacion=" + valorCombinacion + "]";
    }

    

}
