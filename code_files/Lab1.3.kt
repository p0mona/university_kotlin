class Student(private var firstName: String, private var lastName: String, private var id: String) {
    fun getFirstName(): String {
        return firstName
    }

    fun setFirstName(newFirstName: String) {
        firstName = newFirstName
    }

    fun getLastName():String{
        return lastName
    }

    fun setLastName(newLastNew : String) {
        lastName = newLastNew
    }

    fun getId(): String{
        return id
    }

    override fun toString(): String {
        return "Student($firstName, $lastName, $id)"
    }
}

fun main() {
    val s1 = Student("Monika", "Adamczyk", "12345")
    val s2 = Student("Antek", "Kowalczyk", "12346")
    val s3 = Student("Mateusz", "Bujkowski", "12347")
    val s4 = Student("Julia", "Frant", "12348")
    val s5 = Student("Dawid", "Zajkowski", "12349")

    val studentsList = listOf(s1, s2, s3, s4, s5)

    for (student in studentsList) {
        println(student)
    }
}