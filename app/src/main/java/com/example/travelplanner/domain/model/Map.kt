package com.example.travelplanner.domain.model

data class Map(
    val id: String,
    var latitud: Double,
    var longitud: Double,
    var direction: String,
)
{
    fun showLocation(): String {
        return "Latitud: $latitud, Longitud: $longitud, Dirección: $direction"
        // @TODO Implementar la funcionalidad de mostrar la ubicación
        // @TODO Con la funcionalidad a partir de la latitud y longitud o dirección
    }
    fun getNearbyPlaces(): String {
        return "Lugares cercanos a la ubicación"
        // @TODO Implementar la funcionalidad de busqueda de GPS
    }
}

