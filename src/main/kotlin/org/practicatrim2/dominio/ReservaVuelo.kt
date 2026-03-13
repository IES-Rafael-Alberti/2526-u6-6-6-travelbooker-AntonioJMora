package org.practicatrim2.dominio

import java.time.LocalDateTime

class ReservaVuelo private constructor(descripcion: String, val origen: String, val destino: String, val horaVuelo: LocalDateTime): Reserva(descripcion) {

    override val detalle : String
        //horaVuelo usa el formatear para que sea legible para el usuario
        get() = "$id - $descripcion - $origen -> $destino [${horaVuelo.format(formatear)}]"

    companion object {
        //Función creada para que se pueda hacer la reserva de vuelo
        fun creaInstancia(descripcion: String, origen: String, destino: String, horaVuelo: LocalDateTime): ReservaVuelo {
            require(origen.isNotBlank()){"El origen no puede estar vacio"}
            require(destino.isNotBlank()){"El destino no puede estar vacio"}
            return ReservaVuelo(descripcion, origen, destino, horaVuelo)
        }
    }

    override fun toString(): String {
        return """
            Reserva de vuelo:
            ID: $id
            Descripcion: $descripcion
            Origen: $origen
            Destino: $destino
            Hora del vuelo: ${horaVuelo.format(formatear)}
            Fecha de reserva: ${fechaFormateada()}
        """.trimIndent()
    }
}