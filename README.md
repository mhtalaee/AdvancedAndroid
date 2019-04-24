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
