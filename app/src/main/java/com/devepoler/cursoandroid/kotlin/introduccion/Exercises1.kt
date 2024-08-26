package com.devepoler.cursoandroid.kotlin.introduccion

fun main() {
    /* Ejercicio 1
    * Dado un nombre, dígale hola por pantalla
    */
    val name = "Pablo"
    println("Hola, $name")

    /* Ejercicio 2
    * Dadas las horas de trabajo y el precio por hora,
    * calcule e imprima el importe total del servicio
    */
    val workedHours = 8
    val moneyPerHour = 6.5
    val totalEarned = workedHours * moneyPerHour

    println("Tras trabajar $workedHours horas, a $moneyPerHour€ la hora, habremos ganado: $totalEarned€")

    /* Ejercicio 3
    * Dada una temperatura en grados Celsius,
    * convierta dicha temperatura a Fahrenheit
    * imprima por pantalla ambas temperaturas con un formato amigable
    */
    val celsius = 31
    val fahrenheit = (celsius * 9.0/5) + 32

    println("$celsius ºC equivalen a $fahrenheit ºF")

    /* Ejercicio 4
    * Dado el importe sin IVA de un artículo,
    * calcule e imprima el precio final del artículo.
    * El IVA aplicado es el 21%
    */
    val price = 100
    val taxes = 1.21

    val finalPrice = price * taxes

    println("El precio final del producto ($price€), tras el 21% de IVA es: $finalPrice€")

    /* Ejercicio 5
    * Dado el importe final de un artículo,
    * calcule e imprima el precio que se ha pagado sin IVA.
    * El IVA aplicado es el 21%
    */
    val finalSecondPrice = 100
    val secondTaxes = 1.21

    val secondPrice = finalSecondPrice / secondTaxes

    println("El precio sin IVA (21%) del producto ($finalSecondPrice€), es: $secondPrice€")
}