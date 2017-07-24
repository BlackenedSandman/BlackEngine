/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackengine.gameLogic.components.prefab;

import blackengine.gameLogic.components.base.RenderComponentBase;
import blackengine.openGL.texture.Texture;
import blackengine.openGL.vao.Vao;
import blackengine.rendering.prefab.SimpleMeshComponentRenderer;

/**
 *
 * @author Blackened
 */
public class SimpleMeshRenderComponent extends RenderComponentBase<SimpleMeshComponentRenderer>{
    
    private Vao vao;
    
    private Texture texture;

    public Vao getVao() {
        return vao;
    }

    public Texture getTexture() {
        return texture;
    }
    
    public SimpleMeshRenderComponent(Vao vao, Texture texture, SimpleMeshComponentRenderer renderer) {
        super(renderer);
        
        this.vao = vao;
        this.texture = texture;
        
        this.enableRendering();
    }
        

    @Override
    public void enableRendering() {
        super.getRenderer().addRenderTarget(this);
    }

    @Override
    public void disableRendering() {
        super.getRenderer().removeRenderTarget(this);
    }

    @Override
    public boolean isRendered() {
        if(super.getRenderer() != null){
            super.getRenderer().containsRenderTarget(this);
        }
        return false;
    }

    
}
