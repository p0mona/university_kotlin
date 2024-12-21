open class Employee(private val firstName: String, private val lastName: String, private val payment: Double) {
    override fun toString(): String {
        return "Employee [name = $firstName, last name = $lastName, salary = $payment]"
    }

    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0.0) {
    }
}

open class EmployeeFullTime(
    firstName: String,
    lastName: String,
    payment: Double,
    private val contractFixedTime: Boolean
) : Employee(firstName, lastName, payment) {
    override fun toString(): String {
        return "Full-time employee [${super.toString()}, fixed-term contract = $contractFixedTime]"
    }

    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0.0, false) {
    }
}

open class Manager(
    firstName: String,
    lastName: String,
    payment: Double,
    contractFixedTime: Boolean,
    private val department: String,
    private val bonus: Double
) : EmployeeFullTime(firstName, lastName, payment, contractFixedTime) {
    override fun toString(): String {
        return "Manager [${super.toString()}, department = $department, bonus = $bonus]"
    }
    constructor(firstName: String, lastName: String, department: String) : this(firstName, lastName, 0.0, false, department, 0.0) {
    }
}

class Director(
    firstName: String,
    lastName: String,
    payment: Double,
    contractFixedTime: Boolean,
    department: String,
    bonus: Double
) : Manager(firstName, lastName, payment, contractFixedTime, department, bonus) {
    override fun toString(): String {
        return "Director [${super.toString()}]"
    }
    constructor(firstName: String, lastName: String, department: String) : this(firstName, lastName, 0.0, false, department, 0.0) {
    }
}

open class Collaborator(
    firstName: String,
    lastName: String,
    payment: Double,
    private val contractOrder: Boolean,
    private val contractWork: Boolean
) : Employee(firstName, lastName, payment) {
    override fun toString(): String {
        return "Collaborator [${super.toString()}, contract of mandate = $contractOrder, contract for specific work = $contractWork]"
    }
    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0.0, false, false) {
    }
}

class CollaboratorPermanent(
    firstName: String,
    lastName: String,
    payment: Double,
    contractOrder: Boolean,
    contractWork: Boolean
) : Collaborator(firstName, lastName, payment, contractOrder, contractWork) {
    override fun toString(): String {
        return "Permanent collaborator [${super.toString()}]"
    }
    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0.0, false, false) {
    }
}

class CollaboratorTemporary(
    firstName: String,
    lastName: String,
    payment: Double,
    contractOrder: Boolean,
    contractWork: Boolean,
    private val periodOfEmployment: Int
) : Collaborator(firstName, lastName, payment, contractOrder, contractWork) {
    override fun toString(): String {
        return "Periodic collaborator [${super.toString()}, period of employment = $periodOfEmployment]"
    }
    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0.0, false, false, 0) {
    }
}

fun main(){
    val employee = Employee("John", "Doe", 1200.0)
    val expectedEmployee = "Employee [name = John, last name = Doe, salary = 1200.0]"
    val actualEmployee = employee.toString()
    if(expectedEmployee == actualEmployee) {
        println("TestToStringEmployee OK")
    } else {
        println("TestToStringEmployee FAILED")
    }

    val employeeFullTime = EmployeeFullTime("John", "Doe", 1200.0, true)
    val expectedEmployeeFullTime = "Full-time employee [Employee [name = John, last name = Doe, salary = 1200.0], fixed-term contract = true]"
    if (employeeFullTime.toString() == expectedEmployeeFullTime) {
        println("TestToStringEmployeeFullTime OK")
    } else {
        println("TestToStringEmployeeFullTime FAILED")
    }

    val manager = Manager("John", "Doe", 1200.0, true, "Design", 2000.0)
    val expectedManager = "Manager [Full-time employee [Employee [name = John, last name = Doe, salary = 1200.0], fixed-term contract = true], department = Design, bonus = 2000.0]"
    if (manager.toString() == expectedManager) {
        println("TestToStringManager OK")
    } else {
        println("TestToStringManager FAILED")
    }

    val director = Director("Alice", "Smith", 3000.0, true, "Marketing", 5000.0)
    val expectedDirector = "Director [Manager [Full-time employee [Employee [name = Alice, last name = Smith, salary = 3000.0], fixed-term contract = true], department = Marketing, bonus = 5000.0]]"
    if (director.toString() == expectedDirector) {
        println("TestToStringDirector OK")
    } else {
        println("TestToStringDirector FAILED")
    }

    val collaborator = Collaborator("Adam", "Nowak", 1500.0, true, false)
    val expectedCollaborator = "Collaborator [Employee [name = Adam, last name = Nowak, salary = 1500.0], contract of mandate = true, contract for specific work = false]"
    if (collaborator.toString() == expectedCollaborator) {
        println("TestToStringCollaborator OK")
    } else {
        println("TestToStringCollaborator FAILED")
    }

    val collaboratorPermanent = CollaboratorPermanent("Maria", "Zielinska", 2000.0, true, true)
    val expectedCollaboratorPermanent = "Permanent collaborator [Collaborator [Employee [name = Maria, last name = Zielinska, salary = 2000.0], contract of mandate = true, contract for specific work = true]]"
    if (collaboratorPermanent.toString() == expectedCollaboratorPermanent) {
        println("TestToStringCollaboratorPermanent OK")
    } else {
        println("TestToStringCollaboratorPermanent FAILED")
    }

    val collaboratorTemporary = CollaboratorTemporary("Ewa", "Kowalska", 1500.0, true, false, 12)
    val expectedCollaboratorTemporary = "Periodic collaborator [Collaborator [Employee [name = Ewa, last name = Kowalska, salary = 1500.0], contract of mandate = true, contract for specific work = false], period of employment = 12]"
    if (collaboratorTemporary.toString() == expectedCollaboratorTemporary) {
        println("TestToStringCollaboratorTemporary OK")
    } else {
        println("TestToStringCollaboratorTemporary FAILED")
    }
}

