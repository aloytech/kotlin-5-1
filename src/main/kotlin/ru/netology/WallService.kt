package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        val currentId: Int = when {
            posts.isEmpty() -> 1
            else -> posts.last().id + 1
        }
        val countedPost = post.copy(id = currentId)
        posts += countedPost
        return posts.last()
    }
    fun repost(post: Post): Boolean {
        var history: Array<Post> = post.copyHistory ?: emptyArray<Post>()
        history += post
        val originalPostCountReposts = post.reposts.count
        val changedPost = post.copy(reposts = Reposts(originalPostCountReposts+1,true))
        if (updatePost(changedPost)){
            val repost = post.copy(copyHistory = history)
            add(repost)
            return true
        } else{
            return false
        }
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


    fun outWall(): String {
        val outString: StringBuilder = java.lang.StringBuilder()

        for (post in posts) {
            val isRepost = when (post.copyHistory) {
                null -> "original"
                else -> "repost"
            }
            outString.append("\n" +
                    post.id + " " + post.text + " reposted:" + post.reposts.count +
                    " " + isRepost)
        }
        return outString.toString()
    }

    fun clearWall() {
        posts = emptyArray<Post>()
    }
}