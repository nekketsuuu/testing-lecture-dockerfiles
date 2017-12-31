object Main {
    def main(args: Array[String]): Unit = {
        val t = Triangle(Vec2(0.0, 0.0),
                         Vec2(1.0, 0.0),
                         Vec2(0.0, 1.0))
        println(t)
        println(t.getType)
    }
}

case class Vec2(val x: Double, val y: Double) {
    override def toString: String =
        "(" + x + ", " + y + ")"
}

sealed trait TriangleType
case object Scalene extends TriangleType
case object Isosceles extends TriangleType
case object Equilateral extends TriangleType
case object NoTriangle extends TriangleType

case class Triangle(val p1: Vec2, val p2: Vec2, val p3: Vec2) {
    private val d12 = distance(p1, p2)
    private val d23 = distance(p2, p3)
    private val d31 = distance(p3, p1)
    private val eps = 1e-10

    def isTriangle: Boolean = {
        if (d12 < d23 + d31 && d23 < d31 + d12 && d31 < d23 + d12) {
            return true
        } else {
            return false
        }
    }
    def getType: TriangleType = {
        if (!isTriangle) {
            return NoTriangle
        }

        val eq1 = (Math.abs(d12 -d23) < eps)
        val eq2 = (Math.abs(d23 -d31) < eps)
        val eq3 = (Math.abs(d31 -d12) < eps)

        if (eq1 && eq2 && eq3) {
            return Equilateral
        } else if (!eq1 && !eq2 && !eq3) {
            return Scalene
        } else {
            return Isosceles
        }
    }

    def distance(p: Vec2, q: Vec2): Double = {
        val dx = p.x - q.x
        val dy = p.y - q.y
        return Math.sqrt(dx * dx + dy * dy)
    }
    override def toString: String =
        "(" + p1 + ",\n " + p2 + ",\n " + p3 + ")"
}
