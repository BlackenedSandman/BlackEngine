#version 400 core

in vec3 position;
in vec2 textureCoords;

out vec2 pass_textureCoords;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

void main(void){
    pass_textureCoords = textureCoords;

    vec4 worldPosition = transformationMatrix * vec4(position,1.0);
    gl_Position = projectionMatrix * viewMatrix * worldPosition;
    
}