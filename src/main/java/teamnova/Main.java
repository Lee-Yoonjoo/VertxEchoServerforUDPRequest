package teamnova;
/* Vertx로 작성한 Benchmark용 TEST UDP Echo 서버 */
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.datagram.DatagramSocket;
import io.vertx.core.datagram.DatagramSocketOptions;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main Method");

		VertxServer udp = new VertxServer();
		Vertx.vertx().deployVerticle(udp);		

	}
}