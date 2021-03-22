package arce.jesus.popcorn_189029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.revervation.*

class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.revervation)
        val bundle= intent.extras
        if (bundle!=null){
            tv_asiento_reservation.setText("Your seat is: "+bundle.getInt("seat"))
            tv_pelicula_reservation.setText("Your movie is: "+bundle.getString("movie"))
            tv_nombre_reservation.setText(bundle.getString("name"))
        }
    }
}