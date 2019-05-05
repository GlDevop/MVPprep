package gabriellee.project.mvpdagger.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gabriellee.project.mvpdagger.R
import gabriellee.project.mvpdagger.databinding.ItemPostBinding
import gabriellee.project.mvpdagger.model.Post

class PostAdapter(private val context: Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts: List<Post> = listOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemPostBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, p0, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        p0.bind(posts[p1])
    }

    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */
    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Post item
     */
    class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a post into the view
         */
        fun bind(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }
}