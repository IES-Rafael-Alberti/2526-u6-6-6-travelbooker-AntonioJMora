package org.practicatrim2.dominio

class ReservaHotel private constructor(descripcion: String, val ubicacion : String, val numeroNoches : Int) : Reserva(descripcion){
    init {
        //Require hecho para que el número de noches deba de ser mayor a 0 si o si
        require(numeroNoches > 0) { "El número de noches debe ser mayor a 0" }
    }

    override val detalle: String
        get() = "$id - $descripcion - $ubicacion ($numeroNoches)"

    companion object{
        //Función creada para poder hacer la reserva del hotel
        fun creaInstancia(descripcion: String, ubicacion: String, numeroNoches: Int): ReservaHotel {
            require(ubicacion.isNotBlank()){"La ubicacion no puede estar vacia"}
            return ReservaHotel(descripcion, ubicacion, numeroNoches)
        }
    }

    override fun toString(): String{
        return """
            Reserva de Hotel:
            ID: $id
            Descripcion: $descripcion
            Ubicacion: $ubicacion
            Numero de noches: $numeroNoches
            Fecha de reserva: ${fechaFormateada()}
        """.trimIndent()
    }
}