import kotlin.random.Random
import kotlin.test.Test
import kotlin.time.measureTime

class Bench {
    @Test
    fun benchmarkSequence() {
        val data = (1..100).map { Random.Default.nextLong() }

        val time1 = measureTime {
            data.toSet()
                .map { it * it }
                .sorted()
                .toLongArray()
        }

        val time2 = measureTime {
            data.toSet()
                .asSequence()
                .map { it * it }
                .sorted()
                .toList()
                .toLongArray()
        }

        println(time1)
        println(time2)
    }
}