1.Function with an expression body and inferred return type:
	fun sum(a: Int, b: Int) = a + b
	
2.Function returning no meaningful value:
	fun printSum(a: Int, b: Int): Unit {
    println("abc")
}

3.string templates
	var a = 1
	val s1 = "a is $a"

4.Return null if str does not hold an integer:

	fun parseInt(str: String): Int? {
	
	}
	
5.is operator: checks if an expression is an instance of a type	
cast is done automatically after comparission
	if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }
	
6.inintiate list
		val items = listOf("apple", "banana", "kiwifruit")

7. for loop
	for (item in items) {
     println(item)
	}
	
	get item 0 in items list --> items[0]
	
8. when expression
	 when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
	
9.check if number is/is not in range 
		if (x in 1..10) {
		println("fits in range")
		}
		
		if (x !in 1..10) {
		println("not fits in range")
		}
		

10.Iterating over a range:
	for (x in 1..10)		
	for (x in 1..10 step 2)
	for (x in 10 downTo 1)
	
11.Checking if a collection contains an object using in operator:
	when {
    "orange" in items -> println("juicy")
    "apple" in items -> println("apple is fine too")
	}
	
12. Lambda expression syntax
	val sum = { x: Int, y: Int -> x + y }
	
13. ?: (Elvis Operator)
		val l = b?.length ?: -1
		
14. Default values for function parameters
	fun foo(a: Int = 0, b: String = "") { ... }
	
15.filtering a list
	val positives = list.filter { x -> x > 0 }
	
16. Extension Functions
	fun String.spaceToCamelCase() { ... }
	"Convert this to camelcase".spaceToCamelCase()
	
17. Creating a singleton
		object Resource {
		val name = "Name"
		}
		
18.Get first item of a possibly empty collection
	emails.firstOrNull()		
	
19.try/catch
	val result = try {
        count()
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }	

20. arrayListOf("a", "b", "c") //returns a mutable collection type
    listOf("a", "b", "c") //returns a immutable collection type
    
21.  { it > 0 } //replace parameter with "it" in Lambada function with only one parameter    

22. 'if' branches can be blocks, and the last expression is the value of a block:
	val max = if (a > b) {
    		print("Choose a")
    		a
	} else {
    		print("Choose b")
    		b
	}

23. If the primary constructor has annotations or visibility modifiers, the constructor keyword is required, and the modifiers go before it:
	class Customer public @Inject constructor(name: String) { ... }
	
	
24. I. Initializer blocks are part of the primary constructor, so the code in all initializer blocks is executed before the secondary       constructor body
    II. If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor
    
	class Person(val name: String) {
		init {
        		println("Init block")
    		}
    		constructor(name: String, parent: Person) : this(name) {
        		parent.children.add(this)
    		}
	}

25. Kotlin class members: Constuctors, initializer blocks, functions, properties, nested classes, inner classes, object declarations

26. All classes in Kotlin have a common superclass 'Any'. This class does not have any members other than equals(), hashCode() and toString()

27. Inheritance:
     If the derived class has a primary constructor, the base class can (and must) be initialized right there
     If the class has no primary constructor, then each secondary constructor has to initialize the base type using the 'super' keyword

28. 'open' keyword: is used before overridable Functions & Properties
    'override' keyword is used before Functions & Properties which are to override
 
 open class Base {
    open fun v() { ... }
    fun nv() { ... }
}

class Derived() : Base() {
    override fun v() { ... }
}

29. init block of base class is done before the init block of derived class.

30. Code in a derived class can call its superclass functions and property using the 'super' keyword
    Inside an inner class, accessing the superclass of the outer class is done with the 'super' keyword with the outer class name: super@Outer:



