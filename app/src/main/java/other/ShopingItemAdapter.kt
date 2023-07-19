package other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hoppingkotlin.R
import com.example.hoppingkotlin.data.entities.ShoppingItem
import com.example.hoppingkotlin.repository.shoppinglist.ShoppingViewModel

class ShopingItemAdapter(
    var items: List<ShoppingItem>,
    val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShopingItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.shopping_item, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.tvName.text = curShoppingItem.name
        holder.tvAmount.text = "${curShoppingItem.amount}"
        holder.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }
        holder.ivMinus.setOnClickListener {
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }
        holder.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAmount: TextView = view.findViewById(R.id.tvAmount)
        val ivDelete: TextView = view.findViewById(R.id.ivDelet)
        val ivMinus: TextView = view.findViewById(R.id.ivMinus)
        val ivPlus: TextView = view.findViewById(R.id.ivPlus)
    }
}