package arce.jesus.popcorn_189029

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_description.*

class movieDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_description)

        val bundle= intent.extras
        var numberSeats= 0
        var id= -1
        var title="none"
        if(bundle!=null){
            title= bundle.getString("title")!!
            numberSeats=bundle.getInt("numberOfSeats")
            iv_imgMovie.setImageResource(bundle.getInt("header"))
            tv_movieTitle.setText(bundle.getString("title"))
            tv_movieDescription.setText(bundle.getString("description"))
            seatLeft.setText("$numberSeats seats available ")
            id=bundle.getInt("pos")
        }

        if(numberSeats==0){
            btnBuyTickets.isEnabled=false
        }else{
            btnBuyTickets.isEnabled=true
            btnBuyTickets.setOnClickListener {
                val intent: Intent = Intent(this,SeatSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("tamanio",numberSeats)
                intent.putExtra("title",title)
                this.startActivity(intent)
            }
        }

    }
}