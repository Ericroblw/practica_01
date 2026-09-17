object Main extends App {

  // DATOS INICIALES

  val estudiantes = List(
    "Ana",
    "Luis",
    "Marta",
    "Pedro",
    "Sofia"
  )

  val notas = Array(
    8,
    4,
    10,
    6,
    3
  )

  // FUNCION APROBADO

  def aprobado(nota: Int): Boolean = {
    if (nota >= 5) {
      true
    } else {
      false
    }
  }

  // FUNCION ESTADONOTA

  def estadoNota(nota: Int): String = {
    if (aprobado(nota)) {
      "APROBADO"
    } else {
      "SUSPENSO"
    }
  }

  // FUNCION MAXNOTA

  def maxNota(a: Int, b: Int): Int = {
    if (a > b) {
      a
    } else {
      b
    }
  }

  def clasificacion(nota: Int): String = {
    if (nota >= 9) {
      "EXCELENTE"
    } else if (nota >= 7) {
      "NOTABLE"
    } else if (nota >= 5) {
      "APROBADO"
    } else {
      "SUSPENSO"
    }
  }

  println("=== PRIMERA EVALUACION ===")
  var i = 0
  while (i < notas.length) {
    println(s"${estudiantes(i)} -> ${notas(i)} -> ${estadoNota(notas(i))}")
    i += 1
  }

  var aprobados1 = 0
  var suspensos1 = 0
  var mejorNota1 = 0

  var k = 0
  while (k < notas.length) {
    if (aprobado(notas(k))) {
      aprobados1 += 1
    } else {
      suspensos1 += 1
    }
    mejorNota1 = maxNota(mejorNota1, notas(k))
    k += 1
  }

  println("--- Resumen del grupo ---")
  println(s"Estudiantes: ${estudiantes.length}")
  println(s"Aprobados: $aprobados1")
  println(s"Suspensos: $suspensos1")
  println(s"Mejor nota: $mejorNota1")

  // ==========================================
  // 3.2.12 CLASIFICACION CUALITATIVA DETALLADA
  // ==========================================
  println("=== CLASIFICACION DETALLADA (PRIMERA EVALUACION) ===")
  var m = 0
  while (m < notas.length) {
    println(s"${estudiantes(m)} -> ${notas(m)} -> ${clasificacion(notas(m))}")
    m += 1
  }

  // SEGUNDA EVALUACION

  val notasSegundaEvaluacion = Array(
    9,
    5,
    8,
    7,
    6
  )

  println("=== SEGUNDA EVALUACION ===")
  var j = 0
  while (j < notasSegundaEvaluacion.length) {
    println(s"${estudiantes(j)} -> ${notasSegundaEvaluacion(j)} -> ${estadoNota(notasSegundaEvaluacion(j))}")
    j += 1
  }

  var aprobados2 = 0
  var suspensos2 = 0
  var mejorNota2 = 0

  var l = 0
  while (l < notasSegundaEvaluacion.length) {
    if (aprobado(notasSegundaEvaluacion(l))) {
      aprobados2 += 1
    } else {
      suspensos2 += 1
    }
    mejorNota2 = maxNota(mejorNota2, notasSegundaEvaluacion(l))
    l += 1
  }

  println("--- Resumen segunda evaluacion ---")
  println(s"Estudiantes: ${estudiantes.length}")
  println(s"Aprobados: $aprobados2")
  println(s"Suspensos: $suspensos2")
  println(s"Mejor nota: $mejorNota2")

  // COMPARACION DE EVALUACIONES

  println("=== COMPARACION DE EVALUACIONES ===")
  println(s"Mejor nota de la primera evaluacion: $mejorNota1")
  println(s"Mejor nota de la segunda evaluacion: $mejorNota2")
  println(s"Numero de aprobados de la primera: $aprobados1")
  println(s"Numero de aprobados de la segunda: $aprobados2")

  if (aprobados2 > aprobados1) {
    println("Resultado: El grupo ha mejorado.")
  } else if (aprobados2 < aprobados1) {
    println("Resultado: El grupo ha empeorado.")
  } else {
    println("Resultado: El grupo se ha mantenido igual.")
  }

  // USO DE LISTAS

  println("=== USO DE LISTAS ===")
  val nuevosEstudiantes = "Carlos" :: estudiantes

  println(s"Lista original: $estudiantes")
  println(s"Lista nueva: $nuevosEstudiantes")
}