package advance

fun <T> initSomething(obj: T, init: T.() -> Unit): T {
    obj.init()
    return obj
}


class MemoryCard {
    var brandName: String = ""
    var capacityInBytes: Long = 0L
    var folders: MutableList<Folder> = mutableListOf()

    override fun toString(): String {
        return "Brand: $brandName, Size(b): $capacityInBytes" +
                folders.joinToString { "\n -- Folder: ${it.name} has ${it.files.size} files" }
    }

    fun folder (init: Folder.() -> Unit): Folder {
        val newFolder = Folder()
        newFolder.init()
        folders.add(newFolder)
        return newFolder
    }
}

class Folder {
    var name: String = ""
    var files: MutableList<File> = mutableListOf()

    fun file (init: File.() -> Unit): File {
        val newFile = File()
        newFile.init()
        files.add(newFile)
        return newFile
    }
}

enum class FileType {
    MP3, MP4, ZIP, PDF, DOC, NOT_SPECIFIED
}

class File {
    var name: String = ""
    var sizeInBytes: Long = 0L
    var type: FileType = FileType.NOT_SPECIFIED
}

fun memoryCard(init: MemoryCard.() -> Unit): MemoryCard {
    val memoryCard = MemoryCard()
    memoryCard.init()
    return memoryCard
}

fun main() {
    // Without Builder
    val memoryCard = MemoryCard().apply {
        brandName = "Sandisk"
        capacityInBytes = 1024 * 1024 * 1024 * 1 // 1 GB
    }

    val videoFolder1 = Folder()
    videoFolder1.name = "Videos"
    memoryCard.folders.add(videoFolder1)

    val videoFile1 = File().apply {
        name = "One Piece"
        type = FileType.MP4
        sizeInBytes = 5 * 1024 // 5 KB
    }

    val videoFile2 = File().apply {
        name = "Naruto"
        type = FileType.MP4
        sizeInBytes = 7 * 1024 // 7 KB
    }

    videoFolder1.files.add(videoFile1)
    videoFolder1.files.add(videoFile2)

    println(memoryCard)

    // With Builder
    println("--------- Object Creation Hierarchy With In Safe Builder Way ---------")
    val memoryCard2 = memoryCard {
        brandName = "Sandisk"
        capacityInBytes = 1024 * 1024 * 1024 * 1

        folder {
            name = "Videos"

            file {
                name = "One Piece"
                type = FileType.MP4
                sizeInBytes = 5 * 1024
            }
            file {
                name = "Naruto"
                type = FileType.MP4
                sizeInBytes = 7 * 1024 // 7 KB
            }
        }
    }

    println(memoryCard2)
}

