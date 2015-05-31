package com.mygdx.Classe;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.Random;

/**
 * Created by Alexis on 31/05/2015.
 */
public class Cube extends ModelInstance {
    private final static Float WIDTH = 5f;
    private final static Float HEIGHT = 5f;
    private final static Float DEPTH = 5f;
    protected Float width = WIDTH;
    protected Float height = HEIGHT;
    protected Float depth = DEPTH;
    public static Random j_random = new Random();
    public static ModelBuilder modelBuilder = new ModelBuilder();

    public Cube() {
        super(modelBuilder.createBox(WIDTH, HEIGHT, DEPTH,
                new Material(ColorAttribute.createDiffuse(
                        new Color(j_random.nextFloat(), j_random.nextFloat(), j_random.nextFloat(), j_random.nextFloat()))),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));

    }
    public Cube(Float width, Float height, Float depth, Texture texture) {
        super(modelBuilder.createBox(width, height, depth,
                new Material(TextureAttribute.createDiffuse(texture)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public Cube(Texture texture) {
        super(modelBuilder.createBox(WIDTH, HEIGHT, DEPTH,
                new Material(TextureAttribute.createDiffuse(texture)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates));
    }
    public void dispose(){
        this.model.dispose();
    }
    public void setPosition(Float x,Float y,Float z){
        this.transform.setToTranslation(x,y,z);
    }
}
