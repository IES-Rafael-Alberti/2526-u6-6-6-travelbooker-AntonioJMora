package org.practicatrim2.servicios

import org.practicatrim2.datos.IReservaRepository
import org.practicatrim2.dominio.Reserva
import org.practicatrim2.dominio.ReservaHotel
import org.practicatrim2.dominio.ReservaVuelo
import java.time.LocalDateTime

class ReservaService(private val repositorio: IReservaRepository) {
    fun crearReservaVuelo(
        descripcion: String,
        origen: String,
        destino: String,
        horaVuelo: LocalDateTime
    ): ReservaVuelo {
        var reserva = ReservaVuelo.creaInstancia(destino, descripcion, origen, horaVuelo)
        repositorio.guardar(reserva)
        return reserva
    }

    fun crearReservaHotel(
        descripcion: String,
        ubicacion: String,
        numeroNoches: Int
    ): ReservaHotel {
        val reserva = ReservaHotel.creaInstancia(descripcion, ubicacion, numeroNoches)
        repositorio.guardar(reserva)
        return reserva
    }

    fun listarReservas(): List<Reserva> = repositorio.obtenerTodas()
}