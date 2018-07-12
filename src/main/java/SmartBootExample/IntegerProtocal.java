package SmartBootExample;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

public class IntegerProtocal implements Protocol<Integer> {
	private static final int INT_LENGTH = 4;

	@Override
	public Integer decode(ByteBuffer byteBuffer, AioSession<Integer> aioSession, boolean b) {
		if (byteBuffer.remaining() < INT_LENGTH) {
			return null;
		}
		return byteBuffer.getInt();
	}

	@Override
	public ByteBuffer encode(Integer integer, AioSession<Integer> aioSession) {
		ByteBuffer b = ByteBuffer.allocate(INT_LENGTH);
		b.putInt(integer);
		b.flip();
		return b;
	}
}
