package ru.netology

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @Before
    fun prepare() {
        WallService.clearWall()
    }


    @Test
    fun addIdChanged() {
        val expectedId = 1
        val service = WallService.add(
            Post(
                ownerId = 1,
                fromId = 1,
                date = System.currentTimeMillis().toInt(),
                text = "my first post"
            )
        )
        assertEquals(expectedId, service.id)
    }
    @Test
    fun repostIdExists() {
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
        val actualResult = WallService.repost(
            Post(
                id = 2,
                ownerId = 1,
                fromId = 1,
                date = System.currentTimeMillis().toInt(),
                text = "post with id=2 updated"
            )
        )
        assertTrue(actualResult)
    }

    @Test
    fun repostIdNotExists() {
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
        val actualResult = WallService.repost(
            Post(
                id = 5,
                ownerId = 1,
                fromId = 1,
                date = System.currentTimeMillis().toInt(),
                text = "post with id=2 updated"
            )
        )
        assertFalse(actualResult)
    }

    @Test
    fun updatePostIdExists() {
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
        val actualResult = WallService.updatePost(
            Post(
                id = 2,
                ownerId = 1,
                fromId = 1,
                date = System.currentTimeMillis().toInt(),
                text = "post with id=2 updated"
            )
        )
        assertTrue(actualResult)
    }

    @Test
    fun updatePostIdNotExists() {
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
        val actualResult = WallService.updatePost(
            Post(
                id = 4,
                ownerId = 1,
                fromId = 1,
                date = System.currentTimeMillis().toInt(),
                text = "post with id=2 updated"
            )
        )
        assertFalse(actualResult)
    }
}