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
            text = "my fourth post",
            attachments = arrayOf(Audio(id = 1), Video(id = 2), Photo(id = 3))
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
    println()
    val attachments = WallService.getAttachments(
        Post(
            id = 4,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis().toInt(),
            text = "my 10th post"
        )
    )
    if (attachments != null) {
        for (attachment in attachments) {
            if (attachment is Photo) {
                attachment.resize("800x600")
            }
            attachment.outputAccordingType()
        }
    }
}




