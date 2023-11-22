package com.example.navigationexample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationexample.DetailScreen
import com.example.navigationexample.HomeScreen
import com.example.navigationexample.Screens

@Composable
fun Navigation() {
    // Once builde gradele ekleme yapcam.
    // Navigasyon islemlerini burada yonetecegim.
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route){
//        route = "Home Screen" yazmak yerine Sealed class olusrturdum

        composable(route = Screens.HomeScreen.route){
            // burda home screen'e gitcem. Ama home screen'den baska bir ekrana gitmek icin yine navcontroller'a ihtiyacim var
            // bu yuzden burdan oraya parametre olarak gectim.
           HomeScreen(navController=navController)
        }

        // Burda composable'in arguman alabilecegini belirtmedim ben. Home screen'de
        // navController.navigate yaptigim zaman soyle yapiyorum
        // navController.navigate( route ismini de buraya yaziyorum. Yani burdaki route ismini)
        // yani soyle:
        // navController.navigate(route=Screens.DetailScreen.route). burdaki route bir arguman almiyor
        // Burdaki route'in bir arguman almasi gerekiyor ki bende HomeScreen sayfasinda onu cagirdigim
        // zaman onun istedigi argumani vereyim. Dolayisiyle burdaki route'da degisiklik yapcam.
        // bu route cagirildigi yerde bir arguman girilmesi gerektigini de ekliycem.
        // ilk hali boyleydi: composable(route=Screens.DetailScreen.route,Degistirdim. argument de
//        alabilecek sekle getirdim.Ozetle bu route'i arguman alabilir hale getirdim.
        composable(route=Screens.DetailScreen.route+"/{mySurname}",
            arguments = listOf(navArgument("mySurname"){
                type= NavType.StringType
                nullable=true
                defaultValue="Defualt value"
            })
        ){entry->
            // burda da DetailScreen'e gitcem. Ama burda argument gonderme var.
           val surname=entry.arguments?.getString("mySurname")
            DetailScreen(surname = surname)
        }
        // Buraya kadar her sey tamam. Peki biz argumani nasil verecegiz.Yani HomeScreen'de
    // navController.navigate yapan buton argumani ona verebilmek icin route'in da arguman
    // alabiliyor olmasi lazim. Cunku orda biz route'i cagiriyoruz, Simdi yukardakini oku.

    }
}

