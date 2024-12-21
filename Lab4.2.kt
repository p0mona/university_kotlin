class Student(private var firstName: String, private var lastName: String, private var id: String, private var mark:String) {
    fun getFirstName(): String {
        return firstName
    }

    //test
    fun testGetFirstName() {
        val student = Student("John", "Doe", "12345","4")
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
        val student = Student("John", "Doe", "12345", "4")
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
        val student = Student("John", "Doe", "12345","4")
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
        val student = Student("John", "Doe", "12345", "4")
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
        val student = Student("John", "Doe", "12345", "4")
        val expected = "12345"
        val actual = student.getId()
        if(expected == actual) {
            println("testGetId OK")
        }
    }

    fun getMark():String{
        return mark
    }

    //test
    fun testGetMark() {
        val student = Student("John", "Doe", "12345", "4")
        val expected = "4"
        val actual = student.getMark()
        if(expected == actual) {
            println("testGetMark OK")
        }
    }

    fun setMark(newMark : String){
        if (newMark in setOf("2", "3", "4", "5")) {
            mark = newMark
        } else {
            println("Invalid character. The character should be one of: {2, 3, 4, 5}")
        }
    }

    //test
    fun testSetMark(){
        val student = Student("John", "Doe", "12345", "4")
        student.setMark("4")
        val expected = "4"
        val actual = student.getMark()
        if(expected == actual) {
            println("testSetMark OK")
        }
    }

    override fun toString(): String {
        return "Student($firstName, $lastName, $id, $mark)"
    }

    //test
    fun testToString() {
        val student = Student("John", "Doe", "12345", "4")
        val expected = "Student(John, Doe, 12345, 4)"
        val actual = student.toString()
        if(expected == actual) {
            println("testToString OK")
        }
    }
}


class Group{
    private val mapStudents: MutableMap<String, Student> = mutableMapOf()
    var averageRating: Double = 0.0

    fun addStudents(student: Student){
        if (mapStudents.containsKey(student.getId())) {
            throw IllegalArgumentException("Student with index: ${student.getId()} już istnieje w grupie.")
        } else {
            mapStudents[student.getId()] = student
            calculateAverageRating()
        }
    }

    //test
    fun testAddStudents() {
        val group = Group()
        val student = Student("John", "Doe", "12345", "4")
        group.addStudents(student)
        val expectedSize = 1
        val actualSize = group.mapStudents.size
        if (expectedSize == actualSize) {
            println("testAddStudents OK")
        }
    }

    fun calculateAverageRating() {
        if (mapStudents.isEmpty()) {
            averageRating = 0.0
        } else {
            var totalMarks = 0
            for (student in mapStudents.values) {
                totalMarks += student.getMark().toInt()
            }
            averageRating = totalMarks.toDouble() / mapStudents.size
        }
    }

    //test
    fun testCalculateAverageRating() {
        val group = Group()
        val student1 = Student("John", "Doe", "12345", "4")
        val student2 = Student("Jane", "Doe", "12346", "3")
        val student3 = Student("Alice", "Smith", "12347", "5")

        group.addStudents(student1)
        group.addStudents(student2)
        group.addStudents(student3)

        group.calculateAverageRating()

        val expectedAverage = (4 + 3 + 5) / 3.0 // Average of marks (4, 3, 5)
        val actualAverage = group.averageRating

        if (expectedAverage == actualAverage) {
            println("testCalculateAverageRating OK")
        }
    }
}


fun main() {
    val st = Student("John", "Doe", "12340","4")
    println("TESTS:\n")
    st.testGetFirstName()
    st.testSetFirstName()
    st.testGetLastName()
    st.testSetLastName()
    st.testGetId()
    st.testGetMark()
    st.testSetMark()
    st.testToString()

    val gr = Group()
    gr.testAddStudents()
    gr.testCalculateAverageRating()


    val s1 = Student("Monika", "Adamczyk", "12345", "2")
    val s2 = Student("Antek", "Kowalczyk", "12346", "3")
    val s3 = Student("Mateusz", "Bujkowski", "12347","5")
    val s4 = Student("Julia", "Frant", "12348","4")
    val s5 = Student("Dawid", "Zajkowski", "12349","5")

    val studentsList: List<Student> = listOf(s1, s2, s3, s4, s5)

    println("\nList of students (List):\n")
    for (student in studentsList) {
        println(student)
    }

    val mutableStudentsList: MutableList<Student> = mutableListOf(s1, s2, s3, s4, s5)
    println("\nList of students (MutableList):\n")
    for (student in mutableStudentsList) {
        println(student)
    }

    val grupa = Group()
    grupa.addStudents(s1)
    grupa.addStudents(s2)
    grupa.addStudents(s3)
    grupa.addStudents(s4)
    grupa.addStudents(s5)

    println("\nAverage grade in the group: ${grupa.averageRating}")
}