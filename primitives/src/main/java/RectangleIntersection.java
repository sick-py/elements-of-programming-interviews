

public class RectangleIntersection {

    /*
    5.11
    Since the problem leaves it unspecified, we will treat the boundary as part of the rectangle. This implies, for example, rectangles A and B in Figure 5.2 on the preceding page intersect.

    There are many qualitatively different ways in which rectangles can intersect, e.g., they have partial overlap (D and F), one contains the other (F and G), they share a common side (D and F), they share a common corner (A and B), they form a cross (B and C), they form a tee (F and H), etc. The case analysis is quite tricky.
So A better approach is to focus on conditions under which it can be guaranteed that the rectangles do not intersect.

Equivalently, if the set of X-values for the rectangles intersect and the set of Y- values for the rectangles intersect, then all points with those X- and Y-values are common to the two rectangles, so there is a nonempty intersection.
    */




    public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
        if (!isIntersect(r1, r2)) {
            return new Rectangle(0,0,-1, -1);
        }

        return new Rectangle(
                Math.max(r1.x, r1.x), Math.max(r1.y, r2.y),
                Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x),
                Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y)
        );
    }

    /** it comes from !(x1 > x2 + width || x1 + width < x2)
     * */
    private static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x
                && r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y;
    }


}
