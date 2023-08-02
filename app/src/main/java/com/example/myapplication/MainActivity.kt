package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.Logger
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.patterns.creational.MySingleton
import com.example.patterns.creational.ShapeFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var logger: Logger

    // Create a ShapeFacade instance
    private val shapeFacade = ShapeFacade()



    override fun onCreate(savedInstanceState: Bundle?) {


        // Perform the shape operations using the ShapeFacade
        shapeFacade.drawCircle()
        shapeFacade.drawRectangle()

        val circle = ShapeFactory.createShape("circle")
        circle?.draw()

        val rectangle = ShapeFactory.createShape("rectangle")
        rectangle?.draw()

        super.onCreate(savedInstanceState)



        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        // Logging a message from MainActivity
        logger.log("Logging a message from MainActivity.")

        //using singleton
        MySingleton.myMethod()

        // Show the sandwich dialog when MainActivity is created
        showSandwichDialog(this)
    }

    fun showSandwichDialog(context: Context) {
        AlertDialog.Builder(context)
            .setTitle("Sandwich Dialog")
            .setMessage("Please use the spicy mustard.")
            .setNegativeButton("No thanks") { dialogInterface, i ->
                // "No thanks" action
                // You can add your custom code here when the "No thanks" button is clicked.
            }
            .setPositiveButton("OK") { dialogInterface, i ->
                // "OK" action
                // You can add your custom code here when the "OK" button is clicked.
            }
            .show()
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

class ShapeFacade {
    private val shapeFactory = ShapeFactory()

    fun drawCircle() {
        val circle = shapeFactory.createShape("circle")
        circle?.draw()
    }

    fun drawRectangle() {
        val rectangle = shapeFactory.createShape("rectangle")
        rectangle?.draw()
    }
}