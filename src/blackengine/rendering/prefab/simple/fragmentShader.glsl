#version 400 core

// The texture coordinates for this fragment.
in vec2 pass_textureCoords;

// The exact colour (including alpha) for this fragment.
out vec4 out_Colour;

// The texture that will be used to determine the colour of the fragment.
uniform sampler2D textureSampler;

// The main method that processes each fragment.
void main(void){

    // The colour of the texture at the specified texture coordinate.
    vec4 textureVec = texture(textureSampler, pass_textureCoords);

    // Sets the output colour of this fragment to the colour of the texture at the specified texture coordinate.
    out_Colour = textureVec;
}

