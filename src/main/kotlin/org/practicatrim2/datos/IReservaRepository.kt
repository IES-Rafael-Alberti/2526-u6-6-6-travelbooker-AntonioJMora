package org.practicatrim2.datos

import org.practicatrim2.dominio.Reserva

interface IReservaRepository {
    fun guardar(reserva: Reserva)

    fun obtenerTodas(): List<Reserva>
}