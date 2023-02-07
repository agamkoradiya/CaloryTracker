package com.plcoding.tracker_domain.use_case

import com.google.common.truth.Truth.assertThat
import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.model.GoalType
import com.plcoding.core.domain.model.UserInfo
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_domain.model.TrackedFood
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.random.Random

class CalculateMealNutrientsTest {

    private lateinit var calculateMealNutrients: CalculateMealNutrients
    private lateinit var trackedFoods: List<TrackedFood>

    @Before
    fun setUp() {
        val preferences = mockk<Preferences>(relaxed = true)
        every { preferences.loadUserInfo() } returns UserInfo(
            gender = Gender.Male,
            age = 20,
            weight = 80f,
            height = 180,
            activityLevel = ActivityLevel.Medium,
            goalType = GoalType.KeepWeight,
            carbRatio = 0.4f,
            proteinRatio = 0.3f,
            fatRatio = 0.3f
        )
        calculateMealNutrients = CalculateMealNutrients(preferences)

        trackedFoods = (1..50).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner", "snack").random()
                ),
                imageUrl = null,
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }
    }

    @Test
    fun `Calories for breakfast properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val breakfastCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }

        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }

        assertThat(breakfastCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Calories for lunch properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val lunchCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.calories }

        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.calories }

        assertThat(lunchCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Calories for dinner properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val dinnerCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.calories }

        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.calories }

        assertThat(dinnerCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Calories for snack properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val snackCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.calories }

        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.calories }

        assertThat(snackCalories).isEqualTo(expectedCalories)
    }




    @Test
    fun `carbs for breakfast properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.carbs }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.carbs }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `carbs for lunch properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.carbs }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.carbs }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `carbs for dinner properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `carbs for snack properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.carbs }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.carbs }

        assertThat(actual).isEqualTo(expected)
    }



    @Test
    fun `protein for breakfast properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.protein }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.protein }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `protein for lunch properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.protein }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.protein }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `protein for dinner properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.protein }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.protein }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `protein for snack properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.protein }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.protein }

        assertThat(actual).isEqualTo(expected)
    }



    @Test
    fun `fat for breakfast properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.fat }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.fat }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `fat for lunch properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.fat }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.fat }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `fat for dinner properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.fat }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.fat }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `fat for snack properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        val actual = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.fat }

        val expected = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.fat }

        assertThat(actual).isEqualTo(expected)
    }


    @Test
    fun `total values properly calculated`() {
        val result = calculateMealNutrients(trackedFoods = trackedFoods)

        assertThat(result.totalCarbs).isEqualTo(trackedFoods.sumOf { it.carbs })
        assertThat(result.totalProtein).isEqualTo(trackedFoods.sumOf { it.protein })
        assertThat(result.totalFat).isEqualTo(trackedFoods.sumOf { it.fat })
        assertThat(result.totalCalories).isEqualTo(trackedFoods.sumOf { it.calories })
    }
}