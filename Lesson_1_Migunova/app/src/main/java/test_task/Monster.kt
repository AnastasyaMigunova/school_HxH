package test_task

class Monster(name: String) : Creatures(name) {
    companion object {
        private val MONSTER_TYPES = arrayOf("Орк", "Чернокнижник", "Зомби", "Ведьма", "Разбойник")

        fun createMonster(): Monster {
            val rand = java.util.Random()
            val randomType = MONSTER_TYPES[rand.nextInt(MONSTER_TYPES.size)]
            return Monster(randomType)
        }
    }
}