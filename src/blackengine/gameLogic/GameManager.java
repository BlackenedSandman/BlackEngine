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
package blackengine.gameLogic;

/**
 * Engine singleton for managing game elements.
 * @author Blackened
 */
public class GameManager {

    private GameElement activeScene;

    private GameElement activeUserInterface;

    public GameElement getActiveScene() {
        return activeScene;
    }

    public void setActiveScene(GameElement activeScene) {
        if(this.activeScene != null){
            this.activeScene.deactivate();
            this.activeScene.destroy();
        }
        this.activeScene = activeScene;
        this.activeScene.setGameManager(this);
        this.activeScene.activate();
        
    }

    public GameElement getActiveUserInterface() {
        return activeUserInterface;
    }

    public void setActiveUserInterface(GameElement activeUserInterface) {
        this.activeUserInterface = activeUserInterface;
        this.activeUserInterface.setGameManager(this);
        this.activeUserInterface.activate();
        
    }

    public void createEngine() {
        LogicEngine.create();
    }
    
    public void destroyEngine(){
        if(LogicEngine.getInstance() != null){
            LogicEngine.getInstance().destroy();
        }
    }

    public void destroyGameElements() {
        if (this.activeScene != null) {
            this.activeScene.destroy();
        }
        if (this.activeUserInterface != null) {
            this.activeUserInterface.destroy();
        }
        this.activeScene = null;
        this.activeUserInterface = null;
    }

    public GameManager() {
    }

    public void updateActiveScene() {
        if (this.activeScene != null) {
            this.activeScene.update();
        }
    }

    public void updateActiveUI() {
        if (this.activeUserInterface != null) {
            this.activeUserInterface.update();
        }
    }

}
