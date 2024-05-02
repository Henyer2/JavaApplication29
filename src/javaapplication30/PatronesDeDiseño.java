package javaApplication30;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatronesDeDiseño {

    static class Objeto {
        String nombre;
        String forma;
        int peso;
        int precio;

        public Objeto(String nombre, String forma, int peso, int precio) {
            this.nombre = nombre;
            this.forma = forma;
            this.peso = peso;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Objeto{" +
                    "nombre='" + nombre + '\'' +
                    ", forma='" + forma + '\'' +
                    ", peso=" + peso +
                    ", precio=" + precio +
                    '}';
        }
    }

    static class Mochila {
        List<Objeto> objetosSeleccionados = new ArrayList<>();
        int capacidadMaxima;
        int pesoActual = 0;
        int valorTotal = 0;

        public Mochila(int capacidadMaxima) {
            this.capacidadMaxima = capacidadMaxima;
        }

        public void añadirObjeto(Objeto objeto) {
            if (pesoActual + objeto.peso <= capacidadMaxima) {
                objetosSeleccionados.add(objeto);
                pesoActual += objeto.peso;
                valorTotal += objeto.precio;
                System.out.println("Añadido: " + objeto);
            } else {
                System.out.println("No se puede añadir " + objeto.nombre + ", excede el peso máximo.");
            }
        }

        public void imprimirEstadoFinal() {
            System.out.println("\nEstado final de la mochila:");
            for (Objeto objeto : objetosSeleccionados) {
                System.out.println(objeto);
            }
            System.out.println("Peso total: " + pesoActual + ", Valor total: " + valorTotal);
        }
    }

    public static void main(String[] args) {
        int capacidadMaxima = 50; // Peso máximo que puede llevar la mochila
        List<Objeto> todosLosObjetos = generarObjetos();
        Mochila mochila = new Mochila(capacidadMaxima);

        for (Objeto objeto : todosLosObjetos) {
            mochila.añadirObjeto(objeto);
            if (mochila.objetosSeleccionados.size() == 15) {
                break; // Detener después de seleccionar 15 objetos
            }
        }

        mochila.imprimirEstadoFinal();
    }

    private static List<Objeto> generarObjetos() {
        List<Objeto> objetos = new ArrayList<>();
        Random rand = new Random();
        String[] formas = {"circular", "cuadrada", "rectangular", "triangular"};

        for (int i = 1; i <= 20; i++) {
            String nombre = "Objeto" + i;
            String forma = formas[rand.nextInt(formas.length)];
            int peso = rand.nextInt(5) + 1; // Pesos entre 1 y 5
            int precio = rand.nextInt(100) + 1; // Precios entre 1 y 100
            objetos.add(new Objeto(nombre, forma, peso, precio));
        }
        return objetos;
    }
}
