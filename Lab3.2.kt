class Student(private var firstName: String, private var lastName: String, private var id: String) {
    fun getFirstName(): String {
        return firstName
    }

    //test
    fun testGetFirstName() {
        val student = Student("John", "Doe", "12345")
        val expected = "John"
        val actual = student.getFirstName()
        if(expected == actual) {
            println("testGetFirstName OK")
        }
    }

    fun setFirstName(newFirstName: String) {
        firstName = newFirstName
    }

    //test
    fun testSetFirstName() {
        val student = Student("John", "Doe", "12345")
        student.setFirstName("Jane")
        val expected = "Jane"
        val actual = student.getFirstName()
        if(expected == actual) {
            println("testSetFirstName OK")
        }
    }

    fun getLastName():String{
        return lastName
    }

    //test
    fun testGetLastName() {
        val student = Student("John", "Doe", "12345")
        val expected = "Doe"
        val actual = student.getLastName()
        if(expected == actual) {
            println("testGetLastName OK")
        }
    }

    fun setLastName(newLastNew : String) {
        lastName = newLastNew
    }

    //test
    fun testSetLastName() {
        val student = Student("John", "Doe", "12345")
        student.setLastName("Smith")
        val expected = "Smith"
        val actual = student.getLastName()
        if(expected == actual) {
            println("testSetLastName OK")
        }
    }

    fun getId(): String{
        return id
    }

    //test
    fun testGetId() {
        val student = Student("John", "Doe", "12345")
        val expected = "12345"
        val actual = student.getId()
        if(expected == actual) {
            println("testGetId OK")
        }
    }

    override fun toString(): String {
        return "Student($firstName, $lastName, $id)"
    }

    //test
    fun testToString() {
        val student = Student("John", "Doe", "12345")
        val expected = "Student(John, Doe, 12345)"
        val actual = student.toString()
        if(expected == actual) {
            println("testToString OK")
        }
    }
}

fun main() {
    val st = Student("John", "Doe", "12340")
    println("TESTS:\n")
    st.testGetFirstName()
    st.testSetFirstName()
    st.testGetLastName()
    st.testSetLastName()
    st.testGetId()
    st.testToString()

    val s1 = Student("Monika", "Adamczyk", "12345")
    val s2 = Student("Antek", "Kowalczyk", "12346")
    val s3 = Student("Mateusz", "Bujkowski", "12347")
    val s4 = Student("Julia", "Frant", "12348")
    val s5 = Student("Dawid", "Zajkowski", "12349")

    val studentsList: List<Student> = listOf(s1, s2, s3, s4, s5)

    println("\nList of students (List):\n")
    for (student in studentsList) {
        println(student)
    }

    val mutableStudentsList: MutableList<Student> = mutableListOf(s1, s2, s3, s4, s5)
    println("\nList of students (MutableList):")
    for (student in mutableStudentsList) {
        println(student)
    }
}