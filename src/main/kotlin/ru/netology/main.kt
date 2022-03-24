package ru.netology

const val POSTTYPEPOST = "post"

fun main() {
    val service = WallService.add(
        Post(
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "my first post"
        )
    )
    println(service)
    WallService.add(
        Post(
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "my second post"
        )
    )
    WallService.add(
        Post(
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "my third post"
        )
    )
    WallService.add(
        Post(
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "my fourth post"
        )
    )
    WallService.updatePost(
        Post(
            id = 2,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "post with id=2 updated"
        )
    )
    println(WallService.outWall())

}

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int = 0,
    val date: Int,
    val text: String,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendOnly: Boolean = false,
    val comments: Comments = Comments(0, true, true, true, true),
    val copyright: String = "@aloytech",
    val likes: Likes = Likes(0, true, true, true),
    val reposts: Reposts = Reposts(0, false),
    val views: Views = Views(0),
    val postType: String = POSTTYPEPOST
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

data class Views(
    val count: Int
)

object WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        val maxId = findMaxId()
        val countedPost = post.copy(id = maxId + 1)
        posts += countedPost
        return posts.last()
    }

    fun updatePost(post: Post): Boolean {
        var exist = false
        for ((index, existPost) in posts.withIndex()) {
            if (existPost.id == post.id) {
                val updatedPost = post.copy(date = existPost.date, ownerId = existPost.ownerId)
                posts[index] = updatedPost
                exist = true
            }
        }
        return exist
    }

    fun findMaxId(): Int {
        var maxId = 0
        for (post in posts) {
            if (post.id > maxId) {
                maxId = post.id
            }
        }
        return maxId
    }

    fun outWall(): String {
        var outString: String = ""
        for (post in posts) {
            outString = outString + "\n" + post.id + " " + post.text
        }
        return outString
    }

    fun clearWall() {
        posts = emptyArray<Post>()
    }
}