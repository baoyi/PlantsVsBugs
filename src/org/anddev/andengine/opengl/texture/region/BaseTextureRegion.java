package org.anddev.andengine.opengl.texture.region;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import org.anddev.andengine.opengl.buffer.BufferObjectManager;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.region.buffer.TextureRegionBuffer;
import org.anddev.andengine.opengl.util.GLHelper;

/**
 * @author Nicolas Gramlich
 * @since 14:29:59 - 08.03.2010
 */
public abstract class BaseTextureRegion {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected final Texture mTexture;

	protected final TextureRegionBuffer mTextureRegionBuffer;

	protected int mWidth;
	protected int mHeight;

	protected int mTexturePositionX;
	protected int mTexturePositionY;

	// ===========================================================
	// Constructors
	// ===========================================================

	public BaseTextureRegion(final Texture pTexture, final int pTexturePositionX, final int pTexturePositionY, final int pWidth, final int pHeight) {
		this.mTexture = pTexture;
		this.mTexturePositionX = pTexturePositionX;
		this.mTexturePositionY = pTexturePositionY;
		this.mWidth = pWidth;
		this.mHeight = pHeight;

		this.mTextureRegionBuffer = new TextureRegionBuffer(this, GL11.GL_STATIC_DRAW, true);

		this.initTextureBuffer();
	}

	protected void initTextureBuffer() {
		this.updateTextureRegionBuffer();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public int getWidth() {
		return this.mWidth;
	}

	public int getHeight() {
		return this.mHeight;
	}

	public void setWidth(final int pWidth) {
		this.mWidth = pWidth;
		this.updateTextureRegionBuffer();
	}

	public void setHeight(final int pHeight) {
		this.mHeight = pHeight;
		this.updateTextureRegionBuffer();
	}

	public void setTexturePosition(final int pX, final int pY) {
		this.mTexturePositionX = pX;
		this.mTexturePositionY = pY;
		this.updateTextureRegionBuffer();
	}

	public int getTexturePositionX() {
		return this.mTexturePositionX;
	}

	public int getTexturePositionY() {
		return this.mTexturePositionY;
	}

	public Texture getTexture() {
		return this.mTexture;
	}

	public TextureRegionBuffer getTextureBuffer() {
		return this.mTextureRegionBuffer;
	}

	public boolean isFlippedHorizontal() {
		return this.mTextureRegionBuffer.isFlippedHorizontal();
	}

	public void setFlippedHorizontal(final boolean pFlippedHorizontal) {
		this.mTextureRegionBuffer.setFlippedHorizontal(pFlippedHorizontal);
	}

	public boolean isFlippedVertical() {
		return this.mTextureRegionBuffer.isFlippedVertical();
	}

	public void setFlippedVertical(final boolean pFlippedVertical) {
		this.mTextureRegionBuffer.setFlippedVertical(pFlippedVertical);
	}

	public boolean isTextureRegionBufferManaged() {
		return this.mTextureRegionBuffer.isManaged();
	}

	/**
	 * @param pVertexBufferManaged when passing <code>true</code> this {@link BaseTextureRegion} will make its {@link TextureRegionBuffer} unload itself from the active {@link BufferObjectManager}, when this {@link BaseTextureRegion} is finalized/garbage-collected.<b><u>WARNING:</u></b> When passing <code>false</code> one needs to take care of that by oneself!
	 */
	public void setTextureRegionBufferManaged(final boolean pTextureRegionBufferManaged) {
		this.mTextureRegionBuffer.setManaged(pTextureRegionBufferManaged);
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public abstract float getTextureCoordinateX1();
	public abstract float getTextureCoordinateY1();
	public abstract float getTextureCoordinateX2();
	public abstract float getTextureCoordinateY2();

	// ===========================================================
	// Methods
	// ===========================================================

	protected void updateTextureRegionBuffer() {
		this.mTextureRegionBuffer.update();
	}

	public void onApply(final GL10 pGL) {
		if(GLHelper.EXTENSIONS_VERTEXBUFFEROBJECTS) {
			final GL11 gl11 = (GL11)pGL;

			this.mTextureRegionBuffer.selectOnHardware(gl11);

			GLHelper.bindTexture(pGL, this.mTexture.getHardwareTextureID());
			GLHelper.texCoordZeroPointer(gl11);
		} else {
			GLHelper.bindTexture(pGL, this.mTexture.getHardwareTextureID());
			GLHelper.texCoordPointer(pGL, this.mTextureRegionBuffer.getFloatBuffer());
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
