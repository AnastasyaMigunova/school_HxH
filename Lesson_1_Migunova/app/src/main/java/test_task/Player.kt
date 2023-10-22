package test_task

class Player(name: String) : Creatures(name) {
    private val maxHealth: Int = healthPoint
    private var healCount = 4

    fun heal() {
        if (healCount > 0) {
            val currentHealth = (healthPoint + (maxHealth * 0.3)).toInt()
            healthPoint = minOf(maxHealth, currentHealth)
            healCount--
            println("Вы исцелились. Осталось исцелений: $healCount\n")
        } else {
            println("Исцелить себя больше нельзя!\n")
        }
    }
}