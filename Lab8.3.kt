import kotlin.math.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream
class Student(private var firstName: String, private var lastName: String, private var id: String, var mark: Ocena) {

    constructor(firstName: String, lastName: String) : this(firstName, lastName, generateNewId(), Ocena.DST)

    constructor(firstName: String, lastName: String, id: String) : this(firstName, lastName, id, Ocena.DST)


    init {
        if (id.isEmpty()) {
            this.id = generateNewId()
        }
        if (mark !in setOf(Ocena.NDST, Ocena.DST, Ocena.DST_PLUS, Ocena.DB, Ocena.DB_PLUS, Ocena.BDB, Ocena.NB)) {
            throw IllegalArgumentException("Invalid rating. Rating must be one of: {2.0, 3.0, 3.5, 4.0, 4.5, 5.0}")
        }
    }

    //test
    fun testStudentInit() {
        try {
            val student1 = Student("John", "Doe", "", Ocena.DB)
            println("testStudentInit (id generation without id) OK")
        } catch (e: Exception) {
            println("testStudentInit (id generation without id) FAILED")
        }


        try {
            val student3 = Student("John", "Doe", "12345", Ocena.DB)
            if (student3.getId() == "12345") {
                println("testStudentInit (valid id) OK")
            } else {
                println("testStudentInit (valid id) FAILED")
            }
        } catch (e: Exception) {
            println("testStudentInit (valid id) FAILED")
        }

        try {
            val student4 = Student("John", "Doe", "12345", Ocena.DB)
            println("testStudentInit (mark) OK")
        } catch (e: Exception) {
            println("testStudentInit (mark) FAILED")
        }

    }

    companion object {
        private var lastId = 0

        fun generateNewId(): String {
            lastId++
            return lastId.toString()
        }
    }

    //test
    fun testGenerateNewId() {
        val initialLastId = Student.lastId

        val id1 = Student.generateNewId()
        val id2 = Student.generateNewId()
        val id3 = Student.generateNewId()

        val isUniqueIds = id1 != id2 && id2 != id3 && id1 != id3

        val isSequentialIds = id1.toInt() == initialLastId + 1 &&
                id2.toInt() == initialLastId + 2 &&
                id3.toInt() == initialLastId + 3

        if (isUniqueIds && isSequentialIds) {
            println("testGenerateNewId OK")
        } else {
            println("testGenerateNewId FAILED")
        }
    }

    fun getFirstName(): String {
        return firstName
    }

    //test
    fun testGetFirstName() {
        val student = Student("John", "Doe", "12345",Ocena.DB)
        val expected = "John"
        val actual = student.getFirstName()
        if(expected == actual) {
            println("testGetFirstName OK")
        }else {
            println("testGetFirstName FAILED")
        }
    }

    fun setFirstName(newFirstName: String) {
        firstName = newFirstName
    }

    //test
    fun testSetFirstName() {
        val student = Student("John", "Doe", "12345", Ocena.DB)
        student.setFirstName("Jane")
        val expected = "Jane"
        val actual = student.getFirstName()
        if(expected == actual) {
            println("testSetFirstName OK")
        }else {
            println("testSetFirstName FAILED")
        }
    }

    fun getLastName():String{
        return lastName
    }

    //test
    fun testGetLastName() {
        val student = Student("John", "Doe", "12345",Ocena.DB)
        val expected = "Doe"
        val actual = student.getLastName()
        if(expected == actual) {
            println("testGetLastName OK")
        }else {
            println("testGetLastName FAILED")
        }
    }

    fun setLastName(newLastNew : String) {
        lastName = newLastNew
    }

    //test
    fun testSetLastName() {
        val student = Student("John", "Doe", "12345", Ocena.DB)
        student.setLastName("Smith")
        val expected = "Smith"
        val actual = student.getLastName()
        if(expected == actual) {
            println("testSetLastName OK")
        }else {
            println("testSetLastName FAILED")
        }
    }

    fun getId(): String{
        return id
    }

    //test
    fun testGetId() {
        val student = Student("John", "Doe", "12345", Ocena.DB)
        val expected = "12345"
        val actual = student.getId()
        if(expected == actual) {
            println("testGetId OK")
        }else {
            println("testGetId FAILED")
        }
    }

    fun getStMark():Ocena{
        return mark
    }

    //test
    fun testGetStMark() {
        val student = Student("John", "Doe", "12345", Ocena.DB)
        val expected = Ocena.DB
        val actual = student.getStMark()
        if(expected == actual) {
            println("testGetStMark OK")
        }else {
            println("testGetStMark FAILED")
        }
    }

    fun setStMark(newMark: Ocena) {
        if (newMark in setOf(Ocena.NDST, Ocena.DST, Ocena.DST_PLUS, Ocena.DB, Ocena.DB_PLUS, Ocena.BDB)) {
            mark = newMark
        } else {
            throw IllegalArgumentException("Invalid rating. Rating must be one of: {2.0, 3.0, 3.5, 4.0, 4.5, 5.0}")
        }
    }

    //test
    fun testSetStMark(){
        val student = Student("John", "Doe", "12345", Ocena.DB)
        student.setStMark(Ocena.DB)
        val expected = Ocena.DB
        val actual = student.getStMark()
        if(expected == actual) {
            println("testSetStMark OK")
        }else {
            println("testSetStMark FAILED")
        }
    }

    override fun toString(): String {
        return "Student($firstName, $lastName, $id, ${mark.mark_value})"
    }

    //test
    fun testToString() {
        val student = Student("John", "Doe", "12345", Ocena.DB)
        val expected = "Student(John, Doe, 12345, ${Ocena.DB.mark_value})"
        val actual = student.toString()
        if(expected == actual) {
            println("testToString OK")
        }else {
            println("testToString FAILED")
        }
    }
}


class Group{
    val mapStudents: MutableMap<String, Student> = mutableMapOf()
    var averageRating: Double = 0.0

    fun addStudents(student: Student){
        if (mapStudents.containsKey(student.getId())) {
            throw IllegalArgumentException("Student with index ${student.getId()} already exists in the group. Average grade in the group:")
        } else {
            mapStudents[student.getId()] = student
            calculateAverageRating()
        }
    }

    //test
    fun testAddStudents() {
        val group = Group()
        val student = Student("John", "Doe", "12345", Ocena.DB)
        group.addStudents(student)
        val expectedSize = 1
        val actualSize = group.mapStudents.size
        if (expectedSize == actualSize) {
            println("testAddStudents OK")
        }else {
            println("testAddStudents FAILED")
        }
    }

    fun calculateAverageRating() {
        if (mapStudents.isEmpty()) {
            averageRating = 0.0
        } else {
            var totalMarks = 0.0
            for (student in mapStudents.values) {
                totalMarks += student.getStMark().mark_value
            }
            averageRating = totalMarks/ mapStudents.size
        }
    }

    //test
    fun testCalculateAverageRating() {
        val group = Group()
        val student1 = Student("John", "Doe", "12345", Ocena.DB)
        val student2 = Student("Jane", "Doe", "12346", Ocena.DST)
        val student3 = Student("Alice", "Smith", "12347", Ocena.BDB)

        group.addStudents(student1)
        group.addStudents(student2)
        group.addStudents(student3)

        group.calculateAverageRating()

        val expectedAverage = (4 + 3 + 5) / 3.0 // Average of marks (4, 3, 5)
        val actualAverage = group.averageRating

        if (expectedAverage == actualAverage) {
            println("testCalculateAverageRating OK")
        }else {
            println("testCalculateAverageRating FAILED")
        }
    }
}


fun Student.strMark(): String {
    return when (mark) {
        Ocena.NDST -> "Insufficient"
        Ocena.DST -> "Satisfactory"
        Ocena.DST_PLUS -> "Satisfactory +"
        Ocena.DB -> "Good"
        Ocena.DB_PLUS -> "Good +"
        Ocena.BDB -> "Very good"
        else -> "Invalid rating. Rating must be one of: {2.0, 3.0, 3.5, 4.0, 4.5, 5.0}"
    }
}

//test
fun testStrMark() {
    val student = Student("John", "Doe", "12345", Ocena.DB)
    val expected = "Good"
    val actual = student.strMark()
    if (expected == actual) {
        println("testStrMark OK")
    }else {
        println("testStrMark FAILED")
    }
}

enum class Ocena(val mark_sh: String, val mark_desc: String, val mark_value: Double){
    NDST("ndst","Insufficient",2.0),
    DST("dst","Satisfactory",3.0),
    DST_PLUS("dst_plus","Satisfactory +",3.5),
    DB("db","Good",4.0),
    DB_PLUS("db_plus","Good +", 4.5),
    BDB("bdb","Very good", 5.0),
    NB("nb","Absent", 0.0)

}

//test
fun testOcena() {
    val ocena = Ocena.NDST
    val expected_desc = "Insufficient"
    val expected_value = 2.0

    if (ocena.mark_desc == expected_desc && ocena.mark_value == expected_value) {
        println("testOcena OK")
    } else {
        println("testOcena FAILED")
    }
}

data class StatisticsOfMarks(val min: Ocena, val max: Ocena, val average: Double, val standardDeviation: Double)


fun calculateStatistics(students: List<Student>): StatisticsOfMarks {
    require(students.isNotEmpty()) { "The student list cannot be empty." }

    var minMark = students[0].getStMark()
    var maxMark = students[0].getStMark()
    var totalMarks = 0.0

    for (student in students) {
        val mark = student.getStMark()
        totalMarks += mark.mark_value

        if (mark.mark_value < minMark.mark_value) {
            minMark = mark
        }
        if (mark.mark_value > maxMark.mark_value) {
            maxMark = mark
        }
    }

    val average = totalMarks / students.size

    val variance = students.map { it.getStMark().mark_value }.map { it - average }.map { it * it }.sum() / students.size
    val standardDeviation = kotlin.math.sqrt(variance)

    return StatisticsOfMarks(minMark, maxMark, average, standardDeviation)
}

//test
fun testCalculateStatistics() {
    val s1 = Student("Julia", "Frant", "12348", Ocena.DB)
    val s2 = Student("Dawid", "Zajkowski", "12349", Ocena.BDB)
    val s3 = Student("Jan", "Kowalski", "12344", Ocena.NB)

    val studentsList: List<Student> = listOf(s1, s2, s3)

    val statistics = calculateStatistics(studentsList)

    val expectedMinMark = Ocena.NB.mark_value
    val expectedMaxMark = Ocena.BDB.mark_value
    val expectedAverage = (Ocena.DB.mark_value + Ocena.BDB.mark_value + Ocena.NB.mark_value) / studentsList.size
    val variance = studentsList.map { it.getStMark().mark_value }.map { it - expectedAverage }.map { it * it }.sum() / studentsList.size
    val expectedStandardDeviation = sqrt(variance)

    if (statistics.min.mark_value == expectedMinMark &&
        statistics.max.mark_value == expectedMaxMark &&
        statistics.average == expectedAverage &&
        statistics.standardDeviation == expectedStandardDeviation
    ) {
        println("testCalculateStatistics OK")
    } else {
        println("testCalculateStatistics FAILED")
    }
}

class GroupID<T> {
    private val mapStudents: MutableMap<String, T> = mutableMapOf()

    fun addStudent(id: String, student: T) {
        mapStudents[id] = student
    }

    //test
    fun testAddStudent() {
        val group = GroupID<Student>()
        val student = Student("John", "Doe", "12345", Ocena.DB)
        val studentId = "12345"

        group.addStudent(studentId, student)

        val addedStudent = group.getStudentByID(studentId)
        if (addedStudent == student) {
            println("testAddStudent OK")
        } else {
            println("testAddStudent FAILED")
        }
    }

    fun getStudentByIDorNull(id: String): T? {
        return mapStudents[id]
    }

    //test
    fun testGetStudentByIDorNull() {
        val group = GroupID<Student>()
        val student1 = Student("John", "Doe", "12345", Ocena.DB)
        group.addStudent("12345", student1)

        val foundStudent = group.getStudentByIDorNull("12345")
        if (foundStudent != null) {
            println("testGetStudentByIDorNull (existing student) OK")
        } else {
            println("testGetStudentByIDorNull (existing student) FAILED")
        }

        val nonExistentStudent = group.getStudentByIDorNull("54321")
        if (nonExistentStudent == null) {
            println("testGetStudentByIDorNull (non-existent student) OK")
        } else {
            println("testGetStudentByIDorNull (non-existent student) FAILED")
        }

        val nonExistentStudent2 = group.getStudentByIDorNull("54321")?.getFirstName()
        if (nonExistentStudent2 == null) {
            println("testGetStudentByIDorNull (non-existent student with ?. operator) OK")
        } else {
            println("testGetStudentByIDorNull (non-existent student with ?. operator) FAILED")
        }
    }

    fun getStudentByID(id: String): T {
        return mapStudents[id] ?: throw NoSuchElementException("There is no student with the given index number: $id")
    }

    //test
    fun testGetStudentByID() {
        val group = GroupID<Student>()
        val student1 = Student("John", "Doe", "12345", Ocena.DB)
        group.addStudent("12345", student1)

        val foundStudent = group.getStudentByID("12345")
        println("testGetStudentByID (existing student) OK")

        try {
            val nonExistentStudent = group.getStudentByID("54321")
            println("testGetStudentByID (non-existent student) FAILED")
        } catch (e: NoSuchElementException) {
            println("testGetStudentByID (non-existent student) OK")
        }
    }

}

fun <T> display(elements: List<T>) {
    for ((index, element) in elements.withIndex()) {
        println("${index + 1}. $element")
    }
}

//test
fun testDisplay() {
    val fruits = listOf("Apple", "Banana", "Orange")
    val expectedOutput = listOf("1. Apple", "2. Banana", "3. Orange")

    val outputStream = ByteArrayOutputStream()
    val originalOut = System.out
    System.setOut(PrintStream(outputStream))

    display(fruits)

    val actualOutputLines = outputStream.toString().lines().map { it.trim() }

    System.setOut(originalOut)

    val allLinesMatch = expectedOutput.zip(actualOutputLines).all { (expected, actual) ->
        expected == actual
    }

    if (allLinesMatch) {
        println("testDisplay OK")
    } else {
        println("testDisplay FAILED")
    }
}


fun main() {
    val st = Student("John", "Doe", "12340", Ocena.DB)
    println("TESTS:\n")
    st.testGetFirstName()
    st.testSetFirstName()
    st.testGetLastName()
    st.testSetLastName()
    st.testGetId()
    st.testGetStMark()
    st.testSetStMark()
    st.testToString()
    testStrMark()
    testOcena()
    testCalculateStatistics()
    testDisplay()
    st.testGenerateNewId()
    st.testStudentInit()
    println()

    val grID = GroupID<Student>()
    grID.testGetStudentByIDorNull()
    grID.testGetStudentByID()
    grID.testAddStudent()
    println()

    val gr = Group()
    gr.testAddStudents()
    gr.testCalculateAverageRating()



    val s1 = Student("Monika", "Adamczyk", "12345", Ocena.NDST)
    val s2 = Student("Antek", "Kowalczyk", "12346", Ocena.DST)
    val s3 = Student("Mateusz", "Bujkowski", "12347", Ocena.DB_PLUS)
    val s4 = Student("Julia", "Frant", "12348", Ocena.DB)
    val s5 = Student("Dawid", "Zajkowski", "12349", Ocena.BDB)
    val s6 = Student("Jan", "Kowalski", "12344", Ocena.NB)

    val studentsList: List<Student> = listOf(s1, s2, s3, s4, s5, s6)

    println("\nList of students (List):\n")
    for (student in studentsList) {
        println(student)
    }

    val mutableStudentsList: MutableList<Student> = mutableListOf(s1, s2, s3, s4, s5, s6)
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
    grupa.addStudents(s6)

    println("\nAverage grade in the group:: ${grupa.averageRating}")

    val statistics = calculateStatistics(mutableStudentsList)

    println("\nGrade statistics in the group:")
    println("\nMinimum: ${statistics.min.mark_desc}")
    println("Maximum: ${statistics.max.mark_desc}")
    println("Average (lab 6): ${statistics.average}")
    println("Standard deviation: ${statistics.standardDeviation}")


}
