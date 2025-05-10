package libcostos;

public class JavaCostos {
    static {
        System.loadLibrary("costos"); // Carga la biblioteca al inicio
    }

    public static native float calcularCostoTotal(float cfijo, float cvariable, float cindirecto);
    public static native float calcularCostoUnitario(float costoTotal, int unidades);
    public static native float calcularMargenGanancia(float costoTotal, float porcentajeGanancia);
    public static native float calcularPrecioVenta(float costoTotal, float margenGanancia);
}
