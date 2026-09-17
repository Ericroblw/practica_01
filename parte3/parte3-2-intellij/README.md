# Practica 01 - Parte 3.2: Analizador de Calificaciones (IntelliJ IDEA)

Este modulo implementa un analizador estadistico de calificaciones academicas desarrollado en Scala 2.12.21 y gestionado a traves de sbt dentro del entorno IntelliJ IDEA.

---

## 1. Estructura del proyecto

El subproyecto se organiza respetando la arquitectura estandar de proyectos sbt:


parte3-2-intellij/
├── images/
├── README.md
└── analizador-notas/
    ├── build.sbt
    ├── project/
    │   └── build.properties
    └── src/
        └── main/
            └── scala/
                └── Main.scala
2. Configuracion de compilacion (build.sbt)Definicion de dependencias y versiones en analizador-notas/build.sbt:ScalascalaVersion := "2.12.21"

name := "analizador-notas"
El archivo project/build.properties especifica el motor de construccion:Propertiessbt.version=1.10.7
3. Implementacion modularEl archivo Main.scala centraliza las funciones de evaluacion y clasificacion cualitativa:aprobado(nota: Int): Boolean: Determina si la calificacion alcanza el umbral minimo aprobatorio ($\ge 5$).estadoNota(nota: Int): String: Devuelve "APROBADO" o "SUSPENSO" invocando a la funcion anterior.maxNota(a: Int, b: Int): Int: Retorna el valor maximo mediante estructuras condicionales if-else.clasificacion(nota: Int): String: Segmenta el rendimiento en "EXCELENTE", "NOTABLE", "APROBADO" o "SUSPENSO".4. Inmutabilidad y manejo de coleccionesSe incorpora un nuevo registro a la coleccion principal utilizando el constructor de listas :: (cons):Scalaval nuevosEstudiantes = "Carlos" :: estudiantes
Justificacion tecnicaEn Scala, la coleccion List es estrictamente inmutable. La operacion :: genera una nueva referencia en memoria donde el nuevo elemento encabeza la estructura, reutilizando de forma segura los nodos de la lista original por debajo (structural sharing). Por esta razon, estudiantes no sufre ninguna mutacion ni efecto colateral.5. Compilacion y ejecucionCompilacion limpia con sbtBashsbt compile
Salida completa del programaBashsbt run
Plaintext=== PRIMERA EVALUACION ===
Ana -> 8 -> APROBADO
Luis -> 4 -> SUSPENSO
Marta -> 10 -> APROBADO
Pedro -> 6 -> APROBADO
Sofia -> 3 -> SUSPENSO

--- Resumen del grupo ---
Estudiantes: 5
Aprobados: 3
Suspensos: 2
Mejor nota: 10

=== CLASIFICACION DETALLADA (PRIMERA EVALUACION) ===
Ana -> 8 -> NOTABLE
Luis -> 4 -> SUSPENSO
Marta -> 10 -> EXCELENTE
Pedro -> 6 -> APROBADO
Sofia -> 3 -> SUSPENSO

=== SEGUNDA EVALUACION ===
Ana -> 9 -> APROBADO
Luis -> 5 -> APROBADO
Marta -> 8 -> APROBADO
Pedro -> 7 -> APROBADO
Sofia -> 6 -> APROBADO

--- Resumen segunda evaluacion ---
Estudiantes: 5
Aprobados: 5
Suspensos: 0
Mejor nota: 9

=== COMPARACION DE EVALUACIONES ===
Mejor nota de la primera evaluacion: 10
Mejor nota de la segunda evaluacion: 9
Numero de aprobados de la primera: 3
Numero de aprobados de la segunda: 5
Resultado: El grupo ha mejorado.

=== USO DE LISTAS ===
Lista original: List(Ana, Luis, Marta, Pedro, Sofia)
Lista nueva: List(Carlos, Ana, Luis, Marta, Pedro, Sofia)
