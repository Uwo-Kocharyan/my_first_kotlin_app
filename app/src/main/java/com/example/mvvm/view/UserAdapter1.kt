import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.User
import com.example.mykotlinapp.R
import com.example.mykotlinapp.adapter.UserAdapter
import com.example.mykotlinapp.databinding.ItemPokemonBinding

class UserAdapter1 : RecyclerView.Adapter<UserAdapter1.UserHolder>() {

    private var users: List<User> = ArrayList()

    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent:  ViewGroup, viewType: Int): UserHolder {
        return UserAdapter1.UserHolder(binding)
    }

    //связывает views с содержимым
    override fun onBindViewHolder(viewHolder: UserHolder, position: Int) {
        viewHolder.bind(users[position])
    }

    override fun getItemCount() = users.size

    //передаем данные и оповещаем адаптер о необходимости обновления списка
    fun refreshUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    class UserHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root){
    //внутренний класс ViewHolder описывает элементы представления списка и привязку их к RecyclerView
        fun bind(user: User) = with(itemView) {
            binding.nameTextView.text = user.name
           // userDescription.text = user.description
        }
    }
}
