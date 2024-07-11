package com.sample.app

enum class CollectionType {
    COLLECTION_3_4,
    COLLECTION_4_3,
    COLLECTION_16_6,
    COLLECTION_16_9,
    COLLECTION_MAX_WIDTH
}

data class Collection(
    val title: String,
    val type: CollectionType
)

val HomeCollections = listOf(
    Collection(
        title = "Collection 16_6",
        type = CollectionType.COLLECTION_16_6
    ),
    Collection(
        title = "Collection 16_9",
        type = CollectionType.COLLECTION_16_9
    ),
    Collection(
        title = "Collection MAX_WIDTH",
        type = CollectionType.COLLECTION_MAX_WIDTH
    ),
    Collection(
        title = "Collection 4_3",
        type = CollectionType.COLLECTION_4_3
    ),
    Collection(
        title = "Collection 16_6",
        type = CollectionType.COLLECTION_3_4
    ),
    Collection(
        title = "Collection 16_9",
        type = CollectionType.COLLECTION_16_9
    ),
    Collection(
        title = "Collection 16_6",
        type = CollectionType.COLLECTION_16_6
    ),
    Collection(
        title = "Collection 4_3",
        type = CollectionType.COLLECTION_4_3
    ),
    Collection(
        title = "Collection 16_6",
        type = CollectionType.COLLECTION_3_4
    ),
    Collection(
        title = "Collection 16_9",
        type = CollectionType.COLLECTION_16_9
    ),
    Collection(
        title = "Collection 16_6",
        type = CollectionType.COLLECTION_16_6
    ),
    Collection(
        title = "Collection 4_3",
        type = CollectionType.COLLECTION_4_3
    ),
    Collection(
        title = "Collection 16_6",
        type = CollectionType.COLLECTION_3_4
    )
)