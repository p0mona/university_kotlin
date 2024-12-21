data class Address(var city: String, var street: String)

open class PersonBase(
    open var id: Int,
    open var name: String,
    open var surname: String,
    open var age: Int,
    open var address: Address
)

data class Person(
    override var id: Int,
    override var name: String,
    override var surname: String,
    override var age: Int,
    override var address: Address,
    var position: String,
    var salary: Double
) : PersonBase(id, name, surname, age, address)

interface Crud<T> {
    fun create(item: T)
    fun read(id: Int): T?
    fun update(item: T)
    fun delete(id: Int)
    fun findAll(): List<T>
}

class CrudPerson : Crud<Person> {
    private val persons = mutableListOf<Person>()

    override fun create(item: Person) {
        if (persons.any { it.id == item.id }) {
            println("Person with ID <${item.id}> already exists.")
            return
        }
        persons.add(item)
    }

    override fun read(id: Int): Person? {
        return persons.find { it.id == id }
    }

    override fun update(item: Person) {
        val index = persons.indexOfFirst { it.id == item.id }
        if (index != -1) {
            persons[index] = item
        }
    }

    override fun delete(id: Int) {
        persons.removeIf { it.id == id }
    }

    override fun findAll(): List<Person> {
        return persons.toList()
    }
}

fun addPerson(repository: Crud<Person>) {
    println("Enter the person's ID:")
    val id = readLine()?.toIntOrNull()
    if (id == null) {
        println("Invalid ID.")
        return
    }
    println("Enter the person's name:")
    val name = readLine().orEmpty().takeIf { it.isNotBlank() && !it.any { it.isDigit() } } ?: run {
        println("Invalid name.")
        return
    }

    println("Enter the person's surname:")
    val surname = readLine().orEmpty().takeIf { it.isNotBlank() && !it.any { it.isDigit() } } ?: run {
        println("Invalid surname.")
        return
    }

    println("Enter the person's age:")
    val age = readLine()?.toIntOrNull()
    if (age == null || age <= 0) {
        println("Invalid age.")
        return
    }

    println("Enter the person's city:")
    val city = readLine().orEmpty()

    println("Enter the person's street address:")
    val street = readLine().orEmpty()

    val address = Address(city, street)

    println("Enter the person's position:")
    val position = readLine().orEmpty().takeIf { it.isNotBlank() && !it.any { it.isDigit() } } ?: run {
        println("Invalid position.")
        return
    }

    println("Enter the person's salary:")
    val salary = readLine()?.toDoubleOrNull()
    if (salary == null || salary < 0) {
        println("Invalid salary.")
        return
    }

    val person = Person(id, name, surname, age, address, position, salary)
    repository.create(person)
    println("Person added successfully.")
}

fun viewPerson(repository: Crud<Person>) {
    println("Enter Person ID to view:")
    val id = readLine()?.toIntOrNull()
    if (id != null) {
        val person = repository.read(id)
        if (person != null) {
            println(person)
        } else {
            println("Person not found.")
        }
    } else {
        println("Invalid ID.")
    }
}

fun updatePerson(repository: Crud<Person>) {
    println("Enter Person ID to update:")
    val id = readLine()?.toIntOrNull()
    if (id != null) {
        val person = repository.read(id)
        if (person != null) {
            while (true) {
                println("\nSelect the field to update:")
                println("1. Name")
                println("2. Surname")
                println("3. Age")
                println("4. Address")
                println("5. Position")
                println("6. Salary")
                println("7. Exit")

                when (readLine()?.toIntOrNull()) {
                    1 -> {
                        println("Enter new name:")
                        val newName = readLine().orEmpty()
                        person.name = newName
                        repository.update(person)
                        println("Name updated successfully.")
                    }
                    2 -> {
                        println("Enter new surname:")
                        val newSurname = readLine().orEmpty()
                        person.surname = newSurname
                        repository.update(person)
                        println("Surname updated successfully.")
                    }
                    3 -> {
                        println("Enter new age:")
                        val newAge = readLine()?.toIntOrNull()
                        if (newAge != null && newAge > 0) {
                            person.age = newAge
                            repository.update(person)
                            println("Age updated successfully.")
                        } else {
                            println("Invalid age.")
                        }
                    }
                    4 -> {
                        println("Enter new city:")
                        val newCity = readLine().orEmpty()
                        println("Enter new street address:")
                        val newStreet = readLine().orEmpty()

                        val newAddress = Address(newCity, newStreet)
                        person.address = newAddress
                        repository.update(person)
                        println("Address updated successfully.")
                    }
                    5 -> {
                        println("Enter new position:")
                        val newPosition = readLine().orEmpty()
                        person.position = newPosition
                        repository.update(person)
                        println("Position updated successfully.")
                    }
                    6 -> {
                        println("Enter new salary:")
                        val newSalary = readLine()?.toDoubleOrNull()
                        if (newSalary != null && newSalary >= 0) {
                            person.salary = newSalary
                            repository.update(person)
                            println("Salary updated successfully.")
                        } else {
                            println("Invalid salary.")
                        }
                    }
                    7 -> return
                    else -> println("Invalid option. Please try again.")
                }
            }
        } else {
            println("Person not found.")
        }
    } else {
        println("Invalid ID.")
    }
}

fun deletePerson(repository: Crud<Person>) {
    println("Enter Person ID to delete:")
    val id = readLine()?.toIntOrNull()
    if (id != null) {
        repository.delete(id)
        println("Person deleted successfully.")
    } else {
        println("Invalid ID.")
    }
}

fun listAllPersons(repository: Crud<Person>) {
    val persons = repository.findAll()
    if (persons.isNotEmpty()) {
        persons.forEach { println(it) }
    } else {
        println("No persons found.")
    }
}

fun main() {
    val repository: Crud<Person> = CrudPerson()

    while (true) {
        println("\nMENU")
        println("1. Add a person")
        println("2. View a person")
        println("3. Update a person")
        println("4. Delete a person")
        println("5. List of all persons")
        println("6. Exit")
        println("(7. Tests)")

        when (readLine()?.toIntOrNull()) {
            1 -> addPerson(repository)
            2 -> viewPerson(repository)
            3 -> updatePerson(repository)
            4 -> deletePerson(repository)
            5 -> listAllPersons(repository)
            6 -> return
            7 -> testCrud(repository)
            else -> println("Invalid option. Please try again.")
        }
    }
}

fun testCrud(repository: Crud<Person>) {
    val person1 = Person(1, "Katrin", "Doe", 30, Address("Main Street", "New York"), "Developer", 50000.0)
    val person2 = Person(2, "John", "Smith", 28, Address("Elm Street", "Berlin"), "Manager", 60000.0)

    repository.create(person1)
    repository.create(person2)

    // Тест добавления
    assert(repository.findAll().size == 2) { "Add Person Test Failed: Incorrect number of persons in repository." }
    assert(repository.read(1) == person1) { "Add Person Test Failed: Person 1 not found in repository." }
    assert(repository.read(2) == person2) { "Add Person Test Failed: Person 2 not found in repository." }

    // Тест чтения
    val readPerson = repository.read(1)
    assert(readPerson != null && readPerson.id == 1 && readPerson.name == "Katrin") { "Read Person Test Failed: Incorrect person data." }

    // Тест обновления
    val updatedPerson = person1.copy(name = "Johnathan", age = 31)
    repository.update(updatedPerson)

    val readUpdatedPerson = repository.read(1)
    assert(readUpdatedPerson != null && readUpdatedPerson.name == "Johnathan" && readUpdatedPerson.age == 31) { "Update Person Test Failed: Person data not updated correctly." }

    // Тест удаления
    repository.delete(1)
    assert(repository.read(1) == null) { "Delete Person Test Failed: Person not deleted correctly." }
    assert(repository.findAll().size == 1) { "Delete Person Test Failed: Incorrect number of persons in repository after deletion." }

    // Тест получения всех людей
    val allPersons = repository.findAll()
    assert(allPersons.size == 1 && allPersons[0].id == 2) { "Find All Persons Test Failed: Incorrect data." }

    println("All tests passed successfully!")
}

