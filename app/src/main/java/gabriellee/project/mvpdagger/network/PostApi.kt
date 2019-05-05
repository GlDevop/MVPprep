package gabriellee.project.mvpdagger.network

import gabriellee.project.mvpdagger.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

}