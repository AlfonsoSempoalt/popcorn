package arce.jesus.popcorn_189029

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seat_selection.*
import java.util.*
import kotlin.collections.ArrayList

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)
        val bundle= intent.extras
        var posMovie= -1
        var title=""
        if (bundle!=null){
            title= bundle.getString("title")!!
            titleSeat.setText(title)
            posMovie= bundle.getInt("id")
            disableButtons(bundle.getInt("tamanio"))
        }

        btnConfirm.setOnClickListener {
            val cliente = Cliente (
                tipoPago = "Efectivo",
                nombre = "Alfonso",
                asiento = seatSelection(),
                pelicula = title
            )
            val intent: Intent = Intent(this,ReservationActivity::class.java)
            intent.putExtra("name",cliente.nombre)
            intent.putExtra("seat",cliente.asiento)
            intent.putExtra("movie",cliente.pelicula)
            this.startActivity(intent)
          //  Toast.makeText(this,cliente.toString(),Toast.LENGTH_SHORT).show()
        }

        row1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row1.check(checkedId)
            }
        }
        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
            }
        }
        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
            }
        }
        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                row4.check(checkedId)
            }
        }

    }

    private fun seatSelection():Int{
        var seat=-1
        for (i in 0 until 20){
            var radioId:String="radio"+(i+1)
            var resID:Int=resources.getIdentifier(radioId,"id",packageName)
            var radio:RadioButton= findViewById(resID)
            if (radio.isChecked){
                seat=i+1
                return seat
            }
        }
        return seat
    }

    private fun disableButtons(seatAv:Int){
        var asientos:ArrayList<Int> = ArrayList<Int>()
        for (i in 0 until seatAv){
            asientos.add(1)
        }
        for (i in seatAv until 20){
            asientos.add(0)
        }
        Collections.shuffle(asientos)
        for (i in 0 until 20){
            if (asientos.get(i)==0){
                var radioId:String="radio"+(i+1)
                var resID:Int=resources.getIdentifier(radioId,"id",packageName)
                var radio:RadioButton= findViewById(resID)

                radio.isEnabled=false
            }
        }

    }
}