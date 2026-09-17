# Mini proyecto 3.1 — Torneo de Twenty-One

## Entorno

- Visual Studio Code
- Metals
- Scala 2.12.21
- JDK 17 (Eclipse Adoptium Temurin 17.0.18)
- sbt 1.13.0

### Verificación del entorno

#### Versión de Java (JDK 17)
![Version Java](images/parte3-java-version.jpg)

#### Versión de Scala (2.12.21)
![Version Scala](images/parte3-version-Scala.jpg)

## Descripción

Mini proyecto desarrollado en Scala para procesar y clasificar los resultados de un torneo de cartas de Twenty-One a lo largo de dos rondas consecutivas. El programa evalúa si las manos de cada jugador son válidas o exceden el límite de 21 (bust), calcula estadísticas agregadas por ronda, identifica la mano ganadora aplicando lógica condicional y compara el desempeño global entre ambas rondas mediante estructuras imperativas (`while`) y colecciones funcionales (`foreach`).

## Estructura del proyecto

```text
parte3-1-vscode/
├── README.md
├── images/
│   ├── parte3-java-version.jpg
│   ├── parte3-version-Scala.jpg
│   ├── parte3-funcion-bust.jpg
│   ├── parte3-funcion-estadoMano.jpg
│   ├── parte3-funcion-mejorMano.jpg
│   ├── parte3- sbt-compile.jpg
│   └── parte3- sbt-run.jpg
└── torneo-twenty-one/
    ├── build.sbt
    ├── project/
    └── src/
        └── main/
            └── scala/
                └── Main.scala
