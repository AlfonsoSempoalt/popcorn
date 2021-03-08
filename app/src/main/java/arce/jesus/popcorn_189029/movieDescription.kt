package arce.jesus.popcorn_189029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_description.*

class movieDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_description)

        val bundle= intent.extras

        if(bundle!=null){
            iv_imgMovie.setImageResource(bundle.getInt("header"))
            tv_movieTitle.setText(bundle.getString("title"))
            tv_movieDescription.setText(bundle.getString("description"))
        }
    }
}