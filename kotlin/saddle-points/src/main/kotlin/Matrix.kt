class Matrix(private val matrixList: List<List<Int>>){

	val saddlePoints = emptySet<MatrixCoordinate>()
}


class Matrix(private val rows: List<List<Int>>) {
    private val columns by lazy { (0 until rows[0].size).map { i -> rows.map { it[i] } } }
    private val maxInRow by lazy { rows.map { it.max() } }
    private val minInCol by lazy { columns.map { it.min() } }

    val saddlePoints: Set<MatrixCoordinate> =
            rows.mapIndexed { x, row ->
                row.mapIndexedNotNull { y, it ->
                    if (it == maxInRow[x] && it == minInCol[y]) {
                        MatrixCoordinate(x, y)
                    } else null
                }
            }.flatten().toSet()
}



class Matrix(private val grid: List<List<Int>>) {
    private val columnMinimums = (0 until grid[0].size).map { col -> grid.map { it[col] }.min() }

    val saddlePoints = grid.foldIndexed(setOf<MatrixCoordinate>(), { rowNumber, coords, row ->
        row.foldIndexed(coords, { columnNumber, acc, i ->
            if (row.max() == i && columnMinimums[columnNumber] == i) acc.plus(MatrixCoordinate(rowNumber, columnNumber)) else acc })
    })
}





typealias Coordinate = MatrixCoordinate
typealias IntMatrix = List<List<Int>>

fun IntMatrix.Coordinates() = this.mapIndexed{r, row -> row.mapIndexed{c, _ -> Coordinate(r, c)}}.flatMap{it}

class Matrix(val matrix: IntMatrix) {
    val saddlePoints: Set<Coordinate>
        get() = matrix.Coordinates().filter { (checkRow(it) && checkCol(it)) }.toSet()

    fun checkRow(c: Coordinate) = matrix[c.row][c.col] == matrix[c.row].max()
    fun checkCol(c: Coordinate) = matrix[c.row][c.col] == matrix.map { it[c.col] }.min()
}




data class Matrix (val matrix: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate> get() {
        var s =  HashSet<MatrixCoordinate>()
        matrix.forEachIndexed { i, list ->
            list.forEachIndexed { j, e ->
                val mc = MatrixCoordinate(i, j)
                val maxRow = matrix[i].max()
                val minCol = matrix.map { it[j] }.min()
                if (e == maxRow && e == minCol) s.add(mc)
            }
        }
        return s
    }
}





/**
 * The mutable/imperative way that makes a single pass through the input matrix (list of lists)
 * This would be most beneficial when the number of saddle points is expected to be low and the
 * cost of iterating through the matrix is high
 */
fun findSaddlePoints(values: List<List<Int>>): Set<MatrixCoordinate> {
    val numRows = values.size
    val numCols = values.firstOrNull()?.size ?: 0
    if (numCols == 0)
        return setOf()

    val rowMaxs = Array(numRows) { _ -> Int.MIN_VALUE }
    val colMins = Array(numCols) { _ -> Int.MAX_VALUE }

    val saddles = mutableSetOf<MatrixCoordinate>()
    for (r in 0..numRows - 1) {
        for (c in 0..numCols - 1) {
            val value = values[r][c]

            if (value > rowMaxs[r]) {
                saddles.removeIf { it.row == r }
                rowMaxs[r] = value
            }
            if (value < colMins[c]) {
                saddles.removeIf { it.col == c }
                colMins[c] = value
            }

            if (value == rowMaxs[r] && value == colMins[c])
                saddles.add(MatrixCoordinate(r, c))
        }
    }
    return saddles
}

class Matrix(values: List<List<Int>>) {
    val saddlePoints = findSaddlePoints(values)
}






data class MatrixCoordinate(val row: Int, val col: Int)

fun <T> List<T>.indexed(): List<Pair<Int, T>> = (0 until size).zip(this)

data class Matrix(val cc: List<List<Int>>) {
  val rowMaxes = cc.map { it.max() }.filterNotNull()
  val columnMins = (0 until cc[0].size).map { x -> cc.map { it[x] } }.map { it.min() }.filterNotNull()

  val saddlePoints: Set<MatrixCoordinate> = cc.indexed().flatMap { (y, row) ->
    row.mapIndexed { x, value -> if(value >= rowMaxes[y] && value <= columnMins[x]) MatrixCoordinate(y, x) else null }
  }.filterNotNull().toSet()
}






class Matrix(rows: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate> = run {
        val cols = (0 until rows[0].size).mapIndexed { index, _ -> rows.map { it[index] } }
        mutableSetOf<MatrixCoordinate>().apply {
            rows.mapIndexed { rowIndex, row ->
                row.mapIndexed { colIndex, value ->
                    if (isSaddlePoint(value, row, cols[colIndex])) add(MatrixCoordinate(rowIndex, colIndex))
                }
            }
        }
    }
}

private fun isSaddlePoint(i: Int, rows: List<Int>, cols: List<Int>) = i >= rows.max()!! && i <= cols.min()!!






class Matrix(private val values : List<List<Int>>) {

    private fun column(index: Int) = values.map { it -> it[index]}


    val saddlePoints: Set<MatrixCoordinate>
    get() {
        val numberOfRow = values.size
        val numberOfCol = if (numberOfRow == 0) 0 else values[0].size

        var results = emptySet<MatrixCoordinate>().toMutableSet()

        for (rowIndex in 1..numberOfRow)
            for (colIndex in 1..numberOfCol) {
                var value = values[rowIndex - 1][colIndex - 1]
                if (value == values[rowIndex-1].max() && value == column(colIndex-1).min())
                    results.add(MatrixCoordinate(rowIndex-1, colIndex-1))
            }

        return results
    }


}




class Matrix(matrix: List<List<Int>>) {

    val saddlePoints = mutableSetOf<MatrixCoordinate>()

    init {
        matrix.forEachIndexed { i, list ->
            list.forEachIndexed { j, number ->
                if (matrix.all { it[j] >= number } && list.all { it <= number }) {
                    saddlePoints.add(MatrixCoordinate(i, j))
                }
            }
        }
    }

}




class Matrix(values: List<List<Int>>) {
    val saddlePoints: MutableSet<MatrixCoordinate> = mutableSetOf()

    init {
        for ((row, list) in values.withIndex()) {
            for ((column, element) in list.withIndex()) {
                if (
                        list.all { e -> element >= e }
                        && values.all { r -> element <= r[column] }
                ) {
                    saddlePoints.add(MatrixCoordinate(row, column))
                }
            }
        }
    }

}





class Matrix(val rows: List<List<Int>>) {
  val saddlePoints: Set<MatrixCoordinate> get() {
    val matrix = mutableSetOf<MatrixCoordinate>()
    if (rows.count() == 0 || rows[0].count() == 0)
      return matrix

    rows.forEachIndexed{ rowIdx, row ->
      row.forEachIndexed{ colIdx, point ->
        if (isSaddlePoint(rowIdx, colIdx, point)) {
          matrix.add(MatrixCoordinate(rowIdx, colIdx))
        }
      }
    }

    return matrix
  }

  fun isSaddlePoint(rowIdx: Int, colIdx: Int, pointValue: Int): Boolean {
    val column = rows.map { row -> row[colIdx] }
    val allRowsAreLess = rows[rowIdx].all({it <= pointValue})
    val allColsAreLess = column.all({it >= pointValue})

    return allRowsAreLess && allColsAreLess
  }
}



class Matrix(val matrix: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate>
        get() {
            val res = mutableSetOf<MatrixCoordinate>()
            for(row in 0 until matrix.size)
                for(column in 0 until matrix[0].size)
                    if(isSaddlePoint(row, column))
                        res += MatrixCoordinate(row, column)
            return res
        }

    private fun largestInRow(row: Int, column: Int) = matrix[row].all { matrix[row][column] >= it}

    private fun smallestInColumn(row: Int, column: Int) = matrix.all { matrix[row][column] <= it[column] }

    private fun isSaddlePoint(row: Int, column: Int) = largestInRow(row, column) && smallestInColumn(row, column)

}





class Matrix(private val entries: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            if (entries.isEmpty() || entries[0].isEmpty()) {
                return emptySet()
            }
            return mutableSetOf<MatrixCoordinate>().apply {
                for (rowIndex: Int in 0 until entries.size) {
                    for (columnIndex: Int in 0 until entries.size) {
                        if (isSaddlePoint(rowIndex, columnIndex)) add(MatrixCoordinate(rowIndex, columnIndex))
                    }
                }
            }
        }

    private fun isSaddlePoint(rowIndex: Int, columnIndex: Int): Boolean {
        return with(entries[rowIndex][columnIndex]) {
            this == getRow(rowIndex).max() && this == getColumn(columnIndex).min()
        }
    }

    private fun getRow(rowNumber: Int) = entries[rowNumber]

    private fun getColumn(columnNumber: Int) = entries.map { it[columnNumber] }
}







class Matrix(matrix: List<List<Int>>){
    val saddlePoints = mutableSetOf<MatrixCoordinate>()

    init{
        matrix.forEachIndexed { row, list ->
            list.forEachIndexed { column, number ->
                if (list.all{ it <= number} && matrix.all { it[column] >= number} ){
                    saddlePoints.add(MatrixCoordinate(row, column))
                }
            }
        }
    }
}

