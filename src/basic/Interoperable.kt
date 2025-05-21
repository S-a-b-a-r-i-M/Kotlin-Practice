package basic

// By default, the getters will be created
data class Education(
    val course: String,
    val startYear: Int,
    val endYear: Int,
    val percentage: Float
)

class Teacher (
    val id: String,
    var department: String,
    var subjects: List<String>,
    var educationDetails: List<Education> = listOf<Education>()
)

fun main() {
    val interOperable = InterOperable()

}