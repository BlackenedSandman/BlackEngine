/*
 * The MIT License
 *
 * Copyright 2017 Blackened.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blackengine.gameLogic.components.prefab.collision;

import blackengine.gameLogic.Entity;
import blackengine.gameLogic.components.base.ComponentBase;
import java.util.List;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Blackened
 */
public abstract class CollisionComponent extends ComponentBase {

    protected Vector3f offset;

    /**
     *
     * @return
     */
    protected abstract List<Entity> isColliding();

    protected abstract void onCollision(Entity entity);

    public abstract Vector3f getEdgePoint(Vector3f otherCollisionComponentCenter);

    protected abstract Vector3f getCollisionComponentCenter();

    @Override
    public void update() {
        List<Entity> collidingEntities = this.isColliding();
        collidingEntities.forEach(x -> this.onCollision(x));
    }

}