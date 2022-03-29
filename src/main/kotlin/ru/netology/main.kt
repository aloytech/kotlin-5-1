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
    WallService.repost(
        Post(
            id = 3,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "my third post"
        )
    )
    WallService.repost(
        Post(
            id = 10,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "my 10th post"
        )
    )
    println(WallService.outWall())

}




