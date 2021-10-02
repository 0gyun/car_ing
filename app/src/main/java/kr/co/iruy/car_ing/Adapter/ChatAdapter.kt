package kr.co.iruy.car_ing.Adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.co.iruy.car_ing.ChatModel
import kr.co.iruy.car_ing.R

class ChatAdapter(val context: Context, val arrayList: ArrayList<ChatModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    internal lateinit var preferences: SharedPreferences
    fun addItem(item: ChatModel){
        if(arrayList != null){
            arrayList.add(item)
        }
    }
    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):
            RecyclerView.ViewHolder{
        val view: View
        if(viewType == 1){
            view = LayoutInflater.from(context).inflate(R.layout.item_my_chat,parent,false)
            return Holder(view)
        }
        else{
            view = LayoutInflater.from(context).inflate(R.layout.item_your_chat,parent,false)
            return Holder2(view)
        }
    }
    override fun getItemCount(): Int{
        return arrayList.size
    }
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder,i:Int){
        if(viewHolder is Holder){
            (viewHolder as Holder).chat_Text?.setText(arrayList.get(i).script)
            (viewHolder as Holder).chat_Time?.setText(arrayList.get(i).date_time)
        }
        else if (viewHolder is Holder2){
            (viewHolder as Holder2).chat_You_Image?.setImageResource(R.mipmap.ic_launcher)
            (viewHolder as Holder2).chat_You_Name?.setText(arrayList.get(i).name)
            (viewHolder as Holder2).chat_Text?.setText(arrayList.get(i).script)
            (viewHolder as Holder2).chat_Time?.setText(arrayList.get(i).date_time)
        }
    }
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //친구목록 모델의 변수들 정의하는부분
        val chat_Text = itemView?.findViewById<TextView>(R.id.chat_Text)
        val chat_Time = itemView?.findViewById<TextView>(R.id.chat_Time)
    }
    inner class Holder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //친구목록 모델의 변수들 정의하는부분
        val chat_You_Image = itemView?.findViewById<ImageView>(R.id.chat_You_Image)
        val chat_You_Name = itemView?.findViewById<TextView>(R.id.chat_You_Name)
        val chat_Text = itemView?.findViewById<TextView>(R.id.chat_Text)
        val chat_Time = itemView?.findViewById<TextView>(R.id.chat_Time)
    }
    override fun getItemViewType(position: Int): Int {//여기서 뷰타입을 1, 2로 바꿔서 지정해줘야 내채팅 너채팅을 바꾸면서 쌓을 수 있음
        preferences = context.getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)

        //내 아이디와 arraylist의 name이 같다면 내꺼 아니면 상대꺼
        return if (arrayList.get(position).name == preferences.getString("name","")) {
            1
        } else {
            2
        }
    }
}