package teamnova;
/* Vertx�� �ۼ��� Benchmark�� TEST UDP Echo ���� */
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