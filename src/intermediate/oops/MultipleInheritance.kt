package intermediate.oops

import java.text.SimpleDateFormat
import java.util.Date

interface ReadableIntr {
    val fileName: String
    val fileSize: Long
    var lastAccess: Long?
    var isOpen: Boolean

    fun openFile(): Boolean {
        isOpen = true
        lastAccess = System.currentTimeMillis()
        println("📖 Opened document: {self.filename}")
        return true
    }

    fun closeFile() {
        isOpen = false
        println("📕 Closed document: {self.filename}")
    }

    fun getFileSize(): String {
        return "$fileSize KB"
    }

    fun getLastAccessed(): String {
        if (lastAccess != null) {
            try {
                val sdf = SimpleDateFormat("dd/mm/YYYY")
                val netDate = Date(lastAccess!! * 1000)
                return sdf.format(netDate)
            } catch (exp: Exception) {
                println(exp)
            }
        }

        return "Never Accessed"
    }

    fun getContent()
    fun getFileFormat()
}

interface EditableIntr {
    var lastModified: Long
    var backUpContent: String
    var editHistory: List<String>

    fun markModification() {
        lastModified = System.currentTimeMillis()
        print("✏️ Document marked as modified")
    }

    fun undoChanges(): Boolean {
        if (backUpContent.isNotEmpty()) {
            println("↩️ Undoing changes...")
            return true
        }

        println("❌ No backup available for undo")
        return false
    }

    fun createBackup() : Boolean
    fun saveChanges()
}

abstract class Readable (private val fileName: String, private val fileSize: Long) {
    private var lastAccess: Long? = null
    private var isOpen = false

    fun openFile(): Boolean {
        isOpen = true
        lastAccess = System.currentTimeMillis()
        println("📖 Opened document: {self.filename}")
        return true
    }

    fun closeFile() {
        isOpen = false
        println("📕 Closed document: {self.filename}")
    }

    fun getFileSize(): String {
        return "$fileSize KB"
    }

    fun getLastAccessed(): String {
        if (lastAccess != null) {
            try {
                val sdf = SimpleDateFormat("dd/mm/YYYY")
                val netDate = Date(lastAccess!! * 1000)
                return sdf.format(netDate)
            } catch (exp: Exception) {
                println(exp)
            }
        }

        return "Never Accessed"
    }

    abstract fun getContent()
}

abstract class Editable {
    private var lastModified: Long = 0L
    private var backUpContent = ""
    private var editHistory = mutableListOf<String>()

    fun markModification() {
        lastModified = System.currentTimeMillis()
        print("✏️ Document marked as modified")
    }

    fun undoChanges(): Boolean {
        if (backUpContent.isNotEmpty()) {
            println("↩️ Undoing changes...")
            return true
        }

        println("❌ No backup available for undo")
        return false
    }

    abstract fun createBackup() : Boolean
    abstract fun saveChanges(): Boolean
}

class EditableSupport (val content: Any) : Editable() {

    // We can implement the behaviour here
    override fun createBackup(): Boolean {
        println("Creating backup...")
        return true
    }

    override fun saveChanges(): Boolean {
        println("saving changes...")
        return true
    }
}

class Docs(fileName: String, fileSize: Long) : Readable(fileName, fileSize) {
    private val editable = EditableSupport(getContent())

    override fun getContent() {
        println("📄 Showing content of the document...")
    }

    fun createBackUp() = editable.createBackup()
    fun saveChanges() = editable.saveChanges()
    fun undoChanges() = editable.undoChanges()
    fun markModify() = editable.markModification()
}
