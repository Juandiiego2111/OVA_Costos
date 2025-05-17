package aplicacion;

import libcostos.JavaCostos;
import java.util.Scanner;

public class Costos {
    private float cfijo;
    private float cvariable;
    private float cindirecto;
    private int unidades;
    private float porcentajeGanancia;

    private static class MenuCostos {
        private final Scanner scanner = new Scanner(System.in);
        private final Costos costos = new Costos();

        public void iniciar() {
            int opcion;
            do {
                mostrarMenu();
                opcion = leerOpcion();
                procesarOpcion(opcion);
            } while(opcion != 0);
            scanner.close();
        }

        private void mostrarMenu() {
            System.out.println("=== SISTEMA DE COSTOS ===");
            System.out.println("1. Calcular Costo Total");
            System.out.println("2. Calcular Costo Unitario");
            System.out.println("3. Calcular Margen de Ganancia");
            System.out.println("4. Calcular Precio de Venta");
            System.out.println("5. Generar JSON de Costos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
        }

        private int leerOpcion() {
            try {
                return scanner.nextInt();
            } finally {
                scanner.nextLine();
            }
        }

        private void procesarOpcion(int opcion) {
            switch(opcion) {
                case 1: calcularCostoTotal(); 
                break;
                case 2: calcularCostoUnitario(); 
                break;
                case 3: calcularMargenGanancia(); 
                break;
                case 4: mostrarPrecioVenta(); 
                break;
                case 5: generarJSONCostos(); 
                break;
                case 0: System.out.println("Saliendo.."); 
                break;
                default: System.out.println("Opción inválida!");
            }
        }

        private void calcularCostoTotal() {
            System.out.print("\nCosto Fijo: ");
            float cfijo = scanner.nextFloat();
            System.out.print("Costo Variable: ");
            float cvariable = scanner.nextFloat();
            System.out.print("Costo Indirecto: ");
            float cindirecto = scanner.nextFloat();
            
            costos.cfijo = cfijo;
            costos.cvariable = cvariable;
            costos.cindirecto = cindirecto;

            float total = JavaCostos.calcularCostoTotal(cfijo, cvariable, cindirecto);
            System.out.println("Costo Total: " + total);
        }

        private void calcularCostoUnitario() {
            System.out.print("\nUnidades Producidas: ");
            costos.unidades = scanner.nextInt();
            float unitario = JavaCostos.calcularCostoUnitario(
                JavaCostos.calcularCostoTotal(costos.cfijo, costos.cvariable, costos.cindirecto),
                costos.unidades
            );
            System.out.println("Costo Unitario: " + unitario);
        }

        private void calcularMargenGanancia() {
            System.out.print("\nPorcentaje de Ganancia (%): ");
            costos.porcentajeGanancia = scanner.nextFloat();
            float margen = JavaCostos.calcularMargenGanancia(
                JavaCostos.calcularCostoTotal(costos.cfijo, costos.cvariable, costos.cindirecto),
                costos.porcentajeGanancia
            );
            System.out.println("Margen de Ganancia: " + margen);
        }

        private void mostrarPrecioVenta() {
            float total = JavaCostos.calcularCostoTotal(costos.cfijo, costos.cvariable, costos.cindirecto);
            float margen = JavaCostos.calcularMargenGanancia(total, costos.porcentajeGanancia);
            System.out.println("\nPrecio de Venta: " + JavaCostos.calcularPrecioVenta(total, margen));
        }

        private void generarJSONCostos() {
            if (costos.cfijo == 0 && costos.cvariable == 0 && costos.cindirecto == 0) {
                System.out.println("\nError: Primero ingrese los costos (Opción 1)");
                return;
            }
            
            String json = JavaCostos.generarJSONCostos(
                costos.cfijo,
                costos.cvariable,
                costos.cindirecto,
                costos.unidades,
                costos.porcentajeGanancia
            );
            System.out.println("\nJSON Generado:\n" + json);
        }
    }

    public static void main(String[] args) {
        new MenuCostos().iniciar();
    }
} 
