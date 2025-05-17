#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include "libcostos_JavaCostos.h"
#include <cjson/cJSON.h>

// Implementaciones existentes
JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularCostoTotal
  (JNIEnv *env, jclass clazz, jfloat cfijo, jfloat cvariable, jfloat cindirecto) {
    return cfijo + cvariable + cindirecto;
}

JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularCostoUnitario
  (JNIEnv *env, jclass clazz, jfloat costoTotal, jint unidades) {
    return (unidades != 0) ? costoTotal / unidades : 0;
}

JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularMargenGanancia
  (JNIEnv *env, jclass clazz, jfloat costoTotal, jfloat porcentajeGanancia) {
    return costoTotal * (porcentajeGanancia / 100.0);
}

JNIEXPORT jfloat JNICALL Java_libcostos_JavaCostos_calcularPrecioVenta
  (JNIEnv *env, jclass clazz, jfloat costoTotal, jfloat margenGanancia) {
    return costoTotal + margenGanancia;
}

// Implementación para generar JSON
JNIEXPORT jstring JNICALL Java_libcostos_JavaCostos_generarJSONCostos(JNIEnv *env, jclass clazz, jfloat cfijo, jfloat cvariable, jfloat cindirecto, jint unidades, jfloat porcentajeGanancia) {
    jfloat costoTotal = cfijo + cvariable + cindirecto;
    jfloat costoUnitario = (unidades != 0) ? costoTotal / unidades : 0;
    jfloat margenGanancia = costoTotal * (porcentajeGanancia / 100.0);
    jfloat precioVenta = costoTotal + margenGanancia;

    cJSON *root = cJSON_CreateObject();
    cJSON_AddNumberToObject(root, "costo_fijo", cfijo);
    cJSON_AddNumberToObject(root, "costo_variable", cvariable);
    cJSON_AddNumberToObject(root, "costo_indirecto", cindirecto);
    cJSON_AddNumberToObject(root, "unidades", unidades);
    cJSON_AddNumberToObject(root, "porcentaje_ganancia", porcentajeGanancia);
    cJSON_AddNumberToObject(root, "costo_total", costoTotal);
    cJSON_AddNumberToObject(root, "costo_unitario", costoUnitario);
    cJSON_AddNumberToObject(root, "margen_ganancia", margenGanancia);
    cJSON_AddNumberToObject(root, "precio_venta", precioVenta);

    char *json_str = cJSON_Print(root);
    jstring result = (*env)->NewStringUTF(env, json_str);
    
    cJSON_Delete(root);
    free(json_str);
    
    return result;
}
