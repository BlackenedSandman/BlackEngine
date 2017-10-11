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
package blackengine.rendering.prefab.testing;

import blackengine.gameLogic.components.prefab.rendering.RenderComponent;
import blackengine.rendering.renderers.RendererBase;
import blackengine.rendering.renderers.ShaderProgram;
import java.util.HashSet;

/**
 *
 * @author Blackened
 */
public class DebugRenderer extends RendererBase<DebugMaterial>{
    
    private HashSet<RenderComponent<DebugMaterial>> targets;

    public DebugRenderer(ShaderProgram shaderProgram) {
        super(shaderProgram);
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRenderTarget(RenderComponent<DebugMaterial> renderTarget) {
        this.targets.add(renderTarget);
    }

    @Override
    public void removeRenderTarget(RenderComponent<DebugMaterial> renderTarget) {
        this.targets.remove(renderTarget);
    }

    @Override
    public boolean containsRenderTarget(RenderComponent<DebugMaterial> renderTarget) {
        return this.targets.contains(renderTarget);
    }
}
