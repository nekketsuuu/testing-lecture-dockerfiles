import org.scalacheck.Gen
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

object TriangleSpecification extends Properties("Triangle") {
    property("equilateral") = forAll { (d: Double) =>
        Triangle(Vec2(0.0, 0.0),
                 Vec2(d, 0.0),
                 Vec2(0.5 * d, Math.sqrt(3.0) * 0.5 * d)).getType == Equilateral
    }

    val smallDouble = Gen.choose(-100.0, 100.0)
    property("small equilateral") = forAll(smallDouble) { d =>
        Triangle(Vec2(0.0, 0.0),
                 Vec2(d, 0.0),
                 Vec2(0.5 * d, Math.sqrt(3.0) * 0.5 * d)).getType == Equilateral
    }
}
