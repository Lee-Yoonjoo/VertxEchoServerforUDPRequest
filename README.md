# VertxServerExample

Version of Java : JavaSE-1.8 (jdk1.8.0_144)

1. Create a Maven Project, named vertx-benchmark.
2. Add Dependencies, vertx-core:3.3.2 and jsr305:3.0.0 on pom.xml.
3. Create VertxServer.java which extends AbstrackVerticle and wrote the codes.
4. Run the server as Java Application on Eclipse in my local windows 8.1 (64bits)machine. It worked well.
5. A runnable jar, VertxServer.jar, file is exported from Eclipse, I copy that to Ubuntu server through USB or Email.
6. Run the jar file on my Ubuntu 16.04 Server. But, I got an error message, "Error: Could not find or load main class".
7. Create Main.java to have Main class and Method. Export runnable jar file from Eclipse and run that on Ubuntu again.
8. Run with command line "java -Xmx8gb or -Xmx10gb -jar VertxServer.jar 
9. It was running well
10. Set up JMeter. Setup information is on the post I wrote on Vertx google group https://groups.google.com/forum/#!topic/vertx/ApUYfOzub24


Netty, Vertx and Node.js Response times Benchmark Test plan

My issue is that only Vertx Server throws "java.lang.OutOfMemoryError: Java heap space" in 15mins and it stops.
You can also have a look the PerfMon Monitor Collector Graph on my post on Vertx Google group
https://groups.google.com/forum/#!topic/vertx/ApUYfOzub24

