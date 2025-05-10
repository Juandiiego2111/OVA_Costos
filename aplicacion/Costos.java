// Declaramos que esta clase pertenece al paquete 'aplicacion'
package aplicacion;

// Importamos la clase nativa JavaCostos desde el paquete libcostos
import libcostos.JavaCostos;

// Importamos Scanner para leer entrada del usuario por consola
import java.util.Scanner;

public class Costos {

// Atributo para acceder a los métodos nativos de la biblioteca en C
    private JavaCostos costos;

// Constructor: inicializa el objeto costos con una instancia de JavaCostos
    public Costos() {
        this.costos = new JavaCostos();
    }

// Método principal que ejecuta el programa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Objeto para leer entrada del usuario
        Costos app = new Costos(); // Creamos una instancia de esta clase
        double resultado; // Variable para almacenar los resultados de los cálculos

// Bucle infinito para mostrar el menú hasta que el usuario decida salir
        while (true){ 
// Menú con opciones para el usuario
            System.out.println("\n--- Menú de Cálculo de Costos ---");
            System.out.println("1. Calcular Costo Total");
            System.out.println("2. Calcular Costo Unitario");
            System.out.println("3. Calcular Margen de Ganancia");
            System.out.println("4. Calcular Precio de Venta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt(); // Leemos la opción del usuario

            if (opcion == 0) break; // Si elige 0, salimos del bucle

            switch (opcion) {
                case 1:
                    // Costo Total = Costo Fijo + Costo Variable
                    System.out.print("Ingrese costo fijo: ");
                    double cf = sc.nextDouble();
                    System.out.print("Ingrese costo variable: ");
                    double cv = sc.nextDouble();
                    System.out.print("Ingrese costo indirecto: ");
                    double ci = sc.nextDouble();
                    resultado = app.costos.calcularCostoTotal((float)cf, (float)cv, (float)ci);
                    System.out.println("Costo Total: " + resultado);
                    break;
                case 2:
                    // Costo Unitario = Costo Total / Número de Unidades
                    System.out.print("Ingrese el costo total: ");
                    double ct = sc.nextDouble();
                    System.out.print("Ingrese el número de unidades: ");
                    int u = sc.nextInt();
                    resultado = app.costos.calcularCostoUnitario((float)ct, u);
                    System.out.println("Costo Unitario: " + resultado);
                    break;
                case 3:
                    // Margen de Ganancia = Precio Venta - Costo
                    System.out.print("Ingrese el costo: ");
                    double c = sc.nextDouble();
                    System.out.print("Ingrese el precio de venta: ");
                    double pv = sc.nextDouble();
                    resultado = app.costos.calcularMargenGanancia((float)c, (float)pv);
                    System.out.println("Margen de Ganancia: " + resultado);
                    break;
                case 4:
                    // Precio Venta = Costo + Margen de Ganancia
                    System.out.print("Ingrese el costo: ");
                    double c2 = sc.nextDouble();
                    System.out.print("Ingrese el margen de ganancia: ");
                    double mg = sc.nextDouble();
                    resultado = app.costos.calcularPrecioVenta((float)c2, (float)mg);
                    System.out.println("Precio de Venta: " + resultado);
                    break;
                default:
                    // Si el usuario digita una opción no válida
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

// Cerramos el scanner y despedimos al usuario
        sc.close();
        System.out.println("¡Gracias por usar la calculadora!");
    }
}

