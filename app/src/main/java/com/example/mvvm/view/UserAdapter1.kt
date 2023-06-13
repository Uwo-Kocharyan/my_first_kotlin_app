import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.User
import com.example.mykotlinapp.R
import com.example.mykotlinapp.databinding.ItemPokemonBinding

class UserAdapter1 : RecyclerView.Adapter<UserAdapter1.UserHolder>() {

    var users: List<User> = listOf()

    class UserHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonBinding.inflate(inflater, parent, false)
        return UserHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: UserAdapter1.UserHolder, position: Int) {
        val user = users[position]
        viewHolder.binding.nameTextView.text = user.name
        val avatar: Int = if (position % 2 == 1) R.drawable.avatar else R.drawable.avatar_male
        viewHolder.binding.apply {
            iconView.setImageDrawable(
                ContextCompat.getDrawable(viewHolder.binding.itemPokemon.context, avatar)
            )
        }
    }

    override fun getItemCount() = users.size

    fun refreshUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}
