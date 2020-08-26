package cl.desafiolatam.restapidesafio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var pojoLista = ArrayList<PojoLista>()
    private lateinit var userAdapter : RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       userAdapter = UserAdapter(pojoLista)
        listRecyclerView.adapter = userAdapter
        loadApiData()
    }

    private fun loadApiData() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getLista()
        call.enqueue(object : retrofit2.Callback<List<PojoLista>> {

            override fun onResponse(
                call: Call<List<PojoLista>>,
                response: Response<List<PojoLista>>
            ) {
                response.body()?.map {
                        pojoLista.add(it)
                }
                userAdapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<PojoLista>>, t: Throwable) {
                Log.d("Main", "Error: " + t)
                Toast.makeText(
                    applicationContext, "Error : no pudimos recuperar los posts desde la Api",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        )
    }
}