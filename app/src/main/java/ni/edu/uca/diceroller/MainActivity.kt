package ni.edu.uca.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            val toast = Toast.makeText(this, "Tirado", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun rollDice() {
        // Dandole el numero de lados al dado
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Mostrando en pantalla
        val resultado : TextView = findViewById(R.id.tvNum)
        resultado.text = diceRoll.toString()
        val diceImage: ImageView = findViewById(R.id.imageView3)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }

}
class Dice(val numLados: Int){
    fun roll(): Int {
        return (1..numLados).random()
    }
}