package test_task

open class Creatures(name: String) {
    private val name: String = name
    private val attack: Int = getRandomNumber(1, 30)
    private val def: Int = getRandomNumber(1, 30)
    protected var healthPoint: Int = maxOf(getRandomNumber(0, 100), 1)
    private val minDamage: Int = getRandomNumber(1, 10)
    private val maxDamage: Int = getRandomNumber(15, 30)

    private fun getRandomNumber(min: Int, max: Int): Int {
        val rand = java.util.Random()
        return rand.nextInt(max - min + 1) + min
    }

    fun getName(): String {
        return name
    }

    fun getHealthPointValue(): Int {
        return healthPoint
    }

    open fun isAlive(): Boolean {
        return healthPoint > 0
    }

    open fun takingDamage(damage: Int) {
        if (damage > 0) {
            healthPoint -= damage
            if (healthPoint < 0) {
                healthPoint = 0
                println("$name погиб!\n")
            }
        }
    }

    open fun successHit(defender: Creatures) {
        var N = attack - (defender.def + 1)
        N = maxOf(N, 1)
        var success = false

        for (i in 0 until N) {
            val randomNumber = getRandomNumber(1, 6)
            if (randomNumber >= 5) {
                success = true
                break
            }
        }

        if (success) {
            val attackerHit = getRandomNumber(minDamage, maxDamage)
            println("\n$name нанес $attackerHit урона!\n")
            defender.takingDamage(attackerHit)
        } else {
            println("\n$name промахнулся!\n")
        }
    }

    open fun printInfo() {
        println("Характеристики $name:")
        println("Атака: $attack")
        println("Защита: $def")
        println("Здоровье: $healthPoint")
        println("Урон: $minDamage-$maxDamage\n")
    }
}