package com.example.talha.tictactoedemo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity:AppCompatActivity() {

    lateinit var testBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

//        var btn1 = findViewById<ImageButton>(R.id.btn_1)
//        var btn2 = findViewById<ImageButton>(R.id.btn_2)
//        var btn3 = findViewById<ImageButton>(R.id.btn_3)
//        var btn4 = findViewById<ImageButton>(R.id.btn_4)
//        var btn5 = findViewById<ImageButton>(R.id.btn_5)
//        var btn6 = findViewById<ImageButton>(R.id.btn_6)
//        var btn7 = findViewById<ImageButton>(R.id.btn_7)
//        var btn8 = findViewById<ImageButton>(R.id.btn_8)
//        var btn9 = findViewById<ImageButton>(R.id.btn_9)

    }

    protected fun clickMethod(view:View){
        val btnSelected:Button = view as Button
        var cellId=0
        try {
            when(btnSelected.id){
                R.id.btn1 -> {
                    cellId=1
                //    btnSelected.setText("X")
                }
                R.id.btn2 -> {
                    cellId=2
                  //  btnSelected.setText("O")
                }
                R.id.btn3 -> cellId=3
                R.id.btn4 -> cellId=4
                R.id.btn5 -> cellId=5
                R.id.btn6 -> cellId=6
                R.id.btn7 -> cellId=7
                R.id.btn8 -> cellId=8
                R.id.btn9 -> cellId=9
            }
//            if (cellId%2==0){
//                btnSelected.setText("0")
//            }else{
//                btnSelected.setText("X")
//            }

          //  Toast.makeText(this@MainActivity,"Id:"+cellId,Toast.LENGTH_SHORT).show()
        }catch (e:Exception){
           // Toast.makeText(this@MainActivity,e.toString(),Toast.LENGTH_SHORT).show()
        }

        playGame(cellId,btnSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(cellId:Int,btnSelected:Button){
        var winner = -1
        if (activePlayer==1){
            btnSelected.setText("X")
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        }else{
            btnSelected.setText("O")
            btnSelected.setBackgroundColor(Color.YELLOW)
            player2.add(cellId)
            activePlayer = 1
        }

        btnSelected.isEnabled = false

       if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
           winner = 1
           //Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
       }else if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
           winner = 1
           //Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
       }else if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
           winner = 1
           //Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
       }else if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
           winner = 1
           //Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
       }else if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
           winner = 1
           //Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
       }else if (player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
           winner = 1
           //Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
       }else if (player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
           winner = 1
           //Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
       }

        if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner = 2
            //Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
        }else if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner = 2
            //Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
        }else if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner = 2
            //Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
        }else if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner = 2
            //Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
        }else if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner = 2
            //Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
        }else if (player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner = 2
            //Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
        }else if (player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner = 2
            //Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
        }

        if (winner!=-1){
            if (winner == 1){
                Toast.makeText(this,"Player1 wins",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Player2 wins",Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun autoPlay(){
        var emptyCell = ArrayList<Int>()
        for (cellId in 1..9){
            if (!(player1.contains(cellId)|| player2.contains(cellId))){
                emptyCell.add(cellId)
            }
        }
        var random = Random()
        var randomIndex = random.nextInt(emptyCell.size-0)+0
        val cellId = emptyCell.get(randomIndex)
        var btnSelect:Button?
        when(cellId){
            1-> btnSelect = btn1
            2-> btnSelect = btn2
            3-> btnSelect = btn3
            4-> btnSelect = btn4
            5-> btnSelect = btn5
            6-> btnSelect = btn6
            7-> btnSelect = btn7
            8-> btnSelect = btn8
            9-> btnSelect = btn9
            else ->{
                btnSelect = btn1
            }

        }
        playGame(cellId,btnSelect)
    }


}