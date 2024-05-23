package com.example.tictactoefinalproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var currentMove = "X"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun changeCurrentMove(){
        if(currentMove == "X"){
            currentMove = "O"
        } else{
            currentMove = "X"
        }
    }

    private fun handleMove(){
        val win: Boolean = checkForWin()
        if(win){
            handleWin()
        }
        changeCurrentMove()
    }

    private fun checkForWin(): Boolean {
        var textArray: Array<CharSequence> = arrayOf(
            findViewById<Button>(R.id.button4).text,
            findViewById<Button>(R.id.button3).text,
            findViewById<Button>(R.id.button5).text,
            findViewById<Button>(R.id.button7).text,
            findViewById<Button>(R.id.button6).text,
            findViewById<Button>(R.id.button8).text,
            findViewById<Button>(R.id.button10).text,
            findViewById<Button>(R.id.button9).text,
            findViewById<Button>(R.id.button11).text
        )


        return checkRowForWin(textArray) || checkColForWin(textArray) || checkLeftDiagForWin(textArray) || checkRightDiagForWin(textArray)

    }

    private fun checkRightDiagForWin(textArray: Array<CharSequence>): Boolean {
            return  textArray[2] == textArray[4] && textArray[4] == textArray[6] && textArray[6] != ""

    }

    private fun checkLeftDiagForWin(textArray: Array<CharSequence>): Boolean {
            return textArray[0] == textArray[4] && textArray[4] == textArray[8] && textArray[8] != ""
    }

    private fun checkColForWin(textArray: Array<CharSequence>): Boolean {
        for (col in 0..2){
            if (textArray[3 * col + 0] == textArray[3 * col +1] && textArray[3 * col + 1] == textArray[3 * col + 2]){
                return true
            }
        }
        return false
    }

    private fun checkRowForWin(textArray: Array<CharSequence>): Boolean {
        for (row in 0..2){
           if( textArray[3 * row + 0] == textArray[3 * row + 1] && textArray[3 * row + 1] == textArray[3 * row + 2]){
               return true
           }
        }
        return false
    }

    private fun handleWin() {
        var winLoseText: TextView = findViewById(R.id.winLose)
    }

    fun topLeftClick(view: View) {
        val button: Button = findViewById(R.id.button4)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }

    fun bottomRightClick(view: View) {
        val button: Button = findViewById(R.id.button11)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
    fun bottomLeftClick(view: View) {
        val button: Button = findViewById(R.id.button10)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
    fun bottomMiddleClick(view: View) {
        val button: Button = findViewById(R.id.button9)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
    fun midRightClick(view: View) {
        val button: Button = findViewById(R.id.button8)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
    fun midLeftClick(view: View) {
        val button: Button = findViewById(R.id.button7)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
    fun midMiddleClick(view: View) {
        val button: Button = findViewById(R.id.button6)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
    fun topRightClick(view: View) {
        val button: Button = findViewById(R.id.button5)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
    fun topMiddleClick(view: View) {
        val button: Button = findViewById(R.id.button3)
        if (button.text.equals("")){
            button.text = currentMove
            changeCurrentMove()
        }
    }
}