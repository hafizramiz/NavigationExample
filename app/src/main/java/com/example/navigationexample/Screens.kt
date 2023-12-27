package com.example.navigationexample

sealed class Screens(val route:String) {
    // vararg birden fazla ayni tipte nesneyi almak icin kullanilir. varaargs
    // yaparsam bir liste vercek bana
//    fun withArgs(  vararg args:String):String{
//        return route +"/{${args[0]}}"
//        // Burasi artik composable'da yazdigim vardi ya
//    // route=Screens.DetailScreen.route+"/{mySurname}", bunu donuyor artik. Bunu yazmadan yapcam
//        // yani artik.
//    }
    fun withArg(name:String):String{
        // ikinci paramter eklemek istersem
        return route+"/$name"
    }
    object HomeScreen:Screens("HomeScreen")
    object DetailScreen:Screens("DetailScreen")
}

fun main() {
    val nesne=Screens.DetailScreen.route+"/{mySurname}"
    println("nesne: $nesne")
    println("result: ${Screens.HomeScreen.withArg("surname")}")

    val anasayfa:String=Ekranlar.Anasayfa.route
    println("ekran:${anasayfa}")

}

// Navigation bolumunde bunu bu sekilde
// composable(route=Screens.DetailScreen.route+"/{mySurname}", yazmak yerine daha da kullanisli hale
//getircem. Bunu da withArgs ile yapcam.


sealed class Ekranlar(val route: String){
    object Anasayfa:Ekranlar("Anasayfa")
    object DetaySayfa:Ekranlar(route = "DetaySayfa")
}

