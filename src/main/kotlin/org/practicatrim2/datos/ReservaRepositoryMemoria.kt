package org.practicatrim2.datos

import org.practicatrim2.dominio.Reserva

class ReservaRepositoryMemoria : IReservaRepository {
    private val reservas: MutableList<Reserva> = mutableListOf()

    override fun guardar(reserva: Reserva) {
        reservas.add(reserva)
    }

    override fun obtenerTodas(): List<Reserva> = reservas.toList()
}