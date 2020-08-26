package cl.desafiolatam.restapidesafio

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_list.view.*

class UserAdapter(private val myDataset: List<PojoLista>) :
    RecyclerView.Adapter<UserAdapter.UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: UserAdapter.UsersViewHolder, position: Int) {
        val pojoLista = myDataset[position]
        Log.d("variables","${pojoLista}")
        holder.nombre.text = pojoLista.name
        holder.eMail.text = pojoLista.email
        holder.phone.text = pojoLista.phone
        //holder.id.++++ = pojoLista.id.toString()

    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id : Int = itemView.id
        val nombre: TextView = itemView.tvNombre
        val eMail: TextView = itemView.tvMail
        val phone: TextView = itemView.tvPhone
    }
}