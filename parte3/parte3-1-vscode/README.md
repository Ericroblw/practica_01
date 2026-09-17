# Mini proyecto 3.1 — Clasificador de resultados de un torneo de Twenty-One

## Entorno de trabajo

- **Editor / IDE:** Visual Studio Code
- **Language Server:** Scala (Metals)
- **Versión de Scala:** 2.12.21
- **Máquina Virtual:** Java Development Kit 17 (Eclipse Adoptium Temurin 17.0.18)
- **Herramienta de compilación:** sbt 1.13.0

### Verificación y configuración del entorno

Para garantizar la compatibilidad del ecosistema sbt con Scala 2.12.21, se configuró el entorno local asegurando el uso estricto de JDK 17 mediante las variables del sistema y la directiva `metals.javaHome`.

#### 1. Verificación de JDK 17
Comprobación de la versión activa de OpenJDK en la terminal integrada:

![Version Java](images/parte3-java-version.jpg)

#### 2. Verificación de Scala 2.12.21
Comprobación de la versión de Scala ejecutada mediante la propiedad interna `scala.util.Properties.versionString`:

![Version Scala](images/parte3-%20version-Scala.jpg)

---

## Descripción del proyecto

Este mini proyecto implementa un sistema automatizado de procesamiento y clasificación de jugadas para un torneo del juego de cartas **Twenty-One** (Blackjack simplificado). 

El objetivo principal es procesar colecciones paralelas de datos (jugadores y puntuaciones) a lo largo de dos fases eliminatorias consecutivas. El sistema evalúa individualmente el estado de la mano de cada jugador, realiza recuentos estadísticos grupales mediante acumuladores, determina de forma algorítmica la mejor mano válida y compara el rendimiento entre rondas utilizando estructuras de control imperativas y funcionales.

---

## Estructura del proyecto

El proyecto respeta la organización canónica de aplicaciones gestionadas por sbt:

![Estructura](images/parte3-%20estructura.jpg)

build.sbt: Archivo declarativo donde se define el identificador del proyecto (name := "torneo-twenty-one") y se fija la versión del compilador (scalaVersion := "2.12.21").

src/main/scala/Main.scala: Punto de entrada de la aplicación (object Main extends App) que alberga las funciones puras de evaluación, los datos inmutables y los algoritmos de iteración.

images/: Carpeta local que almacena las evidencias gráficas requeridas.

Funciones implementadas
La lógica de decisión se descompuso en tres funciones modulares:

1. Función bust
Evalúa si una puntuación numérica excede el límite reglamentario de 21 puntos. Devuelve true si el jugador queda eliminado y false si se mantiene en juego.

![Funcion bust](images/parte3-%20funcion-bust.jpg)

2. Función estadoMano
Reutiliza la función bust para clasificar semánticamente la mano del jugador, devolviendo "Bust" o "Valida".

![Funcion estadoMano](images/parte3-%20funcion-estadoMano.jpg)

3. Función mejorMano
Aplica las reglas de eliminación y desempate entre dos puntuaciones (handA y handB):

Si ambas puntuaciones superan 21, se descartan devolviendo 0.

Si una de las dos supera 21, se descarta la eliminada y se retorna la válida.

Si ambas están dentro del rango reglamentario, se compara mediante un operador relacional y se devuelve la de mayor valor.


![Funcion mejorMano](images/parte3-%20funcion-mejorMano.jpg)


Compilación y Ejecución
El ciclo de construcción y ejecución se realizó desde la terminal integrada de Visual Studio Code mediante sbt.


![Compilacion sbt](images/parte3-%20sbt-compile.jpg)

![Ejecucion sbt](images/parte3-%20sbt-run.jpg)


Evidencia de compilación (sbt compile)
Compilación limpia sin advertencias ni fallos de sintaxis:

Evidencia de ejecución (sbt run)
Salida completa generada por la consola mostrando las dos rondas, resúmenes y comparativas:

Resultados y Análisis de las Rondas
Al ejecutar el programa, se procesaron secuencialmente las dos rondas de juego:

Ronda 1
Colección de datos: Array(18, 24, 21, 20, 26) asociado a la lista inmutable de participantes.

Participantes y estado:

Alex: 18 -> Valida

Chen: 24 -> Bust

Marta: 21 -> Valida

Sindhu: 20 -> Valida

Luis: 26 -> Bust

Estadísticas obtenidas:

Total jugadores: 5

Manos válidas: 3

Bust: 2

Mejor puntuación válida: 21 (Marta)

Ronda 2
Colección de datos: Array(22, 19, 20, 21, 17). Se mantuvo la lista original inmutable sin mutación estructural.

Participantes y estado:

Alex: 22 -> Bust

Chen: 19 -> Valida

Marta: 20 -> Valida

Sindhu: 21 -> Valida

Luis: 17 -> Valida

Estadísticas obtenidas:

Total jugadores: 5

Manos válidas: 4

Bust: 1

Mejor puntuación válida: 21 (Sindhu)

Comparación entre rondas
Mediante la evaluación de las variables acumuladoras mejorPuntuacionR1 (21) y mejorPuntuacionR2 (21) con un bloque if / else if / else, el sistema determinó un empate técnico al alcanzar ambas tandas la puntuación máxima reglamentaria (21 puntos).

Comparativa técnica: while frente a foreach
En cumplimiento con el apartado 3.1.14 del enunciado, se contrastaron los dos estilos de iteración implementados:

Criterio	Bucle while (Estilo Imperativo)	Método foreach (Estilo Funcional)
Gestión de contador	Requiere un índice explícito (var i = 0, i += 1).	No requiere contador; itera internamente sobre la colección.
Mutabilidad del estado	Depende de variables mutables (var) para el control de flujo.	Opera con valores inmutables (val) pasados por parámetro a la función.
Seguridad de tipos/índice	Riesgo alto de IndexOutOfBoundsException si falla la condición.	Seguro contra desbordamientos de rango en colecciones indexadas.
Paradigma	Imperativo: indica cómo recorrer paso a paso la memoria.	Funcional: indica qué hacer con cada elemento individual.
Conclusión: foreach se aproxima mucho mejor a la filosofía idiomática de Scala y a los principios de inmutabilidad trabajados a lo largo del curso.

Incidencias y soluciones técnicas
Prioridad en variables de entorno (JDK):

Problema: El sistema operativo ejecutaba por defecto Java 21 en lugar de la versión 17 exigida para el proyecto.

Solución: Se forzó en la terminal la variable JAVA_HOME apuntando al directorio jdk-17.0.18.8-hotspot de Eclipse Adoptium y se configuró metals.javaHome en VS Code para desacoplar el entorno de compilación.

Excepción de índice fuera de rango (IndexOutOfBoundsException: 5):

Problema: Al copiar la lógica de iteración para la segunda ronda, se utilizó un nuevo contador var y = 0 en la condición del bucle, pero se mantuvieron referencias residuales a la variable i de la primera ronda (jugadores(i)). Al haber finalizado i con valor 5, se intentó acceder a una posición inexistente en una colección de tamaño 5.

Solución: Se unificó el uso del identificador de variable local y tanto en la indexación de la lista como en el array de puntuaciones secundario.
