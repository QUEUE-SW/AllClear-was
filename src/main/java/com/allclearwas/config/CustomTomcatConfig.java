package com.allclearwas.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.ProtocolHandler;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CustomTomcatConfig {

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customTomcatConnector() {
		return factory -> factory.addConnectorCustomizers(connector -> {
			ProtocolHandler handler = connector.getProtocolHandler();
			if (handler instanceof AbstractProtocol<?> protocol) {
				protocol.setMaxThreads(200);
				protocol.setAcceptCount(100);

				// 큐를 먼저 생성해놓고 추후 로깅용으로 사용
				ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);

				ThreadPoolExecutor executor = new ThreadPoolExecutor(
					200, 200, 0L, TimeUnit.MILLISECONDS,
					queue,
					new ThreadPoolExecutor.AbortPolicy() {
						@Override
						public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
							log.info("🚨 요청 초과! 스레드풀/큐가 가득 찼습니다. 현재 상태:\n" +
									" - Active Threads     : {}\n" +
									" - Pool Size          : {}\n" +
									" - Maximum Pool Size  : {}\n" +
									" - Task Count         : {}\n" +
									" - Completed Tasks    : {}\n" +
									" - Queue Size         : {}\n" +
									" - Remaining QueueCap : {}",
								e.getActiveCount(),
								e.getPoolSize(),
								e.getMaximumPoolSize(),
								e.getTaskCount(),
								e.getCompletedTaskCount(),
								e.getQueue().size(),
								e.getQueue().remainingCapacity()
							);
							super.rejectedExecution(r, e);
						}
					}
				);

				protocol.setExecutor(executor);
			}
		});
	}
}