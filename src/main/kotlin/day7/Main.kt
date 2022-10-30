package day7

import java.io.File
import kotlin.math.abs


fun part1(list:List<Int>) {
    println(list)

    var curMin = Long.MAX_VALUE
    var curPos = -1
    val min = list.min()
    val max = list.max()
    for (i in min..max) {
        var sumDist = 0L
        list.forEach { j ->
            sumDist += abs(j - i)
        }
        //println("pos: $i, sumDist: $sumDist, curMin $curMin, curPos $curPos")
        if (sumDist < curMin) {
            println("$sumDist < curMin $curMin, newPos $i curPos $curPos")
            curMin = sumDist
            curPos = i
        }
    }
    println("Winner -> curMin: " + curMin + ", curPos: " + curPos)
}

fun part2(list:List<Int>) {
    println(list)

    var curMin = Long.MAX_VALUE
    var curPos = -1
    val min = list.min()
    val max = list.max()
    for (i in min..max) {
        var sumDist = 0L
        list.forEach { j ->
            val dist = abs(j - i)

            val fuel = (0..dist).fold(0) { acc:Int, d:Int -> acc + d }
            sumDist += fuel
        }
        //println("pos: $i, sumDist: $sumDist, curMin $curMin, curPos $curPos")
        if (sumDist < curMin) {
            println("$sumDist < curMin $curMin, newPos $i curPos $curPos")
            curMin = sumDist
            curPos = i
        }
    }
    println("Winner -> curMin: " + curMin + ", curPos: " + curPos)
}

fun main(args:Array<String>) {
    println("Day 7")

    val str = File("/Users/sten/dev/adventofcode2021kotlin/src/main/kotlin/day7/input.txt").readLines().first()

    part2(str.split(",").map { i -> i.toInt()})
}