object Main extends App {

  //DATOS INICIALES//
  val jugadores = List(
    "Alex",
    "Chen",
    "Marta",
    "Sindhu",
    "Luis"
  )

  val puntuaciones = Array(
    18,
    24,
    21,
    20,
    26
  )

  //FUNCION BUST
  def bust(puntuacion: Int): Boolean =
    if (puntuacion > 21) {
      true
    } else {
      false
    }

  //FUNCION ESTADOMANO
  def estadoMano(puntuacion: Int): String = {
    if (bust(puntuacion)) {
      "Bust"
    } else {
      "Valida"
    }
  }

  def mejorMano(handA: Int, handB: Int): Int = {
    if (bust(handA) && bust(handB)) {
      0
    } else if (bust(handA)) {
      handB
    } else if (bust(handB)) {
      handA
    } else {
      if (handA > handB) handA else handB
    }
  }

  //INICIALIZAMOS VARIABLES PARA LUEGO INCREMENTARLAS
  var i = 0
  var manosValidasR1 = 0
  var manosBustR1 = 0
  var mejorPuntuacionR1 = 0

  while (i < puntuaciones.length) {
    val jugadorActual = jugadores(i)
    val puntuacionActual = puntuaciones(i)
    val estado = estadoMano(puntuacionActual)

    //MOSTRAMOS LA PUNTUACION Y EL ESTADO
    println(s"$jugadorActual -> $puntuacionActual -> $estado")

    if (estado == "Valida") {
      manosValidasR1 += 1
      mejorPuntuacionR1 = mejorMano(mejorPuntuacionR1, puntuacionActual)
    } else {
      manosBustR1 += 1
    }

    i += 1
  }

  println(" Resumen de la ronda ")
  println(s"Jugadores: ${jugadores.length}")
  println(s"Manos validas: $manosValidasR1")
  println(s"Bust: $manosBustR1")
  println(s"Mejor puntuacion valida: $mejorPuntuacionR1\n")

  //RONDA 2
  val puntuacionesRonda2 = Array(
    22,
    19,
    20,
    21,
    17
  )

  var y = 0
  var manosValidasR2 = 0
  var manosBustR2 = 0
  var mejorPuntuacionR2 = 0

  while (y < puntuacionesRonda2.length) {
    val jugadorActual = jugadores(y)
    val puntuacionActual = puntuacionesRonda2(y)
    val estado = estadoMano(puntuacionActual)

    //MOSTRAMOS LA PUNTUACION Y EL ESTADO
    println(s"$jugadorActual -> $puntuacionActual -> $estado")

    if (estado == "Valida") {
      manosValidasR2 += 1
      mejorPuntuacionR2 = mejorMano(mejorPuntuacionR2, puntuacionActual)
    } else {
      manosBustR2 += 1
    }

    y += 1
  }

  println("\n--- Resumen de la ronda 2 ---")
  println(s"Jugadores: ${jugadores.length}")
  println(s"Manos validas: $manosValidasR2")
  println(s"Bust: $manosBustR2")
  println(s"Mejor puntuacion valida: $mejorPuntuacionR2\n")

  //LAS RONDAS SE COMPARAN
  println(" COMPARACION DE RONDAS ")
  println(s"Mejor puntuacion Ronda 1: $mejorPuntuacionR1")
  println(s"Mejor puntuacion Ronda 2: $mejorPuntuacionR2")

  if (mejorPuntuacionR1 > mejorPuntuacionR2) {
    println("Resultado: La Ronda 1 tuvo la mejor puntuacion.")
  } else if (mejorPuntuacionR2 > mejorPuntuacionR1) {
    println("Resultado: La Ronda 2 tuvo la mejor puntuacion.")
  } else {
    println("Resultado: Ambas rondas tuvieron la misma mejor puntuacion.")
  }

  //PUNTUACION VALIDA CON FOREACH
  println(" ANALISIS DE PUNTUACIONES CON FOREACH ")
  puntuacionesRonda2.foreach { punt =>
    println(s"Puntuacion: $punt -> Estado: ${estadoMano(punt)}")
  }

}