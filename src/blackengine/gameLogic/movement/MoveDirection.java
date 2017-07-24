/* 
 * Project: Beams
 * Phase: ALPHA
 * Property of: Blackened Studio
 * Contact: blackenedstudio@gmail.com
 */
package blackengine.gameLogic.movement;

import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Blackened
 */
public enum MoveDirection {

    FORWARD {

        @Override
        protected Vector3f calculateTranslation(float amount, Vector3f currentRotation) {
            float dx = (float) (amount * Math.sin(currentRotation.getY()));
            float dz = (float) (amount * Math.cos(currentRotation.getY()));
            return new Vector3f(dx, 0, dz);
        }
    },
    BACKWARD {
        @Override
        protected Vector3f calculateTranslation(float amount, Vector3f currentRotation) {
            float dx = (float) (amount * Math.sin(currentRotation.getY()));
            float dz = (float) (amount * Math.cos(currentRotation.getY()));
            return new Vector3f(-dx, 0, -dz);
        }
    },
    LEFT {
        @Override
        protected Vector3f calculateTranslation(float amount, Vector3f currentRotation) {
            float dx = (float) (amount * Math.sin(currentRotation.getY() - 0.5 * Math.PI));
            float dz = (float) (amount * Math.cos(currentRotation.getY() - 0.5 * Math.PI));
            return new Vector3f(-dx, 0, -dz);
        }
    },
    RIGHT {
        @Override
        protected Vector3f calculateTranslation(float amount, Vector3f currentRotation) {
            float dx = (float) (amount * Math.sin(currentRotation.getY() - 0.5 * Math.PI));
            float dz = (float) (amount * Math.cos(currentRotation.getY() - 0.5 * Math.PI));
            return new Vector3f(dx, 0, dz);
        }
    },
    UP {
        @Override
        protected Vector3f calculateTranslation(float amount, Vector3f currentRotation) {
            return new Vector3f(0, amount, 0);
        }
    },
    DOWN {
        @Override
        protected Vector3f calculateTranslation(float amount, Vector3f currentRotation) {
            return new Vector3f(0, -amount, 0);
        }
    };

    protected abstract Vector3f calculateTranslation(float amount, Vector3f currentRotation);

}
