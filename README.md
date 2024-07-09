# Currency Converter

Este es un pequeño programa en Java que utiliza la API de ExchangeRate-API para convertir entre diferentes monedas basadas en el dólar estadounidense.

## Características

- Convierte entre dólares estadounidenses (USD), pesos colombianos (COP), pesos argentinos (ARS) y pesos chilenos (CLP).
- Utiliza Gson para el mapeo de JSON y HttpClient para realizar solicitudes HTTP a la API de tipos de cambio.

## Uso

1. Clona el repositorio o descarga los archivos.
2. Compila y ejecuta el programa `Main.java`.
3. Sigue las instrucciones en consola para seleccionar el tipo de conversión deseado.

## Requisitos

- Java 11 o superior.
- Acceso a Internet para realizar las consultas a la API de ExchangeRate-API.

## Ejemplo de Uso

```
**********************************************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dolar ==> Peso Colombiano
2) Peso Colombiano ==> Dolar
3) Dolar ==> Peso Argentino
4) Peso Argentino ==> Dolar
5) Dolar ==> Peso Chileno
6) Peso Chileno ==> Dolar
7) Salir
Ingrese la opción deseada:
**********************************************************

Ingrese la opción deseada: 1

Ingrese la cantidad de dólares: 100
Tienes $368000 COP (USD)

Presione enter para continuar...

...

Gracias por usar el conversor de moneda.


```