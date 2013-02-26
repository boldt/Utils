package de.dennis_boldt.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;

import java.nio.ByteBuffer;

/**
 * Some utils for Netty 4.0.0.Beta1
 *
 * @author Dennis Boldt
 *
 */
public class NettyUtil {

	/**
	 * Creates a new ByteBuf
	 *
	 * @param bytes
	 * @return
	 */
	public static ByteBuf toByteBuf(byte[] bytes) {
    	ByteBufAllocator alloc = new PooledByteBufAllocator();
    	ByteBuf b = alloc.buffer();
    	b.capacity(bytes.length);
    	b.writeBytes(bytes);
    	return b;
    }

	/**
	 * Creates a new ByteBuf
	 *
	 * @param bytes
	 * @return
	 */
	public static ByteBuf toByteBuf(ByteBuffer bytes) {
    	ByteBufAllocator alloc = new PooledByteBufAllocator();
    	ByteBuf b = alloc.buffer();
    	b.capacity(bytes.capacity());
    	b.writeBytes(bytes);
    	return b;
    }

	/**
	 * Creates a byte array
	 *
	 * @param buffer
	 * @return
	 */
	public static byte[] toArray(ByteBuf buffer) {
    	byte[] bytes = new byte[buffer.capacity()];
    	for (int i = 0; i < buffer.capacity(); i ++) {
    		bytes[i] = buffer.getByte(i);
    	}
    	//System.out.println("Server received: " + HexUtil.toString(bytes,"0x", " "));
    	return bytes;
    }

}
