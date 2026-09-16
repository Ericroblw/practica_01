# Pr ctica de programaci¢n b sica con Scala 
 
## Autor 
**Nombre y apellidos:** Eric Robles 
 
## Entorno 
- **Sistema operativo:** Windows 11 
- **Scala:** 2.12.21 
- **Java:** Eclipse Temurin JDK 17 
 
--- 
 
## Parte 1 - Entornos de trabajo 
 
### 1.1 Entorno 1 - JupyterLab + Almond Kernel + Scala 2.12.21 
 
#### Instalaci¢n de JupyterLab y soluci¢n con Python 3.12 
Primero se procedi¢ a instalar JupyterLab desde la terminal. Al no reconocer el comando pip, se solucion¢ instalando Python 3.12 y ejecutando: 
 
```cmd 
py -3.12 -m pip install jupyterlab 
``` 
 
![Error pip](images/error_01.jpg) 
 
#### Descarga de Coursier e instalaci¢n del kernel Almond 
Se descarg¢ Coursier cs.zip mediante curl y se descomprimi¢: 
 
```cmd 
curl -Lo cs.zip https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-win32.zip 
tar -xf cs.zip 
``` 
 
![Descomprimir Coursier](images/descomprimir_courser.jpg) 
 
Se instal¢ y vincul¢ el kernel interactivo Almond para Scala 2.12.21, comprobando los kernels y la versi¢n del ejecutor: 
 
```cmd 
cs.exe launch --fork almond:latest.release --scala 2.12.21 -- --install 
py -3.12 -m jupyter kernelspec list 
cs.exe launch scala:2.12.21 -- -version 
``` 
 
![Kernel instalado](images/jupyter-kernel-instalado.jpg) 
 
#### Apertura de JupyterLab y pruebas en el Notebook 
Se inici¢ el servidor con jupyter lab comprobando la disponibilidad del kernel interactivo de Scala en el Launcher. 
 
![Inicio JupyterLab](images/jupiter-inicio.jpg) 
 
Se ejecut¢ la instrucci¢n scala.util.Properties.versionString comprobando que utiliza Scala 2.12.21: 
 
![Versi¢n de Scala](images/jupiter-scala-version.jpg) 
 
Pruebas b sicas de sintaxis ejecutadas en el notebook (interpolaci¢n de cadenas, suma aritm‚tica e inicializaci¢n de listas): 
 
![Pruebas sintaxis](images/jupyter-pruebas-codigo.jpg) 
 
--- 
 
### 1.2 Entorno 2 - Visual Studio Code + Metals + Scala 2.12.21 + JDK 17 + sbt 
 
#### Verificaci¢n de JDK 17 y sbt 
Se configur¢ Eclipse Temurin JDK 17 y se verificaron las versiones con java -version, javac -version y sbt --version: 
 
![Java 17](images/vscode-jdk17.jpg) 
![Versi¢n sbt](images/vscode-sbt-version.jpg) 
 
#### Instalaci¢n de la extensi¢n Metals 
En VS Code se instal¢ la extensi¢n oficial Scala (Metals): 
 
![Descarga Metals](images/descarga-metals.jpg) 
![Metals integrado](images/vscode-metal-extensions.jpg) 
 
#### Configuraci¢n de build.sbt y compilaci¢n 
Configuraci¢n de build.sbt con nombre, versi¢n y Scala 2.12.21, seguido de compilaci¢n exitosa con sbt compile: 
 
![build.sbt](images/vscode-built-sbt.jpg) 
![sbt compile](images/vscode-sbt-compile.jpg) 
 
#### Ejecuci¢n de Main.scala 
Ejecuci¢n del programa mediante sbt run dentro de Visual Studio Code: 
 
![Ejecuci¢n Main](images/vscode-ejecucion-main.jpg) 
 
--- 
 
### 1.3 Entorno 3 - IntelliJ IDEA Community + Scala 2.12.21 + sbt 
 
#### Instalaci¢n y primer inicio 
Instalaci¢n y apertura inicial de IntelliJ IDEA en Windows: 
 
![Inicio IntelliJ](images/inicio-intellij.jpg) 
 
#### Instalaci¢n del plugin de Scala 
Instalaci¢n y activaci¢n del plugin oficial de Scala desde el repositorio de IntelliJ IDEA: 
 
![Plugin Scala](images/intellij-scala-instalado.jpg) 
 
#### Configuraci¢n del proyecto y build.sbt 
Creaci¢n del proyecto sbt scala-intellij con JDK 17 y Scala 2.12.21: 
 
![Crear proyecto](images/intellij-creacion-proyecto.jpg) 
![build.sbt IntelliJ](images/intellij-build-sbt.jpg) 
 
#### Ejecuci¢n desde el IDE 
Ejecuci¢n del objeto Main desde las herramientas integradas del IDE: 
 
![Ejecuci¢n IDE](images/intellij-ejecucion-ide.jpg) 
 
#### Ejecuci¢n con sbt en terminal 
Resoluci¢n del entorno en terminal para reconocer sbt y posterior compilaci¢n y ejecuci¢n con sbt run: 
 
![Error PowerShell](images/intellij-error-compile.jpg) 
![sbt run IntelliJ](images/intellij-sbt-run.jpg)
