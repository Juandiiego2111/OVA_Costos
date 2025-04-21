#include <jni.h>

#include "libcostos_JavaCostos.h"

JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularCostoTotal
  (JNIEnv *env, jobject obj, jfloat materiales, jfloat manoObra, jfloat indirectos) {
    return materiales + manoObra + indirectos;
}

JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularCostoUnitario
  (JNIEnv *env, jobject obj, jfloat costoTotal, jint unidades) {
    if (unidades == 0) return 0;  // Evita división por cero
    return costoTotal / unidades;
}

JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularMargenGanancia
  (JNIEnv *env, jobject obj, jfloat costoTotal, jfloat porcentajeGanancia) {
    return costoTotal * (porcentajeGanancia / 100.0);
}

JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularPrecioVenta
  (JNIEnv *env, jobject obj, jfloat costoTotal, jfloat margenGanancia) {
    return costoTotal + margenGanancia;
}

