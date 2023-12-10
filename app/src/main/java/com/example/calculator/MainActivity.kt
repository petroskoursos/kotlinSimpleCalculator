package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    calculator()
                }
            }
        }
    }
}

@Composable
fun calculator()
{
    var firstNum by remember { mutableStateOf("") }
    var secondNum by remember{ mutableStateOf("") }
    var action by remember{ mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var isFirstNum by remember { mutableStateOf(false) }
    var isClear by remember { mutableStateOf(true) }

    fun result()
    {
        if(action=="+"){
            val num1= firstNum.toInt()
            val num2=secondNum.toInt()
            val result=num1+num2
            outputValue=result.toString()
            isFirstNum=false
            isClear=false
        }
        else if(action=="*")
        {
            val num1= firstNum.toInt()
            val num2=secondNum.toInt()
            val result=num1*num2
            outputValue=result.toString()
            isFirstNum=false
            isClear=false
        }
        else if(action=="-")
        {
            val num1= firstNum.toInt()
            val num2=secondNum.toInt()
            val result=num1-num2
            outputValue=result.toString()
            isFirstNum=false
            isClear=false
        }
        else if(action=="/")
        {
            val num1= firstNum.toDouble()
            val num2=secondNum.toDouble()
            val result=num1/num2
            outputValue=result.toString()
            isFirstNum=false
            isClear=false
        }



    }
    fun clear()
    {
        isClear=true
        firstNum=""
        secondNum=""
        action=""
        outputValue=""
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        OutlinedTextField(value = "$firstNum $action $secondNum = $outputValue", onValueChange = {})

        Spacer(modifier = Modifier.height(30.dp))
        Row (
        //////// backspace////////////////
        ) {
            Button(onClick = {
                if(isClear)
                {
                    if(!isFirstNum && firstNum.isNotEmpty())
                    {
                        firstNum=firstNum.dropLast(1)
                    }
                    else if(secondNum.isNotEmpty())
                        secondNum=secondNum.dropLast(1)
                }
            }) {

                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        }
        //first Row
        Row {
            Button(onClick = {
                if(isClear)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="7"
                    }
                    else
                        secondNum+="7"
                }

            }) {
                Text(text = "7")



            }
            ////////////////number 8/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="8"
                    }
                    else
                        secondNum+="8"
                }
            }) {
                Text(text = "8")
            }
            ////////////////number 9/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="9"
                    }
                    else
                        secondNum+="9"
                }
            }) {
                Text(text = "9")
            }
            Spacer(modifier = Modifier.width(20.dp))
            ///////////////////////////// action "/" ////////////////////////
            Button(onClick = {
                isFirstNum=true
                action="/"
            }) {
                Text(text = "/")
            }
            ////////////////////////action '-' ////////////////////////////////
            Button(onClick = {
                isFirstNum=true
                action="-"
            }) {
                Text(text = "-")
            }
        }
        //second row
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            ////////////////number 4/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="4"
                    }
                    else
                        secondNum+="4"
                }
            }) {
                Text(text = "4")

            }
            ////////////////number 5/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="5"
                    }
                    else
                        secondNum+="5"
                }
            }) {
                Text(text = "5")
            }
            ////////////////number 6/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="6"
                    }
                    else
                        secondNum+="6"
                }
            }) {
                Text(text = "6")
            }
            Spacer(modifier = Modifier.width(20.dp))
            ///////////////////// action '*' ////////////////////////
            Button(onClick = {
                isFirstNum=true
                action="*"
            }) {
                Text(text = "*")
            }
            ////////////////////////// action '+'//////////////////
            Button(onClick = {
                isFirstNum=true
                action="+"

            }) {
                Text(text = "+")
            }
        }
        //third row
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            ////////////////number 1/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="1"
                    }
                    else
                        secondNum+="1"
                }
            }) {
                Text(text = "1")

            }
            ////////////////number 2/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="2"
                    }
                    else
                        secondNum+="2"
                }
            }) {
                Text(text = "2")
            }
            ////////////////number 3/////////////////////
            Button(onClick = {
                if(isClear==true)
                {
                    if(isFirstNum==false )
                    {
                        firstNum+="3"
                    }
                    else
                        secondNum+="3"
                }
            }) {
                Text(text = "3")
            }
            Spacer(modifier = Modifier.width(5.dp))
            ////////////////////////// clear/////////////////////////
            Button(onClick = {
                clear()
            }) {
                Text(text = "clear")
            }
            /////////////////////////// result///////////////////////////
            Button(onClick = {
                result()
            }) {
                Text(text = "=")
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun calculatorPreview()
{
    calculator()
}