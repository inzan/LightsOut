package com.zybooks.lightsout

import kotlin.random.Random

const val GRID_SIZE = 3

class LightsOutGame {

    private val lightsGrid = Array(GRID_SIZE) { Array(GRID_SIZE) { true } }

    var state: String
        get() {
            val boardString = StringBuilder()
            for (row in 0 until GRID_SIZE) {
                for (col in 0 until GRID_SIZE) {
                    val value = if (lightsGrid[row][col]) 'T' else 'F'
                    boardString.append(value)
                }
            }
            return boardString.toString()
        }
        set(value) {
            var index = 0
            for (row in 0 until GRID_SIZE) {
                for (col in 0 until GRID_SIZE) {
                    lightsGrid[row][col] = value[index] == 'T'
                    index++
                }
            }
        }

    fun newGame() {
        for (row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                lightsGrid[row][col] = Random.nextBoolean()
            }
        }
    }

    fun isLightOn(row: Int, col: Int): Boolean {
        return lightsGrid[row][col]
    }

    fun selectLight(row: Int, col: Int) {
        lightsGrid[row][col] = !lightsGrid[row][col]
        if (row > 0) {
            lightsGrid[row - 1][col] = !lightsGrid[row - 1][col]
        }
        if (row < GRID_SIZE - 1) {
            lightsGrid[row + 1][col] = !lightsGrid[row + 1][col]
        }
        if (col > 0) {
            lightsGrid[row][col - 1] = !lightsGrid[row][col - 1]
        }
        if (col < GRID_SIZE - 1) {
            lightsGrid[row][col + 1] = !lightsGrid[row][col + 1]
        }
    }

    val isGameOver: Boolean
        get() {
            for (row in 0 until GRID_SIZE) {
                for (col in 0 until GRID_SIZE) {
                    if (lightsGrid[row][col]) {
                        return false
                    }
                }
            }
            return true
        }
}