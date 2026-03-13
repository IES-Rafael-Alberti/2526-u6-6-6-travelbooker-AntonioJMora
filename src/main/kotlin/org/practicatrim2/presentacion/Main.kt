package org.practicatrim2.presentacion

import org.practicatrim2.servicios.ReservaService
import org.practicatrim2.datos.ReservaRepositoryMemoria
import java.time.LocalDateTime

fun main() {
    val repositorio = ReservaRepositoryMemoria()
    val servicio = ReservaService(repositorio)

    var opcion: Int

    do {
        println(
            """
            ---- MENU ----
            1. Crear reserva de vuelo
            2. Crear reserva de hotel
            3. Listar reservas
            0. Salir
            --------------------------
            Elige una opcion:
        """.trimIndent()
        )

        opcion = try{
            readln().trim().toInt()
        }catch(e: NumberFormatException){
            println("Opcion invalida. Introduce un numero del menu")
            -1
        }

        when (opcion) {

            1 -> {
                //Esta primera opcion es para la reserva de los vuelos
                println("Reserva de vuelo:")
                try {
                    println("Descripcion:")
                    val descripcion = readln()

                    println("Origen:")
                    val origen = readln()

                    println("Destino:")
                    val destino = readln()

                    println("Hora del vuelo (YYYY-MM-DDTHH:MM):")
                    val hora = LocalDateTime.parse(readln())

                    val vuelo = servicio.crearReservaVuelo(descripcion, origen, destino, hora)
                    println("Reserva creada: ${vuelo.detalle}")
                }catch(e: IllegalArgumentException){
                    println("Error de validacion: ${e.message}")
                }catch(e: Exception){
                    println("Error inesperado: ${e.message}")
                }

            }

            2 -> {
                //Esta segunda opcion hace la reserva de los hoteles
                println("Reserva de hotel:")
                try {
                    println("Descripcion:")
                    val descripcion = readln()

                    println("Ubicacion:")
                    val ubicacion = readln()

                    println("Numero de noches:")
                    val noches = readln().toInt()

                    val hotel = servicio.crearReservaHotel(descripcion, ubicacion, noches)
                    println("Reserva creada: ${hotel.detalle}")
                }catch(e: NumberFormatException){
                    println("El numero de noches debe de ser un numero entero")
                }catch(e: IllegalArgumentException){
                    println("Error de validacion: ${e.message}")
                }catch(e: Exception){
                    println("Error inesperado: ${e.message}")
                }

            }

            3 -> {
                //Esta tercera opción lista las reservas hechas por el usuario
                println("---- LISTA DE RESERVAS ----")

                servicio.listarReservas().forEach { println(it.detalle) }
            }
            0 -> println("Servicio terminado")
            else -> if(opcion != -1) println("Opcion invalida, elige entre 0 y 3")

        }
        //El while hace que la aplicacion se mantenga en ejecucion hasta que el usuario decida salir
    } while (opcion != 0)
}