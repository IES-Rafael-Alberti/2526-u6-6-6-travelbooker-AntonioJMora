package org.practicatrim2.dominio

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

abstract class Reserva(var descripcion: String) {
    init {
        require(descripcion.isNotBlank()){"La descripción no puede estar vacía"}
    }
    companion object{
        //Esta variable está hecha para que se cree el ID, sumándole 1 cuando se cree
        private var contadorID = 0
    }

    val id: Int = contadorID++

    //Variable creada para formatear la fecha
    val formatear = DateTimeFormatter.ofPattern(
        "dd 'de' MMMM 'de' yyyy HH:mm", Locale.forLanguageTag("es-ES"))

    val fechaCreacion: LocalDateTime = LocalDateTime.now()

    //funcion que formatea las fechas para que al mostrarlas al usuario se muestren de manera entendible
    fun fechaFormateada():String{
        return formatear.format(fechaCreacion.toLocalDate())
    }

    open val detalle: String
        get() = "ID: $id - $descripcion"
}