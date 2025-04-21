package libcostos;

import libcostos.JavaCostos;

public class Costos {
    // Declaramos un objeto que represente a la biblioteca
    JavaCostos costos = null;

    static {

        System.loadLibrary("costos");
    }

    public Costos() {
        this.costos = new JavaCostos();

        float materiales = 1000f;
        float manoObra = 700f;
        float indirectos = 300f;

        float costoTotal = costos.calcularCostoTotal(materiales, manoObra, indirectos);
        System.out.println("Costo Total: " + costoTotal);

        float costoUnitario = costos.calcularCostoUnitario(costoTotal, 100);
        System.out.println("Costo Unitario: " + costoUnitario);

        float margen = costos.calcularMargenGanancia(costoTotal, 0.2f);
        System.out.println("Margen de Ganancia: " + margen);

        float precioVenta = costos.calcularPrecioVenta(costoTotal, margen);
        System.out.println("Precio de Venta: " + precioVenta);
    }

    public static void main(String[] args) {
        new Costos();
    }
}

