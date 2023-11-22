package com.example.navigationexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import com.example.navigationexample.navigation.Navigation
import com.example.navigationexample.ui.theme.NavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    Navigation()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
// Burda navController'i paramertre olarak aldim. Cunku bununla baska ekrana gecis yapcam.
fun HomeScreen(navController: NavController) {

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        // BURDA TEXTFIELD'DAN ILE KULLANICIDAN INPUT ALDIM. ONU DA DIGER EKRANA ATTIM.
       var surname by remember {
           mutableStateOf("")
       }
        Text(text = "Home Screen")
        TextField(value = surname, onValueChange = {
            surname=it
        })
        Button(
            onClick = {
                // "${BusScheduleScreens.RouteSchedule.name}/$busStopName"
            //navController.navigate("${Screens.DetailScreen.route}/${surname}")
            navController.navigate("${Screens.DetailScreen.route}/${surname}")
                // BUSEKILDE YAZMAK YERINE SEALED CLASS'I ARGUMAN ALABILIR HALE GETIRCEM.

        }) {
            Text(text = "Go to Detial Screen")
        }
    }
}

@Composable
fun DetailScreen(surname:String?) {
    Column {
        Text(text = "Details Screen")
        Text(text = "Merhaba $surname")
    }
}