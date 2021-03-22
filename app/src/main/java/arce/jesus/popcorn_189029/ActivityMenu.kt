package arce.jesus.popcorn_189029

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.movie.view.*
import kotlin.random.Random

class ActivityMenu : AppCompatActivity() {
    var adapter: MovieAdapter?=null
    var adapterSeries: MovieAdapter?=null
    var movies= ArrayList<Movie>()
    var series= ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        loadMovies()
        adapter= MovieAdapter(this, movies)
        gvPeliculas.adapter=adapter

    }

    fun loadMovies(){
        movies.add(Movie("Big Hero 6", R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called", arrayListOf<Cliente>()))
        movies.add(Movie("Leap year", R.drawable.leapyear, R.drawable.leapyearheader,"A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback  when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged.", arrayListOf<Cliente>()))
        movies.add(Movie("Men in Black", R.drawable.mib, R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency&#39;s finest men only going by the name &quot;K&quot; (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the &quot;Bug&quot; race. He takes the body of a farmer (Vincent D&#39;Onofrio) and heads to New York.", arrayListOf<Cliente>()))
        movies.add(Movie("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the &#39;secret life of toys&#39; when people are not around. When Buzz Lightyear, a space-ranger, takes Woody&#39;s place as Andy&#39;s favorite toy, Woody doesn&#39;t like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home.", arrayListOf<Cliente>()))
        movies.add(Movie("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb&#39;s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. ", arrayListOf<Cliente>()))
    }



    class MovieAdapter: BaseAdapter {
        var movies = ArrayList<Movie>()
        var context: Context? = null

        constructor(context: Context, movies:ArrayList<Movie>){
            this.context=context
            this.movies=movies
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var movie = movies[position]
            var inflador =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view = inflador.inflate(R.layout.movie, null)
            view.iv_movie.setImageResource(movie.image)
            view.tv_movieTittle.setText(movie.title)
            var numberSeats= -1
            view.iv_movie.setOnClickListener {
                numberSeats=getValueSeats()
                var intent = Intent(context, movieDescription::class.java)
                intent.putExtra("title", movie.title)
                intent.putExtra("image", movie.image)
                intent.putExtra("header", movie.header)
                intent.putExtra("description", movie.description)
                intent.putExtra("numberOfSeats",(20-numberSeats))
                intent.putExtra("pos",position)
                context!!.startActivity(intent)
            }
            return view
        }
        fun getValueSeats(): Int{
            val random= java.util.Random()
            return random.nextInt(21)
        }
        override fun getItem(position: Int): Any {
            return movies[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return movies.size
        }

    }
}