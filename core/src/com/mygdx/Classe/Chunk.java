package com.mygdx.Classe;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Alexis on 31/05/2015.
 */
public class Chunk extends Array<ModelInstance> {

    public final static String DefaultTexture = "Swiss-Grass.jpg";

    private final static Float WIDTH_CUBE = 5f;
    private final static Float HEIGHT_CUBE = 5f;
    private final static Float DEPTH_CUBE = 5f;

    private final static Float WIDTH = 50f;
    private final static Float HEIGHT = 50f;
    private final static Float DEPTH = 500f;

    /////////////////////
    //Position
    //
    protected Integer x = 0;
    protected Integer y = 0;
    protected Integer z = 0;
    ////////
    //Size Chunk
    //
    protected Float width = WIDTH;
    protected Float height = HEIGHT;
    protected Float depth = DEPTH;
    ////////
    //Size Cube
    //
    protected Float width_cube = WIDTH_CUBE;
    protected Float height_cube = HEIGHT_CUBE;
    protected Float depth_cube = DEPTH_CUBE;

    ////////
    //Type
    //
    public enum Type {

        DEFAULT (new Texture(DefaultTexture));

        private final Texture texture;

        Type(Texture texture){
            this.texture = texture;
        }

        public Texture getTexture() {
            return texture;
        }
    }

    protected Type type = Type.DEFAULT;

    /////
    public Chunk() {

        for (float x = this.getX() * this.getWidth();
             x <= this.getX() * this.getWidth() + this.getWidth();
             x += this.getWidth_cube()) {
            for (float y = this.getY() * this.getHeight();
                 y <= this.getY() * this.getDepth() + this.getDepth();
                 y += this.getDepth_cube()) {
                for (float z = this.getZ() * this.getHeight();
                     z <= this.getZ() * this.getHeight() + this.getHeight();
                     z += this.getHeight_cube()) {

                    Cube blockInstance;
                    switch (this.getType()) {
                        case DEFAULT:
                            blockInstance = new Cube(this.getType().getTexture());
                            break;
                        default:
                            blockInstance = new Cube();
                            break;
                    }
                    blockInstance.setPosition(x, -y, z);
                    this.add(blockInstance);
                }
            }
        }
    }

    /////////
    // GETTER SETTER
    //


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Float getDepth_cube() {
        return depth_cube;
    }

    public void setDepth_cube(Float depth_cube) {
        this.depth_cube = depth_cube;
    }

    public Float getWidth_cube() {
        return width_cube;
    }

    public void setWidth_cube(Float width_cube) {
        this.width_cube = width_cube;
    }

    public Float getHeight_cube() {
        return height_cube;
    }

    public void setHeight_cube(Float height_cube) {
        this.height_cube = height_cube;
    }
}
