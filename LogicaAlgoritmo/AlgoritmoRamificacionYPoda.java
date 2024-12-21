package Practica1.LogicaAlgoritmo;

import java.util.PriorityQueue;

import Practica1.FuncionesEntrada.MatrizEntrada;

public class AlgoritmoRamificacionYPoda {

    private int[][] matriz;
    private int tamX, tamY;
    private boolean traza;
    // La altura del arbol es debido a que pueden haber mas tareas que agentes o viceversa
    private int ALTURA_ARBOL;
    private String RESULTADO = "";
    public String getRESULTADO() {
        return RESULTADO;
    }
    private PriorityQueue<TareaValor>[] monticuloTareasOrdenadas;
    private CombinacionAgenteTarea combinacionMejor;
    private CombinacionAgenteTarea combinacionActual;


    @SuppressWarnings("unchecked")
    public AlgoritmoRamificacionYPoda(MatrizEntrada _entrada, boolean _traza) {
        matriz = _entrada.getMatriz();
        traza = _traza;
        tamX = _entrada.getTamX();
        tamY = _entrada.getTamY();
        ALTURA_ARBOL = tamX > tamY ? tamY : tamX;
        // inicializamos el monticulo
        monticuloTareasOrdenadas = new PriorityQueue[ALTURA_ARBOL];
        for (int i = 0; i < ALTURA_ARBOL; i++) {
            monticuloTareasOrdenadas[i] = new PriorityQueue<TareaValor>();
        }
        combinacionMejor = new CombinacionAgenteTarea();
        combinacionActual = new CombinacionAgenteTarea();
        rellenarMonticulo();
        combinacionMejor.setValorCombinacion(Integer.MAX_VALUE);
    }


    // rellenamos el monticulo con las tareas ordenadas
    private void rellenarMonticulo() {
        for (int x = 0; x < tamX; x++) {
            for (int y = 0; y < tamY; y++) {
                monticuloTareasOrdenadas[x].add(new TareaValor(x, y, matriz[x][y]));
            }
        }
    }

    // Iniciamos el algoritmo
    public void iniciarAlgoritmo() {
        algoritmoRecursivo();
        if(traza) System.out.println("\n\nMejor combinacion encontrada: " + combinacionMejor);
        mostrarCombinacionOptimista();
        mostrarResultado();
    }

    // Metodo recursivo que se encarga de recorrer el arbol de posibilidades y podar las peores
    private void algoritmoRecursivo() {
        if(traza) System.out.println("\n Nivel " + combinacionActual.getNumeroTareasEscogidas() + " -> " + combinacionActual);
        // comprobar condicion de parada
        if (combinacionActual.getNumeroTareasEscogidas() >= ALTURA_ARBOL) {
            if (combinacionMejor.getValorCombinacion() > combinacionActual.getValorCombinacion()) {
                combinacionMejor = new CombinacionAgenteTarea(combinacionActual);
                if(traza) System.out.println("\n_______________________________________________________________________________________");
                if(traza) System.out.println("\n¡Nuevo mejor encontrado!");
                if(traza) System.out.println("\n" + combinacionMejor + "\n");
                if(traza) System.out.println("__________________________________________________________________________________________\n\n");
            }
            return;
        }
        // comprobar si es posible mejorar la combinacion, si no, podar
        if (!esPosibleMejorarCombinacion()) {
            return;
        }
        // como es posible mejorar, seguimos con la recursividad
        for (TareaValor y : monticuloTareasOrdenadas[combinacionActual.getNumeroTareasEscogidas()]) {
            if (!combinacionActual.getTareasEscogidas().contains(y.getIndiceTarea())) {
                combinacionActual.añadirTarea(y.getIndiceTarea(), y.getValor());
                algoritmoRecursivo();
                combinacionActual.quitarTarea(y.getValor());
            }
        }
    }


    // Comprobamos si es posible mejorar la combinacion actual
    private boolean esPosibleMejorarCombinacion() {
        // vamos a añadir tareas optimistas hasta completar y a sumarle el valor de las
        // tareas actuales
        int sumatorioActualMasOptimista = combinacionActual.getValorCombinacion();
        for (int i = combinacionActual.getNumeroTareasEscogidas(); i < ALTURA_ARBOL; i++) {
            sumatorioActualMasOptimista += monticuloTareasOrdenadas[i].peek().getValor();
        }
        // Si se puede mejorar devolvemos true
        if (sumatorioActualMasOptimista < combinacionMejor.getValorCombinacion()) {
            return true;
        }
        // Si no se puede mejorar, devolvemos false
        if(traza) System.out.println("\n#########################################################################################");
        if(traza) System.out.println("\n Podamos en: " + combinacionActual.getTareasEscogidas() + ", Mejor valor alcanzable: "
                + sumatorioActualMasOptimista + ", Mejor valor: " + combinacionMejor.getValorCombinacion() + "\n");
        if(traza) System.out.println("#########################################################################################\n\n");
        return false;
    }

    private void mostrarCombinacionOptimista(){
        if(traza) System.out.println("\n\nCombinacion optimista: \n");
        int valorOptimista = 0;
        for(int i = combinacionActual.getNumeroTareasEscogidas(); i < ALTURA_ARBOL; i++){
            TareaValor tv = monticuloTareasOrdenadas[i].peek();
            valorOptimista += tv.getValor();
            if(traza) System.out.println("Agente " + i + " -> Tarea " + tv.getIndiceTarea() + " -> Valor " + tv.getValor() + "\n");
        }
        if(traza) System.out.println("Valor combinacion optimista -> "+valorOptimista+"\n");
    }

    private void mostrarResultado(){
        for(int i=0; i<ALTURA_ARBOL; i++){
            RESULTADO += i + " " +combinacionMejor.getTareasEscogidas().get(i) + "\n";
        }
    }

}
