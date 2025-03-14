package com.example.travelplanner.domain
//
data class  Preferences(
    var userId: User,
    var notificationsEnabled: Boolean,
    var preferredLanguage: String, //var por que se toca el valor
    var theme: String //var por que se toca el valor
)
{ //Funciones de la clase
    fun updatePreferences(newTheme: String, newLanguage: String, newNotificationsEnabled: Boolean) {
        this.theme = newTheme
        this.preferredLanguage = newLanguage
        this.notificationsEnabled = newNotificationsEnabled
    }
}