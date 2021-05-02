package com.zainpradana.belajarkotlin.jetpack.myviewmodel.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import java.lang.NumberFormatException

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @get:Rule
    var thrown = ExpectedException.none()

    /*
    * Annotation @Rule digunakan untuk menjalankan kode sebelum pengujian dilakukan. Jadi ketika tidak diberi anotasi
    * @Rule pada thrown, maka kode tersebut tidak akan berjalan
    * */

    @Test
    fun calculate() {
        val width = "1"
        val length = "2"
        val height = "3"

        mainViewModel.calculate(width, height, length)
        assertEquals(6, mainViewModel.result)
    }
    @Test
    @Throws(NumberFormatException::class)
    fun doubleInputCalculateText() {
        val width = "1"
        val length = "2.4"
        val height = "3"

        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For Input String: \"2.4\"")

        mainViewModel.calculate(width, height, length)
    }

    @Test
    @Throws(NumberFormatException::class)
    fun emptyInputCalculateTest() {
        val width = "1"
        val length = ""
        val height = "3"

        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For Input String: \"\"")

        mainViewModel.calculate(width, height, length)
    }
}