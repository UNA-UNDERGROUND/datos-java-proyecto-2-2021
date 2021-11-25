# datos-java-proyecto-2-2021
Proyecto 2 estructura de datos en Java UNA 2021.

Puede visitar la documentacion en [pagina web](https://proyecto2.xravn.net/javadoc/index.html)

## Diseño del proyecto

### sistema del proyecto

El proyecto usa como sistema de proyecto maven, debido a la simplesa al trabajar con varios IDEs o editores de texto.

Por ejemplo se pueden usar VSCode o Intellij IDEA e incluso eclipse,
mientras netbeans sigue usandolo sin agregar archivos adicionales,
permitiendo el nivel de compatibilidad ideal en el proyecto.

## Analisis de resultados

El sistema se baso al encontrar el circuito y el camino con base de arreglos que lo hace mas efectivo a la hora de estimar el tiempo.

### optimizaciones fuera del alcance

Por otra parte la mayoría de la implementacion es un tiempo optimo el cual puede ser
mejorado mucho mas si se dispone de un acceso interno a las estructuras contenedoras.


### Acceso a la memoria y arquitectura

Por ejemplo el tiempo de acceso de una lista enlazada a un elemento es O(n) mientras que un arreglo es O(1), en varias arquitecturas modernas estas implementan un cache para acelerar la velocidad de los datos, la cual la lista enlazada no garantiza tal continuidad por lo que la velocidad de esta suele ser inferior conforme crecen los datos, y estas operaciones de lectura suelen ser bastante intensivas por lo que es un posible punto de optimizacion prioritario el cual exede el objetivo de este proyecto.

### Documentacion tecnica

JavaDoc permite el acceso interno a los comentarios del codigo para generar la documentacion, maven dispone de un target para generarla,
el cual es el siguente
> mvn javadoc:javadoc