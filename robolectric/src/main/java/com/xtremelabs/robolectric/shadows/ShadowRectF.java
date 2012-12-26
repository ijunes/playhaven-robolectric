package com.xtremelabs.robolectric.shadows;

import static com.xtremelabs.robolectric.Robolectric.shadowOf_;
import android.graphics.Rect;
import android.graphics.RectF;

import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.internal.RealObject;

@Implements(RectF.class)
public class ShadowRectF {
    @RealObject RectF realRect;

    public void __constructor__(float left, float top, float right, float bottom) {
        realRect.left = left;
        realRect.top = top;
        realRect.right = right;
        realRect.bottom = bottom;
    }

    public void __constructor__(Rect otherRect) {
        realRect.left = otherRect.left;
        realRect.top = otherRect.top;
        realRect.right = otherRect.right;
        realRect.bottom = otherRect.bottom;
    }

    @Implementation    
    public void set(RectF rect) {
        set(rect.left, rect.top, rect.right, rect.bottom);
    }
    
    @Implementation
    public void set(float left, float top, float right, float bottom) {
        realRect.left = left;
        realRect.top = top;
        realRect.right = right;
        realRect.bottom = bottom;
    }

    @Implementation
    public float width() {
        return realRect.right - realRect.left;
    }

    @Implementation
    public float height() {
        return realRect.bottom - realRect.top;
    }

    @Implementation
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Object o = shadowOf_(obj);
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        if (this == o) return true;

        Rect r = (Rect) obj;
        return realRect.left == r.left && realRect.top == r.top && realRect.right == r.right
                && realRect.bottom == r.bottom;
    }

    @Implementation
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("RectF(");
        sb.append(realRect.left);
        sb.append(", ");
        sb.append(realRect.top);
        sb.append(" - ");
        sb.append(realRect.right);
        sb.append(", ");
        sb.append(realRect.bottom);
        sb.append(")");
        return sb.toString();
    }
    
    @Implementation
    public boolean contains(int x, int y) {
    	return x > realRect.left && x < realRect.right
    			&& y >= realRect.top && y <= realRect.bottom;
    } 

    @Implementation
    public boolean contains(Rect r) {
    	return equals(r)
    			|| (contains(r.left, r.top) && contains(r.right, r.top)
    					&& contains(r.left, r.bottom) && contains(r.right, r.bottom));
    }
    
    @Implementation
	public static boolean intersects(RectF a, RectF b) {
    	return a.left < b.right && b.left < a.right
    			&& a.top < b.bottom && b.top < a.bottom;
    }
    
    @Implementation
    public boolean intersect(RectF r) {
    	return intersects(realRect, r);
    }
    
    @Implementation
    public boolean intersect(float left, float top, float right, float bottom) {
    	return intersect(new RectF(left, top, right, bottom));
    }
    
    @Implementation
    public void offset(float dx, float dy) {
      realRect.left += dx;
      realRect.right += dx;
      realRect.top += dy;
      realRect.bottom += dy;
    }
}
