package libcostos;

public class JavaCostos {

    public native float calcularCostoTotal(float materiales, float manoObra, float indirectos);
    public native float calcularCostoUnitario(float costoTotal, int unidades);
    public native float calcularMargenGanancia(float costoTotal, float porcentajeGanancia);
    public native float calcularPrecioVenta(float costoTotal, float margenGanancia);
}

