package edu.cesspool.metanit.chapter4_objectOrientedProgramming.less35_03

enum class DifficultyLevel {

    EASY{
        override fun getEnemyCount(): Int = 5
        override fun getEnemyHealth(): Int = 50
        override fun getTimeLimit(): Int? = null // без ограничения времени
        override fun calculateScore(baseScore: Int): Int = baseScore
    },

    MEDIUM {
        override fun getEnemyCount(): Int = 10
        override fun getEnemyHealth(): Int = 100
        override fun getTimeLimit(): Int? = 300  // 5 минут
        override fun calculateScore(baseScore: Int): Int = baseScore * 2
    },

    HARD {
        override fun getEnemyCount(): Int = 20
        override fun getEnemyHealth(): Int = 200
        override fun getTimeLimit(): Int? = 180
        override fun calculateScore(baseScore: Int): Int = baseScore * 5
    },

    INSANE {
        override fun getEnemyCount(): Int = 50
        override fun getEnemyHealth(): Int = 500
        override fun getTimeLimit(): Int? = 120
        override fun calculateScore(baseScore: Int): Int = baseScore * 10
    };

    abstract fun getEnemyCount(): Int
    abstract fun getEnemyHealth(): Int
    abstract fun getTimeLimit(): Int?  // минуты, null - если без ограничений
    abstract fun calculateScore(baseScore: Int): Int

    // Общий метод для всех уровней сложностей
    fun getTotalEnemyHealth(): Int = getEnemyCount() * getEnemyHealth()
}

fun testDifficultyLevel(){
    val level = DifficultyLevel.HARD

    println("Уровень: ${level.name}")
    println("Количество врагов: ${level.getEnemyCount()}")
    println("Здоровье врага: ${level.getEnemyHealth()}")
    println("Общее здоровье врагов: ${level.getTotalEnemyHealth()}")
    println("Лимит времени: ${level.getTimeLimit() ?: "Нет"}")
    println("Очки за победу (база 100): ${level.calculateScore(100)}")

    // Сравнение всех уровней
    println("\nСравнение всех уровней:")
    DifficultyLevel.values().forEach { lvl ->
        println("${lvl.name}: ${lvl.getEnemyCount()} врагов, " +
                "здоровье ${lvl.getEnemyHealth()}, " +
                "очки x${lvl.calculateScore(1)}")
    }
}

fun main(){
    testDifficultyLevel()
}